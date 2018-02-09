package com.sun.demo.sys.controller;

import com.sun.demo.common.Result;
import com.sun.demo.sys.entity.User;
import com.sun.demo.sys.service.UserService;
import com.sun.demo.utils.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by me on 2018/1/16.
 */
@RestController
@RequestMapping(value="sys/user")
public class UserController {

    @Autowired
    private UserService service;

    @RequestMapping(value="findAll")
    public Result<User> findAll(@RequestParam int pageNo, @RequestParam int pageSize, String keyword){
        List<User> userList = service.findAll(pageNo,pageSize,keyword);
        return ResultUtils.success(userList);
    }

    @RequestMapping(value="save",method = RequestMethod.POST)
    public Result<User> save(@Valid User user, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return ResultUtils.error(400,bindingResult.getFieldError().getDefaultMessage());
        }
        service.add(user);
        return ResultUtils.success(user);
    }

    @RequestMapping(value="update",method = RequestMethod.POST)
    public Result<User> update(User user){
        if(null == user.getId()){
            return ResultUtils.error(400,"主键不能为空");
        }
        service.update(user);
        return ResultUtils.success();
    }

    @RequestMapping(value="getById/{id}")
    public Result<User> getById(@PathVariable("id") Long id){
        User user = service.getById(id);
        return ResultUtils.success(user);
    }



}
