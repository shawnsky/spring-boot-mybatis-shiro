package com.xt.service;

import com.xt.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

/**
 * Created by Administrator on 2017/7/5.
 */
public interface UserService {
    void createUser(User user);

    void updateUser(User user);

    void deleteUser(Long userId);

    void deleteUserByRole(String role);

    List<User> findAll(Integer pageNum, Integer pageSize);

    Integer getTotalPageNum(Integer pageSize);

    User findById(Long userId);

    User findByUsername(String username);

    List<User> findByRole(String role);

    Set<String> findRoles(String username);

    Set<String> findRoleNames(String username);

    Set<String> findPermissions(String username);
}
