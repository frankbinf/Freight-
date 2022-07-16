package com.bin.controller;

import com.bin.dto.CustomerDto;
import com.bin.pojo.Customer;
import com.bin.service.ICustomerService;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private ICustomerService customerService;

    @RequiresRoles(value = {"administrator","操作员","业务员"},logical = Logical.OR)
    @RequestMapping("/query")
    public String query(Customer customer,Model model)throws Exception{
        List<CustomerDto> list = customerService.query(customer);
        model.addAttribute("list",list);
        return "customer/customer";
    }
    @RequestMapping("/customerDispatch")
    public String customerDispatch(Integer id, Model model) throws Exception{
       customerService.getInfoForCustomer(id, model);
        return "customer/updateCustomer";
    }

    @RequestMapping("/saveOrUpdate")
    public String saveOrUpdate(Customer customer) throws Exception{
        customerService.saveOrUpdate(customer);
        return "redirect:/customer/query";
    }


}
