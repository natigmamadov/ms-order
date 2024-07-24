package com.example.ms.order.model.response;

import com.example.ms.order.model.client.response.PaymentResponse;
import com.example.ms.order.model.client.response.ProductResponse;
import com.example.ms.order.model.enums.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderResponse {

    private Long id;
    private Long productId;
    private Integer quantity;
    private OrderStatus orderStatus;
    private BigDecimal price;
    private LocalDateTime createdOn;
    private ProductResponse productResponse;
    private PaymentResponse paymentResponse;
}
