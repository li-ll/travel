package com.ruo.travel_1.service;

import com.ruo.travel_1.domain.User;

import java.util.List;

public interface UserService {

    /**
     * 注册用户
     * @param user
     * @return
     */
    boolean regist(User user);

    /**
     * 判断激活与否
     * @param code
     * @return
     */
    boolean active(String code);

    /**
     * 登录
     * @param user
     * @return
     */
    User login(String username,String password);
     User findByUsername(String username);
     User findByUid(int uid);

    List<User> findAll();
}
