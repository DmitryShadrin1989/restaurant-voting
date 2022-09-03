package ru.shadrindmitry.diploma.restaurantvoting.repository;

import org.springframework.transaction.annotation.Transactional;
import ru.shadrindmitry.diploma.restaurantvoting.model.Restaurant;

@Transactional(readOnly = true)
public interface RestaurantRepository extends BaseRepository<Restaurant> {

}
