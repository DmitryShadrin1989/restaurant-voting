package ru.shadrindmitry.diploma.restaurantvoting.web.vote;

import ru.shadrindmitry.diploma.restaurantvoting.model.Vote;
import ru.shadrindmitry.diploma.restaurantvoting.to.RestaurantRatingTo;
import ru.shadrindmitry.diploma.restaurantvoting.to.VoteTo;
import ru.shadrindmitry.diploma.restaurantvoting.web.MatcherFactory;

import java.time.LocalDate;

import static ru.shadrindmitry.diploma.restaurantvoting.web.restaurant.RestaurantTestData.*;
import static ru.shadrindmitry.diploma.restaurantvoting.web.user.UserTestData.*;

public class VoteTestData {

    public static final MatcherFactory.Matcher<VoteTo> VOTE_TO_MATCHER = MatcherFactory.usingIgnoringFieldsComparator(VoteTo.class);
    public static final MatcherFactory.Matcher<RestaurantRatingTo> RESTAURANT_RATING_MATCHER = MatcherFactory.usingIgnoringFieldsComparator(RestaurantRatingTo.class);

    public static final LocalDate DATE_TOMORROW = LocalDate.now().plusDays(1);

    public static final int VOTE1_ID = 1;
    public static final int VOTE2_ID = 2;
    public static final int VOTE3_ID = 3;
    public static final int VOTE4_ID = 4;
    public static final int VOTE5_ID = 5;
    public static final int VOTE6_ID = 6;
    public static final int VOTE_FOR_TOMORROW_ID = 7;

    public static final Vote vote1 = new Vote(VOTE1_ID, LocalDate.of(2022, 1, 1), user1, restaurant1);
    public static final Vote vote2 = new Vote(VOTE2_ID, LocalDate.of(2022, 1, 1), user2, restaurant2);
    public static final Vote vote3 = new Vote(VOTE3_ID, LocalDate.of(2022, 1, 1), user3, restaurant2);
    public static final Vote vote4 = new Vote(VOTE4_ID, LocalDate.of(2022, 1, 2), user1, restaurant1);
    public static final Vote vote5 = new Vote(VOTE5_ID, LocalDate.of(2022, 1, 2), user2, restaurant1);
    public static final Vote vote6 = new Vote(VOTE6_ID, LocalDate.of(2022, 1, 2), user3, restaurant3);

    public static final Vote voteForTomorrow = new Vote(VOTE_FOR_TOMORROW_ID, DATE_TOMORROW, user1, restaurant1);

    public static final RestaurantRatingTo RESTAURANT_RATING_TO_1 = new RestaurantRatingTo(restaurant1, 1);
    public static final RestaurantRatingTo RESTAURANT_RATING_TO_2 = new RestaurantRatingTo(restaurant2, 2);
}
