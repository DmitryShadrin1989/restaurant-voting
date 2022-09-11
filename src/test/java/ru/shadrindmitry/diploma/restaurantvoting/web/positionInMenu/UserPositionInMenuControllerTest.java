package ru.shadrindmitry.diploma.restaurantvoting.web.positionInMenu;

import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import ru.shadrindmitry.diploma.restaurantvoting.web.AbstractControllerTest;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static ru.shadrindmitry.diploma.restaurantvoting.web.positionInMenu.PositionInMenuTestData.*;
import static ru.shadrindmitry.diploma.restaurantvoting.web.user.UserTestData.USER1_MAIL;

public class UserPositionInMenuControllerTest extends AbstractControllerTest {

    private static final String REST_URL = UserPositionInMenuController.REST_URL + '/';

    @Test
    @WithUserDetails(value = USER1_MAIL)
    void get() throws Exception {
        perform(MockMvcRequestBuilders.get(REST_URL + POSITION_IN_MENU_1_ID))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(POSITION_IN_MENU_MATCHER.contentJson(positionInMenu1));
    }

    @Test
    @WithUserDetails(value = USER1_MAIL)
    void getRestaurantMenu() throws Exception {
        perform(MockMvcRequestBuilders.get(REST_URL)
                .param("restaurant_id", "1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(POSITION_IN_MENU_MATCHER.contentJson(positionInMenu6, positionInMenu7,
                        positionInMenu8, positionInMenu9, positionInMenu10, positionInMenu1,
                        positionInMenu2, positionInMenu3, positionInMenu4, positionInMenu5));
    }

    @Test
    @WithUserDetails(value = USER1_MAIL)
    void getRestaurantMenuOnDate() throws Exception {
        perform(MockMvcRequestBuilders.get(REST_URL)
                .param("restaurant_id", "1").param("date", "2022-01-01"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(POSITION_IN_MENU_MATCHER.contentJson(positionInMenu1, positionInMenu2,
                        positionInMenu3, positionInMenu4, positionInMenu5));
    }






}
