package ru.shadrindmitry.diploma.restaurantvoting.to;

import lombok.EqualsAndHashCode;
import lombok.Value;

@Value
@EqualsAndHashCode(callSuper = true)
public class PositionInMenuTo extends BaseTo {

    String description;
    Double price;

    public PositionInMenuTo(Integer id, String description, Double price) {
        super(id);
        this.description = description;
        this.price = price;
    }
}
