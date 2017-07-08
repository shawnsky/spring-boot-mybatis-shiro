package com.xt.service.impl;/**
 * Created by Administrator on 2017/7/7.
 */

import com.xt.entity.Role;
import com.xt.entity.User;
import com.xt.mapper.RoleMapper;
import com.xt.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 07-07 16:31
 *
 * @author xt
 **/
@Service("roleService")
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleMapper roleMapper;

    @Override
    public User createRole(Role role) {
        return roleMapper.createRole(role);
    }

    @Override
    public void deleteRole(Long roleId) {
        roleMapper.deleteRole(roleId);
    }

    @Override
    public Role findById(Long roleId) {
        return roleMapper.findById(roleId);
    }

    @Override
    public List<Role> findAll() {
        return roleMapper.findAll();
    }
}
