package com.bin.service.impl;

import com.bin.common.Constant;
import com.bin.dto.CustomerDto;
import com.bin.mapper.CustomerMapper;
import com.bin.mapper.OrderMapper;
import com.bin.pojo.*;
import com.bin.service.IBasicDataService;
import com.bin.service.ICustomerService;
import com.bin.service.IRoleService;
import com.bin.service.IUserService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceImpl implements ICustomerService {
    @Autowired
    private CustomerMapper customerMapper ;
    @Autowired
    private IUserService userService;
    @Autowired
    private IBasicDataService basicDataService;
    @Autowired
    private OrderMapper orderMapper;


    @Override
    public void getInfoForCustomer(Integer id, Model model) throws Exception{
        //1.查询默认的常用区间
        List<BasicData> intervals = basicDataService.queryByParentName(Constant.BASIC_DEFAULT_INTERVAL);
        //2.查询角色为业务员的信息
        List<User> users = userService.queryUserByRoleName(Constant.ROLE_SALESMAN);
        if(id != null && id>0){
            //表示这是更新  根据传过来的id查询对应的客户信息
            Customer customer = customerMapper.selectByPrimaryKey(id);
            model.addAttribute("customer",customer);
        }
        model.addAttribute("intervals",intervals);
        model.addAttribute("users",users);
    }

    @Override
    public void saveOrUpdate(Customer customer) throws Exception {
        if(customer != null && customer.getCustomerId()!=null){
            //这是更新
            customerMapper.updateByPrimaryKeySelective(customer);
        }else {
            //这是添加
            customerMapper.insertSelective(customer);
        }
    }

    /**
     * 能查询客户信息的角色：管理员，操作员，业务员
     * 管理员和操作员可以查看所有客户信息
     * 业务员只能查看自己的客户信息
     * @param customer
     * @return
     * @throws Exception
     */
    @Override
    public List<CustomerDto> query(Customer customer) throws Exception {
        //1.获取当前登录用户具有的角色信息
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        List<Role> roles = userService.queryUserHaveRole(user);
        //2.判断当前用户是否具有管理员或者操作员的角色
        boolean flag = false;
        for (Role role : roles) {
            if(role.getRoleName().equals(Constant.ROLE_ADMIN) || role.getRoleName().equals(Constant.ROLE_OPERATOR)){
                flag = true;
            }
        }
        CustomerExample example = new CustomerExample();
        if(!flag){   //只有业务员一个角色
            example.createCriteria().andUserIdEqualTo(user.getUserId());
        }
        List<Customer> list = customerMapper.selectByExample(example);
        //需要返回CustomerDto对象的结果，需要设置到CustomerDto的属性中去
        List<CustomerDto> dtos = new ArrayList<>();
        if(list != null && list.size()>0){
            for (Customer c : list) {
                CustomerDto dto = new CustomerDto();
                //对象属性的拷贝
                BeanUtils.copyProperties(c,dto);
                //dto中的属性：常用区间、业务员名称
                String realName = userService.queryById(dto.getUserId()).getRealName();
                //设置业务员名称
                dto.setRealName(realName);
                String baseName = basicDataService.queryById(dto.getBaseId()).getBaseName();
                //设置常用区间
                dto.setIntervalName(baseName);
                dtos.add(dto);
            }
            return dtos;
        }
        return null;
    }

    /**
     * 检查客户是否生成了订单信息
     * @param id
     * @return
     */
    @Override
    public String checkCustomerOrder(Integer id) {
        OrderExample example = new OrderExample();
        example.createCriteria().andCustomerIdEqualTo(id);
        int count = orderMapper.countByExample(example);
        return count > 0 ? "1":"0";
    }

    @Override
    public void deleteById(Integer id) {
        customerMapper.deleteByPrimaryKey(id);
    }
}
