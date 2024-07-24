package com.example.ms.order.model.request;


import com.example.ms.order.model.enums.PaymentType;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import static com.example.ms.order.model.constants.ApplicationConstants.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateOrderRequest {
    @NotNull(message = PRODUCT_ID_IS_REQUIRED)
    private Long productId;

    @NotNull(message = QUANTITY_IS_REQUIRED)
    private Integer quantity;

    @NotNull(message = PAYMENT_TYPE_IS_REQUIRED)
    private PaymentType paymentType;

    // @NotNull(message = PRICE_IS_REQUIRED)
//    private BigDecimal price;
}
