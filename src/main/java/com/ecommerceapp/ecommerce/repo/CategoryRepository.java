package com.ecommerceapp.ecommerce.repo;

import com.ecommerceapp.ecommerce.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
