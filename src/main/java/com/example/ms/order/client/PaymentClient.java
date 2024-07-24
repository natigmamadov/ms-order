package com.example.ms.order.client;


import com.example.ms.order.client.decoder.RetreiveMessageErrorDecoder;
import com.example.ms.order.model.client.request.CreatePaymentRequest;
import com.example.ms.order.model.client.response.PaymentResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "ms-payment", url = "${ms-payment-client.url}", configuration = RetreiveMessageErrorDecoder.class)
public interface PaymentClient {


    @PostMapping("/v1/payments/pay")
    PaymentResponse pay(@RequestBody CreatePaymentRequest createPaymentRequest);

    @GetMapping("/v1/payments/order/{orderId}")
    PaymentResponse getPaymentByOrderId(@PathVariable Long orderId);

}
