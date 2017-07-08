package com.xt.service;

import com.xt.entity.Role;
import com.xt.entity.User;

import java.util.List;

/**
 * Created by Administrator on 2017/7/7.
 */
public interface RoleService {

    User createRole(Role role);

    void deleteRole(Long roleId);

    Role findById(Long roleId);

    List<Role> findAll();
}
