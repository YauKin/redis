package com.service.redis.service;

import com.service.redis.constant.ErrorType;
import com.service.redis.constant.Status;
import com.service.redis.dao.CacheData;
import com.service.redis.dto.StatusDto;
import com.service.redis.logging.FunctionalException;
import com.service.redis.repositories.CacheDataRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RedisService {

    private final CacheDataRepository cacheDataRepository;

    public ResponseEntity<CacheData> getCacheData(String key) {
        var cacheData = cacheDataRepository.findById(key).orElseThrow(() ->
                new FunctionalException(ErrorType.KEY_NOT_FOUND, "Key Not Found"));
        return ResponseEntity.ok().body(cacheData);
    }

    public ResponseEntity<StatusDto> setCacheData(CacheData cacheData) {
        if (isKeyExists(cacheData.getKey())) {
            throw new FunctionalException(ErrorType.KEY_ALREADY_EXISTS, "Key Already Exists");
        }
        try {
            cacheDataRepository.save(cacheData);
            return ResponseEntity.ok().body(StatusDto.builder().status(Status.SUCCESS).build());
        } catch (Exception e) {
            throw new FunctionalException(ErrorType.SAVE_CACHE_DATA_ERROR, "Error While Saving Data");
        }
    }

    public ResponseEntity<StatusDto> deleteCacheByKey(String key) {
        if (!isKeyExists(key)) {
            throw new FunctionalException(ErrorType.KEY_NOT_FOUND, "Key Not Found");
        }
        try {
            cacheDataRepository.deleteById(key);
            return ResponseEntity.ok().body(StatusDto.builder().status(Status.SUCCESS).build());
        } catch (Exception e) {
            throw new FunctionalException(ErrorType.DELETE_CACHE_DATA_ERROR, "Error While Deleting Data");
        }
    }

    public ResponseEntity<StatusDto> clearAllCache() {
        try {
            cacheDataRepository.deleteAll();
            return ResponseEntity.ok().body(StatusDto.builder().status(Status.SUCCESS).build());
        } catch (Exception e) {
            throw new FunctionalException(ErrorType.DELETE_CACHE_DATA_ERROR, "Error While Clearing All Data");
        }
    }

    private boolean isKeyExists(String key) {
        return cacheDataRepository.existsById(key);
    }


}
