package com.bin.service;

import com.bin.dto.OrderDto;
import org.springframework.ui.Model;

public interface IOrderService {

    /**
     * 查询添加订单所需要的数据
     * @param model
     */
    public void queryAddNeedData(Model model)throws Exception;

    public void saveOrder(OrderDto dto);
}
