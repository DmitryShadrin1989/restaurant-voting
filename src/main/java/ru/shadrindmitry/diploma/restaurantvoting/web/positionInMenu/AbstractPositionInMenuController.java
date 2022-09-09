package ru.shadrindmitry.diploma.restaurantvoting.web.positionInMenu;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import ru.shadrindmitry.diploma.restaurantvoting.repository.PositionInMenuRepository;
import ru.shadrindmitry.diploma.restaurantvoting.service.PositionInMenuService;

@Slf4j
public abstract class AbstractPositionInMenuController {
    @Autowired
    protected PositionInMenuService positionInMenuService;
    @Autowired
    protected PositionInMenuRepository positionInMenuRepository;

}
