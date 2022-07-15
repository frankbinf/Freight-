package com.bin.service.impl;
import com.bin.dto.UserDto;
import com.bin.mapper.UserMapper;
import com.bin.mapper.UserRoleMapper;
import com.bin.pojo.User;
import com.bin.pojo.UserExample;
import com.bin.pojo.UserRoleExample;
import com.bin.pojo.UserRoleKey;
import com.bin.service.IUserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
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
        //查询u2字段不为1的记录
        criteria.andU2IsNull();
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
        User user = new User();
        user.setUserId(id);
        user.setU2("1");
        return mapper.updateByPrimaryKeySelective(user);
    }

    /**
     * 添加和更新用户信息
     * @param userDto
     * @return
     * @throws Exception
     */
    @Override
    public Integer saveOrUpdate(UserDto userDto) throws Exception {
        //1.保存用户信息
        User user = userDto.getUser();
        if(user.getUserId()!= null){
            //id不为空表示是更新
            this.updateUser(user);
        }else {
            //id为空表示添加
            String salt = UUID.randomUUID().toString();
            Md5Hash passwordHash = new Md5Hash(user.getPassword(),salt);
            user.setPassword(passwordHash.toString());
            user.setU1(salt);
            this.addUser(user);
       }
        //2.保存用户和角色的绑定关系
        //如果用户id不为空则为更新，绑定角色id时需要将原理的角色删除再绑定新的角色
        UserRoleExample example = new UserRoleExample();
        example.createCriteria().andUserIdEqualTo(user.getUserId());
        userRoleMapper.deleteByExample(example);
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
    @Override
    public User queryById(Integer id) throws Exception{
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Integer> queryRoleById(Integer userId) throws Exception {
        UserRoleExample example = new UserRoleExample();
        example.createCriteria().andUserIdEqualTo(userId);
        List<UserRoleKey> userRoleKeys = userRoleMapper.selectByExample(example);
        List<Integer> ids = new ArrayList<Integer>();
        for (UserRoleKey userRoleKey : userRoleKeys) {
            ids.add(userRoleKey.getRoleId());
        }
        return ids;
    }

    @Override
    public PageInfo<User> queryByPage(UserDto userDto) throws Exception{
        PageHelper.startPage(userDto.getPageNum(),userDto.getPageSize());
        List<User> list = this.query(userDto.getUser());
        PageInfo<User> pageInfo = new PageInfo<User>(list);
        return pageInfo;
    }
}
