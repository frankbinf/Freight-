package com.bin.service.impl;

import com.bin.mapper.BasicDataMapper;
import com.bin.pojo.BasicData;
import com.bin.pojo.BasicDataExample;
import com.bin.service.IBasicDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BasicDataServiceImpl implements IBasicDataService {
    @Autowired
    private BasicDataMapper basicDataMapper;

    @Override
    public List<BasicData> query(BasicData basicData) throws Exception {
        BasicDataExample example = new BasicDataExample();
        BasicDataExample.Criteria criteria = example.createCriteria();
        if(basicData != null){
            if(basicData.getBaseName() != null && !"".equals(basicData.getBaseName())){
                criteria.andBaseNameEqualTo(basicData.getBaseName());
            }
            if(basicData.getParentId() != null && !"".equals(basicData.getParentId())){
                criteria.andParentIdEqualTo(basicData.getParentId());
            }
        }
        //查询显示u2字段不为1的记录
        criteria.andU2IsNull();
        return basicDataMapper.selectByExample(example);
    }

    @Override
    public BasicData queryById(Integer id) throws Exception {
        return basicDataMapper.selectByPrimaryKey(id);
    }

    @Override
    public Integer addBasicData(BasicData basicData) throws Exception {
        if(basicData.getParentId() != null && basicData.getParentId() == -1){
            basicData.setParentId(null);
        }
        return basicDataMapper.insertSelective(basicData);
    }

    @Override
    public Integer updateBasicData(BasicData basicData) throws Exception {
        if(basicData.getParentId() != null && basicData.getParentId()==-1){
            basicData.setParentId(null);
        }
        return basicDataMapper.updateByPrimaryKeySelective(basicData);
    }

    @Override
    public Integer deleteBasicData(Integer id) throws Exception {
        BasicData basicData = new BasicData();
        basicData.setBaseId(id);
        basicData.setU2("1");
        return basicDataMapper.updateByPrimaryKeySelective(basicData);
    }

    @Override
    public List<BasicData> queryParentData() throws Exception {
        BasicDataExample example = new BasicDataExample();
        example.createCriteria().andParentIdIsNull();
        return basicDataMapper.selectByExample(example);
    }

    /**
     * 根据分类编号获取该类下面基础数据的信息
     */
    @Override
    public List<BasicData> queryByParentName(String parentName) throws Exception{
        BasicData basicData = new BasicData();
        basicData.setBaseName(parentName);
        List<BasicData> datas = this.query(basicData);
        if(datas != null && datas.size()>0){
            BasicData bd1 = datas.get(0);
            BasicData bd2 = new BasicData();
            bd2.setParentId(bd1.getBaseId());
            List<BasicData> list = this.query(bd2);
            return list;
        }
        return null;
    }
}
