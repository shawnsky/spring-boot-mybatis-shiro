package com.xt.service.impl;/**
 * Created by Administrator on 2017/7/11.
 */

import com.xt.service.*;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 07-11 10:01
 *
 * @author xt
 **/
public class ServiceImpl {
    @Autowired
    protected UserService userService;
    @Autowired
    protected PermissionService permissionService;
    @Autowired
    protected RoleService roleService;
    @Autowired
    protected UserRoleService userRoleService;
    @Autowired
    protected RolePermService rolePermService;
}
