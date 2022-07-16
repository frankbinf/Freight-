package com.bin.service;

import com.bin.pojo.BasicData;
import org.springframework.stereotype.Service;

import java.util.List;


public interface IBasicDataService {

    /**
     * 根据条件查询基础数据信息
     * @param basicData
     * @return
     */
    List<BasicData> query(BasicData basicData) throws Exception;

    BasicData queryById(Integer id) throws Exception;

    /**
     * 添加基础数据信息
     * @param basicData
     * @return
     */
    Integer addBasicData(BasicData basicData) throws Exception;

    /**
     * 更新基础数据信息
     * @param basicData
     * @return
     */
    Integer updateBasicData(BasicData basicData) throws Exception;

    /**
     * 删除基础数据信息
     * @param id
     * @return
     */
    Integer deleteBasicData(Integer id) throws Exception;

    /**
     * 查询所有大类基础数据
     */
    List<BasicData> queryParentData()throws Exception;

    /**
     * 根据分类编号获取该类下面基础数据的信息
     */
    List<BasicData> queryByParentName(String parentName)throws Exception;
}
