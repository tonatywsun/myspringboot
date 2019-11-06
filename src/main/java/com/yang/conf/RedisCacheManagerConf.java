package com.yang.conf;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description: spring缓存使用redis时redis的配置
 * @Author: tona.sun
 * @Date: 2019/11/06 12:07
 */
@Configuration
public class RedisCacheManagerConf {
    @Bean
    public CacheManager redisCacheManager(RedisConnectionFactory redisConnectionFactory) {
        return new RedisCacheManager(
                RedisCacheWriter.nonLockingRedisCacheWriter(redisConnectionFactory),
                this.getRedisCacheConfigurationWithTtl(Duration.ofSeconds(900)),
                // 默认策略，未配置的 key 会使用这个
                this.getRedisCacheConfigurationMap()
        );
    }

    private Map<String, RedisCacheConfiguration> getRedisCacheConfigurationMap() {
        Map<String, RedisCacheConfiguration> redisCacheConfigurationMap = new HashMap<>();
        redisCacheConfigurationMap.put("time-to-live", this.getRedisCacheConfigurationWithTtl(Duration.ofSeconds(9000)));
        return redisCacheConfigurationMap;
    }

    private RedisCacheConfiguration getRedisCacheConfigurationWithTtl(Duration seconds) {
        RedisSerializer<String> redisSerializer = new StringRedisSerializer();
        Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer = getJackson2JsonRedisSerializer();
        RedisCacheConfiguration redisCacheConfiguration = RedisCacheConfiguration
                .defaultCacheConfig();
        redisCacheConfiguration = redisCacheConfiguration
                .serializeKeysWith(
                        RedisSerializationContext.SerializationPair.fromSerializer(redisSerializer))
                .serializeValuesWith(
                        RedisSerializationContext.SerializationPair
                                .fromSerializer(jackson2JsonRedisSerializer))
                .computePrefixWith(cacheName -> cacheName.concat(":")).entryTtl(seconds);
        return redisCacheConfiguration;
    }

    private Jackson2JsonRedisSerializer<Object> getJackson2JsonRedisSerializer() {
        Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<>(
                Object.class);
        ObjectMapper om = new ObjectMapper();
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        jackson2JsonRedisSerializer.setObjectMapper(om);
        return jackson2JsonRedisSerializer;
    }
}
