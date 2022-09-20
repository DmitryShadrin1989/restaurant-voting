package ru.shadrindmitry.diploma.restaurantvoting.web.positioninmenu;

import org.springframework.beans.factory.annotation.Autowired;
import ru.shadrindmitry.diploma.restaurantvoting.repository.PositionInMenuRepository;
import ru.shadrindmitry.diploma.restaurantvoting.web.AbstractControllerTest;

public class AdminPositionInMenuControllerTest extends AbstractControllerTest {

    private static final String REST_URL = AdminPositionInMenuController.REST_URL;

    @Autowired
    private PositionInMenuRepository positionInMenuRepository;

}
