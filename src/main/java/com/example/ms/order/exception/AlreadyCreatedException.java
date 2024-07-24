package com.example.ms.order.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class AlreadyCreatedException extends RuntimeException {
    private String code;

    public AlreadyCreatedException(String code, String message) {
        super(message);
        this.code = code;
    }
}