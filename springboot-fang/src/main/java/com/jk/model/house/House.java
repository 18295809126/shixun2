package com.jk.model.house;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

public class House implements Serializable{

    private String id;

    private String teid;

    private String title;

    private Integer price;

    private Integer room;

    private Integer hall;

    private Integer toilet;

    private Double houseArea;

    private String community;

    private BigInteger province;

    private BigInteger city;

    private BigInteger county;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date buildingTime;

    private  String roomType;

    private String roomDirection;

    private String houseFloor;

    private String decorate;

    private Double unitPrice;

    private Double monthlyPayments;

    private String sellingPoint;

    private String ownerMentality;

    private String communityComplete;

    private String serviceIntroduce;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date releaseTime;

    private String roomNum;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTeid() {
        return teid;
    }

    public void setTeid(String teid) {
        this.teid = teid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getRoom() {
        return room;
    }

    public void setRoom(Integer room) {
        this.room = room;
    }

    public Integer getHall() {
        return hall;
    }

    public void setHall(Integer hall) {
        this.hall = hall;
    }

    public Integer getToilet() {
        return toilet;
    }

    public void setToilet(Integer toilet) {
        this.toilet = toilet;
    }

    public Double getHouseArea() {
        return houseArea;
    }

    public void setHouseArea(Double houseArea) {
        this.houseArea = houseArea;
    }

    public String getCommunity() {
        return community;
    }

    public void setCommunity(String community) {
        this.community = community;
    }

    public BigInteger getProvince() {
        return province;
    }

    public void setProvince(BigInteger province) {
        this.province = province;
    }

    public BigInteger getCity() {
        return city;
    }

    public void setCity(BigInteger city) {
        this.city = city;
    }

    public BigInteger getCounty() {
        return county;
    }

    public void setCounty(BigInteger county) {
        this.county = county;
    }

    public Date getBuildingTime() {
        return buildingTime;
    }

    public void setBuildingTime(Date buildingTime) {
        this.buildingTime = buildingTime;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public String getRoomDirection() {
        return roomDirection;
    }

    public void setRoomDirection(String roomDirection) {
        this.roomDirection = roomDirection;
    }

    public String getHouseFloor() {
        return houseFloor;
    }

    public void setHouseFloor(String houseFloor) {
        this.houseFloor = houseFloor;
    }

    public String getDecorate() {
        return decorate;
    }

    public void setDecorate(String decorate) {
        this.decorate = decorate;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Double getMonthlyPayments() {
        return monthlyPayments;
    }

    public void setMonthlyPayments(Double monthlyPayments) {
        this.monthlyPayments = monthlyPayments;
    }

    public String getSellingPoint() {
        return sellingPoint;
    }

    public void setSellingPoint(String sellingPoint) {
        this.sellingPoint = sellingPoint;
    }

    public String getOwnerMentality() {
        return ownerMentality;
    }

    public void setOwnerMentality(String ownerMentality) {
        this.ownerMentality = ownerMentality;
    }

    public String getCommunityComplete() {
        return communityComplete;
    }

    public void setCommunityComplete(String communityComplete) {
        this.communityComplete = communityComplete;
    }

    public String getServiceIntroduce() {
        return serviceIntroduce;
    }

    public void setServiceIntroduce(String serviceIntroduce) {
        this.serviceIntroduce = serviceIntroduce;
    }

    public Date getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(Date releaseTime) {
        this.releaseTime = releaseTime;
    }

    public String getRoomNum() {
        return roomNum;
    }

    public void setRoomNum(String roomNum) {
        this.roomNum = roomNum;
    }
}
