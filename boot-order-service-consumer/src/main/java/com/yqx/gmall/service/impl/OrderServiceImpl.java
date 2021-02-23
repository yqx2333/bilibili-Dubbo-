package com.yqx.gmall.service.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.yqx.gmall.bean.UserAddress;
import com.yqx.gmall.service.OrderService;
import com.yqx.gmall.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collections;
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

    // @Autowired  不再使用
    // 远程引用  会自动从注册中心发现  注入UserService
    // @Reference //( url = "127.0.0.1:20880")     // dubbo直连 将地址直接告诉给UserService

    @Reference    // (loadbalance = "roundrobin") loadbalance 负载均衡策略 roundrobin轮询
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

    /**
     * 如果服务调用失败,则降级调用该hello方法
     * @param userId
     * @return
     */
    public List<UserAddress> hello(String userId) {
       return Collections.singletonList
               (new UserAddress(10, "测试地址", "1", "测试", "测试", "1"));
    }
}
