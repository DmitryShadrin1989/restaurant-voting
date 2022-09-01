package ru.shadrindmitry.diploma.restaurantvoting.web.position;

import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.shadrindmitry.diploma.restaurantvoting.model.PositionInMenu;
import ru.shadrindmitry.diploma.restaurantvoting.repository.PositionInMenuRepository;
import ru.shadrindmitry.diploma.restaurantvoting.service.PositionInMenuService;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(value = PositionInMenuController.REST_URL)
@AllArgsConstructor
public class PositionInMenuController {
    static final String REST_URL = "/api/menu";

    protected PositionInMenuService positionInMenuService;
    protected PositionInMenuRepository positionInMenuRepository;

    @GetMapping
    public List<PositionInMenu> get(@RequestParam int restaurant_id,
                                    @RequestParam @Nullable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return positionInMenuService.get(restaurant_id, date);
    }

}
