package ru.shadrindmitry.diploma.restaurantvoting.web.restaurant;

import ru.shadrindmitry.diploma.restaurantvoting.model.Restaurant;
import ru.shadrindmitry.diploma.restaurantvoting.web.MatcherFactory;

public class RestaurantTestData {

    public static final MatcherFactory.Matcher<Restaurant> RESTAURANT_MATCHER = MatcherFactory.usingIgnoringFieldsComparator(Restaurant.class, "menu");

    public static final int RESTAURANT1_ID = 1;
    public static final int RESTAURANT2_ID = 2;
    public static final int RESTAURANT3_ID = 3;

    public static final int RESTAURANT_NOT_FOUND_ID = 100;

    public static final Restaurant restaurant1 = new Restaurant(RESTAURANT1_ID, "Печки-лавочки");
    public static final Restaurant restaurant2 = new Restaurant(RESTAURANT2_ID, "Суши-терра");
    public static final Restaurant restaurant3 = new Restaurant(RESTAURANT3_ID, "Дрова-мука");

    public static Restaurant getUpdated() {
        return new Restaurant(RESTAURANT1_ID, "Обновленные Печки-лавочки");
    }

    public static Restaurant getNew() {
        return new Restaurant(null, "Новый ресторан");
    }
}