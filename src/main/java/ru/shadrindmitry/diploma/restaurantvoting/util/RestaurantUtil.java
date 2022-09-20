package ru.shadrindmitry.diploma.restaurantvoting.util;

import lombok.experimental.UtilityClass;
import ru.shadrindmitry.diploma.restaurantvoting.model.PositionInMenu;
import ru.shadrindmitry.diploma.restaurantvoting.model.Restaurant;
import ru.shadrindmitry.diploma.restaurantvoting.to.RestaurantTo;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@UtilityClass
public class RestaurantUtil {

    public static RestaurantTo createTo(Restaurant restaurant, List<PositionInMenu> menuItems) {
        return new RestaurantTo(restaurant.id(), restaurant.getName(), PositionInMenuUtil.getTos(menuItems));
    }

    public static List<RestaurantTo> getTos(List<PositionInMenu> positionInMenus) {
        return positionInMenus.stream()
                .collect(Collectors.groupingBy(PositionInMenu::getRestaurant))
                .entrySet()
                .stream()
                .map(entry -> createTo(entry.getKey(), entry.getValue())).toList();
    }

    public static LocalDate checkDateMenuItems(LocalDate date) {
        return (date != null) ? date : LocalDate.now();
    }
}