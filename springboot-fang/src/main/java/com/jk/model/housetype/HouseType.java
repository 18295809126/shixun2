package com.jk.model.housetype;

import java.io.Serializable;

public class HouseType implements Serializable {

    /**
     * 房屋类型主键ID
     * */
    private String id;

    /**
     * 房屋类型名称
     * */
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
