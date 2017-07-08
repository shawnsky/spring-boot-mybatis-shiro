package com.xt.mapper;

import com.xt.entity.User;

import java.util.List;
import java.util.Set;

/**
 * Created by Administrator on 2017/7/5.
 */
public interface UserMapper {

    User createUser(User user);

    void updateUser(User user);

    void deleteUser(Long userId);

    User findById(Long userId);

    User findByUsername(String username);

    List<User> findByRole(String role);

    Set<String> findRoles(String username);

    Set<String> findRoleNames(String username);

    Set<String> findPermissions(String username);

}
