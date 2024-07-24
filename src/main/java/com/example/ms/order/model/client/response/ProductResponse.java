package com.example.ms.order.model.client.response;

import com.example.ms.order.model.enums.ProductStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductResponse {

    private Long id;
    private String name;
    private BigDecimal price;
    private Long categoryId;
    private ProductStatus productStatus;
    private String description;
    private Integer quantity;
}
