package ru.shadrindmitry.diploma.restaurantvoting.web.restaurant;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.shadrindmitry.diploma.restaurantvoting.model.Restaurant;
import ru.shadrindmitry.diploma.restaurantvoting.service.RestaurantService;

import java.util.List;

@RestController
@RequestMapping(value = "/restaurants")
public class RestaurantController {

    protected RestaurantService restaurantService;

    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @GetMapping
    public List<Restaurant> getAll(){
        //return restaurantRepository.findAll();
        return restaurantService.getAll();
    }
}
