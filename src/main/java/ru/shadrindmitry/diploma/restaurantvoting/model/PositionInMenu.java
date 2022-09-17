package ru.shadrindmitry.diploma.restaurantvoting.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
@Table(name = "positions_in_menu")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(callSuper = true)
public class PositionInMenu extends BaseEntity {

    @Column(name = "date", nullable = false)
    @NotNull
    private LocalDate date;

    @Column(name = "description", nullable = false)
    @NotBlank
    @Size(min = 2, max = 120)
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "position_type", nullable = false)
    @NotNull
    private PositionType positionType;

    @Column(name = "price", nullable = false)
    @NotNull
    @Range(min = 5, max = 10000)
    private Double price;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "restaurant_id", nullable = false)
    @JsonIgnore
    private Restaurant restaurant;

    public PositionInMenu(LocalDate date, String description, PositionType positionType, Double price, Restaurant restaurant) {
        this.date = date;
        this.description = description;
        this.positionType = positionType;
        this.price = price;
        this.restaurant = restaurant;
    }

    public PositionInMenu(Integer id, LocalDate date, String description, PositionType positionType, Double price, Restaurant restaurant) {
        super(id);
        this.date = date;
        this.description = description;
        this.positionType = positionType;
        this.price = price;
        this.restaurant = restaurant;
    }
}
