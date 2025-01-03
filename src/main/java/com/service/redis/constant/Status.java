package com.service.redis.constant;

import lombok.Getter;

@Getter
public enum Status {

    SUCCESS("SUCCESS"),

    FAILURE("FAILURE");


    private final String status;

    Status(String status) {
        this.status = status;
    }

}