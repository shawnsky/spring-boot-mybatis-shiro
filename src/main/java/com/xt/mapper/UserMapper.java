package com.xt.mapper;

import com.xt.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

/**
 * Created by Administrator on 2017/7/5.
 */
public interface UserMapper {

    /**
     * Create user.
     * 创建用户
     * @param user the user
     */
    void createUser(User user);

    /**
     * Update user.
     * 更新用户
     * @param user the user
     */
    void updateUser(User user);

    /**
     * Delete user.
     * 删除用户
     * @param userId the user id
     */
    void deleteUser(Long userId);

    /**
     * Delete user by role.
     * 删除某角色下属所有用户
     * @param role the role
     */
    void deleteUserByRole(String role);

    /**
     * Find all user.
     * 分页查询所有用户
     * @param pageNum page num
     * @param pageSize the size
     */
    List<User> findAll(@Param("pageNum") int pageNum, @Param("pageSize") int pageSize);

    /**
     * Get data count.
     * 查询用户表条数
     */
    Long count();

    /**
     * Find by id user.
     * ID查找用户
     * @param userId the user id
     * @return the user
     */
    User findById(Long userId);

    /**
     * Find by username user.
     * 用户名查找用户
     * @param username the username
     * @return the user
     */
    User findByUsername(String username);

    /**
     * Find by role list.
     * 查找某角色所有用户
     * @param role the role
     * @return the list
     */
    List<User> findByRole(String role);

    /**
     * Find roles set.
     * 查找用户角色
     * @param username the username
     * @return the set
     */
    Set<String> findRoles(String username);

    /**
     * Find role names set.
     * 查找用户角色描述
     * @param username the username
     * @return the set
     */
    Set<String> findRoleNames(String username);

    /**
     * Find permissions set.
     * 查找用户权限
     * @param username the username
     * @return the set
     */
    Set<String> findPermissions(String username);

}
