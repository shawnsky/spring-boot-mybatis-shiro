package com.xt.service;

import com.xt.entity.Role;
import com.xt.entity.User;

import java.util.List;

/**
 * Created by Administrator on 2017/7/7.
 */
public interface RoleService {

    void createRole(Role role);

    void deleteRole(Long roleId);

    Role findById(Long roleId);

    Role findByRole(String role);

    List<Role> findAll();

    List<Role> findAllExceptAdmin();
}
