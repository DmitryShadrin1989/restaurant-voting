package ru.shadrindmitry.diploma.restaurantvoting.web.positionInMenu;

import ru.shadrindmitry.diploma.restaurantvoting.model.PositionInMenu;
import ru.shadrindmitry.diploma.restaurantvoting.to.PositionInMenuTo;
import ru.shadrindmitry.diploma.restaurantvoting.web.MatcherFactory;

import java.time.LocalDate;

import static ru.shadrindmitry.diploma.restaurantvoting.web.restaurant.RestaurantTestData.restaurant1;

public class PositionInMenuTestData {

    public static final MatcherFactory.Matcher<PositionInMenu> POSITION_IN_MENU_MATCHER = MatcherFactory
            .usingIgnoringFieldsComparator(PositionInMenu.class, "restaurant");

    public static final int POSITION_IN_MENU_1_ID = 1;
    public static final int POSITION_IN_MENU_2_ID = 2;
    public static final int POSITION_IN_MENU_3_ID = 3;
    public static final int POSITION_IN_MENU_4_ID = 4;
    public static final int POSITION_IN_MENU_5_ID = 5;
    public static final int POSITION_IN_MENU_6_ID = 16;
    public static final int POSITION_IN_MENU_7_ID = 17;
    public static final int POSITION_IN_MENU_8_ID = 18;
    public static final int POSITION_IN_MENU_9_ID = 19;
    public static final int POSITION_IN_MENU_10_ID = 20;

    public static final PositionInMenu positionInMenu1 = new PositionInMenu(POSITION_IN_MENU_1_ID, LocalDate.of(2022, 1, 1),
            "Винегрет", 150d, restaurant1);
    public static final PositionInMenu positionInMenu2 = new PositionInMenu(POSITION_IN_MENU_2_ID, LocalDate.of(2022, 1, 1),
            "Борщ", 200d, restaurant1);
    public static final PositionInMenu positionInMenu3 = new PositionInMenu(POSITION_IN_MENU_3_ID, LocalDate.of(2022, 1, 1),
            "Картофельное пюре", 130d, restaurant1);
    public static final PositionInMenu positionInMenu4 = new PositionInMenu(POSITION_IN_MENU_4_ID, LocalDate.of(2022, 1, 1),
            "Котлета по Киевски", 190d, restaurant1);
    public static final PositionInMenu positionInMenu5 = new PositionInMenu(POSITION_IN_MENU_5_ID, LocalDate.of(2022, 1, 1),
            "Компот", 30d, restaurant1);
    public static final PositionInMenu positionInMenu6 = new PositionInMenu(POSITION_IN_MENU_6_ID, LocalDate.of(2022, 1, 2),
            "Сельдь под шубой", 200d, restaurant1);
    public static final PositionInMenu positionInMenu7 = new PositionInMenu(POSITION_IN_MENU_7_ID, LocalDate.of(2022, 1, 2),
            "Борщ", 190d, restaurant1);
    public static final PositionInMenu positionInMenu8 = new PositionInMenu(POSITION_IN_MENU_8_ID, LocalDate.of(2022, 1, 2),
            "Картофельное пюре", 170d, restaurant1);
    public static final PositionInMenu positionInMenu9 = new PositionInMenu(POSITION_IN_MENU_9_ID, LocalDate.of(2022, 1, 2),
            "Шашлык из курицы", 300d, restaurant1);
    public static final PositionInMenu positionInMenu10 = new PositionInMenu(POSITION_IN_MENU_10_ID, LocalDate.of(2022, 1, 2),
            "Компот", 35d, restaurant1);

    public static PositionInMenuTo getUpdated() {
        return new PositionInMenuTo(POSITION_IN_MENU_1_ID, LocalDate.of(2022, 1, 1),
                "Обновленный Винегрет", 160d);
    }

    public static PositionInMenu getNew() {
        return new PositionInMenu(LocalDate.of(2022, 1, 3),
                "Новая позиция в меню", 220d, restaurant1);
    }
}
