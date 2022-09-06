package ru.shadrindmitry.diploma.restaurantvoting.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import ru.shadrindmitry.diploma.restaurantvoting.model.Vote;

import java.time.LocalDate;
import java.util.List;

@Transactional(readOnly = true)
public interface VoteRepository extends JpaRepository<Vote, Integer> {

    @Query("SELECT v FROM Vote v ORDER BY v.date DESC")
    List<Vote> getAll();

    @Query("SELECT v FROM Vote v WHERE v.date = :date ORDER BY v.date DESC")
    List<Vote> getAllOnDate(LocalDate date);

    @Modifying
    @Query("DELETE FROM Vote v WHERE v.date = :date AND v.user.id = :userId")
    void deleteVoteOnDate(LocalDate date, int userId);
}
