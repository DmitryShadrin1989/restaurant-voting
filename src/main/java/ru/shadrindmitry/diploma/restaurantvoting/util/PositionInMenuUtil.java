package ru.shadrindmitry.diploma.restaurantvoting.util;

import lombok.experimental.UtilityClass;
import ru.shadrindmitry.diploma.restaurantvoting.model.PositionInMenu;
import ru.shadrindmitry.diploma.restaurantvoting.to.PositionInMenuTo;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@UtilityClass
public class PositionInMenuUtil {

    public static void updateEntity(PositionInMenu positionInMenu, PositionInMenu updatePositionInMenu) {
        positionInMenu.setDateMenuItem(updatePositionInMenu.getDateMenuItem());
        positionInMenu.setDescription(updatePositionInMenu.getDescription());
        positionInMenu.setPrice(updatePositionInMenu.getPrice());
    }

    public static List<PositionInMenuTo> getTos(Collection<PositionInMenu> positionInMenuCollection) {
        return positionInMenuCollection.stream()
                .map(PositionInMenuUtil::createTo)
                .collect(Collectors.toList());
    }

    public static PositionInMenuTo createTo(PositionInMenu positionInMenu) {
        return new PositionInMenuTo(positionInMenu.id(),
                positionInMenu.getDateMenuItem(), positionInMenu.getDescription(),
                positionInMenu.getPrice(), positionInMenu.getRestaurant().id());
    }

    public static PositionInMenu createFromTo(PositionInMenuTo positionInMenuTo) {
        if (positionInMenuTo.isNew()) {
            return new PositionInMenu(positionInMenuTo.getDateMenuItems(),
                    positionInMenuTo.getDescription(),
                    positionInMenuTo.getPrice(),
                    null);
        } else {
            return new PositionInMenu(positionInMenuTo.id(),
                    positionInMenuTo.getDateMenuItems(),
                    positionInMenuTo.getDescription(),
                    positionInMenuTo.getPrice(),
                    null);
        }
    }
}