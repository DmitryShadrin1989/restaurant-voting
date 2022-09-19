package ru.shadrindmitry.diploma.restaurantvoting.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
@Table(name = "menu_item")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(callSuper = true)
public class PositionInMenu extends BaseEntity {

    @Column(name = "date_menu_item", nullable = false)
    @NotNull
    private LocalDate dateMenuItem;

    @Column(name = "description", nullable = false)
    @NotBlank
    @Size(min = 2, max = 120)
    private String description;

    @Column(name = "price", nullable = false)
    @NotNull
    private int price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id", nullable = false)
    @ToString.Exclude
    private Restaurant restaurant;

    public PositionInMenu(LocalDate dateMenuItem, String description, int price, Restaurant restaurant) {
        this.dateMenuItem = dateMenuItem;
        this.description = description;
        this.price = price;
        this.restaurant = restaurant;
    }

    public PositionInMenu(Integer id, LocalDate dateMenuItem, String description, int price, Restaurant restaurant) {
        super(id);
        this.dateMenuItem = dateMenuItem;
        this.description = description;
        this.price = price;
        this.restaurant = restaurant;
    }
}
