package com.yqx.gmall;

import com.alibaba.dubbo.config.spring.context.annotation.DubboComponentScan;
import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * SpringBoot 结合Dubbo去实现
 *      1. 导入依赖
 *          1> 导入Dubbo-starter依赖;
 *          2> 导入Dubbo其他依赖
 */
@EnableDubbo    // 开启基于注解的Dubbo功能
// @ImportResource(locations = "classpath:provider.xml" )   使用xml配置的时候 需要加上该注解
// @EnableDubbo(scanBasePackages = "com.yqx.gmall")         还要将@Service注解添加上 dubbo的Service
@SpringBootApplication
public class BootUserServiceProviderApplication {

    public static void main(String[] args) {
        // 主方法
        SpringApplication.run(BootUserServiceProviderApplication.class, args);
    }

}
