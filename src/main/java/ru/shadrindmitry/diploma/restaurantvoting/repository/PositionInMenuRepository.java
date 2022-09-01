package ru.shadrindmitry.diploma.restaurantvoting.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import ru.shadrindmitry.diploma.restaurantvoting.model.PositionInMenu;

import java.time.LocalDate;
import java.util.List;

@Transactional(readOnly = true)
public interface PositionInMenuRepository extends JpaRepository<PositionInMenu, Integer> {

    @Query("SELECT p FROM PositionInMenu p WHERE p.restaurant.id = :restaurant_id ORDER BY p.date DESC")
    List<PositionInMenu> getAll(int restaurant_id);

    @Query("SELECT p FROM PositionInMenu p WHERE p.restaurant.id = :restaurant_id AND p.date = :date")
    List<PositionInMenu> getAllOnDate(int restaurant_id, LocalDate date);
}
