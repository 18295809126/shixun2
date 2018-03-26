package com.jk.model.company;

import java.io.Serializable;

public class t_company implements Serializable{

    //公司主键id
    private Integer id;

    //公司名称
    private String company_name;

    //公司logo
    private String company_logo;

    //公司简介
    private String company_introduction;

    //公司主页
    private String company_homepage;

    //公司收款方式支付宝二维码
    private String alipay_img;

    //公司收款方式微信二维码
    private String wx_img;

    //公司收款方式转账卡号
    private String accounts;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public String getCompany_logo() {
        return company_logo;
    }

    public void setCompany_logo(String company_logo) {
        this.company_logo = company_logo;
    }

    public String getCompany_introduction() {
        return company_introduction;
    }

    public void setCompany_introduction(String company_introduction) {
        this.company_introduction = company_introduction;
    }

    public String getCompany_homepage() {
        return company_homepage;
    }

    public void setCompany_homepage(String company_homepage) {
        this.company_homepage = company_homepage;
    }

    public String getAlipay_img() {
        return alipay_img;
    }

    public void setAlipay_img(String alipay_img) {
        this.alipay_img = alipay_img;
    }

    public String getWx_img() {
        return wx_img;
    }

    public void setWx_img(String wx_img) {
        this.wx_img = wx_img;
    }

    public String getAccounts() {
        return accounts;
    }

    public void setAccounts(String accounts) {
        this.accounts = accounts;
    }

    @Override
    public String toString() {
        return "t_company{" +
                "id=" + id +
                ", company_name='" + company_name + '\'' +
                ", company_logo='" + company_logo + '\'' +
                ", company_introduction='" + company_introduction + '\'' +
                ", company_homepage='" + company_homepage + '\'' +
                ", alipay_img='" + alipay_img + '\'' +
                ", wx_img='" + wx_img + '\'' +
                ", accounts='" + accounts + '\'' +
                '}';
    }
}
