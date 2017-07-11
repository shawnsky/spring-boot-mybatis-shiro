package com.xt.service.impl;/**
 * Created by Administrator on 2017/7/10.
 */

import com.xt.entity.Permission;
import com.xt.mapper.PermissionMapper;
import com.xt.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 07-10 10:27
 *
 * @author xt
 */
@Service("permissionService")
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionMapper permissionMapper;

    @Override
    public void createPermission(Permission permission) {
        permissionMapper.createPermission(permission);
    }

    @Override
    public void deletePermission(Long permissionId) {
        permissionMapper.deletePermission(permissionId);
    }

    @Override
    public Permission findById(Long permissionId) {
        return permissionMapper.findById(permissionId);
    }

    @Override
    public List<Permission> findAll() {
        return permissionMapper.findAll();
    }
}
