package com.bin.service.impl;

import com.bin.common.Constant;
import com.bin.dto.CustomerDto;
import com.bin.dto.OrderDto;
import com.bin.mapper.OrderDetailMapper;
import com.bin.mapper.OrderMapper;
import com.bin.pojo.BasicData;
import com.bin.pojo.OrderDetail;
import com.bin.pojo.User;
import com.bin.service.IBasicDataService;
import com.bin.service.ICustomerService;
import com.bin.service.IOrderService;
import com.bin.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;

@Service
public class OrderServiceImpl implements IOrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private ICustomerService customerService;

    @Autowired
    private IUserService userService;

    @Autowired
    private IBasicDataService basicDataService;

    @Autowired
    private OrderDetailMapper detailMapper;

    /**
     * 查询添加订单所需要的数据
     * 1.查询所有客户信息
     * 2.查询所有的业务员信息
     * 3.查询基础数据：付款方式、货运方式、取件方式、常用区间和单位等
     * @param model
     */
    @Override
    public void queryAddNeedData(Model model) throws Exception{
        //1.查询所有的客户
        List<CustomerDto> customers = customerService.query(null);
        //2.查询所有的业务员
        List<User> users = userService.queryUserByRoleName(Constant.ROLE_SALESMAN);
        //3.查询基础数据
        List<BasicData> payTypes = basicDataService.queryByParentName(Constant.BASIC_PAYMENT_TYPE);
        List<BasicData> freights = basicDataService.queryByParentName(Constant.BASIC_FREIGHT_TYPE);
        List<BasicData> pickTypes = basicDataService.queryByParentName(Constant.BASIC_PICK_TYPE);
        List<BasicData> intervals = basicDataService.queryByParentName(Constant.BASIC_DEFAULT_INTERVAL);
        List<BasicData> units = basicDataService.queryByParentName(Constant.BASIC_UNIT);
        model.addAttribute("customers",customers);
        model.addAttribute("users",users);
        model.addAttribute("payTypes",payTypes);
        model.addAttribute("freights",freights);
        model.addAttribute("pickTypes",pickTypes);
        model.addAttribute("intervals",intervals);
        model.addAttribute("units",units);
    }

    @Override
    public void saveOrder(OrderDto dto) {
        //保存主表数据
        orderMapper.insert(dto);
        //保存详情数据
        List<OrderDetail> orderDetails = dto.getOrderDetails();
        if(orderDetails != null && orderDetails.size()>0){
            for (OrderDetail orderDetail : orderDetails) {
                orderDetail.setOrderId(dto.getOrderId());
                detailMapper.insertSelective(orderDetail);
            }
        }
    }
}
