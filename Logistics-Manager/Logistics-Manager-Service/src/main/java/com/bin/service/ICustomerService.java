package com.bin.service;

import com.bin.dto.CustomerDto;
import com.bin.pojo.Customer;
import org.springframework.ui.Model;

import java.util.List;

public interface ICustomerService {

    /**
     * 获取添加或更新客户需要的基础数据
     */
    void getInfoForCustomer(Integer id, Model model)throws Exception;

    void saveOrUpdate(Customer customer)throws Exception;

    List<CustomerDto> query(Customer customer) throws Exception;
}
