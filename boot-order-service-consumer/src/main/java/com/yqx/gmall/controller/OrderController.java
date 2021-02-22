package com.yqx.gmall.controller;

import com.yqx.gmall.bean.UserAddress;
import com.yqx.gmall.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class OrderController {

    // Controller 调用 Service
    // 注入OrderService
    @Autowired
    private OrderService orderService;

    // 初始化订单
    @ResponseBody
    @RequestMapping( "/initOrder" )
    public List<UserAddress> initOrder(@RequestParam("uid") String userId ){
        // 获取所有地址 id从url中获取
        List<UserAddress> addressList;
        addressList = orderService.initOrder(userId);
        // 将获取到的地址集合 返回
        return addressList;
    }


}
