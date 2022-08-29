package ru.shadrindmitry.diploma.restaurantvoting.web.restaurant;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.shadrindmitry.diploma.restaurantvoting.model.Restaurant;
import ru.shadrindmitry.diploma.restaurantvoting.service.RestaurantService;

import java.util.List;

@RestController
@RequestMapping(value = "/restaurants")
@AllArgsConstructor
public class RestaurantController {
    protected RestaurantService restaurantService;

    @GetMapping("/{id}")
    public Restaurant get(@PathVariable int id) {
        return restaurantService.get(id);
    }

    @GetMapping
    public List<Restaurant> getAll(){
        return restaurantService.getAll();
    }
}
