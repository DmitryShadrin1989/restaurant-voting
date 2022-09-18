package ru.shadrindmitry.diploma.restaurantvoting.web.positioninmenu;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import ru.shadrindmitry.diploma.restaurantvoting.model.PositionInMenu;
import ru.shadrindmitry.diploma.restaurantvoting.repository.PositionInMenuRepository;
import ru.shadrindmitry.diploma.restaurantvoting.service.PositionInMenuService;

import java.net.URI;

import static ru.shadrindmitry.diploma.restaurantvoting.util.validation.ValidationUtil.assureIdConsistent;
import static ru.shadrindmitry.diploma.restaurantvoting.util.validation.ValidationUtil.checkNew;

@RestController
@RequestMapping(value = AdminPositionInMenuController.REST_URL)
@Slf4j
@AllArgsConstructor
public class AdminPositionInMenuController {
    static final String REST_URL = "/api/admin/menu items";
    protected PositionInMenuService positionInMenuService;
    protected PositionInMenuRepository positionInMenuRepository;

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
        log.info("delete PositionInMenu {}", id);
        positionInMenuRepository.delete(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable int id,
                       @RequestBody PositionInMenu positionInMenu) {
        log.info("update PositionInMenu {}", id);
        assureIdConsistent(positionInMenu, id);
        positionInMenuService.update(positionInMenu, id);
    }

    @PostMapping
    public ResponseEntity<PositionInMenu> create(@RequestParam int restaurant_id,
                                                 @RequestBody PositionInMenu positionInMenu) {
        log.info("create PositionInMenu for Restaurant {}", restaurant_id);
        checkNew(positionInMenu);
        PositionInMenu created = positionInMenuService.create(positionInMenu, restaurant_id);
        URI uriOfNewResource = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path(REST_URL + "/{id}")
                .buildAndExpand(created.getId()).toUri();
        return ResponseEntity.created(uriOfNewResource).body(created);
    }
}