package com.example.backend_ponto_local.controller;

import com.example.backend_ponto_local.dto.ProductDTO;
import com.example.backend_ponto_local.model.Product;
import com.example.backend_ponto_local.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody @Validated ProductDTO productRequestDTO) {
        Product product = productService.createProduct(productRequestDTO);
        return new ResponseEntity<>(product, HttpStatus.CREATED);
    }
}
