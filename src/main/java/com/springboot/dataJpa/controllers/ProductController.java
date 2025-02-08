package com.springboot.dataJpa.controllers;

import com.springboot.dataJpa.entities.ProductEntity;
import com.springboot.dataJpa.repositories.ProductRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    @GetMapping("/pr")
    public List<ProductEntity> findproductEntityList(){
        List<ProductEntity> productEntityList = productRepository.findByTitleOrderByPrice("Wooden Chair");
        return productEntityList;
    }
    @GetMapping("/prd")
    public List<ProductEntity> findAllProd(){
        List<ProductEntity> productEntities = productRepository.findByOrderByPrice();
        return productEntities;
    }
}
