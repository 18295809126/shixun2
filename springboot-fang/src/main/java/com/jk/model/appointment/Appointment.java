package com.jk.model.appointment;

import com.jk.model.house.HouseResource;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Appointment implements Serializable {

    private String id;

    private String houseid;

    private String userName;

    private String userSex;

    private String userPhonenum;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date appointmentTime;

    private String title;

    private String community;

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
