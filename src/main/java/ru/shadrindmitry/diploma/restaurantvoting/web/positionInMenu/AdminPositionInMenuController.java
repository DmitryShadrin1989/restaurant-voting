package ru.shadrindmitry.diploma.restaurantvoting.web.positionInMenu;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import ru.shadrindmitry.diploma.restaurantvoting.model.PositionInMenu;
import ru.shadrindmitry.diploma.restaurantvoting.to.PositionInMenuTo;

import java.net.URI;

import static ru.shadrindmitry.diploma.restaurantvoting.util.validation.ValidationUtil.assureIdConsistent;
import static ru.shadrindmitry.diploma.restaurantvoting.util.validation.ValidationUtil.checkNew;

@RestController
@RequestMapping(value = AdminPositionInMenuController.REST_URL)
@Slf4j
@AllArgsConstructor
public class AdminPositionInMenuController extends AbstractPositionInMenuController {
    static final String REST_URL = "/api/admin/menu";

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
