package com.zcoco.springcloud.alibaba;

import com.zcoco.springcloud.alibaba.api.EchoService;
import com.zcoco.springcloud.alibaba.api.vo.User;
import com.zcoco.springcloud.alibaba.config.TestConfig;
import com.zcoco.springcloud.alibaba.repertory.mapper.UserMapper;
import org.apache.dubbo.config.annotation.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/*
 * 描述:
 * @auth zhengkk19738
 * @time 2019/4/24
 */

@Service
public class DefaultDemoService implements EchoService {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private TestConfig testConfig;

    @Autowired
    private UserMapper userMapper;

    @Override
    public String echo(String message) {
        logger.info("DO ECHO 。。。。。。。。。。。。。");
        User byIdUser = userMapper.findById("1");
        if (byIdUser == null) {
            return "null user ";
        }
        return "[echo] Hello, " + message + " and the port is :" + testConfig.isError();
    }

    @Override
    public int saveUser(User user) {
        int result = userMapper.saveUser(user);
        if (testConfig.isError() | result < 1) {
            throw new RuntimeException("模拟出错");
        }
        return result;
    }


}
