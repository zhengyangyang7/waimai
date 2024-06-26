package com.veliona.elemebackend.service.impl;

import com.veliona.elemebackend.entity.User;
import com.veliona.elemebackend.mapper.UserMapper;
import com.veliona.elemebackend.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author veliona
 * @since 2024-06-26 02:55:34
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    UserMapper userMapper;
    @Override
    public String register(User user) {
        User userValidator = userMapper.searchByUserAccount(user.getUserAccount());
        if (userValidator == null) {
            if ("".equals(user.getUserPassword())) {
                return "no password";
            } else if ("".equals(user.getUserAccount())) {
                return "no username";
            } else {
                userMapper.insert(user);
                return "success";
            }

        }
        return "user already exists";
    }

    @Override
    public String login(String userAccount, String userPassword) {
        User user = userMapper.searchByUserAccount(userAccount);
        if (user != null) {
            if(userPassword.equals(user.getUserPassword())) {
                return "success";
            }
            else {
                return "account or password error";
            }
        }
        return "user not exists";
    }
}
