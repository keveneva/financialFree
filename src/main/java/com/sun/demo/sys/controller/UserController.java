package com.sun.demo.sys.controller;

import com.sun.demo.sys.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by me on 2018/1/16.
 */
@RestController
public class UserController {

    @Autowired
    private UserService service;



}
