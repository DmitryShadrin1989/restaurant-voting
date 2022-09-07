package ru.shadrindmitry.diploma.restaurantvoting.web;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import ru.shadrindmitry.diploma.restaurantvoting.model.PositionInMenu;
import ru.shadrindmitry.diploma.restaurantvoting.repository.PositionInMenuRepository;
import ru.shadrindmitry.diploma.restaurantvoting.service.PositionInMenuService;
import ru.shadrindmitry.diploma.restaurantvoting.to.PositionInMenuTo;

import java.net.URI;
import java.time.LocalDate;
import java.util.List;

import static ru.shadrindmitry.diploma.restaurantvoting.util.PositionInMenuUtil.createTo;
import static ru.shadrindmitry.diploma.restaurantvoting.util.PositionInMenuUtil.getTos;
import static ru.shadrindmitry.diploma.restaurantvoting.util.ValidationUtil.assureIdConsistent;
import static ru.shadrindmitry.diploma.restaurantvoting.util.ValidationUtil.checkNew;

@RestController
@RequestMapping(value = PositionInMenuController.REST_URL)
@Slf4j
@AllArgsConstructor
public class PositionInMenuController {
    static final String REST_URL = "/api/menu";

    protected PositionInMenuService positionInMenuService;
    protected PositionInMenuRepository positionInMenuRepository;

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

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
        log.info("delete PositionInMenu {}", id);
        positionInMenuRepository.delete(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable int id,
                       @RequestBody PositionInMenuTo positionInMenuTo) {
        log.info("update PositionInMenu {}", id);
        assureIdConsistent(positionInMenuTo, id);
        positionInMenuService.update(positionInMenuTo, id);
    }

    @PostMapping
    public ResponseEntity<PositionInMenu> create(@RequestParam int restaurant_id,
                                                 @RequestBody PositionInMenuTo positionInMenuTo) {
        log.info("create PositionInMenu for Restaurant {}", restaurant_id);
        checkNew(positionInMenuTo);
        PositionInMenu created = positionInMenuService.create(positionInMenuTo, restaurant_id);
        URI uriOfNewResource = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path(REST_URL + "/{id}")
                .buildAndExpand(created.getId()).toUri();
        return ResponseEntity.created(uriOfNewResource).body(created);
    }
}
