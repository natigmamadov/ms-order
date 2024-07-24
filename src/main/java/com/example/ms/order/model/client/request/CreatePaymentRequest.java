package com.example.ms.order.model.client.request;

import com.example.ms.order.model.enums.PaymentType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

import static com.example.ms.order.model.constants.ApplicationConstants.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreatePaymentRequest {

    @NotNull(message = ORDER_ID_IS_REQUIRED)
    private Long orderId;

    @NotNull(message = PRICE_IS_REQUIRED)
    private BigDecimal price;

    @NotBlank(message = REFERENCE_NUMBER_IS_REQUIRED)
    private String referenceNumber;

    @NotNull(message = PAYMENT_TYPE_IS_REQUIRED)
    private PaymentType paymentType;
}
