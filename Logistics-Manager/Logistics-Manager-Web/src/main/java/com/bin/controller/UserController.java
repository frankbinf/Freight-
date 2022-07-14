package com.bin.controller;

import com.bin.pojo.User;
import com.bin.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService userService;

    @RequestMapping("/query")
    public String query(User user, Model model) throws Exception {
        List<User> list = userService.query(user);
        System.out.println(list.toString());
        model.addAttribute("list",list);
        return "user/user";
    }
}
