package ru.shadrindmitry.diploma.restaurantvoting.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.shadrindmitry.diploma.restaurantvoting.model.PositionInMenu;
import ru.shadrindmitry.diploma.restaurantvoting.repository.PositionInMenuRepository;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class PositionInMenuService {

    protected PositionInMenuRepository positionInMenuRepository;

    public List<PositionInMenu> get(int restaurant_id, LocalDate date) {
        return (date == null)?positionInMenuRepository.getAll(restaurant_id)
                :positionInMenuRepository.getAllOnDate(restaurant_id, date);
    }
}
