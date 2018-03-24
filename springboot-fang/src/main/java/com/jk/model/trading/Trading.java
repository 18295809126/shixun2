package com.jk.model.trading;

import org.springframework.format.annotation.DateTimeFormat;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Trading {
    //交易ID
    private  String id;
    //时间戳 订单号
    private String ordernumber;
    //员工名称ID
    private String tradingname;
    //出售房屋ID
    private String  name;
    //房屋名称ID
    private String tradingroom;
    //展示房屋字段
    private String house;
    //交易时间
    @DateTimeFormat(pattern = ("yyyy-MM-dd"))
    private Date tradingTime;
    //交易类型 租或者卖
    private Integer tradingType;
    //预订期ID
    @DateTimeFormat(pattern = ("yyyy-MM-dd"))
    private Date tradingreservations;
    //预订期展示字段
    @DateTimeFormat(pattern = ("yyyy-MM-dd"))
    private Date predetermined;
    //交付期的ID
    @DateTimeFormat(pattern = ("yyyy-MM-dd"))
    private Date tradingdeliveryperiod;
    //交付期展示字段
    @DateTimeFormat(pattern = ("yyyy-MM-dd"))
    private Date payment;
    //迁出期的ID
    @DateTimeFormat(pattern = ("yyyy-MM-dd"))
    private Date tradingmoveout;
    //迁出期的字段
    @DateTimeFormat(pattern = ("yyyy-MM-dd"))
    private Date emigration;
    //房东ID
    private String  thenameofthelandlordName;
    //展示房东
    private String thenameo ;
    //省份证号ID
    private String  iDcard;
    //展示身份证号
    private String card;
    //联系方式ID
    private String contactinformations;
    //展示联系方式
    private String formation;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrdernumber() {
        return ordernumber;
    }

    public void setOrdernumber(String ordernumber) {
        this.ordernumber = ordernumber;
    }

    public String getTradingname() {
        return tradingname;
    }

    public void setTradingname(String tradingname) {
        this.tradingname = tradingname;
    }

    public String getTradingroom() {
        return tradingroom;
    }

    public void setTradingroom(String tradingroom) {
        this.tradingroom = tradingroom;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTradingTime() {

        if(tradingTime==null){
            return null;
        }
        SimpleDateFormat sims = new SimpleDateFormat("yyyy-MM-dd");
        return sims.format(tradingTime);

    }

    public void setTradingTime(Date tradingTime) {
        this.tradingTime = tradingTime;
    }

    public String getTradingType() {

        if(tradingType==null){
            return null;
        }
        SimpleDateFormat sims = new SimpleDateFormat("yyyy-MM-dd");
        return sims.format(tradingType);

    }

    public void setTradingType(Integer tradingType) {
        this.tradingType = tradingType;
    }

    public String getTradingreservations() {
        if(tradingreservations==null){
            return null;
        }
        SimpleDateFormat sims = new SimpleDateFormat("yyyy-MM-dd");
        return sims.format(tradingreservations);
    }

    public void setTradingreservations(Date tradingreservations) {
        this.tradingreservations = tradingreservations;
    }

    public String getPredetermined() {

        if(predetermined==null){
            return null;
        }
        SimpleDateFormat sims = new SimpleDateFormat("yyyy-MM-dd");
        return sims.format(predetermined);
    }

    public void setPredetermined(Date predetermined) {
        this.predetermined = predetermined;
    }

    public String getTradingdeliveryperiod() {
        if(tradingdeliveryperiod==null){
            return null;
        }
        SimpleDateFormat sims = new SimpleDateFormat("yyyy-MM-dd");
        return sims.format(tradingdeliveryperiod);
    }

    public void setTradingdeliveryperiod(Date tradingdeliveryperiod) {
        this.tradingdeliveryperiod = tradingdeliveryperiod;
    }

    public String getPayment() {
        if(payment==null){
            return null;
        }
        SimpleDateFormat sims = new SimpleDateFormat("yyyy-MM-dd");
        return sims.format(payment);

    }

    public void setPayment(Date payment) {
        this.payment = payment;
    }

    public String getTradingmoveout() {
        if(tradingmoveout==null){
            return null;
        }
        SimpleDateFormat sims = new SimpleDateFormat("yyyy-MM-dd");
        return sims.format(tradingmoveout);
    }

    public void setTradingmoveout(Date tradingmoveout) {
        this.tradingmoveout = tradingmoveout;
    }

    public String getEmigration() {
        if(emigration==null){
            return null;
        }
        SimpleDateFormat sims = new SimpleDateFormat("yyyy-MM-dd");
        return sims.format(emigration);
    }

    public void setEmigration(Date emigration) {
        this.emigration = emigration;
    }

    public String getThenameofthelandlordName() {
        if(thenameofthelandlordName==null){
            return null;
        }
        SimpleDateFormat sims = new SimpleDateFormat("yyyy-MM-dd");
        return sims.format(thenameofthelandlordName);
    }

    public void setThenameofthelandlordName(String thenameofthelandlordName) {
        this.thenameofthelandlordName = thenameofthelandlordName;
    }

    public String getThenameo() {
        return thenameo;
    }

    public void setThenameo(String thenameo) {
        this.thenameo = thenameo;
    }

    public String getiDcard() {
        return iDcard;
    }

    public void setiDcard(String iDcard) {
        this.iDcard = iDcard;
    }

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
    }

    public String getContactinformations() {
        return contactinformations;
    }

    public void setContactinformations(String contactinformations) {
        this.contactinformations = contactinformations;
    }

    public String getFormation() {
        return formation;
    }

    public void setFormation(String formation) {
        this.formation = formation;
    }



    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }
}
