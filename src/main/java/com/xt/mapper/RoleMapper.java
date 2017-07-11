package com.xt.mapper;

import com.xt.entity.Role;
import com.xt.entity.User;

import java.util.List;
import java.util.Set;

/**
 * Created by Administrator on 2017/7/5.
 */
public interface RoleMapper {

    /**
     * Create role.
     * 创建角色
     * @param role the role
     */
    void createRole(Role role);

    /**
     * Delete role.
     * 删除角色
     * @param roleId the role id
     */
    void deleteRole(Long roleId);

    /**
     * Find by id role.
     * ID查找角色
     * @param roleId the role id
     * @return the role
     */
    Role findById(Long roleId);

    /**
     * Find by role role.
     * 角色名查找角色
     * @param role the role
     * @return the role
     */
    Role findByRole(String role);

    /**
     * Find all list.
     * 查找所有角色
     * @return the list
     */
    List<Role> findAll();


}
