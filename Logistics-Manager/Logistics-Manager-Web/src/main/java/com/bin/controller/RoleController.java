package com.bin.controller;

import com.bin.pojo.Role;
import com.bin.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private IRoleService roleService;
    @RequestMapping("/query")
    public String query(Role role , Model model) throws  Exception{
        List<Role> list = roleService.query(role);
        model.addAttribute("list",list);
        return "role/role";
    }

    /**
     * 处理跳转添加角色页面的请求
     * @return
     */
    @RequestMapping("/roleDispatch")
    public String jumpPageDispatch(){

        return "role/addRole";
    }
}
