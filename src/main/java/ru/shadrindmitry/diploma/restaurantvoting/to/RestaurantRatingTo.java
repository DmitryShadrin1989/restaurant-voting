package ru.shadrindmitry.diploma.restaurantvoting.to;

import lombok.*;
import ru.shadrindmitry.diploma.restaurantvoting.model.Restaurant;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@ToString(callSuper = true, exclude = {"restaurant"})
public class RestaurantRatingTo {

    public Restaurant restaurant;

    public int numberOfVotes;
}
