package com.zcoco.springcloud.alibaba.api;

/*
 * 描述:
 * @auth zhengkk19738
 * @time 2019/4/24
 */

import com.zcoco.springcloud.alibaba.api.vo.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(name = "service-provider")
//@FeignClient(name = "service-provider" ,fallback = EchoServiceFallback.class)
//@DubboTransported(protocol = "dubbo")
public interface  EchoService {

    @GetMapping(value = "/echo/{message}")
    String echo(@PathVariable("message") String message);

    int saveUser(User user);
}
