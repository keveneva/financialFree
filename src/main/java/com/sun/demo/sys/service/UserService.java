package com.sun.demo.sys.service;

import com.github.pagehelper.Page;
import com.sun.demo.sys.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by me on 2018/1/15.
 */
@Service
public interface UserService  {

    void add(User user);

    void del(Long id);

    void update(User o);

    User getById(Long id);

    Page<User> findAll(int pageNo, int pageSize,String keyword);
}
