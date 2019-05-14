package com.zcoco.springcloud.alibaba.api.vo;

import java.io.Serializable;

/*
 * 描述:
 * @auth zhengkk19738
 * @time 2019/5/10
 */
public class City implements Serializable {

    private static final long serialVersionUID = -648326128452778457L;
    String id;

    String cityName ;

    int cityAddress ;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public int getCityAddress() {
        return cityAddress;
    }

    public void setCityAddress(int cityAddress) {
        this.cityAddress = cityAddress;
    }
}
