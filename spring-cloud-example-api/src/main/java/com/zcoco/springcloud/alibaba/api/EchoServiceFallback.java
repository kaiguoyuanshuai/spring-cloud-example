package com.zcoco.springcloud.alibaba.api;

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
}
