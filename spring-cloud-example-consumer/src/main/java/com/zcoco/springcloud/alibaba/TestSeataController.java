package com.zcoco.springcloud.alibaba;

import com.zcoco.springcloud.alibaba.api.CityService;
import com.zcoco.springcloud.alibaba.api.EchoService;
import com.zcoco.springcloud.alibaba.api.vo.City;
import com.zcoco.springcloud.alibaba.api.vo.User;
import io.seata.spring.annotation.GlobalTransactional;
import org.apache.dubbo.config.annotation.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 * 描述:
 * @auth zhengkk19738
 * @time 2019/5/14
 */
@RestController
@RequestMapping("seata")
public class TestSeataController {
    private Logger LOGGER = LoggerFactory.getLogger(getClass());
    @Reference
    private EchoService echoService;

    @Reference
    private CityService cityService;

    @GlobalTransactional(timeoutMills = 3000, name = "my_test_tx_group")
    @RequestMapping("/dubbo")
    public String seata() {
        City city = new City();
        city.setCityAddress(0);
        city.setCityName("杭州");
        int cityResult = cityService.saveCity(city);
        LOGGER.info("cityResult" + cityResult);

        User user = new User();
        user.setUserName("name");
        user.setAge(10);
        int userResult = echoService.saveUser(user);
        LOGGER.info("result" + userResult);

        if (cityResult + userResult < 0) {
            throw new RuntimeException("执行出错");
        }
        return "执行成功";
    }
}
