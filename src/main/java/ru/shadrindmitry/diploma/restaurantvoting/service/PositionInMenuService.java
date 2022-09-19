package ru.shadrindmitry.diploma.restaurantvoting.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.shadrindmitry.diploma.restaurantvoting.model.PositionInMenu;
import ru.shadrindmitry.diploma.restaurantvoting.repository.PositionInMenuRepository;
import ru.shadrindmitry.diploma.restaurantvoting.repository.RestaurantRepository;
import ru.shadrindmitry.diploma.restaurantvoting.to.PositionInMenuTo;
import ru.shadrindmitry.diploma.restaurantvoting.util.PositionInMenuUtil;

@Service
@AllArgsConstructor
public class PositionInMenuService {

    protected final PositionInMenuRepository positionInMenuRepository;
    protected final RestaurantRepository restaurantRepository;

    @Transactional
    public void update(PositionInMenuTo positionInMenuTo) {
        PositionInMenu updatePositionInMenu = PositionInMenuUtil.createFromTo(positionInMenuTo);
        updatePositionInMenu.setRestaurant(restaurantRepository.getReferenceById(positionInMenuTo.getRestaurantId()));
        positionInMenuRepository.save(updatePositionInMenu);
    }

    @Transactional
    public PositionInMenu create(PositionInMenuTo positionInMenuTo) {
        PositionInMenu createPositionInMenu = PositionInMenuUtil.createFromTo(positionInMenuTo);
        createPositionInMenu.setRestaurant(restaurantRepository.getReferenceById(positionInMenuTo.getRestaurantId()));
        return positionInMenuRepository.save(createPositionInMenu);
    }
}
