package com.bin.service;

import com.bin.pojo.Role;

import java.util.List;

public interface IRoleService {

    /**
     * 根据条件查询用户信息
     * @param role
     * @return
     */
    List<Role> query(Role role) throws Exception;

    /**
     * 添加角色信息
     * @param role
     * @return
     */
    Integer addRole(Role role) throws Exception;

    /**
     * 更新角色信息
     * @param role
     * @return
     */
    Integer updateRole(Role role) throws Exception;

    /**
     * 根据id删除角色信息
     * @param id
     * @return
     */
    Integer deleteRole(Integer id) throws Exception;
}
