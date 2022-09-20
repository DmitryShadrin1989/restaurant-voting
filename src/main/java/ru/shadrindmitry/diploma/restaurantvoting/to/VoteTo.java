package ru.shadrindmitry.diploma.restaurantvoting.to;

import lombok.EqualsAndHashCode;
import lombok.Value;

import java.time.LocalDate;

@Value
@EqualsAndHashCode(callSuper = true)
public class VoteTo extends BaseTo {

    LocalDate date;

    int restaurantId;

    public VoteTo(LocalDate date, int restaurant_id) {
        this.date = date;
        this.restaurantId = restaurant_id;
    }

    public VoteTo(Integer id, LocalDate date, int restaurant_id) {
        super(id);
        this.date = date;
        this.restaurantId = restaurant_id;
    }
}