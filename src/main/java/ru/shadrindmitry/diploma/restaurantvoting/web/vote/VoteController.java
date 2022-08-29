package ru.shadrindmitry.diploma.restaurantvoting.web.vote;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.shadrindmitry.diploma.restaurantvoting.model.Vote;
import ru.shadrindmitry.diploma.restaurantvoting.service.VoteService;

import java.util.List;

@RestController
@RequestMapping(value = "/votes")
@AllArgsConstructor
public class VoteController {
    protected VoteService voteService;

    @GetMapping
    public List<Vote> getAll() {
        return voteService.getAll();
    }
}
