package com.jk.model.contract;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Contract implements Serializable {

    /**
     * 编号
     */
    private String code;
    /**
     *出租方
     */
    private String lease_name;
    /**
     * 承租方
     */
    private String lessee_name;
    /**
     * 房屋租赁
     */
    private String house_id;
    /**
     * 起租时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date  rent_time;
    /**
     * 到租时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date  finish_time;
    /**
     * 付款方式关联id
     */
    private Integer payment_method;
    /**
     * 分期状态关联id
     */
    private Integer staging_state;

    private Double one_money;

    private Double rent_money;

    private Double deposit_money;

    public Double getRent_money() {
        return rent_money;
    }

    public void setRent_money(Double rent_money) {
        this.rent_money = rent_money;
    }

    public Double getDeposit_money() {
        return deposit_money;
    }

    public void setDeposit_money(Double deposit_money) {
        this.deposit_money = deposit_money;
    }

    /**
     * 合同生成日期
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date  generation_time;
    /**
     * 收租金时间（天数）
     */
    private String mention_rent;
    /**
     * 违约金
     */
    private Double liquidated_damages;


    private String  title;

    private String  name;

    private  String  payment_name;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPayment_name() {
        return payment_name;
    }

    public void setPayment_name(String payment_name) {
        this.payment_name = payment_name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLease_name() {
        return lease_name;
    }

    public void setLease_name(String lease_name) {
        this.lease_name = lease_name;
    }

    public String getLessee_name() {
        return lessee_name;
    }

    public void setLessee_name(String lessee_name) {
        this.lessee_name = lessee_name;
    }

    public String getHouse_id() {
        return house_id;
    }

    public void setHouse_id(String house_id) {
        this.house_id = house_id;
    }

    public String getRent_time() {

        SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
        return sim.format(rent_time);
    }

    public void setRent_time(Date rent_time) {
        this.rent_time = rent_time;
    }

    public String getFinish_time() {
        if (finish_time==null){
            return null;
        }
        SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
        return sim.format(finish_time);
    }

    public void setFinish_time(Date finish_time) {
        this.finish_time = finish_time;
    }


    public Integer getPayment_method() {
        return payment_method;
    }

    public void setPayment_method(Integer payment_method) {
        this.payment_method = payment_method;
    }

    public Integer getStaging_state() {
        return staging_state;
    }

    public void setStaging_state(Integer staging_state) {
        this.staging_state = staging_state;
    }


    public String getGeneration_time() {
        if (generation_time==null){
            return null;
        }
        SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
        return sim.format(generation_time);
    }

    public void setGeneration_time(Date generation_time) {
        this.generation_time = generation_time;
    }

    public String getMention_rent() {
        return mention_rent;
    }

    public void setMention_rent(String mention_rent) {
        this.mention_rent = mention_rent;
    }

    public Double getLiquidated_damages() {
        return liquidated_damages;
    }

    public void setLiquidated_damages(Double liquidated_damages) {
        this.liquidated_damages = liquidated_damages;
    }

    public Double getOne_money() {
        return one_money;
    }

    public void setOne_money(Double one_money) {
        this.one_money = one_money;
    }

    @Override
    public String toString() {
        return "Contract{" +
                "code='" + code + '\'' +
                ", lease_name='" + lease_name + '\'' +
                ", lessee_name='" + lessee_name + '\'' +
                ", house_id='" + house_id + '\'' +
                ", rent_time=" + rent_time +
                ", finish_time=" + finish_time +
                ", payment_method=" + payment_method +
                ", staging_state=" + staging_state +
                ", one_money=" + one_money +
                ", rent_money=" + rent_money +
                ", deposit_money=" + deposit_money +
                ", generation_time=" + generation_time +
                ", mention_rent='" + mention_rent + '\'' +
                ", liquidated_damages=" + liquidated_damages +
                '}';
    }
}
