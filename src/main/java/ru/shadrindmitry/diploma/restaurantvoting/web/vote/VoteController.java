package ru.shadrindmitry.diploma.restaurantvoting.web.vote;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.Nullable;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import ru.shadrindmitry.diploma.restaurantvoting.service.VoteService;
import ru.shadrindmitry.diploma.restaurantvoting.to.VoteTo;
import ru.shadrindmitry.diploma.restaurantvoting.util.VoteUtil;
import ru.shadrindmitry.diploma.restaurantvoting.web.AuthUser;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(value = VoteController.REST_URL)
@Slf4j
@AllArgsConstructor
public class VoteController {
    static final String REST_URL = "/api/votes";
    private final VoteService voteService;

    @GetMapping
    @Transactional
    public List<VoteTo> getUserVotes(
            @AuthenticationPrincipal AuthUser authUser,
            @RequestParam @Nullable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        log.info("getAll Votes on date {}", date);
        return VoteUtil.getTos(voteService.getUserVotes(authUser.id(), date));
    }

    @PostMapping
    public VoteTo create(
            @AuthenticationPrincipal AuthUser authUser,
            @RequestParam int restaurantId) {
        int userId = authUser.id();
        log.info("create Vote from User {} for a Restaurant {}", userId, restaurantId);
        return VoteUtil.createTo(voteService.create(userId, restaurantId));
    }

    @PutMapping
    public void update(
            @AuthenticationPrincipal AuthUser authUser,
            @RequestParam int restaurantId) {
        int userId = authUser.id();
        log.info("create Vote from User {} for a Restaurant {}", userId, restaurantId);
        voteService.prepareAndSave(userId, restaurantId);
    }

}
