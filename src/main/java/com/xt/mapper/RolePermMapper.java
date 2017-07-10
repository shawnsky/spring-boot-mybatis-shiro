package com.xt.mapper;

import com.xt.entity.RolePermission;

import java.util.Set;

/**
 * Created by Administrator on 2017/7/8.
 */
public interface RolePermMapper {
    void add(RolePermission rolePermission);

    void remove(RolePermission rolePermission);

    void removeAll();

    void removeByRole(String role);

    Set<String> findPermissionsByRole(String role);

    Set<String> findRolesByPermission(String permission);
}
