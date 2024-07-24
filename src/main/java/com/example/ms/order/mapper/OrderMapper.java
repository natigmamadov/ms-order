package com.example.ms.order.mapper;

import com.example.ms.order.dao.entity.OrderEntity;
import com.example.ms.order.model.client.request.CreatePaymentRequest;
import com.example.ms.order.model.client.response.PaymentResponse;
import com.example.ms.order.model.client.response.ProductResponse;
import com.example.ms.order.model.enums.OrderStatus;
import com.example.ms.order.model.request.CreateOrderRequest;
import com.example.ms.order.model.response.OrderResponse;

import java.math.BigDecimal;
import java.util.UUID;

import static com.example.ms.order.model.enums.OrderStatus.PENDING;

public enum OrderMapper {
    ORDER_MAPPER;

    public OrderEntity buildOrderEntity(CreateOrderRequest createOrderRequest) {
        return OrderEntity.builder()
                .productId(createOrderRequest.getProductId())
                .quantity(createOrderRequest.getQuantity())
                .orderStatus(PENDING)
//                .price(createOrderRequest.getPrice())
                .build();
    }

    public OrderResponse buildOrderResponse(OrderEntity orderEntity,
                                            ProductResponse productResponse,
                                            PaymentResponse paymentResponse) {
        return OrderResponse.builder()
                .id(orderEntity.getId())
                .productId(orderEntity.getProductId())
                .quantity(orderEntity.getQuantity())
                .orderStatus(orderEntity.getOrderStatus())
                .price(orderEntity.getPrice())
                .createdOn(orderEntity.getCreatedOn())
                .productResponse(productResponse)
                .paymentResponse(paymentResponse)
                .build();

    }

}
