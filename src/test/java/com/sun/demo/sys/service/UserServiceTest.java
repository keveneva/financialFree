package com.sun.demo.sys.service;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.sun.demo.common.PageInfo;
import com.sun.demo.sys.entity.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by me on 2018/1/18.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    private Logger logger = LoggerFactory.getLogger(UserServiceTest.class);

    @Autowired
    private UserService service;

    @Test
    public void findAll() throws Exception {
        Page<User> page = service.findAll(1,2,"");
        PageInfo<User> pageInfo = new PageInfo<>(page);
        System.out.println(JSON.toJSONString(pageInfo));//list //total
        System.out.println("list结果集："+JSON.toJSONString(pageInfo.getList()));
        System.out.println("返回给前端的条数："+pageInfo.getList().size());
        System.out.println("查询总数"+pageInfo.getTotal());
    }

}