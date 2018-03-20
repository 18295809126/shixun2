package com.jk.model.appointment;

import com.jk.model.house.HouseResource;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Appointment implements Serializable {

    //预约表主键ID
    private String id;
    //关联房源ID
    private String houseid;
    //预约人名称
    private String userName;
    //预约人性别
    private String userSex;
    //预约人联系方式
    private String userPhonenum;
    //预约时间
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date appointmentTime;
    //房源主题
    private String title;
    //房源所在小区
    private String community;
    //员工表关联ID
    private String emp_id;
    //预约看房时间
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date reservations_time;
    //员工名称
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(String emp_id) {
        this.emp_id = emp_id;
    }

    public String getReservations_time() {
        if(reservations_time==null){
            return null;
        }
        SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");
        return sim.format(reservations_time);
    }

    public void setReservations_time(Date reservations_time) {
        this.reservations_time = reservations_time;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCommunity() {
        return community;
    }

    public void setCommunity(String community) {
        this.community = community;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHouseid() {
        return houseid;
    }

    public void setHouseid(String houseid) {
        this.houseid = houseid;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    public String getUserPhonenum() {
        return userPhonenum;
    }

    public void setUserPhonenum(String userPhonenum) {
        this.userPhonenum = userPhonenum;
    }


    public String getAppointmentTime() {
        if(appointmentTime == null){
            return null;
        }
        SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");
        return sim.format(appointmentTime);
    }

    public void setAppointmentTime(Date appointmentTime) {
        this.appointmentTime = appointmentTime;
    }
}
