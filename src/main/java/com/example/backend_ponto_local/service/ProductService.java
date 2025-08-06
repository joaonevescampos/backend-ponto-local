package com.example.backend_ponto_local.service;

import com.example.backend_ponto_local.dto.ProductDTO;
import com.example.backend_ponto_local.model.Product;
import com.example.backend_ponto_local.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;


@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product createProduct(ProductDTO productRequestDTO) {
        Product product = new Product();
        product.setCategoryId(productRequestDTO.getCategoryId());
        product.setProductName(productRequestDTO.getProductName());
        product.setIsProduct(productRequestDTO.getIsProduct());

        return productRepository.save(product);
    }
}