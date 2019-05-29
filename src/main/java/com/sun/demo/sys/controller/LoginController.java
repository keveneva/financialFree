package com.sun.demo.sys.controller;

import com.sun.demo.common.Result;
import com.sun.demo.sys.entity.User;
import com.sun.demo.sys.service.UserService;
import com.sun.demo.utils.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by me on 2018年2月24日11:15:53
 * 集合前端框架.
 */
@RestController
public class LoginController {


    @RequestMapping(value="sys/login")
    public Result<User> findAll(@RequestParam int pageNo, @RequestParam int pageSize, String keyword){
        //各种密码的验证

        return ResultUtils.success();
    }




}
