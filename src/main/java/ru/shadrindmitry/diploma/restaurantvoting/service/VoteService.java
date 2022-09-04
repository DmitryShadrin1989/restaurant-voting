package ru.shadrindmitry.diploma.restaurantvoting.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.shadrindmitry.diploma.restaurantvoting.model.RestaurantRating;
import ru.shadrindmitry.diploma.restaurantvoting.model.Vote;
import ru.shadrindmitry.diploma.restaurantvoting.repository.RestaurantRepository;
import ru.shadrindmitry.diploma.restaurantvoting.repository.UserRepository;
import ru.shadrindmitry.diploma.restaurantvoting.repository.VoteRepository;

import java.time.LocalDate;
import java.util.List;

import static ru.shadrindmitry.diploma.restaurantvoting.util.ValidationUtil.checkDateAndTimeOfVoting;

@Service
@AllArgsConstructor
public class VoteService {
    protected VoteRepository voteRepository;

    protected UserRepository userRepository;

    protected RestaurantRepository restaurantRepository;

    public List<Vote> getAll(LocalDate date) {
        if (date != null) {
            return voteRepository.getAllOnDate(date);
        } else {
            return voteRepository.getAll();
        }
    }

    public Vote createUpdate(LocalDate date, int userId, int restaurantId) {
        checkDateAndTimeOfVoting(date);
        Vote vote  = new Vote(date,
               userRepository.getExisted(userId),
               restaurantRepository.getExisted(restaurantId));
       return voteRepository.save(vote);
    }

    public void deleteVoteOnDate(LocalDate date, int userId) {
        checkDateAndTimeOfVoting(date);
        voteRepository.deleteVoteOnDate(date, userId);
    }

    public List<RestaurantRating> getRestaurantRating(LocalDate date) {
        if (date != null) {
            return voteRepository.getRestaurantRatingOnDate(date);
        } else {
            return voteRepository.getRestaurantRatingAll();
        }
    }
}
