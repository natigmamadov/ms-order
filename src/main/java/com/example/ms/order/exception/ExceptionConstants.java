package com.example.ms.order.exception;

public interface ExceptionConstants {
    String UNEXPECTED_EXCEPTION_CODE = "UNEXPECTED_EXCEPTION";
    String UNEXPECTED_EXCEPTION_MESSAGE = "Unexpected exception occurred";

    String ORDER_NOT_FOUND_CODE = "ORDER_NOT_FOUND";
    String ORDER_NOT_FOUND_MESSAGE = "ORDER with id: %s not found";

    String CLIENT_ERROR_MESSAGE = "Exception from client";
    String EMPTY_MESSAGE_FROM_CLIENT_ERROR_MESSAGE = "Empty message from client ";

    String ACCESS_DENIED_CODE = "ACCESS_DENIED";
    String ACCESS_DENIED_MESSAGE = "User doesn't have access for this operation!";


    String PRODUCT_ALREADY_REGISTERED_CODE = "PRODUCT_ALREADY_CREATED";
    String PRODUCT_ALREADY_REGISTERED_MESSAGE = "PRODUCT is already registered";
}
