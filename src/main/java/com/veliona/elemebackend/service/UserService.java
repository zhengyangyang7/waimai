package com.veliona.elemebackend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.veliona.elemebackend.entity.User;

public interface UserService extends IService<User> {
    public String register(User user);
    public String login(String userAccount, String userPassword);
}
