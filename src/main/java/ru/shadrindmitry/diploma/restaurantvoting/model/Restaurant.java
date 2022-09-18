package ru.shadrindmitry.diploma.restaurantvoting.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import ru.shadrindmitry.diploma.restaurantvoting.util.validation.NoHtml;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "restaurants")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(callSuper = true)
public class Restaurant extends BaseEntity{

    @Column(name = "name", nullable = false, unique = true)
    @NotBlank
    @Size(max = 128)
    @NoHtml
    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "restaurant")
    @OrderBy("date DESC")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    @ToString.Exclude
    private List<PositionInMenu> menu;

    public Restaurant(Integer id, String name, List<PositionInMenu> menu) {
        super(id);
        this.name = name;
        this.menu = menu;
    }

    public Restaurant(Integer id, String name) {
        super(id);
        this.name = name;
    }
}
