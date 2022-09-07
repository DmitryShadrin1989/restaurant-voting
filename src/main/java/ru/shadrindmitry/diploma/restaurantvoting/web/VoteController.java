package ru.shadrindmitry.diploma.restaurantvoting.web;

import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import ru.shadrindmitry.diploma.restaurantvoting.model.RestaurantRating;
import ru.shadrindmitry.diploma.restaurantvoting.model.Vote;
import ru.shadrindmitry.diploma.restaurantvoting.service.VoteService;
import ru.shadrindmitry.diploma.restaurantvoting.to.VoteTo;
import ru.shadrindmitry.diploma.restaurantvoting.util.VoteUtil;

import java.net.URI;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(value = VoteController.REST_URL)
@AllArgsConstructor
public class VoteController {
    static final String REST_URL = "/api/votes";

    protected VoteService voteService;

    @GetMapping
    public List<VoteTo> getAll(@RequestParam @Nullable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return VoteUtil.getTos(voteService.getAll(date));
    }

    @GetMapping("/rating")
    public List<RestaurantRating> getRestaurantRating(@RequestParam @Nullable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return voteService.getRestaurantRating(date);
    }

    @DeleteMapping
    public void delete(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date,
                       @RequestParam int userId) {
        voteService.deleteVoteOnDate(date, userId);
    }

    @PostMapping
    public ResponseEntity<Vote> createUpdate(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date,
            @RequestParam int userId,
            @RequestParam int restaurantId) {
        Vote created = voteService.createUpdate(date, userId, restaurantId);
        URI uriOfNewResource = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path(REST_URL + "/{id}")
                .buildAndExpand(created.getId()).toUri();
        return ResponseEntity.created(uriOfNewResource).body(created);
    }

}
