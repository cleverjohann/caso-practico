package com.example.repository;

import com.example.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {

    List<Product> findByPriceGreaterThan(Double price);

    List<Product> findByPriceBetween(Double priceAfter, Double priceBefore);
}
