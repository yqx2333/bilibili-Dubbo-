package com.yqx.gmall.stub;

import com.alibaba.dubbo.common.utils.StringUtils;
import com.yqx.gmall.bean.UserAddress;
import com.yqx.gmall.service.UserService;

import java.util.List;

/**
 * 一般本地存根代码都和接口放在一起
 * 本地存根Stub进行测试
 * 简单来说 就是在调用远程服务之前 先调用本地存根代码
 * 在本地存根代码上进行 参数的判断 或者 添加一些小功能等操作
 */
public class UserServiceStub implements UserService {

    // 定义一个不可变变量UserService
    private final UserService userService;

    /**
     * 定义有参构造方法
     * @param userService
     */
    public UserServiceStub(UserService userService) {
        this.userService = userService;
    }

    /**
     * 重写方法 根据用户ID查询用户所有住址的信息List集合
     * 本地存根代码调用成功!
     * @param userId
     * @return
     * @Auth  yuqingxi
     */
    @Override
    public List<UserAddress> getUserAddressList(String userId) {

        // 测试
        System.out.println( "UserServiceStub本地存根代码进行调用了" );

        // 本地存根代码可以进行参数的判断
        // 判断userID是否为空
        if (!StringUtils.isBlank(userId)){
            // 如果不为空 则进行远程代码调用
            return userService.getUserAddressList(userId);
        }
        // 如果参数为空 则返回null
        return null;
    }
}
