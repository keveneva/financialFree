package com.sun.demo.sys.entity;

import com.sun.demo.common.BaseEntity;
import javax.validation.constraints.NotNull;

/**
 * Created by me on 2018/1/4.
 */
public class User extends BaseEntity{

    @NotNull(message = "用户名必传")
//    @Max(value = 10, message = "用户名长度不能超过10个字符")
    private String userName;

    @NotNull(message = "密码必传")
    private String password;

    @NotNull(message = "号码必传")
    private String phone;

    public User() {
        super();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

}
