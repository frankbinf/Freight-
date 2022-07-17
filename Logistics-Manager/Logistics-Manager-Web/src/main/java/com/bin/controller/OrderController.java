package com.bin.controller;

import com.bin.dto.OrderDto;
import com.bin.pojo.Order;
import com.bin.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private IOrderService orderService;

    @RequestMapping("/orderDispatch")
    public String orderDispatch(Model model)throws Exception{
        orderService.queryAddNeedData(model);
        return "/order/addOrder";
    }

    @RequestMapping("/save")
    @ResponseBody
    public String saveOrder( @RequestBody OrderDto dto){
        orderService.saveOrder(dto);
        return "添加成功！";
    }
}
