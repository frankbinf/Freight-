package com.bin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 页面跳转的控制器
 */
@Controller
public class PageController {
    /**
     * 首页
     */
    @RequestMapping(value = {"/","/home"})
    public String showMain(){
        return "main";
    }
    @RequestMapping("/{path}")
    public String showPage(@PathVariable String path){
        return path;
    }
}
