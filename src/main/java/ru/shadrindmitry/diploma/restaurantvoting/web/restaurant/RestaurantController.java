package ru.shadrindmitry.diploma.restaurantvoting.web.restaurant;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.shadrindmitry.diploma.restaurantvoting.model.Restaurant;
import ru.shadrindmitry.diploma.restaurantvoting.repository.RestaurantRepository;

import java.util.List;

@RestController
@RequestMapping(value = "/restaurants")
public class RestaurantController {
    protected RestaurantRepository restaurantRepository;

    public RestaurantController(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    @GetMapping
    public List<Restaurant> getAll(){
        return restaurantRepository.findAll();
    }
}
