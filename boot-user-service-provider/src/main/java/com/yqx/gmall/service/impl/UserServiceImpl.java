package com.yqx.gmall.service.impl;


import com.yqx.gmall.bean.UserAddress;
import com.yqx.gmall.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

// 实现类
// 服务提供者(用户模块)要 提供接口的实现类 给外界调用
@Service
public class UserServiceImpl implements UserService {

    /**
     * 根据用户Id 查询出该用户下所有的地址信息;
     * @param userId
     * @return
     */
    @Override
    public List<UserAddress> getUserAddressList(String userId) {

        // TO DO 目前只是使用伪数据进行测试
        // 使用伪数据进行测试
        UserAddress address1 = new UserAddress( 1,"北京昌平","1","于清晰","110","Y" );
        UserAddress address2 = new UserAddress( 2,"北京丰台云中图书馆","1","于清晰于清晰于清晰","110110110110","N" );

        // 将两个对象 封装成为一个List返回数据
        return Arrays.asList( address1,address2 );
    }
}
