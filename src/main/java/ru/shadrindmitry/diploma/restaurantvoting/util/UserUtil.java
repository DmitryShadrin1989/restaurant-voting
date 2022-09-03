package ru.shadrindmitry.diploma.restaurantvoting.util;

import lombok.experimental.UtilityClass;
import ru.shadrindmitry.diploma.restaurantvoting.model.User;

@UtilityClass
public class UserUtil {

    public static User prepareToSave(User user) {
        user.setEmail(user.getEmail().toLowerCase());
        return user;
    }
}
