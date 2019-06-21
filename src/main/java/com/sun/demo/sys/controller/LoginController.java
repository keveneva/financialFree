package com.sun.demo.sys.controller;

import com.sun.demo.common.Result;
import com.sun.demo.sys.entity.UserEntity;
import com.sun.demo.utils.ResultUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by me on 2018年2月24日11:15:53
 * 集合前端框架.
 */
@Controller
public class LoginController {


    @RequestMapping(value="sys/login")
    public Result<UserEntity> findAll(@RequestParam int pageNo, @RequestParam int pageSize, String keyword){
        //各种密码的验证

        return ResultUtils.success();
    }
    @RequestMapping(value="index")
    public String get(){

        return "index";
    }




}
