package com.example.ms.order.exception;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CustomFeignException extends RuntimeException {

//    String errorMessage;
    int responseStatus;


    public CustomFeignException(String errorMessage, int responseStatus) {
        super(errorMessage);
        this.responseStatus = responseStatus;
    }
}
