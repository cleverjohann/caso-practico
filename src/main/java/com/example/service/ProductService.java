package com.example.service;

import com.example.Product;
import com.example.dto.ProductDTO;
import com.example.exception.ResourceNotFoundException;
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

    public ProductDTO findById(Long id){
        Product product = productRepository.findById(id).
                orElseThrow(()-> new ResourceNotFoundException("Producto no encontrado con id: " + id));
        return productMapper.toDTO(product);
    }

    public void delete(Long id){
        productRepository.deleteById(id);
    }

    public List<ProductDTO> findByPriceGreaterThan(Double price){
        return productMapper.toDTO(productRepository.findByPriceGreaterThan(price));
    }

    public List<ProductDTO> findByPriceBetween(Double priceAfter, Double priceBefore){
        return productMapper.toDTO(productRepository.findByPriceBetween(priceAfter, priceBefore));
    }

    public List<ProductDTO> buscarPorNombre(String nombre){
        return productMapper.toDTO(productRepository.buscarPorNombre(nombre));
    }
}
