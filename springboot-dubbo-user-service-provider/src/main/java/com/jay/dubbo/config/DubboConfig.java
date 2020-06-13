package com.jay.dubbo.config;

import com.alibaba.dubbo.config.*;
import com.alibaba.dubbo.config.annotation.Service;
import com.jay.dubbo.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 *
 * @author ZhangJieChao
 * @version 1.0
 * @date 2020/6/13 14:19
 */
//@Configuration
public class DubboConfig {

    /**
     * 设置服务名称
     * @return
     */
    @Bean
    public ApplicationConfig applicationConfig(){
        ApplicationConfig applicationConfig = new ApplicationConfig();
        applicationConfig.setName("springboot-user-service-provider");
        return applicationConfig;
    }

    /**
     * 配置注册中心
     * @return
     */
    @Bean
    public RegistryConfig registryConfig(){
        RegistryConfig registryConfig = new RegistryConfig();
        registryConfig.setProtocol("zookeeper");
        registryConfig.setAddress("121.199.79.138:2181");
        return registryConfig;
    }

    /**
     * 通信协议配置
     * @return
     */
    @Bean
    public ProtocolConfig protocolConfig(){
        ProtocolConfig protocolConfig = new ProtocolConfig();
        protocolConfig.setName("dubbo");
        protocolConfig.setPort(20880);
        return protocolConfig;
    }

    @Bean
    public ServiceConfig<UserService> userServiceServiceConfig(UserService userService){
        ServiceConfig<UserService> serviceConfig = new ServiceConfig<>();
        serviceConfig.setInterface(UserService.class);
        serviceConfig.setRef(userService);
        serviceConfig.setVersion("1.0.0");

        //配置每一个method的信息
        MethodConfig methodConfig = new MethodConfig();
        methodConfig.setName("getUserAddressList");
        methodConfig.setTimeout(5000);
        List<MethodConfig> methodConfigs = new ArrayList<>();
        methodConfigs.add(methodConfig);

        serviceConfig.setMethods(methodConfigs);

        return serviceConfig;
    }
}
