package com.ymPrac.dubbo.annotation.provider.service;

import com.alibaba.dubbo.config.ProtocolConfig;
import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.ServiceConfig;

/**
 * Created by Yan Meng on 2016/9/25.
 */
public class DubboProvider {

    public static void main(String[] args) throws InterruptedException {
        initSService();

        Thread.sleep(10000000);
    }

    private static void initSService() {
        // 服务实现
        AnnotationProvider annotationProvider = new AnnotationProviderImpl();

        // 当前应用配置
        ApplicationConfig application = new ApplicationConfig();
        application.setName("xxx");

        // 连接注册中心配置
        RegistryConfig registry = new RegistryConfig();
        registry.setAddress("192.168.116.128:2181");
//        registry.setUsername("aaa");
//        registry.setPassword("bbb");

        // 服务提供者协议配置
        ProtocolConfig protocol = new ProtocolConfig();
        protocol.setName("dubbo");
        protocol.setPort(12345);
        protocol.setThreads(200);

        // 注意：ServiceConfig为重对象，内部封装了与注册中心的连接，以及开启服务端口

        // 服务提供者暴露服务配置
        ServiceConfig<AnnotationProvider> service = new ServiceConfig<>(); // 此实例很重，封装了与注册中心的连接，请自行缓存，否则可能造成内存和连接泄漏
        service.setApplication(application);
        service.setRegistry(registry); // 多个注册中心可以用setRegistries()
        service.setProtocol(protocol); // 多个协议可以用setProtocols()
        service.setInterface(AnnotationProvider.class);
        service.setRef(annotationProvider);
        service.setVersion("1.0.0");

        // 暴露及注册服务
        service.export();
    }
}
