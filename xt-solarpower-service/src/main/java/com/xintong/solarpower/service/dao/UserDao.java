package com.xintong.solarpower.service.dao;

import com.xintong.solarpower.api.entity.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName UserDao
 * @Description TODO
 * @Author zsk
 * @Date 2020/3/3 13:20
 * @Version 1.0
 */
@Repository
public class UserDao {
    public User findUserById(Integer userId){
        return new User(1,1,"zs","13022222130");
    }
    public List<User> findAllUser(){
    List<User> userList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            userList.add(new User(i,i,"userName"+i,"phoneNum"+i));
        }
        return userList;
    }
}
