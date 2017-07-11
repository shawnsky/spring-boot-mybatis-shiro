package com.xt.service.impl;/**
 * Created by Administrator on 2017/7/7.
 */

import com.xt.entity.Role;
import com.xt.entity.User;
import com.xt.mapper.RoleMapper;
import com.xt.mapper.UserMapper;
import com.xt.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 07-07 16:31
 *
 * @author xt
 **/
@Service("roleService")
public class RoleServiceImpl  implements RoleService {
    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private UserService userService;
    @Autowired
    private UserRoleService userRoleService;
    @Autowired
    private RolePermService rolePermService;

    @Override
    public void createRole(Role role) {
        roleMapper.createRole(role);
    }

    @Override
    public void deleteRole(Long roleId) {
        Role role = roleMapper.findById(roleId);
        //删除下属用户
        userService.deleteUserByRole(role.getRole());
        //删除用户角色关系
        userRoleService.removeByRole(role.getRole());
        //删除角色权限关系
        rolePermService.removeByRole(role.getRole());
        //删除角色
        roleMapper.deleteRole(roleId);
    }

    @Override
    public Role findById(Long roleId) {
        return roleMapper.findById(roleId);
    }

    @Override
    public Role findByRole(String role) {
        return roleMapper.findByRole(role);
    }

    @Override
    public List<Role> findAll() {
        return roleMapper.findAll();
    }

    @Override
    public List<Role> findAllExceptAdmin() {
        List<Role> roles = findAll();
        List<Role> del = new ArrayList<>();
        Iterator<Role> iterator = roles.iterator();
        while (iterator.hasNext()){
            Role role = iterator.next();
            if(role.getRole().equals("admin")){
                del.add(role);
            }
        }
        roles.removeAll(del);
        return roles;
    }
}
