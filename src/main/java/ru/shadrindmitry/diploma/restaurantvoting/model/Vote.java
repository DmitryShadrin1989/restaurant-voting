package ru.shadrindmitry.diploma.restaurantvoting.model;

import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = "votes", uniqueConstraints = {@UniqueConstraint(columnNames = {"user_id", "date_vote"},
        name = "vote_unique_user_date_vote_idx")})
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(callSuper = true)
public class Vote extends BaseEntity {

    @Column(name = "date_vote", nullable = false)
    @NotNull
    private LocalDate dateVote;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @ToString.Exclude
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @ToString.Exclude
    private Restaurant restaurant;

    public Vote(Integer id, LocalDate dateVote, User user, Restaurant restaurant) {
        super(id);
        this.dateVote = dateVote;
        this.user = user;
        this.restaurant = restaurant;
    }

    public Vote(LocalDate dateVote, User user, Restaurant restaurant) {
        this.dateVote = dateVote;
        this.user = user;
        this.restaurant = restaurant;
    }
}
