package cn.shuchan.framework.idempotent.config;

import cn.shuchan.framework.idempotent.core.aop.IdempotentAspect;
import cn.shuchan.framework.idempotent.core.keyresolver.impl.DefaultIdempotentKeyResolver;
import cn.shuchan.framework.idempotent.core.keyresolver.impl.ExpressionIdempotentKeyResolver;
import cn.shuchan.framework.idempotent.core.keyresolver.IdempotentKeyResolver;
import cn.shuchan.framework.idempotent.core.redis.IdempotentRedisDAO;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import cn.shuchan.framework.redis.config.ShuchanRedisAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.List;

@AutoConfiguration(after = ShuchanRedisAutoConfiguration.class)
public class ShuchanIdempotentConfiguration {

    @Bean
    public IdempotentAspect idempotentAspect(List<IdempotentKeyResolver> keyResolvers, IdempotentRedisDAO idempotentRedisDAO) {
        return new IdempotentAspect(keyResolvers, idempotentRedisDAO);
    }

    @Bean
    public IdempotentRedisDAO idempotentRedisDAO(StringRedisTemplate stringRedisTemplate) {
        return new IdempotentRedisDAO(stringRedisTemplate);
    }

    // ========== 各种 IdempotentKeyResolver Bean ==========

    @Bean
    public DefaultIdempotentKeyResolver defaultIdempotentKeyResolver() {
        return new DefaultIdempotentKeyResolver();
    }

    @Bean
    public ExpressionIdempotentKeyResolver expressionIdempotentKeyResolver() {
        return new ExpressionIdempotentKeyResolver();
    }

}
