package ru.shadrindmitry.diploma.restaurantvoting.web.vote;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.shadrindmitry.diploma.restaurantvoting.model.Vote;
import ru.shadrindmitry.diploma.restaurantvoting.service.VoteService;

import java.util.List;

@RestController
@RequestMapping(value = VoteController.REST_URL)
@AllArgsConstructor
public class VoteController {
    static final String REST_URL = "/api/votes";

    protected VoteService voteService;

    @GetMapping
    public List<Vote> getAll() {
        return voteService.getAll();
    }
}
