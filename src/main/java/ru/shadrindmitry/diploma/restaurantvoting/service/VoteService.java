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
import java.util.stream.Collectors;

import static ru.shadrindmitry.diploma.restaurantvoting.util.ValidationUtil.checkDateAndTimeOfVoting;

@Service
@AllArgsConstructor
public class VoteService {
    protected VoteRepository voteRepository;

    protected UserRepository userRepository;

    protected RestaurantRepository restaurantRepository;

    public List<Vote> getAll(LocalDate date) {
        return (date != null)?voteRepository.getAllOnDate(date):voteRepository.getAll();
    }

    public Vote createUpdate(LocalDate date, int userId, int restaurantId) {
        checkDateAndTimeOfVoting(date);
       return voteRepository.save(new Vote(date,
               userRepository.getExisted(userId),
               restaurantRepository.getExisted(restaurantId)));
    }

    public void deleteVoteOnDate(LocalDate date, int userId) {
        checkDateAndTimeOfVoting(date);
        voteRepository.deleteVoteOnDate(date, userId);
    }

    public List<RestaurantRating> getRestaurantRating(LocalDate date) {
        List<Vote> votes = (date != null)?voteRepository.getAllOnDate(date):voteRepository.getAll();
        return votes.stream()
                .collect(
                        Collectors.groupingBy(Vote::getRestaurant, Collectors.summingInt(Vote -> 1)))
                .entrySet().stream()
                .map(restaurantMap-> new RestaurantRating(restaurantMap.getKey(), restaurantMap.getValue()))
                .collect(Collectors.toList());
    }
}
