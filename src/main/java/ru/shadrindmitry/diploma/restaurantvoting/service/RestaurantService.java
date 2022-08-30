package ru.shadrindmitry.diploma.restaurantvoting.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.shadrindmitry.diploma.restaurantvoting.repository.RestaurantRepository;

@Service
@AllArgsConstructor
public class RestaurantService {
    protected RestaurantRepository restaurantRepository;

}
