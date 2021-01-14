package ru.stankin.onit2.entity;

import com.sun.istack.NotNull;
import lombok.*;
import javax.persistence.*;
import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull private long id;
    @NotNull private String mark;
    @NotNull private String model;
    @OneToMany(targetEntity = Product.class, cascade = CascadeType.ALL, mappedBy = "car", fetch = FetchType.LAZY)
    @Getter(value = AccessLevel.NONE)
    @Setter(value = AccessLevel.NONE)
    private List<Product> products;
}
