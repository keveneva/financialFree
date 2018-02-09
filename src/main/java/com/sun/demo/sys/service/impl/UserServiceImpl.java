package com.sun.demo.sys.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sun.demo.sys.dao.UserDao;
import com.sun.demo.sys.entity.User;
import com.sun.demo.sys.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by me on 2018/1/15.
 */
@Component
public class UserServiceImpl  implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public void add(User user) {
        userDao.add(user);
    }

    @Override
    public void del(Long id) {
        userDao.del(id);
    }

    @Override
    public void update(User user) {
        userDao.update(user);
    }

    @Override
    public User getById(Long id) {
        return userDao.getById(id);
    }

    @Override
    public Page<User> findAll(int pageNo, int pageSize,String keyword) {
        PageHelper.startPage(pageNo, pageSize);
        Map<String,Object> map = new HashMap<>();
        map.put("keyword",keyword);
        return userDao.findAll(map);
    }
}
