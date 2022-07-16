package com.bin.service.impl;
import com.bin.dto.UserDto;
import com.bin.mapper.RoleMapper;
import com.bin.mapper.UserMapper;
import com.bin.mapper.UserRoleMapper;
import com.bin.pojo.*;
import com.bin.service.IRoleService;
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
    private RoleMapper roleMapper;
    @Autowired
    private UserRoleMapper userRoleMapper;
    @Autowired
    private IRoleService roleService ;
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
            Md5Hash passwordHash = new Md5Hash(user.getPassword(),salt,1024);
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
        List<UserRoleKey> roleKeys = userRoleMapper.selectByExample(example);
        List<Integer> ids = new ArrayList<Integer>();
        if(roleKeys != null && roleKeys.size()>0) {
            for (UserRoleKey roleKey : roleKeys) {
                ids.add(roleKey.getRoleId());
            }
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

    @Override
    public User authLogin(String userName) {
        UserExample example = new UserExample();
        example.createCriteria().andUserNameEqualTo(userName);
        List<User> list = mapper.selectByExample(example);
        if(list != null && list.size()>0){
            return list.get(0);
        }
        return null;
    }

    @Override
    public List<Role> queryUserHaveRole(User user) throws Exception{
        //查询用户具有的角色id
        List<Integer> roleIds = this.queryRoleById(user.getUserId());
        List<Role> roles = null;
        if(roleIds != null && roleIds.size()>0){
            roles = new ArrayList<Role>();
            for (Integer roleId : roleIds) {
                Role role = roleMapper.selectByPrimaryKey(roleId);
                roles.add(role);
            }
            return roles;
        }
        return null;
    }

    /**
     * 根据角色名查询用户信息
     * @param roleName
     * @return
     */
    @Override
    public List<User> queryUserByRoleName(String roleName) throws Exception{
        RoleExample roleexample = new RoleExample();
        roleexample.createCriteria().andRoleNameEqualTo(roleName);
        List<Role> roles = roleMapper.selectByExample(roleexample);
        if(roles != null && roles.size()>0){
            Role role = roles.get(0);
            UserRoleExample userRoleExample = new UserRoleExample();
            userRoleExample.createCriteria().andRoleIdEqualTo(role.getRoleId());
            List<UserRoleKey> userRoleKeys = userRoleMapper.selectByExample(userRoleExample);
            if(userRoleKeys != null && userRoleKeys.size()>0){
                List<User> list = new ArrayList<User>();
                for (UserRoleKey userRoleKey : userRoleKeys) {
                    User user = this.queryById(userRoleKey.getUserId());
                    list.add(user);
                }
                return list;
            }
        }
        return null;
    }
}
