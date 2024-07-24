package com.example.ms.order.config;


import com.example.ms.order.client.decoder.RetreiveMessageErrorDecoder;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class ErrorDecoderConfig {

    @Bean
    public ErrorDecoder errorDecoder() {
        return new RetreiveMessageErrorDecoder(new ObjectMapper());
    }
}
