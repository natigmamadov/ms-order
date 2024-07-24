package com.example.ms.order.dao.entity;

import com.example.ms.order.model.enums.OrderStatus;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import static jakarta.persistence.EnumType.STRING;
import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "orders")
@EqualsAndHashCode(of = "id")
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private Long productId;
    private Integer quantity;
    @Enumerated(STRING)
    private OrderStatus orderStatus;
    private BigDecimal price;

    @Column(name = "created_on")
    @CreationTimestamp
    private LocalDateTime createdOn;

    @Column(name = "updated_on")
    @UpdateTimestamp
    private LocalDateTime updatedOn;

}
