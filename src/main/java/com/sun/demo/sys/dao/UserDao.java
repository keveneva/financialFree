package com.sun.demo.sys.dao;

import com.github.pagehelper.Page;
import com.sun.demo.sys.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;


/**
 * Created by me on 2018/1/15.
 */
@Mapper
public interface UserDao {

    void add(User o);

    void del(Long id);

    void update(User user);

    User getById(Long id);

    Page<User> findAll(Map<String,Object> map);
}
