package com.bin.dto;

public class BasePage {
    //当前页
    protected int pageNum = 1;

    //每页大小
    protected  int pageSize = 3;
    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }


}
