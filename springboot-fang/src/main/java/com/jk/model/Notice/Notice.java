package com.jk.model.Notice;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Notice implements Serializable {
    private  String id;

    private  String empid;

    private  String empnum;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date releasetime;

    private String content;

    private String headline;

    private String empname;

    private Integer auditFlag;

    private String mail;


    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmpid() {
        return empid;
    }

    public void setEmpid(String empid) {
        this.empid = empid;
    }

    public String getEmpnum() {
        return empnum;
    }

    public void setEmpnum(String empnum) {
        this.empnum = empnum;
    }

    public String getReleasetime() {
        if(releasetime==null){
            return null;
        }
        SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sim.format(releasetime);
    }

    public void setReleasetime(Date releasetime) {
        this.releasetime = releasetime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public String getEmpname() {
        return empname;
    }

    public void setEmpname(String empname) {
        this.empname = empname;
    }

    public Integer getAuditFlag() {
        return auditFlag;
    }

    public void setAuditFlag(Integer auditFlag) {
        this.auditFlag = auditFlag;
    }

    @Override
    public String toString() {
        return "Notice{" +
                "id='" + id + '\'' +
                ", empid='" + empid + '\'' +
                ", empnum='" + empnum + '\'' +
                ", releasetime=" + releasetime +
                ", content='" + content + '\'' +
                ", headline='" + headline + '\'' +
                ", empname='" + empname + '\'' +
                ", auditFlag=" + auditFlag +
                ", mail='" + mail + '\'' +
                '}';
    }
}
