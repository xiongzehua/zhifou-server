package com.xiongzehua.zhifou.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.stereotype.Component;

import java.net.UnknownHostException;
import java.util.Set;

/**
 * Created by xiongzehua on 2019/2/17.
 */
@Component
@Configuration
public class RedisConfig {

    @Autowired
    private ZSetOperations<String, Object> zSetOperations;

    @Bean
    public RedisTemplate<Object, Object> redisTemplate(
            RedisConnectionFactory redisConnectionFactory, ObjectMapper objectMapper) throws UnknownHostException {
        RedisTemplate<Object, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(redisConnectionFactory);
        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
        jackson2JsonRedisSerializer.setObjectMapper(objectMapper);
        template.setDefaultSerializer(jackson2JsonRedisSerializer);
        return template;
    }

    @Bean
    public ZSetOperations<String, Object> zSetOperations(RedisTemplate<String, Object> redisTemplate) {
        return redisTemplate.opsForZSet();
    }

//    插入或者更新数据
    public Boolean zadd(String key, Integer member, double score) {
        return zSetOperations.add(key, member, score);
    }

//    获取用户分数
    public Double zscore(String key, double score) {
        return zSetOperations.score(key, score);
    }

//    获取排名
    public Set<Object> zrevrangeWithScoresBytes(String key, final long start, final long end) {
        return zSetOperations.range(key, start, end);
    }

}
