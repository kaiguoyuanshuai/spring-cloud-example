package com.zcoco.springcloud.alibaba;

import com.alibaba.fescar.spring.annotation.GlobalTransactional;
import com.zcoco.springcloud.alibaba.api.CityService;
import com.zcoco.springcloud.alibaba.api.vo.City;
import com.zcoco.springcloud.alibaba.repertory.mapper.CityMapper;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

/*
 * 描述:
 * @auth zhengkk19738
 * @time 2019/4/24
 */

@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityMapper cityMapper;

    @Override
    @GlobalTransactional
    public String getCityName() {
        City byIdCity = cityMapper.findById("1");
        if (byIdCity != null) {
            return "";
        }
        return byIdCity.getCityName();
    }

    @Override
    public int saveCity(City city) {
        return cityMapper.saveCity(city);
    }
}
