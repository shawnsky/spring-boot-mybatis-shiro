package com.xt.service.impl;/**
 * Created by Administrator on 2017/7/5.
 */

import com.xt.entity.User;
import com.xt.mapper.UserMapper;
import com.xt.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.Inet4Address;
import java.util.List;
import java.util.Set;

/**
 * 07-05 17:29
 *
 * @author xt
 **/

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;


    @Override
    public void createUser(User user) {
        userMapper.createUser(user);
    }

    @Override
    public void updateUser(User user) {
        userMapper.updateUser(user);
    }

    @Override
    public void deleteUser(Long userId) {
        userMapper.deleteUser(userId);
    }

    @Override
    public void deleteUserByRole(String role) {
        userMapper.deleteUserByRole(role);
    }

    @Override
    public List<User> findAll(Integer pageNum, Integer pageSize) {
        return userMapper.findAll(pageNum, pageSize);
    }

    @Override
    public Integer getTotalPageNum(Integer pageSize) {
        return userMapper.count().intValue() / pageSize;
    }

    @Override
    public User findById(Long userId) {
        return userMapper.findById(userId);
    }

    @Override
    public User findByUsername(String username) {
        return userMapper.findByUsername(username);
    }

    @Override
    public List<User> findByRole(String role) {
        return userMapper.findByRole(role);
    }

    @Override
    public Set<String> findRoles(String username) {
        return userMapper.findRoles(username);
    }

    @Override
    public Set<String> findRoleNames(String username) {
        return userMapper.findRoleNames(username);
    }

    @Override
    public Set<String> findPermissions(String username) {
        return userMapper.findPermissions(username);
    }
}
