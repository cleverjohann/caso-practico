package com.example.service;

import com.example.Product;
import com.example.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product save (Product product){
        return productRepository.save(product);
    }

    public List<Product> findByPriceGreaterThan(Double price){
        return productRepository.findByPriceGreaterThan(price);
    }

    public List<Product> findByPriceBetween(Double priceAfter, Double priceBefore){
        return productRepository.findByPriceBetween(priceAfter, priceBefore);
    }
}
