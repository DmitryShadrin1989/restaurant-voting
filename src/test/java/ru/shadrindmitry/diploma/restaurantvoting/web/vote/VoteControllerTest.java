package ru.shadrindmitry.diploma.restaurantvoting.web.vote;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import ru.shadrindmitry.diploma.restaurantvoting.service.VoteService;
import ru.shadrindmitry.diploma.restaurantvoting.web.AbstractControllerTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static ru.shadrindmitry.diploma.restaurantvoting.web.restaurant.RestaurantTestData.RESTAURANT1_ID;
import static ru.shadrindmitry.diploma.restaurantvoting.web.user.UserTestData.USER1_ID;
import static ru.shadrindmitry.diploma.restaurantvoting.web.user.UserTestData.USER1_MAIL;
import static ru.shadrindmitry.diploma.restaurantvoting.web.vote.VoteTestData.*;

public class VoteControllerTest extends AbstractControllerTest {

    private static final String REST_URL = VoteController.REST_URL + '/';

    @Autowired
    private VoteService voteService;

    @Test
    @WithUserDetails(value = USER1_MAIL)
    void getUserVotes() throws Exception {
        perform(MockMvcRequestBuilders.get(REST_URL))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(VOTE_MATCHER.contentJson(vote4, vote1));
    }

    @Test
    @WithUserDetails(value = USER1_MAIL)
    void getUserVoteOnDate() throws Exception {
        perform(MockMvcRequestBuilders.get(REST_URL)
                .param("date", "2022-01-01"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(VOTE_MATCHER.contentJson(List.of(vote1)));
    }

    @Test
    @WithUserDetails(value = USER1_MAIL)
    void getRestaurantRatingOnDate() throws Exception {
        perform(MockMvcRequestBuilders.get(REST_URL + "/rating")
                .param("date", "2022-01-01"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(RESTAURANT_RATING_MATCHER.contentJson(restaurantRating1, restaurantRating2));
    }

    @Test
    @WithUserDetails(value = USER1_MAIL)
    void delete() throws Exception {
        voteService.create(USER1_ID, RESTAURANT1_ID);
        perform(MockMvcRequestBuilders.delete(REST_URL)
                .param("date", DATE_TOMORROW.toString()))
                .andExpect(status().isNoContent());
        assertTrue(voteService.getUserVotes(USER1_ID, DATE_TOMORROW).isEmpty());
    }

}
