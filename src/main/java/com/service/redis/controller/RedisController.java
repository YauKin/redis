package com.service.redis.controller;

import com.service.redis.dao.CacheData;
import com.service.redis.dto.StatusDto;
import com.service.redis.service.RedisService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/redis")
@AllArgsConstructor
public class RedisController {

    private RedisService redisService;

    // Redis Service methods

    @PostMapping("/set")
    private ResponseEntity<StatusDto> setCacheData(@RequestBody @Valid CacheData cacheData) {
        return redisService.setCacheData(cacheData);
    }

    @GetMapping("/get")
    private ResponseEntity<CacheData> getCacheData(@RequestParam String key) {
        return redisService.getCacheData(key);
    }

    @DeleteMapping("/delete")
    private ResponseEntity<StatusDto> deleteCacheData(@RequestParam String key) {
        return redisService.deleteCacheByKey(key);
    }

    @DeleteMapping("/deleteAll")
    private ResponseEntity<StatusDto> deleteAllCacheData() {
        return redisService.clearAllCache();
    }
}
