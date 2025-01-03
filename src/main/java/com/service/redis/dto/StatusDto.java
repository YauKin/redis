package com.service.redis.dto;

import com.service.redis.constant.Status;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StatusDto {

    private Status status;

}

