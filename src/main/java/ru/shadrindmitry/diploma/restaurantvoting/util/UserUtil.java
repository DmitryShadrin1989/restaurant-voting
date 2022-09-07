package ru.shadrindmitry.diploma.restaurantvoting.util;

import lombok.experimental.UtilityClass;
import ru.shadrindmitry.diploma.restaurantvoting.model.User;

import static ru.shadrindmitry.diploma.restaurantvoting.config.SecurityConfiguration.PASSWORD_ENCODER;

@UtilityClass
public class UserUtil {

    public static User prepareToSave(User user) {
        user.setPassword(PASSWORD_ENCODER.encode(user.getPassword()));
        user.setEmail(user.getEmail().toLowerCase());
        return user;
    }
}
