package com.yqx.gmall;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * SpringBoot 结合Dubbo去实现
 *      1. 导入依赖
 *          1> 导入Dubbo-starter依赖;
 *          2> 导入Dubbo其他依赖
 */
@EnableDubbo    // 开启基于注解的Dubbo功能
@SpringBootApplication
public class BootUserServiceProviderApplication {

    public static void main(String[] args) {
        // 主方法
        SpringApplication.run(BootUserServiceProviderApplication.class, args);
    }

}
