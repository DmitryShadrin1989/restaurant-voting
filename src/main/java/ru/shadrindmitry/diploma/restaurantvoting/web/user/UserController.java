package ru.shadrindmitry.diploma.restaurantvoting.web.user;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.shadrindmitry.diploma.restaurantvoting.model.User;
import ru.shadrindmitry.diploma.restaurantvoting.repository.UserRepository;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {
    protected UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    public List<User> getAll() {
        return userRepository.findAll();
    }

}
