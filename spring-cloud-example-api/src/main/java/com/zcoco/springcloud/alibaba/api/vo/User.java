package com.zcoco.springcloud.alibaba.api.vo;

import java.io.Serializable;

/*
 * 描述:
 * @auth zhengkk19738
 * @time 2019/5/10
 */
public class User  implements Serializable {

    private static final long serialVersionUID = 3626573890607037226L;
    String id;

    String userName ;

    int age ;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
