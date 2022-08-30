package ru.shadrindmitry.diploma.restaurantvoting.web.user;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.shadrindmitry.diploma.restaurantvoting.model.User;
import ru.shadrindmitry.diploma.restaurantvoting.repository.UserRepository;

import java.util.List;

@RestController
@RequestMapping(value = UserController.REST_URL)
@AllArgsConstructor
public class UserController {
    static final String REST_URL = "/api/users";

    protected UserRepository userRepository;

    @GetMapping
    public List<User> getAll() {
        return userRepository.findAll();
    }

}
