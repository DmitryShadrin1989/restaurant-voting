package ru.shadrindmitry.diploma.restaurantvoting.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.shadrindmitry.diploma.restaurantvoting.repository.PositionInMenuRepository;
import ru.shadrindmitry.diploma.restaurantvoting.repository.RestaurantRepository;
import ru.shadrindmitry.diploma.restaurantvoting.to.RestaurantTo;
import ru.shadrindmitry.diploma.restaurantvoting.util.RestaurantUtil;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class RestaurantService {

    protected RestaurantRepository restaurantRepository;
    protected PositionInMenuRepository positionInMenuRepository;

    public Map<LocalDate, RestaurantTo> getWithMenuItems(int id, LocalDate date) {
        date = RestaurantUtil.checkDateMenuItems(date);
        return Collections.singletonMap(date,
                RestaurantUtil.createTo(
                        restaurantRepository.getExisted(id),
                        positionInMenuRepository.getRestaurantMenuItems(id, date)));
    }

    public Map<LocalDate, List<RestaurantTo>> getAllWithMenuItems(LocalDate date) {
        date = RestaurantUtil.checkDateMenuItems(date);
        return Collections.singletonMap(date,
                RestaurantUtil.getTos(positionInMenuRepository.getAllRestaurantMenuItems(date)));
    }
}
