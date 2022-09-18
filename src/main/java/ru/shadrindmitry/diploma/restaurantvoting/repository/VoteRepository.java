package ru.shadrindmitry.diploma.restaurantvoting.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import ru.shadrindmitry.diploma.restaurantvoting.model.Vote;

import java.time.LocalDate;
import java.util.List;

@Transactional(readOnly = true)
public interface VoteRepository extends JpaRepository<Vote, Integer> {

    @Query("SELECT v FROM Vote v WHERE v.user.id = :userId ORDER BY v.dateVote DESC")
    List<Vote> getAllForUser(int userId);

    @Query("SELECT v FROM Vote v WHERE v.user.id = :userId AND v.dateVote = :date")
    List<Vote> getOnDateForUser(int userId, LocalDate date);

    @Query("SELECT v FROM Vote v WHERE v.dateVote = :date ORDER BY v.dateVote DESC")
    List<Vote> getAllOnDate(LocalDate date);

    @Query("SELECT v FROM Vote v ORDER BY v.dateVote DESC")
    List<Vote> getAll();
}
