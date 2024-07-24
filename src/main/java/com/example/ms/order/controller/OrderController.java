package com.example.ms.order.controller;

import com.example.ms.order.model.request.CreateOrderRequest;
import com.example.ms.order.model.response.OrderResponse;
import com.example.ms.order.service.abstraction.OrderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;

@RestController
@RequestMapping("/v1/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @PostMapping("/create")
    @ResponseStatus(CREATED)
    public void createOrder(@RequestBody @Valid CreateOrderRequest createOrderRequest){
        orderService.createOrder(createOrderRequest);
    }

    @GetMapping("/{id}")
    public OrderResponse getOrderById(@PathVariable  Long id){
       return orderService.getOrderById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(NO_CONTENT)
    public void deleteOrder(@PathVariable Long id){
        orderService.deleteOrder(id);
    }

}
