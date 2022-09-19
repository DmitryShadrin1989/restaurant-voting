package ru.shadrindmitry.diploma.restaurantvoting.to;

import lombok.EqualsAndHashCode;
import lombok.Value;

@Value
@EqualsAndHashCode(callSuper = true)
public class PositionInMenuTo extends BaseTo {

    String description;
    int price;

    public PositionInMenuTo(Integer id, String description, int price) {
        super(id);
        this.description = description;
        this.price = price;
    }
}
