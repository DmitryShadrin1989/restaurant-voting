package ru.shadrindmitry.diploma.restaurantvoting.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@ToString(callSuper = true)
public class RestaurantRating {

    public Restaurant restaurant;

    public int numberOfVotes;
}
