package com.service.redis.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;


@Getter
@AllArgsConstructor
public enum ErrorType implements BaseEnum {
    NOT_SPECIFIED("NOT_SPECIFIED", HttpStatus.OK),
    INVALID_REQUEST("INVALID_REQUEST", HttpStatus.BAD_REQUEST),
    UNEXPECTED_ERROR("UNEXPECTED_ERROR", HttpStatus.BAD_REQUEST),

    KEY_ALREADY_EXISTS("KEY_ALREADY_EXISTS", HttpStatus.BAD_REQUEST),
    KEY_NOT_FOUND("KEY_NOT_FOUND", HttpStatus.BAD_REQUEST),
    SAVE_CACHE_DATA_ERROR("SAVE_CACHE_DATA_ERROR", HttpStatus.BAD_REQUEST),
    DELETE_CACHE_DATA_ERROR("DELETE_CACHE_DATA_ERROR", HttpStatus.BAD_REQUEST),

    NOT_FOUND("NOT_FOUND", HttpStatus.UNPROCESSABLE_ENTITY),
    INVALID_TOKEN("INVALID_TOKEN", HttpStatus.UNPROCESSABLE_ENTITY);

    private final String value;
    private final HttpStatus httpStatus;
    private final ErrorStatusCode statusCode;

    // Constructor
    ErrorType(String value, HttpStatus httpStatus) {
        this(value, httpStatus, ErrorStatusCode.UNEXPECTED); // Default status code
    }

}