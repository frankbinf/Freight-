package com.bin.controller;
import com.bin.dto.UserDto;
import com.bin.pojo.Role;
import com.bin.pojo.User;
import com.bin.service.IRoleService;
import com.bin.service.IUserService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService userService;
    @Autowired
    private IRoleService roleService;

    @RequestMapping("/query")
    public String query(Model model,UserDto userDto) throws Exception {
        PageInfo<User> pageInfo = userService.queryByPage(userDto);
        model.addAttribute("pageModel", pageInfo);
        return "user/user";
    }

    @RequestMapping("/userDispatch")
    public String userDispatch(Integer id, Model model) throws Exception {
        if (id != null && id > 0) {
            //如果传过来的id不为空，就去查询该用户的信息
            User user = userService.queryById(id);
            model.addAttribute("user", user);
            //查询该用户具有的角色id
            List<Integer> ownIds = userService.queryRoleById(id);
            model.addAttribute("ownIds", ownIds);
        }
        //查询所有的角色信息
        List<Role> roleList = roleService.query(new Role());
        model.addAttribute("roleList", roleList);
        return "user/updateUser";
    }

    @RequestMapping("/saveOrUpdate")
    public String saveOrUpdate(UserDto userDto) throws Exception {
        //1.保存用户信息
        //2.保存用户和角色的绑定信息
        //这两个步骤数据业务逻辑代码，不应该放在controller层处理，
        // 所以由service层统一处理，只需声明一个方法调用即可
        Integer result = userService.saveOrUpdate(userDto);
        return "redirect:/user/query";
    }

    @RequestMapping("/checkUserName")
    @ResponseBody
    public String checkUserName(User user) throws Exception {
        List<User> list = userService.query(user);
        if (list == null || list.size() == 0) {
            return "1";
        }
        return "0";
    }
    @RequestMapping("/deleteUser")
    public String deleteUser(Integer userId) throws Exception {
        userService.deleteUser(userId);
        return "redirect:/user/query";
    }

}
