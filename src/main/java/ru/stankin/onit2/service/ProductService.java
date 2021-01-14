package ru.stankin.onit2.service;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.stankin.onit2.entity.Product;
import ru.stankin.onit2.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepository repository;

    @Autowired
    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public List<Product> getProducts() {
        return repository.findAll();
    }

    public Product saveProduct(Product product) {
        return repository.save(product);
    }

    public Optional<Product> getProductById(Long id) {
        return repository.findById(id);
    }

    public void deleteProductById(long id) {
        repository.deleteById(id);
    }

    public Product updateProduct(long id, Product productRequest) {
        return repository.findById(id).map(product-> {
//            product.setCar(productRequest.getCar());
            product.setAuto(productRequest.isAuto());
            product.setPrice(productRequest.getPrice());
            return repository.save(product);
        }).orElseGet(()->repository.save(productRequest));
    }
}
