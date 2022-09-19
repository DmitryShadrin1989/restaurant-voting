package ru.shadrindmitry.diploma.restaurantvoting.to;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Value;

import java.time.LocalDate;

@Value
@EqualsAndHashCode(callSuper = true)
public class PositionInMenuTo extends BaseTo {

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    LocalDate dateMenuItems;
    String description;
    int price;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    int restaurantId;

    public PositionInMenuTo(Integer id, LocalDate dateMenuItems, String description, int price, int restaurantId) {
        super(id);
        this.dateMenuItems = dateMenuItems;
        this.description = description;
        this.price = price;
        this.restaurantId = restaurantId;
    }
}
