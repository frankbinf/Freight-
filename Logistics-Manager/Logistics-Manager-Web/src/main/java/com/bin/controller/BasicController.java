package com.bin.controller;

import com.bin.pojo.BasicData;
import com.bin.service.IBasicDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.xml.ws.soap.Addressing;
import java.util.List;

/**
 * 基础数据
 */
@Controller
@RequestMapping("/basic")
public class BasicController {

    @Autowired
    private IBasicDataService basicDataService;

    @RequestMapping("/query")
    public String query(BasicData data, Model model) throws Exception{
        List<BasicData> list = basicDataService.query(data);
        model.addAttribute("list",list);
        return "/basic/basic";
    }

    /**
     * 添加基础数据的跳转请求
     * @param id
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping("/basicDispatch")
    public String basicDispatch(Integer id,Model model) throws  Exception{
        if(id != null && id>0){
            //这是更新操作
            //先根据id查询出对应的基础数据再返回展示出来
            BasicData basicData = basicDataService.queryById(id);
            model.addAttribute("basicData",basicData);
        }
        //查询所有的大类基础数据
        List<BasicData> parentData = basicDataService.queryParentData();
        model.addAttribute("parent",parentData);
        return "/basic/updateBasic";
    }

    @RequestMapping("/saveOrUpdate")
    public String saveOrUpdate(BasicData data) throws Exception{
        System.out.println("要更新的id是："+data.getBaseId());
        if(data.getBaseId()!=null && data.getBaseId()>0){
            //说明这是更新操作
            basicDataService.updateBasicData(data);
        }else {
            basicDataService.addBasicData(data);
        }
        return "redirect:/basic/query";
    }

    @RequestMapping("/deleteBasic")
    public String deleteBasic(Integer id) throws Exception {
        System.out.println("要删除的id是："+id);
        basicDataService.deleteBasicData(id);
        return "redirect:/basic/query";
    }
}
