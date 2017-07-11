package com.xt.mapper;

import com.xt.entity.RolePermission;

import java.util.Set;

/**
 * Created by Administrator on 2017/7/8.
 */
public interface RolePermMapper {
    /**
     * Add.
     * 添加角色权限关系
     * @param rolePermission the role permission
     */
    void add(RolePermission rolePermission);

    /**
     * Remove.
     * 移除角色权限关系
     * @param rolePermission the role permission
     */
    void remove(RolePermission rolePermission);

    /**
     * Remove all.
     * 删除所有角色权限关系
     */
    void removeAll();

    /**
     * Remove by role.
     * 移除某角色所有权限关系
     * @param role the role
     */
    void removeByRole(String role);

    /**
     * Find permissions by role set.
     * 通过角色查找权限集合
     * @param role the role
     * @return the set
     */
    Set<String> findPermissionsByRole(String role);

    /**
     * Find roles by permission set.
     * 通过权限查找角色集合
     * @param permission the permission
     * @return the set
     */
    Set<String> findRolesByPermission(String permission);
}
