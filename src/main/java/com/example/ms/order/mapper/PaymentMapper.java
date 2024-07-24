package com.example.ms.order.mapper;

import com.example.ms.order.dao.entity.OrderEntity;
import com.example.ms.order.model.client.request.CreatePaymentRequest;
import com.example.ms.order.model.request.CreateOrderRequest;

import java.math.BigDecimal;
import java.util.UUID;

public enum PaymentMapper {
    PAYMENT_MAPPER;

    public CreatePaymentRequest buildCreatePaymentRequest(OrderEntity orderEntity,
                                                          BigDecimal totalAmount,
                                                          CreateOrderRequest createOrderRequest) {
        return CreatePaymentRequest.builder()
                .orderId(orderEntity.getId())
                .price(totalAmount)
                .paymentType(createOrderRequest.getPaymentType())
                .referenceNumber(UUID.randomUUID().toString())
                .build();
    }
}
