package ru.shadrindmitry.diploma.restaurantvoting.web.restaurant;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.shadrindmitry.diploma.restaurantvoting.model.Restaurant;

import java.util.List;

@RestController
@RequestMapping(value = UserRestaurantController.REST_URL)
@Slf4j
public class UserRestaurantController extends AbstractRestaurantController {
    static final String REST_URL = "/api/restaurants";

    @GetMapping("/{id}")
    public ResponseEntity<Restaurant> get(@PathVariable int id) {
        return super.get(id);
    }

    @GetMapping
    public List<Restaurant> getAll(){
        return super.getAll();
    }

}
