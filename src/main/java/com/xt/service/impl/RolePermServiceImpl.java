package com.xt.service.impl;/**
 * Created by Administrator on 2017/7/8.
 */

import com.xt.entity.RolePermission;
import com.xt.mapper.RolePermMapper;
import com.xt.service.RolePermService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 07-08 16:01
 *
 * @author xt
 **/
public class RolePermServiceImpl implements RolePermService {
    @Autowired
    private RolePermMapper rolePermMapper;
    @Override
    public void add(RolePermission rolePermission) {
        rolePermMapper.add(rolePermission);
    }

    @Override
    public void remove(RolePermission rolePermission) {
        rolePermMapper.remove(rolePermission);
    }
}
