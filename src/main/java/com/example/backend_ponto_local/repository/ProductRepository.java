package com.example.backend_ponto_local.repository;

import com.example.backend_ponto_local.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}