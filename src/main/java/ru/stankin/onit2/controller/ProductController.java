package ru.stankin.onit2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.stankin.onit2.dto.ProductDTO;
import ru.stankin.onit2.entity.Product;
import ru.stankin.onit2.service.ProductService;
import java.util.List;

@RestController
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/greet")
    public String greet(@RequestParam(defaultValue = "world") String name) {
        return "hello, " + name + "!";
    }

    @GetMapping("/products")
    public List<Product> getProducts() {
        return productService.getProducts();
    }

    @PostMapping("/products")
    public Product addProduct(@RequestBody ProductDTO product) {
        return productService.saveProduct(ProductDTO.toProduct(product));
    }

    @GetMapping("/products/{id}")
    public Product getProduct(@PathVariable long id) {
        return productService.getProductById(id)
                .orElseThrow();
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<?> deleteProductById(@PathVariable long id) {
        productService.deleteProductById(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/products/{id}")
    public Product updateProduct(@PathVariable long id, @RequestBody ProductDTO productDTO) {
        return productService.updateProduct(id, ProductDTO.toProduct(productDTO));
    }
}
