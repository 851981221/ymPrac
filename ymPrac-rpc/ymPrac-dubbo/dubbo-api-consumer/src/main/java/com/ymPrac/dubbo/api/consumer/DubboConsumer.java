package com.ymPrac.dubbo.api.consumer;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ReferenceConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.ymPrac.dubbo.api.provider.service.AnnotationProvider;

/**
 * dubbo 服务消费者
 * Created by Yan Meng on 2016/9/25.
 */
public class DubboConsumer {

    public static void main(String[] args) {
        initDubboConsumer();
    }

    private static void initDubboConsumer() {
        // 当前应用配置
        ApplicationConfig application = new ApplicationConfig();
        application.setName("consumer");

        // 连接注册中心配置
        RegistryConfig registry = new RegistryConfig();
        registry.setDefault(registry.isDefault());

        registry.setProtocol("zookeeper");
        registry.setAddress("192.168.116.128:2181");
//        registry.setUsername("aaa");
//        registry.setPassword("bbb");

        // 注意：ReferenceConfig为重对象，内部封装了与注册中心的连接，以及与服务提供方的连接

        // 引用远程服务
        ReferenceConfig<AnnotationProvider> reference = new ReferenceConfig<>(); // 此实例很重，封装了与注册中心的连接以及与提供者的连接，请自行缓存，否则可能造成内存和连接泄漏
        reference.setApplication(application);
        reference.setRegistry(registry); // 多个注册中心可以用setRegistries()
        reference.setInterface(AnnotationProvider.class);
        reference.setVersion("1.0.0");

        // 方法级配置
//        List<MethodConfig> methods = new ArrayList<MethodConfig>();
//        MethodConfig method = new MethodConfig();
//        method.setName("sayAnnotation");
//        method.setTimeout(30000);
//        method.setRetries(0);
//        methods.add(method);
//        reference.setMethods(methods); // 设置方法级配置

        // 和本地bean一样使用xxxService
        AnnotationProvider annotationProvider = reference.get(); // 注意：此代理对象内部封装了所有通讯细节，对象较重，请缓存复用
        String result = annotationProvider.sayAnnotation();
        System.out.println(result);
    }
}
