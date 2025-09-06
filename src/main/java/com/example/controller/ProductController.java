package com.example.controller;

import com.example.Product;
import com.example.dto.ProductDTO;
import com.example.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @RequestMapping
    public List<ProductDTO> findAll(){
        return productService.findAll();
    }

    @RequestMapping("/save")
    public ProductDTO save(@RequestBody Product product){
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

    @GetMapping("/{id}")
    public Product findById(@PathVariable Long id){
        return productService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        productService.delete(id);
    }

    @GetMapping("/cookie")
    public String getCookie(@CookieValue(value = "user-token", defaultValue = "desconocido") String token){
        return "Tu navegador es "+token;
    }

    @GetMapping("/filter")
    public List<Product> buscarPorNombre(@RequestParam String nombre){
        return productService.buscarPorNombre(nombre);
    }

}
