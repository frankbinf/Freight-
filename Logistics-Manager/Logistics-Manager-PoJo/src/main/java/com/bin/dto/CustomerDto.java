package com.bin.dto;

import com.bin.pojo.Customer;

public class CustomerDto extends Customer {
    //业务员名字
    private  String realName;
    private String userName;
    //常用区间
    private  String intervalName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getIntervalName() {
        return intervalName;
    }

    public void setIntervalName(String intervalName) {
        this.intervalName = intervalName;
    }
}
