package ru.shadrindmitry.diploma.restaurantvoting.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import ru.shadrindmitry.diploma.restaurantvoting.model.Position;

@Transactional(readOnly = true)
public interface PositionRepository extends JpaRepository<Position, Integer> {

}
