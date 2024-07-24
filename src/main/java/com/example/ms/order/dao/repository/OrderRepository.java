package com.example.ms.order.dao.repository;

import com.example.ms.order.dao.entity.OrderEntity;
import com.example.ms.order.model.enums.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrderRepository extends JpaRepository<OrderEntity,Long> {
    Optional<OrderEntity> findByIdAndOrderStatusNot(Long id, OrderStatus orderStatus);
}
