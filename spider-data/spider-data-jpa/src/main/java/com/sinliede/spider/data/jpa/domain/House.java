package com.sinliede.spider.data.jpa.domain;

import com.sinliede.spider.data.jpa.converter.HouseStatusConverter;
import com.sinliede.spider.data.jpa.model.HouseStatus;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Copyright (C), 2018, 五维引力（上海）数据服务有限公司
 *
 * @author tianyu
 * @date 19-5-9 上午10:16
 * @desc
 */
@Entity
@Table(name = "house")
public class House implements Serializable {

    private static final long serialVersionUID = 3619964007902761036L;

    @Id
    @Column(name = "id", unique = true, nullable = false)
    private String id;

    @Column(name = "districtId", nullable = false)
    private String districtId;

    @Column(name = "status", nullable = false)
    @Convert(converter = HouseStatusConverter.class)
    private HouseStatus status;

    @Column(name = "unitPrice", nullable = false)
    private double unitPrice;

    @Column(name = "squareMeasure", nullable = false)
    private double squareMeasure;

    @Column(name = "type", nullable = false)
    private String type;

    @Column(name = "totalPrice", nullable = false)
    private double totalPrice;

    @Column(name = "launchTime", nullable = false)
    private Date launchTime;

    @Column(name = "withdrawTime")
    private Date withdrawTime;

    public String getId() {
        return id;
    }

    public House setId(String id) {
        this.id = id;
        return this;
    }

    public String getDistrictId() {
        return districtId;
    }

    public House setDistrictId(String districtId) {
        this.districtId = districtId;
        return this;
    }

    public HouseStatus getStatus() {
        return status;
    }

    public House setStatus(HouseStatus status) {
        this.status = status;
        return this;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public House setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
        return this;
    }

    public double getSquareMeasure() {
        return squareMeasure;
    }

    public House setSquareMeasure(double squareMeasure) {
        this.squareMeasure = squareMeasure;
        return this;
    }

    public String getType() {
        return type;
    }

    public House setType(String type) {
        this.type = type;
        return this;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public House setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
        return this;
    }

    public Date getLaunchTime() {
        return launchTime;
    }

    public House setLaunchTime(Date launchTime) {
        this.launchTime = launchTime;
        return this;
    }

    public Date getWithdrawTime() {
        return withdrawTime;
    }

    public House setWithdrawTime(Date withdrawTime) {
        this.withdrawTime = withdrawTime;
        return this;
    }
}
