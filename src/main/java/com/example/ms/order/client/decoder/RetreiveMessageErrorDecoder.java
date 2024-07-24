package com.example.ms.order.client.decoder;


import com.example.ms.order.exception.CustomFeignException;
import com.example.ms.order.exception.ExceptionConstants;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Response;
import feign.codec.ErrorDecoder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;

import static com.example.ms.order.exception.ExceptionConstants.CLIENT_ERROR_MESSAGE;
import static com.example.ms.order.exception.ExceptionConstants.EMPTY_MESSAGE_FROM_CLIENT_ERROR_MESSAGE;


@RequiredArgsConstructor
@Slf4j
public class RetreiveMessageErrorDecoder implements ErrorDecoder {
    private final ObjectMapper objectMapper;

    @Override
    public Exception decode(String methodKey, Response response) {
        try(var body = response.body().asInputStream()) {
            JsonNode jsonNode = objectMapper.readTree(body);
            String message  = Objects.isNull(jsonNode.get(JsonNodeFieldName.MESSAGE.getValue())) ?
                    EMPTY_MESSAGE_FROM_CLIENT_ERROR_MESSAGE :
                    jsonNode.get(JsonNodeFieldName.MESSAGE.getValue()).asText();
            log.error("ActionLog.decode.error Message: {}, Method: {}", message ,methodKey);
            return new CustomFeignException(message, response.status());
        }catch (Exception ex){
            log.error("ActionLog.decode.error.without.json Message: {}, Method: {}", CLIENT_ERROR_MESSAGE,methodKey);
            return new CustomFeignException(CLIENT_ERROR_MESSAGE, response.status());
        }
    }
}
