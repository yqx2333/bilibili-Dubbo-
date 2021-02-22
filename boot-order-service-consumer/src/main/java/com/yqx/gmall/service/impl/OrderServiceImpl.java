package com.yqx.gmall.service.impl;

import com.yqx.gmall.bean.UserAddress;
import com.yqx.gmall.service.OrderService;
import com.yqx.gmall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 逻辑实现流程:
 *  1. 将服务提供者注册到注册中心;(暴漏服务)
 *      1> 导入dubbo依赖;(2.6.2);
 *      2> 创建配置文件 provider.xml
 *  2. 让服务消费者去注册中心订阅服务提供者的服务地址;  实现远程通信连接;
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private UserService userService;

    // 根据用户ID 初始化订单
    @Override
    public List<UserAddress> initOrder(String userId) {

        // TO DO 测试内容
        System.out.println( "用户ID:" + userId );

        // 查询用户收货地址  需要调用provider
        // 不做任何依赖
        List<UserAddress> addressList;
        addressList = userService.getUserAddressList("1");

        // 将所有的收货地址 进行返回
        return addressList;

    }
}
