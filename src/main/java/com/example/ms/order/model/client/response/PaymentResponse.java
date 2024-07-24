package com.example.ms.order.model.client.response;

import com.example.ms.order.model.enums.PaymentStatus;
import com.example.ms.order.model.enums.PaymentType;
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
public class PaymentResponse {

    private Long id;
    private BigDecimal price;
    private String referenceNumber;
    private PaymentType paymentType;
    private PaymentStatus status;
    private LocalDateTime createdAt;
}
