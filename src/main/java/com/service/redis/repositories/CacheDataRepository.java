package com.service.redis.repositories;


import com.service.redis.dao.CacheData;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CacheDataRepository extends CrudRepository<CacheData, String> {

}
