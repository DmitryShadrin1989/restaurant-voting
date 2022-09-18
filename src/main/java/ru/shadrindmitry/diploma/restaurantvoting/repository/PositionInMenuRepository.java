package ru.shadrindmitry.diploma.restaurantvoting.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import ru.shadrindmitry.diploma.restaurantvoting.model.PositionInMenu;

import java.time.LocalDate;
import java.util.List;

@Transactional(readOnly = true)
public interface PositionInMenuRepository extends BaseRepository<PositionInMenu> {

    @Query("SELECT p FROM PositionInMenu p WHERE p.restaurant.id = :restaurant_id AND p.dateMenuItem = :date")
    List<PositionInMenu> getOnDateForRestaurant(int restaurant_id, LocalDate date);

    @Query("SELECT p FROM PositionInMenu p WHERE p.dateMenuItem = :date")
    List<PositionInMenu> getAllOnDate(LocalDate date);

}
