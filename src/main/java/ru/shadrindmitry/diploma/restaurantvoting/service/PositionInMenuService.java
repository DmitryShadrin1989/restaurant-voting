package ru.shadrindmitry.diploma.restaurantvoting.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.shadrindmitry.diploma.restaurantvoting.model.PositionInMenu;
import ru.shadrindmitry.diploma.restaurantvoting.repository.PositionInMenuRepository;
import ru.shadrindmitry.diploma.restaurantvoting.repository.RestaurantRepository;
import ru.shadrindmitry.diploma.restaurantvoting.util.PositionInMenuUtil;

@Service
@AllArgsConstructor
public class PositionInMenuService {

    protected final PositionInMenuRepository positionInMenuRepository;
    protected final RestaurantRepository restaurantRepository;

    public void update(PositionInMenu updatePositionInMenu, int id) {
        PositionInMenu positionInMenu = positionInMenuRepository.getExisted(id);
        PositionInMenuUtil.updateEntity(positionInMenu, updatePositionInMenu);
        positionInMenuRepository.save(positionInMenu);
    }

    public PositionInMenu create(PositionInMenu positionInMenu, int restaurant_id) {
        positionInMenu.setRestaurant(restaurantRepository.getExisted(restaurant_id));
        return positionInMenuRepository.save(positionInMenu);
    }
}
