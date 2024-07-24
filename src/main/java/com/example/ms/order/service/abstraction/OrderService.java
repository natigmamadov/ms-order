package com.example.ms.order.service.abstraction;

import com.example.ms.order.model.request.CreateOrderRequest;
import com.example.ms.order.model.response.OrderResponse;

public interface OrderService {
    void createOrder(CreateOrderRequest createOrderRequest);
    OrderResponse getOrderById(Long id);

    void deleteOrder(Long id);
}
