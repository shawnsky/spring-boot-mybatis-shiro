package com.xt.mapper;

import com.xt.entity.Permission;
import com.xt.entity.Role;
import com.xt.entity.User;

import java.util.List;

/**
 * Created by Administrator on 2017/7/5.
 */
public interface PermissionMapper {

    void createPermission(Permission permission);

    void deletePermission(Long permissionId);

    Permission findById(Long permissionId);

    List<Permission> findAll();


}
