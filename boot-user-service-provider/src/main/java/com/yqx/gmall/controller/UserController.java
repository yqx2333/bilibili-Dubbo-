package com.yqx.gmall.controller;

import com.yqx.gmall.bean.UserAddress;
import com.yqx.gmall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    public UserService userService;

    @RequestMapping( "/user/initUser" )
    public List<UserAddress> initUser(@RequestParam("uid")String userId){
        List<UserAddress> addressList;
        addressList = userService.getUserAddressList(userId);
        return addressList;
    }


}
