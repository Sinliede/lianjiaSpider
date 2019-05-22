package com.sinliede.spider.data.jpa.domain;

import com.sinliede.spider.data.jpa.converter.HouseStatusConverter;
import com.sinliede.spider.data.jpa.model.HouseStatus;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author sinliede
 *
 * @date 19-5-9 上午10:52
 * @desc
 */
@Entity
@Table(name = "box")
public class Box implements Serializable {

    private static final long serialVersionUID = -4294768875609667035L;

    @Id
    @Column(name = "id", nullable = false, unique = true)
    private int id;

    @Column(name = "districtId", nullable = false)
    private String districtId;

    @Column(name = "date", nullable = false)
    private Date date;

    @Column(name = "status", nullable = false)
    @Convert(converter = HouseStatusConverter.class)
    private HouseStatus status;

    @Column(name = "amount", nullable = false)
    private int amount;

    @Column(name = "bottomBorder", nullable = false)
    private double bottomBorder;

    @Column(name = "firstQuarter", nullable = false)
    private double firstQuarter;

    @Column(name = "middle", nullable = false)
    private double middle;

    @Column(name = "thirdQuarter", nullable = false)
    private double thirdQuarter;

    @Column(name = "topBorder", nullable = false)
    private double topBorder;

    @Column(name = "bottomErrPrev", nullable = false)
    private double bottomErrPrev;

    public int getId() {
        return id;
    }

    public Box setId(int id) {
        this.id = id;
        return this;
    }

    public String getDistrictId() {
        return districtId;
    }

    public Box setDistrictId(String districtId) {
        this.districtId = districtId;
        return this;
    }

    public Date getDate() {
        return date;
    }

    public Box setDate(Date date) {
        this.date = date;
        return this;
    }

    public HouseStatus getStatus() {
        return status;
    }

    public Box setStatus(HouseStatus status) {
        this.status = status;
        return this;
    }

    public int getAmount() {
        return amount;
    }

    public Box setAmount(int amount) {
        this.amount = amount;
        return this;
    }

    public double getBottomBorder() {
        return bottomBorder;
    }

    public Box setBottomBorder(double bottomBorder) {
        this.bottomBorder = bottomBorder;
        return this;
    }

    public double getFirstQuarter() {
        return firstQuarter;
    }

    public Box setFirstQuarter(double firstQuarter) {
        this.firstQuarter = firstQuarter;
        return this;
    }

    public double getMiddle() {
        return middle;
    }

    public Box setMiddle(double middle) {
        this.middle = middle;
        return this;
    }

    public double getThirdQuarter() {
        return thirdQuarter;
    }

    public Box setThirdQuarter(double thirdQuarter) {
        this.thirdQuarter = thirdQuarter;
        return this;
    }

    public double getTopBorder() {
        return topBorder;
    }

    public Box setTopBorder(double topBorder) {
        this.topBorder = topBorder;
        return this;
    }

    public double getBottomErrPrev() {
        return bottomErrPrev;
    }

    public Box setBottomErrPrev(double bottomErrPrev) {
        this.bottomErrPrev = bottomErrPrev;
        return this;
    }
}
