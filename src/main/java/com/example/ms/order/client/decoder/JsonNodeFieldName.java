package com.example.ms.order.client.decoder;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum JsonNodeFieldName {
    MESSAGE("message");
    private final String value;
}
