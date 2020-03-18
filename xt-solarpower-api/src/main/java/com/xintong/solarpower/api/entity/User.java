package com.xintong.solarpower.api.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName User
 * @Description TODO
 * @Author zsk
 * @Date 2020/3/3 11:33
 * @Version 1.0
 */
@Data
public class User implements Serializable {
    private static final long serialVersionUID = -7508433417918678676L;
    private Integer id;
    private Integer userId;
    private String userName;
    private String phoneNum;

    public User(Integer id, Integer userId, String userName, String phoneNum) {
        this.id = id;
        this.userId = userId;
        this.userName = userName;
        this.phoneNum = phoneNum;
    }
}
