package ru.shadrindmitry.diploma.restaurantvoting.to;

import lombok.EqualsAndHashCode;
import lombok.Value;

import java.time.LocalDate;

@Value
@EqualsAndHashCode(callSuper = true)
public class PositionInMenuTo extends BaseTo {

    //@JsonIgnore
    //LocalDate date;

    String description;

    Double price;



    public PositionInMenuTo(Integer id, LocalDate date, String description, Double price) {
        super(id);
        //this.date = date;
        this.description = description;
        this.price = price;
    }
}
