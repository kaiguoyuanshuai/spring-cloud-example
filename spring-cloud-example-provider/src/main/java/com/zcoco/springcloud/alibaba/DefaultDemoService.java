package com.zcoco.springcloud.alibaba;

import com.zcoco.springcloud.alibaba.api.EchoService;
import com.zcoco.springcloud.alibaba.repertory.mapper.UserMapper;
import com.zcoco.springcloud.alibaba.repertory.mapper.vo.User;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

/*
 * 描述:
 * @auth zhengkk19738
 * @time 2019/4/24
 */

@Service
public class DefaultDemoService implements EchoService {

    @Autowired
    private TestConfig testConfig;

    @Autowired
    private UserMapper userMapper;

    @Override
    public String echo(String message) {
        User byIdUser = userMapper.findById("1");
        if (byIdUser == null) {
            return "null user ";
        }
        return "[echo] Hello, " + message + " and the port is :" + testConfig.getPort();
    }
}
