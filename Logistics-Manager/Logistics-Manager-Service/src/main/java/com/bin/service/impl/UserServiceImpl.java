package com.bin.service.impl;

import com.bin.mapper.UserMapper;
import com.bin.pojo.User;
import com.bin.pojo.UserExample;
import com.bin.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserMapper mapper;

    @Override
    public List<User> query(User user) throws Exception {
        UserExample example = new UserExample();
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
}
