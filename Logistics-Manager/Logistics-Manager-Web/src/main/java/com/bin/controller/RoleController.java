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
    public String jumpPageDispatch(Integer id,Model model) throws Exception{
        if(id != null){
            Role role = roleService.queryById(id);
            model.addAttribute("role",role);
        }
        return "role/addRole";
    }
    @RequestMapping("/saveOrUpdate")
    public String saveOrUpdate(Role role)throws Exception{
        if(role.getRoleId() !=null && role.getRoleId()>0){
            roleService.updateRole(role);
        }else{
            roleService.addRole(role);
        }
        return "redirect:/role/query";
    }

    /**
     * 根据id删除角色信息
     */
    @RequestMapping("/deleteById")
    public String deleteById(Integer id) throws Exception{
        System.out.println("要删除的角色id是"+id);
        roleService.deleteRole(id);
        return "redirect:/role/query";
    }
}
