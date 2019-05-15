package com.zcoco.springcloud.alibaba.api;

import com.zcoco.springcloud.alibaba.api.vo.User;

/*
 * 描述: 快速返回错误
 * @auth zhengkk19738
 * @time 2019/4/24
 */
//@Component
public class EchoServiceFallback implements EchoService {

    @Override
    public String echo(String message) {
        return "echo fallback";
    }

    @Override
    public int saveUser(User user) {
        return 0;
    }
}
