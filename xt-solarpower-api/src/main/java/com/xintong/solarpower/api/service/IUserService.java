package com.xintong.solarpower.api.service;

import com.xintong.solarpower.api.entity.User;

import java.util.List;

/**
 * @ClassName IUserService
 * @Description TODO
 * @Author zsk
 * @Date 2020/3/3 11:46
 * @Version 1.0
 */
public interface IUserService {
    void addUser(User user);
    void deleteUser(Integer userId);
    void updateUser(User user);
    User findUserById(Integer userId);
    List<User> findAllUser();
}
