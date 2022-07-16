package com.bin.service;

import com.bin.dto.UserDto;
import com.bin.pojo.Role;
import com.bin.pojo.User;
import com.github.pagehelper.PageInfo;
import java.util.List;

public interface IUserService {
    /**
     * 根据条件查询用户信息
     * @param user
     * @return
     */
    List<User> query(User user) throws Exception;

    /**
     * 添加用户信息
     * @param user
     * @return
     */
    Integer addUser(User user) throws Exception;

    /**
     * 更新用户信息
     * @param user
     * @return
     */
    Integer updateUser(User user) throws Exception;

    /**
     * 根据id删除用户信息
     * @param id
     * @return
     */
    Integer deleteUser(Integer id) throws Exception;

    /**
     * 保存用户以及具有的角色信息
     */
    Integer saveOrUpdate(UserDto userDto) throws  Exception;

    /**
     * 根据id查询用户信息
     */
    User queryById(Integer id) throws Exception;

    /**
     * 根据用户id查询具有的角色id
     */
    List<Integer> queryRoleById(Integer userId) throws  Exception;

    /**
     * 分页的方法
     * @param userDto
     * @return
     * @throws Exception
     */
    PageInfo<User> queryByPage(UserDto userDto) throws Exception;

    /**
     * 认证的方法
     */
    User authLogin(String userName);

    /**
     * 查询用户具有的角色信息
     */
    List<Role> queryUserHaveRole(User user) throws Exception;

    List<User> queryUserByRoleName(String roleName ) throws Exception;
}
