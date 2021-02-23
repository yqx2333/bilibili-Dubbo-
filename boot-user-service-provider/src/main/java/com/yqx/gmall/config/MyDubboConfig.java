package com.yqx.gmall.config;

import com.alibaba.dubbo.config.*;
import com.yqx.gmall.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * 创建一个API 该API是用于配置Dubbo属性等
 *  任何Dubbo标签 都有与之对应的 xxxConfig
 *      例如:   <dubbo:application>  -->  ApplicationConfig
 *             <dubbo:registry>     -->  RegistryConfig
 */
// @Configuration  // 将配置类注入到SpringBoot容器中
public class MyDubboConfig {

    /**
     * 替代 <dubbo:application>标签 设置Dubbo名称
     * @return
     */
    @Bean
    public ApplicationConfig applicationConfig(){
        ApplicationConfig applicationConfig = new ApplicationConfig();
        applicationConfig.setName( "boot-user-service-provider" );
        return applicationConfig;
    }

    /**
     * 配置注册中心配置
     * @return
     */
    @Bean
    public RegistryConfig registryConfig(){
        RegistryConfig registryConfig = new RegistryConfig();
        // 设置注册中心为zookeeper
        registryConfig.setProtocol( "zookeeper" );
        // 设置注册中心地址端口
        registryConfig.setAddress( "localhost:2181" );
        return registryConfig;
    }

    /**
     * 配置通信规则为Dubbo 通信端口号为20882
     * @return
     */
    @Bean
    public ProtocolConfig protocolConfig(){
        ProtocolConfig protocolConfig = new ProtocolConfig();
        // 设置通信名称
        protocolConfig.setName( "dubbo" );
        // 设置端口号
        protocolConfig.setPort( 20882 );
        return protocolConfig;
    }

    /**
     * 暴漏服务 泛型为你要暴漏那个服务 就写那个服务的类名
     * 在使用的时候SpringBoot会自动的将UserService注入进来
     * @return
     */
    @Bean
    public ServiceConfig<UserService> serviceServiceConfig(UserService userService){
        ServiceConfig<UserService> serviceConfig = new ServiceConfig<>();
        // 设置暴漏服务 可以使用全类名 也可以使用类名.class
        serviceConfig.setInterface(UserService.class);
        // 暴漏那个服务
        serviceConfig.setRef( userService );
        // 配置版本号
        serviceConfig.setVersion( "1.0.0" );
        // 设置超时属性
        // serviceConfig.setTimeout( 4000 );

        // 配置每一个Method信息
        MethodConfig methodConfig = new MethodConfig();
        // 设置方法名
        methodConfig.setName( "getUserAddressList" );
        // 超时时间
        methodConfig.setTimeout( 4000 );

        // 将method的设置 关联 到ServiceConfig配置中
        // ArrayList<MethodConfig> methodConfigs = new ArrayList<>();
        // methodConfigs.add( methodConfig );
        serviceConfig.setMethods(Collections.singletonList(methodConfig));

        // 返回
        return serviceConfig;
    }




}
