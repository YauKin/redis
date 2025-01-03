package com.service.redis.dao;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

@Getter
@AllArgsConstructor
@Builder
@Accessors(chain = true)
@RedisHash("cacheData")
public class CacheData {
    @Id
    private String key;

    @Indexed
    @Getter
    private String value;
}