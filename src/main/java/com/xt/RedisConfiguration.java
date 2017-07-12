package com.xt;/**
 * Created by Administrator on 2017/7/11.
 */

import org.apache.shiro.session.Session;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.serializer.support.DeserializingConverter;
import org.springframework.core.serializer.support.SerializingConverter;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * 07-11 17:19
 * Redis Beans
 * @author xt
 */
@Configuration
public class RedisConfiguration {


    /**
     * Jedis connection factory jedis connection factory.
     * @return the jedis connection factory
     */
    @Bean
    JedisConnectionFactory jedisConnectionFactory() {
        return new JedisConnectionFactory();
    }




    /**
     * Redis template redis template.
     * 针对Session存储的RedisTemplate
     * @param jedisConnectionFactory the jedis connection factory
     * @return the redis template
     */
    @Bean
    public RedisTemplate<String, Session> redisTemplate(RedisConnectionFactory jedisConnectionFactory) {
        RedisTemplate<String, Session> template = new RedisTemplate<>();
        template.setConnectionFactory(jedisConnectionFactory());
        template.setKeySerializer(new StringRedisSerializer());
        template.setValueSerializer(new RedisObjectSerializer());
        return template;
    }



    /**
     * 对象序列化类
     * 主要是针对Session的序列化和反序列化
     * 使用spring提供的{@link SerializingConverter}和{@link DeserializingConverter}
     */
    private class RedisObjectSerializer implements RedisSerializer<Object> {
        private Converter<Object, byte[]> serializer = new SerializingConverter();
        private Converter<byte[], Object> deserializer = new DeserializingConverter();
        final byte[] EMPTY_ARRAY = new byte[0];
        public Object deserialize(byte[] bytes) {
            if (isEmpty(bytes)) {
                return null;
            }
            try {
                return deserializer.convert(bytes);
            } catch (Exception ex) {
                throw new SerializationException("Cannot deserialize", ex);
            }
        }
        public byte[] serialize(Object object) {
            if (object == null) {
                return EMPTY_ARRAY;
            }
            try {
                return serializer.convert(object);
            } catch (Exception ex) {
                return EMPTY_ARRAY;
            }
        }
        private boolean isEmpty(byte[] data) {
            return (data == null || data.length == 0);
        }
    }
}
