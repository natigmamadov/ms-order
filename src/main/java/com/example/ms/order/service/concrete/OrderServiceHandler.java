package com.example.ms.order.service.concrete;

import com.example.ms.order.client.PaymentClient;
import com.example.ms.order.client.ProductClient;
import com.example.ms.order.dao.entity.OrderEntity;
import com.example.ms.order.dao.repository.OrderRepository;
import com.example.ms.order.exception.NotFoundException;
import com.example.ms.order.model.client.request.ReduceQuantityRequest;
import com.example.ms.order.model.request.CreateOrderRequest;
import com.example.ms.order.model.response.OrderResponse;
import com.example.ms.order.service.abstraction.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

import static com.example.ms.order.exception.ExceptionConstants.ORDER_NOT_FOUND_CODE;
import static com.example.ms.order.exception.ExceptionConstants.ORDER_NOT_FOUND_MESSAGE;
import static com.example.ms.order.mapper.OrderMapper.ORDER_MAPPER;
import static com.example.ms.order.mapper.PaymentMapper.PAYMENT_MAPPER;
import static com.example.ms.order.model.enums.OrderStatus.APPROVED;
import static com.example.ms.order.model.enums.OrderStatus.REJECTED;


@Service
@Slf4j
@RequiredArgsConstructor
public class OrderServiceHandler implements OrderService {
    private final OrderRepository orderRepository;
    private final ProductClient productClient;
    private final PaymentClient paymentClient;

    @Override
    @Transactional
    public void createOrder(CreateOrderRequest createOrderRequest) {
        var orderEntity = ORDER_MAPPER.buildOrderEntity(createOrderRequest);

        var productResponse = productClient.getProductById(createOrderRequest.getProductId());

        var totalAmount = productResponse.getPrice().
                multiply(
                        BigDecimal.valueOf(
                                createOrderRequest.getQuantity()));

        orderEntity.setPrice(totalAmount);

        var reduceQuantityRequest = new ReduceQuantityRequest(
                createOrderRequest.getProductId(),
                createOrderRequest.getQuantity());

        orderRepository.save(orderEntity);


        try {
            productClient.reduceQuantity(reduceQuantityRequest);
            paymentClient.pay(
                    PAYMENT_MAPPER.buildCreatePaymentRequest(
                            orderEntity,
                            totalAmount,
                            createOrderRequest)
            );
            orderEntity.setOrderStatus(APPROVED);

        } catch (Exception e) {
            orderEntity.setOrderStatus(REJECTED);
            throw e;
        }
    }

    @Override
    public OrderResponse getOrderById(Long id) {
        var orderEntity = fetchOrderIfExists(id);
        var productResponse = productClient.getProductById(orderEntity.getProductId());
        var paymentResponse = paymentClient.getPaymentByOrderId(id);
        return ORDER_MAPPER.buildOrderResponse(orderEntity, productResponse, paymentResponse);

    }

    @Override
    public void deleteOrder(Long id) {
        var orderEntity = fetchOrderIfExists(id);
        orderEntity.setOrderStatus(REJECTED);
        orderRepository.save(orderEntity);
    }


    private OrderEntity fetchOrderIfExists(Long id) {
        return orderRepository.findByIdAndOrderStatusNot(id, REJECTED).
                orElseThrow(
                        () ->
                                new NotFoundException(ORDER_NOT_FOUND_CODE,
                                        String.format(ORDER_NOT_FOUND_MESSAGE, id)));
    }
}
