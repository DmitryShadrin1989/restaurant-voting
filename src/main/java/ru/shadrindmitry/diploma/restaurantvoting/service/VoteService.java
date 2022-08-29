package ru.shadrindmitry.diploma.restaurantvoting.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.shadrindmitry.diploma.restaurantvoting.model.Vote;
import ru.shadrindmitry.diploma.restaurantvoting.repository.VoteRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class VoteService {
    protected VoteRepository voteRepository;

    public List<Vote> getAll() {
        return voteRepository.findAll();
    }
}
