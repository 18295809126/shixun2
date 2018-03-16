package com.jk.model.Emp;

public class t_emp {

    private String id;

    private String name;

    private String weixin;

    private String photo;

    private String phonenumer;

    private String loginnumber;

    private String password;


    public t_emp() {
    }

    public t_emp(String id, String name, String weixin, String photo, String phonenumer, String loginnumber, String password) {
        this.id = id;
        this.name = name;
        this.weixin = weixin;
        this.photo = photo;
        this.phonenumer = phonenumer;
        this.loginnumber = loginnumber;
        this.password = password;
    }

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

    public String getWeixin() {
        return weixin;
    }

    public void setWeixin(String weixin) {
        this.weixin = weixin;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getPhonenumer() {
        return phonenumer;
    }

    public void setPhonenumer(String phonenumer) {
        this.phonenumer = phonenumer;
    }

    public String getLoginnumber() {
        return loginnumber;
    }

    public void setLoginnumber(String loginnumber) {
        this.loginnumber = loginnumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "t_emp{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", weixin='" + weixin + '\'' +
                ", photo='" + photo + '\'' +
                ", phonenumer='" + phonenumer + '\'' +
                ", loginnumber='" + loginnumber + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
