package com.xt.service.impl;/**
 * Created by Administrator on 2017/7/10.
 */

import com.xt.entity.UserRole;
import com.xt.mapper.UserRoleMapper;
import com.xt.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 07-10 17:19
 *
 * @author xt
 **/
@Service("userRoleService")
public class UserRoleServiceImpl implements UserRoleService {

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Override
    public void add(UserRole userRole) {
        userRoleMapper.add(userRole);
    }

    @Override
    public void removeByRole(String role) {
        userRoleMapper.removeByRole(role);
    }
}
