package com.zcoco.springcloud.alibaba.api;

import com.zcoco.springcloud.alibaba.api.vo.City;

/*
 * 描述:
 * @auth zhengkk19738
 * @time 2019/5/10
 */
public interface CityService {

    String getCityName() ;

    int saveCity(City city) ;
}
