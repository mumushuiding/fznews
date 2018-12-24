package com.lt.cloud.config;

import java.util.concurrent.TimeUnit;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

@Configuration
/**
 * @功能描述 内存缓存
 * @author www.gaozz.club
 * @date 2018-08-26
 */
public class UrlCache {
	
	@Bean
	public Cache<String, Integer> getCache(){
		return CacheBuilder.newBuilder().expireAfterWrite(2L, TimeUnit.SECONDS).build();
	}
}
