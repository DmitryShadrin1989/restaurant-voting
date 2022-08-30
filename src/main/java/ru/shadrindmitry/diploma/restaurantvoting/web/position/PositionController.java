package ru.shadrindmitry.diploma.restaurantvoting.web.position;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.shadrindmitry.diploma.restaurantvoting.model.Position;
import ru.shadrindmitry.diploma.restaurantvoting.repository.PositionRepository;

import java.util.List;

@RestController
@RequestMapping(value = PositionController.REST_URL)
@AllArgsConstructor
public class PositionController {
    static final String REST_URL = "/api/positions";

    protected PositionRepository positionRepository;
    @GetMapping("/{id}")
    public ResponseEntity<Position> get(@PathVariable int id) {
        return ResponseEntity.of(positionRepository.findById(id));
    }

    @GetMapping
    public List<Position> getAll() {
       return positionRepository.findAll();
    }
}
