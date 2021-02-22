package com.yqx.gmall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * SpringBoot 结合Dubbo去实现
 *      1. 导入依赖
 *          1> 导入Dubbo-starter依赖;
 *          2> 导入Dubbo其他依赖
 */
@SpringBootApplication
public class BootUserServiceProviderApplication {

    public static void main(String[] args) {
        // 主方法
        SpringApplication.run(BootUserServiceProviderApplication.class, args);
    }

}
