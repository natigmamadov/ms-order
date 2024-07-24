package com.example.ms.order.client;


import com.example.ms.order.client.decoder.RetreiveMessageErrorDecoder;
import com.example.ms.order.model.client.request.ReduceQuantityRequest;
import com.example.ms.order.model.client.response.ProductResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "ms-product", url = "${ms-product-client.url}", configuration = RetreiveMessageErrorDecoder.class)
public interface ProductClient {

    @PostMapping("internal/v1/products/reduce-quantity")
    void reduceQuantity(@RequestBody ReduceQuantityRequest reduceQuantityRequest);

    @GetMapping("/v1/products/{id}")
    ProductResponse getProductById(@PathVariable Long id);
}
