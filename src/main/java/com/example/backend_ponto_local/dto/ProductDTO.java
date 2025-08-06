package com.example.backend_ponto_local.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ProductDTO {
    @NotNull
    private Long categoryId;

    @NotNull
    private String productName;

    @NotNull
    private Boolean isProduct;
}
