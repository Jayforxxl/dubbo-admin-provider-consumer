package com.jay.dubbo.service.impl;

import com.jay.dubbo.bean.UserAddress;
import com.jay.dubbo.service.UserService;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * Description:消费者的本地存根
 *
 * @author ZhangJieChao
 * @version 1.0
 * @date 2020/6/13 11:37
 */

public class UserServiceStub implements UserService {

    private final UserService userService;


    /**
     * 传入的是userService的远程代理对象
     * @param userService
     */
    public UserServiceStub(UserService userService) {
        super();
        this.userService = userService;
    }

    /**
     * 本地存根的具体实现
     * @param userId
     * @return
     */
    @Override
    public List<UserAddress> getUserAddressList(String userId) {
        System.out.println("调用本地存根");
        if (!StringUtils.isEmpty(userId)){
            return userService.getUserAddressList(userId);
        }
        return null;
    }
}
