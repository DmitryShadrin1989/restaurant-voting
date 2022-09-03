package ru.shadrindmitry.diploma.restaurantvoting.to;

import lombok.EqualsAndHashCode;
import lombok.Value;
import ru.shadrindmitry.diploma.restaurantvoting.model.PositionType;

import java.time.LocalDate;

@Value
@EqualsAndHashCode(callSuper = true)
public class PositionInMenuTo extends BaseTo {

    LocalDate date;

    String description;

    PositionType positionType;

    Double price;

    public PositionInMenuTo(Integer id, LocalDate date, String description, PositionType positionType, Double price) {
        super(id);
        this.date = date;
        this.description = description;
        this.positionType = positionType;
        this.price = price;
    }
}
