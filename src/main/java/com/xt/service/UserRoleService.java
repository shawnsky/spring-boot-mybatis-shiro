package com.xt.service;

import com.xt.entity.UserRole;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/7/8.
 */
public interface UserRoleService {

    void add(UserRole userRole);

    void removeByRole(String role);

}
