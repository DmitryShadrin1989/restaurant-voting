package ru.shadrindmitry.diploma.restaurantvoting.util;

import ru.shadrindmitry.diploma.restaurantvoting.model.PositionInMenu;
import ru.shadrindmitry.diploma.restaurantvoting.to.PositionInMenuTo;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class PositionInMenuUtil {

    public static void updateEntity(PositionInMenu positionInMenu, PositionInMenuTo positionInMenuTo) {
        positionInMenu.setDate(positionInMenuTo.getDate());
        positionInMenu.setPositionType(positionInMenuTo.getPositionType());
        positionInMenu.setDescription(positionInMenuTo.getDescription());
        positionInMenu.setPrice(positionInMenuTo.getPrice());
    }

    public static List<PositionInMenuTo> getTos(Collection<PositionInMenu> positionInMenuCollection) {
        return positionInMenuCollection.stream()
                .map(PositionInMenuUtil::createTo)
                .collect(Collectors.toList());
    }

    public static PositionInMenuTo createTo(PositionInMenu positionInMenu) {
        return new PositionInMenuTo(positionInMenu.id(),
                positionInMenu.getDate(),
                positionInMenu.getDescription(),
                positionInMenu.getPositionType(),
                positionInMenu.getPrice());
    }

    public static PositionInMenu createFromTo(PositionInMenuTo positionInMenuTo) {
        return new PositionInMenu(positionInMenuTo.id(),
                positionInMenuTo.getDate(),
                positionInMenuTo.getDescription(),
                positionInMenuTo.getPositionType(),
                positionInMenuTo.getPrice(),
                null);
    }
}
