package com.ecommerceapp.ecommerce.controller;

import com.ecommerceapp.ecommerce.dto.ProductCreateRequest;
import com.ecommerceapp.ecommerce.entity.Product;
import com.ecommerceapp.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    // DTO ile ürün ekleme
    @PostMapping
    public Product create(@RequestBody ProductCreateRequest request) {
        return productService.createProduct(request);
    }

    // Entity ile güncelleme (istersen sonra DTO'ya çekebiliriz)
    @PutMapping("/{id}")
    public Product update(@PathVariable Long id, @RequestBody Product product) {
        return productService.updateProduct(id, product);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        productService.deleteProduct(id);
    }

    @GetMapping
    public List<Product> getAll() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Product getById(@PathVariable Long id) {
        return productService.getProductById(id);
    }
}
