package com.bin.service.impl;

import com.bin.dto.UserDto;
import com.bin.mapper.UserMapper;
import com.bin.mapper.UserRoleMapper;
import com.bin.pojo.User;
import com.bin.pojo.UserExample;
import com.bin.pojo.UserRoleKey;
import com.bin.service.IUserService;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserMapper mapper;
    @Autowired
    private UserRoleMapper userRoleMapper;

    @Override
    public List<User> query(User user) throws Exception {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        if(user != null){
            if(user.getUserName() != null && !"".equals(user.getUserName())){
                criteria.andUserNameEqualTo(user.getUserName());
            }
        }
        return mapper.selectByExample(example);
    }

    @Override
    public Integer addUser(User user) throws Exception {
        return mapper.insertSelective(user);
    }

    @Override
    public Integer updateUser(User user) throws Exception {
        return mapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public Integer deleteUser(Integer id) throws Exception {
        return mapper.deleteByPrimaryKey(id);
    }

    @Override
    public Integer saveOrUpdate(UserDto userDto) throws Exception {
        //1.保存用户信息
        User user = userDto.getUser();
        String salt = UUID.randomUUID().toString();
        Md5Hash passwordHash = new Md5Hash(user.getPassword(),salt);
        user.setPassword(passwordHash.toString());
        user.setU1(salt);
        this.addUser(user);
        //2.保存用户和角色的绑定关系
        //获取给用户分配的角色id
        List<Integer> roleIds = userDto.getRoleIds();
        if(roleIds != null && roleIds.size()>0){
            for (Integer roleId : roleIds) {
                //将用户和角色的绑定信息保存到用户和角色的中间表里
                UserRoleKey userRoleKey = new UserRoleKey();
                userRoleKey.setUserId(user.getUserId());
                userRoleKey.setRoleId(roleId);
                userRoleMapper.insertSelective(userRoleKey);
            }
        }
        return 1;
    }
}
