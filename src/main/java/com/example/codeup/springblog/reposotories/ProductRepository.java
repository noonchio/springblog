package com.example.codeup.springblog.reposotories;

import com.example.codeup.springblog.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
