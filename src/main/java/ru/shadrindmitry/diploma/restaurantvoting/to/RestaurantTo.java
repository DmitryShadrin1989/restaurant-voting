package ru.shadrindmitry.diploma.restaurantvoting.to;

import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.Value;

import java.util.List;

@Value
@EqualsAndHashCode(callSuper = true)
public class RestaurantTo extends NamedTo {

    @ToString.Exclude
    List<PositionInMenuTo> menu;

    public RestaurantTo(Integer id, String name, List<PositionInMenuTo> menu) {
        super(id, name);
        this.menu = menu;
    }
}