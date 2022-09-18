package ru.shadrindmitry.diploma.restaurantvoting.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.shadrindmitry.diploma.restaurantvoting.error.IllegalRequestDataException;
import ru.shadrindmitry.diploma.restaurantvoting.model.Restaurant;
import ru.shadrindmitry.diploma.restaurantvoting.model.Vote;
import ru.shadrindmitry.diploma.restaurantvoting.repository.RestaurantRepository;
import ru.shadrindmitry.diploma.restaurantvoting.repository.UserRepository;
import ru.shadrindmitry.diploma.restaurantvoting.repository.VoteRepository;
import ru.shadrindmitry.diploma.restaurantvoting.util.validation.ValidationUtil;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class VoteService {
    protected VoteRepository voteRepository;

    protected UserRepository userRepository;

    protected RestaurantRepository restaurantRepository;

    public List<Vote> getUserVotes(int userId, LocalDate date) {
        return (date != null)?voteRepository.getOnDateForUser(userId, date):voteRepository.getAllForUser(userId);
    }

    public Vote create(int userId, int restaurantId) {
        LocalDate today = LocalDate.now();
        if (!voteRepository.getOnDateForUser(userId, today).isEmpty()) {
            throw new IllegalRequestDataException("Today, a user with id =" + userId + " has already spoken");
        }
        return voteRepository.save(new Vote(today,
                userRepository.getExisted(userId),
                restaurantRepository.getExisted(restaurantId)));
    }

    public void prepareAndSave(int userId, int restaurantId) {
        ValidationUtil.checkTimeOfVoting();
        LocalDate today = LocalDate.now();
        List<Vote> votes = voteRepository.getOnDateForUser(userId, today);
        Restaurant restaurant = restaurantRepository.getExisted(restaurantId);
        if (!votes.isEmpty()) {
            Vote vote  = votes.get(0);
            vote.setRestaurant(restaurant);
            voteRepository.save(vote);
        } else {
            voteRepository.save(new Vote(today,
                    userRepository.getExisted(userId),
                    restaurant));
        }
    }
}
