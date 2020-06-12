package com.jay.dubbo.service;

import com.jay.dubbo.bean.UserAddress;

import java.util.List;

public interface OrderService {

    public void initOrder(String userId);

    public List<UserAddress> initOrderMessage(String userId);

}
