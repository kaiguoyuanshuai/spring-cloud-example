package com.zcoco.springcloud.alibaba;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.zcoco.springcloud.alibaba.api.EchoService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 * 描述:
 * @auth zhengkk19738
 * @time 2019/4/24
 */
@RestController
public class TestDubboController {

    @Reference
    private EchoService echoService;

    @GetMapping("/echo/hi2")
    @SentinelResource("hello2")
    public String echo() {
        return echoService.echo("hi Zo");
    }
}
