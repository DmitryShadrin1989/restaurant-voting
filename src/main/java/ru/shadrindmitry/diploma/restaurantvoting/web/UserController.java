package ru.shadrindmitry.diploma.restaurantvoting.web;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import ru.shadrindmitry.diploma.restaurantvoting.model.User;
import ru.shadrindmitry.diploma.restaurantvoting.repository.UserRepository;
import ru.shadrindmitry.diploma.restaurantvoting.util.UserUtil;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

import static ru.shadrindmitry.diploma.restaurantvoting.util.ValidationUtil.assureIdConsistent;
import static ru.shadrindmitry.diploma.restaurantvoting.util.ValidationUtil.checkNew;

@RestController
@RequestMapping(value = UserController.REST_URL)
@AllArgsConstructor
public class UserController {
    static final String REST_URL = "/api/users";

    protected UserRepository userRepository;

    @GetMapping("{id}")
    public ResponseEntity<User> get(@PathVariable int id) {
        return  ResponseEntity.of(userRepository.findById(id));
    }

    @GetMapping
    public List<User> getAll() {
        return userRepository.findAll(Sort.by(Sort.Direction.ASC, "name", "email"));
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
        userRepository.deleteExisted(id);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@Valid @RequestBody User user, @PathVariable int id) {
        assureIdConsistent(user, id);
        prepareAndSave(user);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> createWithLocation(@Valid @RequestBody User user) {
        checkNew(user);
        User created = prepareAndSave(user);
        URI uriOfNewResource = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path(REST_URL + "/{id}")
                .buildAndExpand(created.getId()).toUri();
        return ResponseEntity.created(uriOfNewResource).body(created);
    }

    protected User prepareAndSave(User user) {
        return userRepository.save(UserUtil.prepareToSave(user));
    }

}
