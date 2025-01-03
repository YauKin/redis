package com.service.redis.logging;

import com.service.redis.constant.ErrorType;
import lombok.Getter;

@Getter
public abstract class GeneralException extends RuntimeException {
    // Getter for type
    private final ErrorType type;

    // Constructor
    public GeneralException(ErrorType type, String message) {
        super(message != null ? message : type.getValue());
        this.type = type;
    }

}
