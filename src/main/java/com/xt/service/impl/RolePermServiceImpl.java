package com.xt.service.impl;/**
 * Created by Administrator on 2017/7/8.
 */

import com.xt.entity.Permission;
import com.xt.entity.Role;
import com.xt.entity.RolePermission;
import com.xt.mapper.PermissionMapper;
import com.xt.mapper.RoleMapper;
import com.xt.mapper.RolePermMapper;
import com.xt.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * 07-08 16:01
 *
 * @author xt
 **/
@Service("rolePermService")
public class RolePermServiceImpl implements RolePermService {

    @Autowired
    private RolePermMapper rolePermMapper;

    @Autowired
    private PermissionService permissionService;
    @Autowired
    private RoleService roleService;

    @Override
    public void add(RolePermission rolePermission) {
        rolePermMapper.add(rolePermission);
    }

    @Override
    public void remove(RolePermission rolePermission) {
        rolePermMapper.remove(rolePermission);
    }

    @Override
    public void removeAll() {
        rolePermMapper.removeAll();
    }

    @Override
    public void removeByRole(String role) {
        rolePermMapper.removeByRole(role);
    }

    @Override
    public Set<String> findPermissionsByRole(String role) {
        return rolePermMapper.findPermissionsByRole(role);
    }

    @Override
    public Set<String> findRolesByPermission(String permission) {
        return rolePermMapper.findRolesByPermission(permission);
    }

    @Override
    public Map<String, Set<String>> getPermissionRolesMap() {
        Map<String, Set<String>> map = new HashMap<>();
        List<Permission> permissions = permissionService.findAll();
        for(Permission p:permissions){
            map.put(p.getDescription(), rolePermMapper.findRolesByPermission(p.getPermission()));
        }
        return map;
    }

    @Override
    public void setPermissionRolesMap(Map<Long, Set<String>> map) {
        removeAll();
        List<Permission> permissions = permissionService.findAll();
        for(Permission p:permissions){
            //add admin
            RolePermission adminPermission = new RolePermission();
            adminPermission.setPermissionId(p.getId());
            adminPermission.setRoleId(roleService.findByRole("admin").getId());
            rolePermMapper.add(adminPermission);

            Set<String> roles = map.get(p.getId());
            Iterator<String> iterator = roles.iterator();
            while (iterator.hasNext()){
                RolePermission rp = new RolePermission();
                rp.setPermissionId(p.getId());
                rp.setRoleId(roleService.findByRole(iterator.next()).getId());
                rolePermMapper.add(rp);
            }

        }
    }


}
