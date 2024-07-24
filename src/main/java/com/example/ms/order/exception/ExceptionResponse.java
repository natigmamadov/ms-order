package com.example.ms.order.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonInclude(Include.NON_NULL)
public class ExceptionResponse {
    private String code;
    private String message;

    public ExceptionResponse(String message) {
        this.message = message;
    }

}
