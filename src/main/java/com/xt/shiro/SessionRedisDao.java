package com.xt.shiro;/**
 * Created by Administrator on 2017/7/11.
 */

import com.xt.entity.User;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.SimpleSession;
import org.apache.shiro.session.mgt.eis.CachingSessionDAO;
import org.apache.shiro.session.mgt.eis.EnterpriseCacheSessionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.io.*;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

/**
 * 07-11 11:28
 * 实现Session共享，每次创建/更新Session都会保存到redis数据库
 * 读取Session时，先尝试从ehcache中读取缓存，没有的话再从redis中查询
 * @author xt
 */
public class SessionRedisDao extends EnterpriseCacheSessionDAO {

    @Autowired
    private RedisTemplate<String, Session> redisTemplate;

    @Override
    protected void doUpdate(Session session) {
        super.doUpdate(session);
        redisTemplate.opsForValue().set(session.getId().toString(),session,30, TimeUnit.MINUTES);
    }

    @Override
    protected void doDelete(Session session) {
        super.doDelete(session);
        redisTemplate.delete(session.getId().toString());
    }

    @Override
    protected Serializable doCreate(Session session) {
        Serializable sessionId = super.doCreate(session);
        redisTemplate.opsForValue().set(sessionId.toString(), session,30,TimeUnit.MINUTES);
        return sessionId;
    }

    @Override
    protected Session doReadSession(Serializable sessionId) {
        Session session = super.doReadSession(sessionId);
        if(session==null){
            session = redisTemplate.opsForValue().get(sessionId.toString());
        }
        return session;
    }
}
