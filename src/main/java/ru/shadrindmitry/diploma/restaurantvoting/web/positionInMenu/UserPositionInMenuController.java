package ru.shadrindmitry.diploma.restaurantvoting.web.positionInMenu;

import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;
import ru.shadrindmitry.diploma.restaurantvoting.to.PositionInMenuTo;

import java.time.LocalDate;
import java.util.List;

import static ru.shadrindmitry.diploma.restaurantvoting.util.PositionInMenuUtil.createTo;
import static ru.shadrindmitry.diploma.restaurantvoting.util.PositionInMenuUtil.getTos;

@RestController
@RequestMapping(value = UserPositionInMenuController.REST_URL)
@Slf4j
public class UserPositionInMenuController extends AbstractPositionInMenuController {
    static final String REST_URL = "/api/menu";

    @GetMapping("{id}")
    public PositionInMenuTo get(@PathVariable int id) {
        log.info("get PositionInMenu {}", id);
        return createTo(positionInMenuRepository.getExisted(id));
    }

    @GetMapping
    public List<PositionInMenuTo> getRestaurantMenu(@RequestParam int restaurant_id,
                                                    @RequestParam @Nullable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        log.info("getAll PositionInMenu for Restaurant {} on date {}", restaurant_id, date);
        return getTos(positionInMenuService.getRestaurantMenu(restaurant_id, date));
    }
}
