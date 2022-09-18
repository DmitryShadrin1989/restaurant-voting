package ru.shadrindmitry.diploma.restaurantvoting.web.restaurant;

import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;
import ru.shadrindmitry.diploma.restaurantvoting.model.Restaurant;
import ru.shadrindmitry.diploma.restaurantvoting.to.RestaurantRatingTo;
import ru.shadrindmitry.diploma.restaurantvoting.to.RestaurantTo;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = UserRestaurantController.REST_URL)
@Slf4j
public class UserRestaurantController extends AbstractRestaurantController {
    static final String REST_URL = "/api/restaurants";

    @GetMapping("/with menu items/{id}")
    public Map<LocalDate, RestaurantTo> getWithMenuItems(@PathVariable int id,
                                        @RequestParam @Nullable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        log.info("get Restaurant {} with menu items on date {}", id, date);
        return service.getWithMenuItems(id, date);
    }

    @GetMapping("/with menu items")
    public Map<LocalDate, List<RestaurantTo>> getAllWithMenuItems(
            @RequestParam @Nullable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        log.info("get Restaurants with menu items on date {}", date);
        return service.getAllWithMenuItems(date);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Restaurant> get(@PathVariable int id) {
        log.info("get Restaurant {}", id);
        return ResponseEntity.of(repository.findById(id));
    }

    @GetMapping
    public List<Restaurant> getAll(){
        log.info("getAll Restaurants");
        return repository.findAll();
    }

    @GetMapping("/rating")
    public Map<LocalDate, List<RestaurantRatingTo>> getRestaurantRating(
            @RequestParam @Nullable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        log.info("getRestaurantRating on date {}", date);
        return service.getRestaurantRating(date);
    }

}
