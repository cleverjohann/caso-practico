package com.example.controller;

import com.example.Product;
import com.example.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @RequestMapping
    public List<Product> findAll(){
        return productService.findAll();
    }

    @RequestMapping("/save")
    public Product save(@RequestBody Product product){
        return productService.save(product);
    }

    @GetMapping("/price-greater-than")
    public List<Product> findByPriceGreaterThan(
            @RequestParam Double price){
        return productService.findByPriceGreaterThan(price);
    }

    @GetMapping("/price-between")
    public List<Product> findByPriceBetween(
            @RequestParam Double priceAfter,
            @RequestParam Double priceBefore) {
        return productService.findByPriceBetween(priceAfter, priceBefore);
    }

}
