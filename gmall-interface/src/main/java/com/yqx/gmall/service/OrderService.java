package com.yqx.gmall.service;

import com.yqx.gmall.bean.UserAddress;

import java.util.List;

public interface OrderService {

    // 根据用户ID初始化订单
    List<UserAddress> initOrder(String userId );


}
