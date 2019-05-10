package com.zcoco.springcloud.alibaba;

import com.zcoco.springcloud.alibaba.api.CityService;
import com.zcoco.springcloud.alibaba.repertory.mapper.CityMapper;
import com.zcoco.springcloud.alibaba.repertory.mapper.vo.City;
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
    public String getCityName() {
        City byIdCity = cityMapper.findById("1");
        if (byIdCity != null) {
            return "";
        }
        return byIdCity.getCityName();
    }
}
