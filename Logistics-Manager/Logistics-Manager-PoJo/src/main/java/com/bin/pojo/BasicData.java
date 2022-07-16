package com.bin.pojo;

public class BasicData {
    private Integer baseId;

    private Integer parentId;

    private String baseName;

    private String baseDesc;

    private String u1;

    private String u2;

    public Integer getBaseId() {
        return baseId;
    }

    public void setBaseId(Integer baseId) {
        this.baseId = baseId;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getBaseName() {
        return baseName;
    }

    public void setBaseName(String baseName) {
        this.baseName = baseName == null ? null : baseName.trim();
    }

    public String getBaseDesc() {
        return baseDesc;
    }

    public void setBaseDesc(String baseDesc) {
        this.baseDesc = baseDesc == null ? null : baseDesc.trim();
    }

    public String getU1() {
        return u1;
    }

    public void setU1(String u1) {
        this.u1 = u1 == null ? null : u1.trim();
    }

    public String getU2() {
        return u2;
    }

    public void setU2(String u2) {
        this.u2 = u2 == null ? null : u2.trim();
    }
}