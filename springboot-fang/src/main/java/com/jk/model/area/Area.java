package com.jk.model.area;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

public class Area implements Serializable {

    private BigInteger id;

    private Date createDate;

    private Date modifyDate;

    private Integer orders;

    private String fullName;

    private String name;

    private String treePath;

    private BigInteger parent;

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public Integer getOrders() {
        return orders;
    }

    public void setOrders(Integer orders) {
        this.orders = orders;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTreePath() {
        return treePath;
    }

    public void setTreePath(String treePath) {
        this.treePath = treePath;
    }

    public BigInteger getParent() {
        return parent;
    }

    public void setParent(BigInteger parent) {
        this.parent = parent;
    }
}
