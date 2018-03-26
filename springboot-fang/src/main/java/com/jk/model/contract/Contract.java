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

    private Double one_money;//第一次交钱金额

    private Double rent_money;//租金

    private Double deposit_money;//押金

    private Integer yueNum;//

    private String cnliquidateddamages;//大写钱转换违约金

    private String cnrentmoney;//大写钱转换租金

    private String cndeposit_money;//大写钱转换押金

    private String cnonemoney;//大写钱转换第一次钱
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

    private String staging_name;

    private Double liquidated_damages_ercentage;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date  predetermined_period;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date  payment_period;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date  emigration_time;

    private String eid;//建合同的员工ID

    private String eidname;//员工

    //房屋名称ID
    private String tradingroom;

    private String roomname;//房屋

    //交易类型 租或者卖（1租，2卖）
    private Integer tradingType;

    private Double unit_price;

    private String contractType;


    private String ordernumber;

    private Integer outOfDay;

    private Double two_money;

    private Double three_money;

    private Double four_money;

    private Integer house_type;



    public Integer getHouse_type() {
        return house_type;
    }

    public void setHouse_type(Integer house_type) {
        this.house_type = house_type;
    }

    public Integer getOutOfDay() {
        return outOfDay;
    }

    public void setOutOfDay(Integer outOfDay) {
        this.outOfDay = outOfDay;
    }

    public Double getTwo_money() {
        return two_money;
    }

    public void setTwo_money(Double two_money) {
        this.two_money = two_money;
    }

    public Double getThree_money() {
        return three_money;
    }

    public void setThree_money(Double three_money) {
        this.three_money = three_money;
    }

    public Double getFour_money() {
        return four_money;
    }

    public void setFour_money(Double four_money) {
        this.four_money = four_money;
    }

    public String getContractType() {
        return contractType;
    }

    public void setContractType(String contractType) {
        this.contractType = contractType;
    }

    public Double getUnit_price() {
        return unit_price;
    }

    public void setUnit_price(Double unit_price) {
        this.unit_price = unit_price;
    }

    public Double getLiquidated_damages_ercentage() {
        return liquidated_damages_ercentage;
    }

    public void setLiquidated_damages_ercentage(Double liquidated_damages_ercentage) {
        this.liquidated_damages_ercentage = liquidated_damages_ercentage;
    }

    public String getPredetermined_period() {
        if (predetermined_period==null){
            return null;
        }
        SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
        return sim.format(predetermined_period);
    }

    public void setPredetermined_period(Date predetermined_period) {
        this.predetermined_period = predetermined_period;
    }

    public String getPayment_period() {
        if (payment_period==null){
            return null;
        }
        SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
        return sim.format(payment_period);
    }

    public void setPayment_period(Date payment_period) {
        this.payment_period = payment_period;
    }

    public String getEmigration_time() {
        if (emigration_time==null){
            return null;
        }
        SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
        return sim.format(emigration_time);
    }

    public void setEmigration_time(Date emigration_time) {
        this.emigration_time = emigration_time;
    }

    public String getStaging_name() {
        return staging_name;
    }

    public void setStaging_name(String staging_name) {
        this.staging_name = staging_name;
    }

    public String getCnliquidateddamages() {
        return cnliquidateddamages;
    }

    public void setCnliquidateddamages(String cnliquidateddamages) {
        this.cnliquidateddamages = cnliquidateddamages;
    }

    public String getCnrentmoney() {
        return cnrentmoney;
    }

    public void setCnrentmoney(String cnrentmoney) {
        this.cnrentmoney = cnrentmoney;
    }

    public String getCndeposit_money() {
        return cndeposit_money;
    }

    public void setCndeposit_money(String cndeposit_money) {
        this.cndeposit_money = cndeposit_money;
    }

    public String getCnonemoney() {
        return cnonemoney;
    }

    public void setCnonemoney(String cnonemoney) {
        this.cnonemoney = cnonemoney;
    }

    public Integer getYueNum() {
        return yueNum;
    }

    public void setYueNum(Integer yueNum) {
        this.yueNum = yueNum;
    }

    public String getEid() {
        return eid;
    }

    public void setEid(String eid) {
        this.eid = eid;
    }


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

            if (rent_time==null){
                return null;
            }
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
                ", yueNum=" + yueNum +
                ", cnliquidateddamages='" + cnliquidateddamages + '\'' +
                ", cnrentmoney='" + cnrentmoney + '\'' +
                ", cndeposit_money='" + cndeposit_money + '\'' +
                ", cnonemoney='" + cnonemoney + '\'' +
                ", generation_time=" + generation_time +
                ", mention_rent='" + mention_rent + '\'' +
                ", liquidated_damages=" + liquidated_damages +
                ", title='" + title + '\'' +
                ", name='" + name + '\'' +
                ", payment_name='" + payment_name + '\'' +
                ", staging_name='" + staging_name + '\'' +
                ", liquidated_damages_ercentage=" + liquidated_damages_ercentage +
                ", predetermined_period=" + predetermined_period +
                ", payment_period=" + payment_period +
                ", emigration_time=" + emigration_time +
                ", ordernumber='" + ordernumber + '\'' +
                ", eid='" + eid + '\'' +
                ", eidname='" + eidname + '\'' +
                ", tradingroom='" + tradingroom + '\'' +
                ", roomname='" + roomname + '\'' +
                ", tradingType=" + tradingType +
                '}';
    }

    public String getOrdernumber() {
        return ordernumber;
    }

    public void setOrdernumber(String ordernumber) {
        this.ordernumber = ordernumber;
    }

    public String getEidname() {
        return eidname;
    }

    public void setEidname(String eidname) {
        this.eidname = eidname;
    }

    public String getTradingroom() {
        return tradingroom;
    }

    public void setTradingroom(String tradingroom) {
        this.tradingroom = tradingroom;
    }

    public String getRoomname() {
        return roomname;
    }

    public void setRoomname(String roomname) {
        this.roomname = roomname;
    }

    public Integer getTradingType() {
        return tradingType;
    }

    public void setTradingType(Integer tradingType) {
        this.tradingType = tradingType;
    }

}
