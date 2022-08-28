package ru.shadrindmitry.diploma.restaurantvoting.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "restaurants")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
//@AllArgsConstructor
@ToString(callSuper = true)
public class Restaurant extends NamedEntity{

    public Restaurant(Integer id, String name) {
        super(id, name);
    }
}
