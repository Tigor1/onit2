package ru.stankin.onit2.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.stankin.onit2.entity.Car;
import ru.stankin.onit2.entity.Product;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductDTO {
    private Car car;
    private Double price;
    private boolean auto;

    public static Product toProduct(ProductDTO productDTO) {
        return Product.builder()
                .car(Car.builder()
                        .mark(productDTO.getCar().getMark())
                        .model(productDTO.getCar().getModel())
                        .build())
                .price(productDTO.price)
                .isAuto(productDTO.auto)
                .build();
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    public class CarDTO {
        private String mark;
        private String model;
    }
}
