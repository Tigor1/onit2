package ru.stankin.onit2.entity;

import com.sun.istack.NotNull;
import lombok.*;
import javax.persistence.*;


@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name="car_id")
    @NotNull private Car car;
    @NotNull private Double price;
    @NotNull private boolean isAuto;
}
