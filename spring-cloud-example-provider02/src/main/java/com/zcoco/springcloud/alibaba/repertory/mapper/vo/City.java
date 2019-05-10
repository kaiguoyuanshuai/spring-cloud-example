package com.zcoco.springcloud.alibaba.repertory.mapper.vo;

/*
 * 描述:
 * @auth zhengkk19738
 * @time 2019/5/10
 */
public class City {

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
