package com.xt.web;
/**
 * Created by Administrator on 2017/7/5.
 */

import com.xt.entity.Role;
import com.xt.entity.User;
import com.xt.service.RoleService;
import com.xt.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * 07-05 16:34
 *
 * @author xt
 **/
@Controller
public class BaseController {
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;

    @RequestMapping("/")
    public String index(Model model){
        //用户角色名
        Subject subject = SecurityUtils.getSubject();
        Set<String> roleNames = userService.findRoleNames(subject.getPrincipal().toString());
        String roleName = roleNames.iterator().next();
        model.addAttribute("roleName",roleName);

        //所有角色
        List<Role> allRoles = roleService.findAll();
        model.addAttribute("allRoles", allRoles);

        return "index";
    }



    @RequestMapping(value = "/login")
    public String showLoginForm(HttpServletRequest req, Model model) {
        String exceptionClassName = (String)req.getAttribute("shiroLoginFailure");
        String error = null;
        if(UnknownAccountException.class.getName().equals(exceptionClassName)) {
            error = "no such user";
        } else if(IncorrectCredentialsException.class.getName().equals(exceptionClassName)) {
            error = "please check your password";
        } else if(exceptionClassName != null) {
            error = "unknown error: " + exceptionClassName;
        } else {
            error = "";
        }
        model.addAttribute("error", error);
        return "login";
    }


    @RequestMapping(value = "/unauthorized")
    public String unauthorized(){
        return "unauthorized";
    }


    @RequestMapping(value = "agentQuery")
    public String agentQuery(Model model,HttpServletRequest request){
        String role = request.getParameter("role");
        String roleName = request.getParameter("roleName");
        //角色标题
        model.addAttribute("roleName",roleName);

        //列表
        List<User> agents = new ArrayList<>();
        agents = userService.findByRole(role);
        model.addAttribute("agents",agents);


        return "query_agent";
    }


    @RequestMapping("/developAgent")
    public String developAgent(Model model){
        model.addAttribute("message","开发代理。。。");
        return "develop_agent";
    }

    @RequestMapping("/authBook")
    public String authBook(Model model){
        return "auth_book";
    }


    @RequestMapping("/updatePermission")
    public String updatePermission(){
        return "update_permission";
    }



}
