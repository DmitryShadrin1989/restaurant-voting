package ru.shadrindmitry.diploma.restaurantvoting.web.restaurant;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import ru.shadrindmitry.diploma.restaurantvoting.model.Restaurant;
import ru.shadrindmitry.diploma.restaurantvoting.repository.RestaurantRepository;

import java.util.List;

@Slf4j
public abstract class AbstractRestaurantController {

    @Autowired
    protected RestaurantRepository repository;

    public ResponseEntity<Restaurant> get(int id) {
        log.info("get Restaurant {}", id);
        return ResponseEntity.of(repository.findById(id));
    }

    public List<Restaurant> getAll(){
        log.info("getAll Restaurants");
        return repository.findAll();
    }









}
