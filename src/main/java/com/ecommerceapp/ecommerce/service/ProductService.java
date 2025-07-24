package com.ecommerceapp.ecommerce.service;

import com.ecommerceapp.ecommerce.dto.ProductCreateRequest;
import com.ecommerceapp.ecommerce.entity.Product;

import java.util.List;

public interface ProductService {
    Product createProduct(ProductCreateRequest request);
    Product updateProduct(Long id, Product product);
    void deleteProduct(Long id);
    List<Product> getAllProducts();
    Product getProductById(Long id);
}
