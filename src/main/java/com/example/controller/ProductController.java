package com.example.controller;

import com.example.Product;
import com.example.dto.ProductDTO;
import com.example.exception.ResourceNotFoundException;
import com.example.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
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
    public ProductDTO save(@RequestBody ProductDTO request){
        return productService.save(request);
    }

    @GetMapping("/price-greater-than")
    public List<ProductDTO> findByPriceGreaterThan(
            @RequestParam Double price){
        return productService.findByPriceGreaterThan(price);
    }

    @GetMapping("/price-between")
    public List<ProductDTO> findByPriceBetween(
            @RequestParam Double priceAfter,
            @RequestParam Double priceBefore) {
        return productService.findByPriceBetween(priceAfter, priceBefore);
    }

    @GetMapping("/{id}")
    public ProductDTO findById(@PathVariable Long id){
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
    public List<ProductDTO> buscarPorNombre(@RequestParam String nombre){
        return productService.buscarPorNombre(nombre);
    }

    @GetMapping("/test/{id}")
    public ResponseEntity<String> test(@PathVariable Long id) {
        ProductDTO product = productService.findById(id);
        if (product == null) {
            throw new ResourceNotFoundException("Producto no encontrado con id: " + id);
        }
        return ResponseEntity.ok("Producto encontrado: " + product.getNombre());
    }

}
