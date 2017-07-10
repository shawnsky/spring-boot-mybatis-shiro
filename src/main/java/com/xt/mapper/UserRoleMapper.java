package com.xt.mapper;

import com.xt.entity.RolePermission;
import com.xt.entity.UserRole;

import java.util.Set;

/**
 * Created by Administrator on 2017/7/8.
 */
public interface UserRoleMapper {

    void add(UserRole userRole);

    void removeByRole(String role);

}
