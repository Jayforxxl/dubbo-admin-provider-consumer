package com.jay.dubbo.service.impl;


import com.alibaba.dubbo.config.annotation.Reference;
import com.jay.dubbo.bean.UserAddress;
import com.jay.dubbo.service.OrderService;
import com.jay.dubbo.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {


    @Reference
    UserService userService;

    @Override
    public void initOrder(String userId) {
        List<UserAddress> resultList = userService.getUserAddressList(userId);
        for (UserAddress userAddress : resultList ) {
            System.out.println(userAddress.getUserAddress());
        }
    }

    @Override
    public List<UserAddress> initOrderMessage(String userId) {
        return userService.getUserAddressList(userId);
    }

}