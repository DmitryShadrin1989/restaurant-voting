package ru.shadrindmitry.diploma.restaurantvoting.web.position;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.shadrindmitry.diploma.restaurantvoting.model.Position;
import ru.shadrindmitry.diploma.restaurantvoting.repository.PositionRepository;

import java.util.List;

@RestController
@RequestMapping(value = "/positions")
public class PositionController {

    protected PositionRepository positionRepository;

    public PositionController(PositionRepository positionRepository) {
        this.positionRepository = positionRepository;
    }

    @GetMapping
    public List<Position> getAll() {
       return positionRepository.findAll();
    }
}
