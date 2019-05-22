package com.sinliede.spider.data.jpa.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Copyright (C), 2018, 五维引力（上海）数据服务有限公司
 *
 * @author tianyu
 * @date 19-5-8 下午6:10
 * @desc
 */
@Entity
@Table(name = "district")
public class District implements Serializable {

    private static final long serialVersionUID = -2286448751387271482L;

    @Id
    @Column(name = "id", nullable = false, unique = true)
    private String id;

    @Column(name = "province", nullable = false)
    private String province;

    @Column(name = "city", nullable = false)
    private String city;

    //区
    @Column(name = "district")
    private String district;

    //小区
    @Column(name = "village")
    private String village;

    public String getId() {
        return id;
    }

    public District setId(String id) {
        this.id = id;
        return this;
    }

    public String getProvince() {
        return province;
    }

    public District setProvince(String province) {
        this.province = province;
        return this;
    }

    public String getCity() {
        return city;
    }

    public District setCity(String city) {
        this.city = city;
        return this;
    }

    public String getDistrict() {
        return district;
    }

    public District setDistrict(String district) {
        this.district = district;
        return this;
    }

    public String getVillage() {
        return village;
    }

    public District setVillage(String village) {
        this.village = village;
        return this;
    }
}
