package ru.shadrindmitry.diploma.restaurantvoting.web;

import lombok.Getter;
import lombok.ToString;
import org.springframework.lang.NonNull;
import ru.shadrindmitry.diploma.restaurantvoting.model.User;

@Getter
@ToString(of = "user")
public class AuthUser extends org.springframework.security.core.userdetails.User {

    private final User user;

    public AuthUser(@NonNull User user) {
        super(user.getEmail(), user.getPassword(), user.getRoles());
        this.user = user;
    }

    public int id() {
        return user.id();
    }
}