package com.jk.model.decorate;

import java.io.Serializable;

public class Decorate implements Serializable {

    /**
     * 装修程度主键ID
     * */
    private String id;

    /**
     * 装修程度
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
