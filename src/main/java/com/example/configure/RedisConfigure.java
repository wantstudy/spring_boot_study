//package com.example.configure;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cache.CacheManager;
//import org.springframework.cache.annotation.CachingConfigurerSupport;
//import org.springframework.cache.annotation.EnableCaching;
//import org.springframework.cache.interceptor.KeyGenerator;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.redis.cache.RedisCacheManager;
//import org.springframework.data.redis.connection.RedisConnectionFactory;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
//import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
//import org.springframework.data.redis.serializer.StringRedisSerializer;
//
//
///**
// * @Auther: WangWeiWei
// * @Date: 2018/12/14 0014
// * @Description: redis 配置类 2.0以上
// *
// */
//@Configuration
//@EnableCaching
//public class RedisConfigure extends CachingConfigurerSupport{
//
//    @Autowired
//    private RedisConnectionFactory connectionFactory;
//
//    @Bean
//    @Override
//    public CacheManager cacheManager() {
//        RedisCacheManager redisCacheManager = RedisCacheManager.builder(connectionFactory).build();
//        return redisCacheManager;
//    }
//
//    /**
//     * 防止redis入库序列化乱码的问题
//     * @param redisConnectionFactory
//     * @return
//     */
//    @Bean
//    public RedisTemplate<Object, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory){
//        RedisTemplate<Object, Object> redisTemplate = new RedisTemplate<Object, Object>();
//        redisTemplate.setConnectionFactory(redisConnectionFactory);
//        redisTemplate.setKeySerializer(new StringRedisSerializer());//key序列化
//        redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer(Object.class));  //value序列化
//
//        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
//        redisTemplate.setHashValueSerializer(new JdkSerializationRedisSerializer());
//
//        redisTemplate.afterPropertiesSet();
//        return redisTemplate;
//    }
//
//    //  设置自动key的生成规则，配置spring boot的注解，进行方法级别的缓存
//    // 使用：进行分割，可以很多显示出层级关系
//    @Bean
//    @Override
//    public KeyGenerator keyGenerator() {
//        return (target, method, params) -> {
//            StringBuilder sb = new StringBuilder();
//            sb.append(target.getClass().getName());
//            sb.append(".");
//            sb.append(method.getName());
//            sb.append("[");
//            for (Object obj : params) {
//                sb.append(String.valueOf(obj));
//            }
//            sb.append("]");
//            return sb.toString();
//        };
//    }
//}
