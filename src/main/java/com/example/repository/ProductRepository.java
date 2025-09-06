package com.example.repository;

import com.example.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {

    List<Product> findByPriceGreaterThan(Double price);

    List<Product> findByPriceBetween(Double priceAfter, Double priceBefore);

    @Query("SELECT p FROM Product p WHERE LOWER(p.name) LIKE LOWER(CONCAT(:nombre,'%'))")
    List<Product> buscarPorNombre(@Param("nombre") String nombre);
}
