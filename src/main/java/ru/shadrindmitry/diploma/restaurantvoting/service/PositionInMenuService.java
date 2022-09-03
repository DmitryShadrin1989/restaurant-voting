package ru.shadrindmitry.diploma.restaurantvoting.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.shadrindmitry.diploma.restaurantvoting.model.PositionInMenu;
import ru.shadrindmitry.diploma.restaurantvoting.model.Restaurant;
import ru.shadrindmitry.diploma.restaurantvoting.repository.PositionInMenuRepository;
import ru.shadrindmitry.diploma.restaurantvoting.repository.RestaurantRepository;
import ru.shadrindmitry.diploma.restaurantvoting.to.PositionInMenuTo;
import ru.shadrindmitry.diploma.restaurantvoting.util.PositionInMenuUtil;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class PositionInMenuService {

    protected PositionInMenuRepository positionInMenuRepository;

    protected RestaurantRepository restaurantRepository;

    public List<PositionInMenu> getRestaurantMenu(int restaurant_id, LocalDate date) {
        return (date == null)?positionInMenuRepository.getAllRestaurantMenu(restaurant_id)
                :positionInMenuRepository.getRestaurantMenuOnDate(restaurant_id, date);
    }

    public void update(PositionInMenuTo positionInMenuTo, int id) {
        PositionInMenu positionInMenu = positionInMenuRepository.getExisted(id);
        PositionInMenuUtil.updateEntity(positionInMenu, positionInMenuTo);
        positionInMenuRepository.save(positionInMenu);
    }

    public PositionInMenu create(PositionInMenuTo positionInMenuTo, int restaurant_id) {
        Restaurant restaurant = restaurantRepository.getExisted(restaurant_id);
        PositionInMenu positionInMenu = new PositionInMenu(positionInMenuTo.getDate(), positionInMenuTo.getDescription(),
                positionInMenuTo.getPositionType(), positionInMenuTo.getPrice(), restaurant);
        positionInMenuRepository.save(positionInMenu);
        return positionInMenu;
    }
}
