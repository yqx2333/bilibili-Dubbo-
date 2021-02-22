package com.yqx.gmall.service;

import com.yqx.gmall.bean.UserAddress;

import java.util.List;

// 用户服务接口
// 主要提供 按照用户ID  返回该用户所有的收获地址;
public interface UserService {

    /**
     * 根据UserId 查询User信息
     * @param userId
     * @return
     */
    List<UserAddress> getUserAddressList( String userId );

}
