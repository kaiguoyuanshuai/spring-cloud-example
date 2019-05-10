package com.zcoco.springcloud.alibaba;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.zcoco.springcloud.alibaba.api.EchoService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 * 描述:
 * @auth zhengkk19738
 * @time 2019/4/24
 */
@RestController
public class TestController {

    @Reference
    private EchoService echoService;

    @RequestMapping("/echo/hi")
    @SentinelResource("hello")
    public String echo() {
        return echoService.echo("hi Zo");
    }
}
