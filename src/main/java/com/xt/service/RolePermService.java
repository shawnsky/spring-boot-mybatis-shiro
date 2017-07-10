package com.xt.service;

import com.xt.entity.RolePermission;

import java.util.Map;
import java.util.Set;

/**
 * Created by Administrator on 2017/7/8.
 */
public interface RolePermService {

    void add(RolePermission rolePermission);

    void remove(RolePermission rolePermission);

    void removeAll();

    void removeByRole(String role);

    Set<String> findPermissionsByRole(String role);

    Set<String> findRolesByPermission(String permission);

    Map<String, Set<String>> getPermissionRolesMap();

    void setPermissionRolesMap(Map<Long, Set<String>> map);
}
