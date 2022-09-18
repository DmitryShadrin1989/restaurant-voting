package ru.shadrindmitry.diploma.restaurantvoting.web.positionInMenu;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import ru.shadrindmitry.diploma.restaurantvoting.model.PositionInMenu;
import ru.shadrindmitry.diploma.restaurantvoting.repository.PositionInMenuRepository;
import ru.shadrindmitry.diploma.restaurantvoting.util.JsonUtil;
import ru.shadrindmitry.diploma.restaurantvoting.web.AbstractControllerTest;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static ru.shadrindmitry.diploma.restaurantvoting.web.positionInMenu.PositionInMenuTestData.POSITION_IN_MENU_1_ID;
import static ru.shadrindmitry.diploma.restaurantvoting.web.positionInMenu.PositionInMenuTestData.POSITION_IN_MENU_MATCHER;
import static ru.shadrindmitry.diploma.restaurantvoting.web.user.UserTestData.ADMIN_MAIL;

public class AdminPositionInMenuControllerTest extends AbstractControllerTest {

    private static final String REST_URL = AdminPositionInMenuController.REST_URL + '/';

    @Autowired
    private PositionInMenuRepository positionInMenuRepository;

    @Test
    @WithUserDetails(value = ADMIN_MAIL)
    void delete() throws Exception {
        perform(MockMvcRequestBuilders.delete(REST_URL + POSITION_IN_MENU_1_ID))
                .andDo(print())
                .andExpect(status().isNoContent());
        assertFalse(positionInMenuRepository.findById(POSITION_IN_MENU_1_ID).isPresent());
    }

//    @Test
//    @WithUserDetails(value = ADMIN_MAIL)
//    void update() throws Exception {
//        PositionInMenuTo updated = PositionInMenuTestData.getUpdated();
//        perform(MockMvcRequestBuilders.put(REST_URL + POSITION_IN_MENU_1_ID)
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(JsonUtil.writeValue(updated)))
//                .andExpect(status().isNoContent());
//
//        POSITION_IN_MENU_MATCHER.assertMatch(positionInMenuRepository.getExisted(POSITION_IN_MENU_1_ID),
//                PositionInMenuUtil.createFromTo(updated));
//    }


    @Test
    @WithUserDetails(value = ADMIN_MAIL)
    void create() throws Exception {
        PositionInMenu newPositionInMenu = PositionInMenuTestData.getNew();
        ResultActions action = perform(MockMvcRequestBuilders.post(REST_URL)
                .param("restaurant_id", "1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(JsonUtil.writeValue(newPositionInMenu)));

        PositionInMenu created = POSITION_IN_MENU_MATCHER.readFromJson(action);
        int newId = created.id();
        newPositionInMenu.setId(newId);
        POSITION_IN_MENU_MATCHER.assertMatch(created, newPositionInMenu);
        POSITION_IN_MENU_MATCHER.assertMatch(positionInMenuRepository.getExisted(newId), newPositionInMenu);
    }
}
