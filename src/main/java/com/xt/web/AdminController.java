package com.xt.web;/**
 * Created by Administrator on 2017/7/10.
 */

import com.xt.entity.Permission;
import com.xt.entity.Role;
import com.xt.entity.User;
import com.xt.entity.UserRole;
import com.xt.service.impl.ServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import redis.clients.jedis.JedisPool;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * 07-10 14:13
 *
 * @author xt
 **/
@Controller
@RequestMapping(value = "/admin")
public class AdminController extends ServiceImpl {

    @RequestMapping("/createUser")
    public String createUser(Model model){
        List<Role> roles = roleService.findAll();
        model.addAttribute("roles",roles);
        return "create_user";
    }

    @RequestMapping("/createUserSubmit")
    public String createUserSubmit(HttpServletRequest request){
        String role = request.getParameter("role");
        Long roleId = roleService.findByRole(role).getId();

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = new User();
        user.setUsername(username);
        user.setPassword("4297f44b13955235245b2497399d7a93");
        user.setSalt("123");
        userService.createUser(user);
        //设置角色
        Long userId = user.getId();
        UserRole ur = new UserRole();
        ur.setUserId(userId);
        ur.setRoleId(roleId);
        userRoleService.add(ur);

        return "redirect:/";
    }

    @RequestMapping("/createRole")
    public String createRole(){
        return "create_role";
    }

    @RequestMapping("/createRoleSubmit")
    public String createRoleSubmit(HttpServletRequest request){
        String role = request.getParameter("role");
        String description = request.getParameter("description");
        Role newRole = new Role();
        newRole.setRole(role);
        newRole.setDescription(description);
        roleService.createRole(newRole);
        return "redirect:/";
    }

    @RequestMapping("/manageRoles")
    public String manageRole(Model model){
        List<Role> roles = roleService.findAllExceptAdmin();
        model.addAttribute("roles",roles);
        return "manage_role";
    }


    @RequestMapping("/deleteRoleSubmit")
    public String deleteRole(HttpServletRequest request){
        String role = request.getParameter("role");
        System.out.println(role);
        roleService.deleteRole(roleService.findByRole(role).getId());
        return "redirect:/";
    }


    @RequestMapping("/updatePermission")
    public String updatePermission(Model model){
        Map<String,Set<String>> map = rolePermService.getPermissionRolesMap();
        model.addAttribute("prMap",map);

        List<Role> roles = roleService.findAllExceptAdmin(); //除了管理员以外其他角色
        model.addAttribute("roles", roles);

        return "update_permission";
    }


    @RequestMapping(value = "/updatePermissionSubmit",method = RequestMethod.POST)
    public String updatePermissionSubmit(HttpServletRequest request){
        Map<Long,Set<String>> map = new HashMap<>();

        for(Permission p:permissionService.findAll()){
            map.put(p.getId(),new HashSet<>());

            List<Role> roles = roleService.findAllExceptAdmin();//除了管理员以外其他角色
            for(Role role:roles){
                if(request.getParameter(p.getDescription()+role.getRole())!=null){
                    map.get(p.getId()).add(role.getRole());
                }
            }
        }
        rolePermService.setPermissionRolesMap(map);
        return "redirect:/";
    }


    @ResponseBody
    @RequestMapping(value = "/clearCache")
    public String clearCache(){
        return "ok";
    }
}
