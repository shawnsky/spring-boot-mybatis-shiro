package com.xt.mapper;

import com.xt.entity.RolePermission;
import com.xt.entity.UserRole;

import java.util.Set;

/**
 * Created by Administrator on 2017/7/8.
 */
public interface UserRoleMapper {

    /**
     * Add.
     * 添加用户角色关系
     * @param userRole the user role
     */
    void add(UserRole userRole);

    /**
     * Remove by role.
     * 移除用户角色关系
     * @param role the role
     */
    void removeByRole(String role);

}
