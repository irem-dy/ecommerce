package com.ecommerceapp.ecommerce.service;

import com.ecommerceapp.ecommerce.entity.Category;

import java.util.List;

public interface CategoryService {

    Category createCategory(Category category);

    Category updateCategory(Long id, Category category);

    void deleteCategory(Long id);

    List<Category> getAllCategories();

    Category getCategoryById(Long id);
}
