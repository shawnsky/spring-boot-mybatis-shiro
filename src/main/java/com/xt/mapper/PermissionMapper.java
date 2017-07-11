package com.xt.mapper;

import com.xt.entity.Permission;
import com.xt.entity.Role;
import com.xt.entity.User;

import java.util.List;

/**
 * Created by Administrator on 2017/7/5.
 */
public interface PermissionMapper {

    /**
     * Create permission.
     * 创建权限
     * @param permission the permission
     */
    void createPermission(Permission permission);

    /**
     * Delete permission.
     * 删除权限
     * @param permissionId the permission id
     */
    void deletePermission(Long permissionId);

    /**
     * Find by id permission.
     * ID查找权限
     * @param permissionId the permission id
     * @return the permission
     */
    Permission findById(Long permissionId);

    /**
     * Find all list.
     * 查找所有权限
     * @return the list
     */
    List<Permission> findAll();


}
