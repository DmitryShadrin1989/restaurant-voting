package ru.shadrindmitry.diploma.restaurantvoting.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.shadrindmitry.diploma.restaurantvoting.model.Vote;
import ru.shadrindmitry.diploma.restaurantvoting.repository.PositionInMenuRepository;
import ru.shadrindmitry.diploma.restaurantvoting.repository.RestaurantRepository;
import ru.shadrindmitry.diploma.restaurantvoting.repository.VoteRepository;
import ru.shadrindmitry.diploma.restaurantvoting.to.RestaurantRatingTo;
import ru.shadrindmitry.diploma.restaurantvoting.to.RestaurantTo;
import ru.shadrindmitry.diploma.restaurantvoting.util.RestaurantUtil;

import java.time.LocalDate;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class RestaurantService {

    protected final RestaurantRepository restaurantRepository;
    protected final PositionInMenuRepository positionInMenuRepository;
    protected final VoteRepository voteRepository;

    @Transactional
    public Map<LocalDate, RestaurantTo> getWithMenuItems(int id, LocalDate date) {
        date = RestaurantUtil.checkDateMenuItems(date);
        return Collections.singletonMap(date,
                RestaurantUtil.createTo(
                        restaurantRepository.getExisted(id),
                        positionInMenuRepository.getOnDateForRestaurant(id, date)));
    }

    @Transactional
    public Map<LocalDate, List<RestaurantTo>> getAllWithMenuItems(LocalDate date) {
        date = RestaurantUtil.checkDateMenuItems(date);
        return Collections.singletonMap(date,
                RestaurantUtil.getTos(positionInMenuRepository.getAllOnDate(date)));
    }

    @Transactional
    public Map<LocalDate, List<RestaurantRatingTo>> getRestaurantRating(LocalDate date) {
        List<Vote> votes = (date != null)?voteRepository.getAllOnDate(date):voteRepository.getAll();
        Map<LocalDate, List<Vote>> dateListMap = votes.stream()
                .collect(
                        Collectors.groupingBy(Vote::getDateVote));

        Map<LocalDate, List<RestaurantRatingTo>> result  = new HashMap<>();
        for (Map.Entry<LocalDate, List<Vote>> entry: dateListMap.entrySet()) {
            List<RestaurantRatingTo> restaurantRatingTos = entry.getValue().stream()
                    .collect(
                            Collectors.groupingBy(Vote::getRestaurant, Collectors.summingInt(Vote -> 1)))
                    .entrySet().stream()
                    .map(restaurantMap -> new RestaurantRatingTo(restaurantMap.getKey(), restaurantMap.getValue())).toList();
            result.put(entry.getKey(), restaurantRatingTos);
        }
        return result;
    }
}