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
import ru.shadrindmitry.diploma.restaurantvoting.to.PositionInMenuTo;

import java.net.URI;

import static ru.shadrindmitry.diploma.restaurantvoting.util.validation.ValidationUtil.assureIdConsistent;
import static ru.shadrindmitry.diploma.restaurantvoting.util.validation.ValidationUtil.checkNew;

@RestController
@RequestMapping(value = AdminPositionInMenuController.REST_URL)
@Slf4j
@AllArgsConstructor
public class AdminPositionInMenuController {

    static final String REST_URL = "/api/admin/menu items";
    private final PositionInMenuService positionInMenuService;
    private final PositionInMenuRepository positionInMenuRepository;

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
        positionInMenuService.update(positionInMenuTo);
    }

    @PostMapping
    public ResponseEntity<PositionInMenu> create(@RequestBody PositionInMenuTo positionInMenuTo) {
        log.info("create PositionInMenu");
        checkNew(positionInMenuTo);
        PositionInMenu created = positionInMenuService.create(positionInMenuTo);
        URI uriOfNewResource = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path(REST_URL + "/{id}")
                .buildAndExpand(created.getId()).toUri();
        return ResponseEntity.created(uriOfNewResource).body(created);
    }
}
