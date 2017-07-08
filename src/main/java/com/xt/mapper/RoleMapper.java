package com.xt.mapper;

import com.xt.entity.Role;
import com.xt.entity.User;

import java.util.List;
import java.util.Set;

/**
 * Created by Administrator on 2017/7/5.
 */
public interface RoleMapper {

    User createRole(Role role);

    void deleteRole(Long roleId);

    Role findById(Long roleId);

    List<Role> findAll();


}
