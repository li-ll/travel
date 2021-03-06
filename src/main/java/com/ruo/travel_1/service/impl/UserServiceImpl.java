package com.ruo.travel_1.service.impl;

import com.ruo.travel_1.mapper.UserMapper;
import com.ruo.travel_1.domain.User;
import com.ruo.travel_1.service.UserService;
import com.ruo.travel_1.util.MailUtils;
import com.ruo.travel_1.util.UuidUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public boolean regist(User user) {
        //2.保存用户信息
        //2.1设置激活码，唯一字符串
        user.setCode(UuidUtil.getUuid());
        //2.2设置激活状态
        user.setStatus("N");
        userMapper.save(user);
       //3.激活邮件发送，邮件正文？

        String content="<a href='http://localhost:81/user/active?code="+user.getCode()+"'>点击激活【黑马旅游网】</a>";

       MailUtils.sendMail(user.getEmail(),content,"激活邮件");
//暂时不发送邮件
        return true;
    }

    @Override
    public boolean active(String code) {
        //1.根据激活码查询用户对象
        User user = userMapper.findByCode(code);
        if(user != null){
            //2.调用dao的修改激活状态的方法
            userMapper.updateStatus(user);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public User login(String username, String password) {
        return userMapper.findByUsernameAndPassword(username,password);
    }


    @Override
    public User findByUsername(String username) {
        return userMapper.findByUsername(username);
    }

    @Override
    public User findByUid(int uid) {
        return userMapper.findByUid(uid);
    }

    @Override
    public List<User> findAll() {
        return userMapper.findAll();
    }


}
