package ru.shadrindmitry.diploma.restaurantvoting.web.user;

import ru.shadrindmitry.diploma.restaurantvoting.model.Role;
import ru.shadrindmitry.diploma.restaurantvoting.model.User;
import ru.shadrindmitry.diploma.restaurantvoting.util.JsonUtil;
import ru.shadrindmitry.diploma.restaurantvoting.web.MatcherFactory;

import java.util.Collections;
import java.util.List;

public class UserTestData {

    public static final MatcherFactory.Matcher<User> USER_MATCHER = MatcherFactory.usingIgnoringFieldsComparator(User.class, "password");
    public static final int USER1_ID = 1;
    public static final int USER2_ID = 2;
    public static final int USER3_ID = 3;
    public static final int ADMIN_ID = 4;
    public static final int GUEST_ID = 5;
    public static final int NOT_FOUND = 100;
    public static final String USER1_MAIL = "user1@gmail.com";
    public static final String USER2_MAIL = "user2@gmail.com";
    public static final String USER3_MAIL = "user3@gmail.com";
    public static final String ADMIN_MAIL = "admin@gmail.com";
    public static final String GUEST_MAIL = "guest@gmail.com";

    public static final User user1 = new User(USER1_ID, "User1", USER1_MAIL, "password1", Role.USER);
    public static final User user2 = new User(USER2_ID, "User2", USER2_MAIL, "password2", Role.USER);
    public static final User user3 = new User(USER3_ID, "User3", USER3_MAIL, "password3", Role.USER);
    public static final User admin = new User(ADMIN_ID, "Admin", ADMIN_MAIL, "admin", Role.ADMIN, Role.USER);
    public static final User guest = new User(GUEST_ID, "Guest", GUEST_MAIL, "guest");

    public static User getNew() {
        return new User(null, "New", "new@gmail.com", "newPass", Collections.singleton(Role.USER));
    }

    public static User getUpdated() {
        return new User(USER1_ID, "UpdatedName", USER1_MAIL, "newPass", List.of(Role.ADMIN));
    }

    public static String jsonWithPassword(User user, String passw) {
        return JsonUtil.writeAdditionProps(user, "password", passw);
    }
}