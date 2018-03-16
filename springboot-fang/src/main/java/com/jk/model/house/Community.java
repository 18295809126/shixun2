package com.jk.model.house;

import java.io.Serializable;

public class Community implements Serializable {
    private static final long serialVersionUID = 2714548129686786769L;

    private String id;

    private String name;

    private String area_id;

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

    public String getArea_id() {
        return area_id;
    }

    public void setArea_id(String area_id) {
        this.area_id = area_id;
    }
}
