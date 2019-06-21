package com.sun.demo.sys.entity;

import com.sun.demo.common.BaseEntity;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * Created by me on 2018/1/4.
 */
@Data
@Table(name="SYS_USER")
public class UserEntity extends BaseEntity{

    @Column(name = "ID")
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;

    @NotNull(message = "用户名必传")
    private String userName;

    @NotNull(message = "密码必传")
    private String password;

    @NotNull(message = "号码必传")
    private String phone;


}
