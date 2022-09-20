package ru.shadrindmitry.diploma.restaurantvoting.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.shadrindmitry.diploma.restaurantvoting.error.IllegalRequestDataException;
import ru.shadrindmitry.diploma.restaurantvoting.model.Vote;
import ru.shadrindmitry.diploma.restaurantvoting.repository.RestaurantRepository;
import ru.shadrindmitry.diploma.restaurantvoting.repository.UserRepository;
import ru.shadrindmitry.diploma.restaurantvoting.repository.VoteRepository;
import ru.shadrindmitry.diploma.restaurantvoting.to.VoteTo;
import ru.shadrindmitry.diploma.restaurantvoting.util.VoteUtil;
import ru.shadrindmitry.diploma.restaurantvoting.util.validation.ValidationUtil;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class VoteService {

    protected final VoteRepository voteRepository;
    protected final UserRepository userRepository;
    protected final RestaurantRepository restaurantRepository;

    @Transactional
    public List<VoteTo> getUserVotes(int userId, LocalDate date) {
        return VoteUtil.getTos((date != null) ? voteRepository.getOnDateForUser(userId, date) : voteRepository.getAllForUser(userId));
    }

    @Transactional
    public VoteTo create(int userId, int restaurantId) {
        try {
            return VoteUtil.createTo(voteRepository.save(new Vote(LocalDate.now(),
                    userRepository.getReferenceById(userId), restaurantRepository.getReferenceById(restaurantId))));
        } catch (Exception e) {
            throw new IllegalRequestDataException("Today, a user with id =" + userId + " has already spoken");
        }
    }

    @Transactional
    public void prepareAndSave(int userId, int restaurantId) {
        ValidationUtil.checkTimeOfVoting();
        List<Vote> votes = voteRepository.getOnDateForUser(userId, LocalDate.now());
        if (!votes.isEmpty()) {
            Vote vote = votes.get(0);
            vote.setRestaurant(restaurantRepository.getReferenceById(restaurantId));
            voteRepository.save(vote);
        } else {
            create(userId, restaurantId);
        }
    }
}