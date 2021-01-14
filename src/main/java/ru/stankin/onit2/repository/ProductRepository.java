package ru.stankin.onit2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.stankin.onit2.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
