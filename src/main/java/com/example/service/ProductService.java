package com.example.service;

import com.example.Product;
import com.example.dto.ProductDTO;
import com.example.repository.ProductRepository;
import com.example.util.ProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public List<ProductDTO> findAll() {
        return productMapper.toDTO(productRepository.findAll());
    }

    public ProductDTO save (Product product){
        return productMapper.toDTO(productRepository.save(product));
    }

    public Product findById(Long id){
        return productRepository.findById(id).orElse(null);
    }

    public void delete(Long id){
        productRepository.deleteById(id);
    }

    public List<Product> findByPriceGreaterThan(Double price){
        return productRepository.findByPriceGreaterThan(price);
    }

    public List<Product> findByPriceBetween(Double priceAfter, Double priceBefore){
        return productRepository.findByPriceBetween(priceAfter, priceBefore);
    }

    public List<Product> buscarPorNombre(String nombre){
        return productRepository.buscarPorNombre(nombre);
    }
}
