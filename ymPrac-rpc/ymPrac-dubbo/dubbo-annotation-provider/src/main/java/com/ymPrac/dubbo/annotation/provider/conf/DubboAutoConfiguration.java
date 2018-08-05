package com.ymPrac.dubbo.annotation.provider.conf;
//
//import javax.annotation.Resource;
//
//import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import conf.alibaba.dubbo.config.ApplicationConfig;
//import conf.alibaba.dubbo.config.ProtocolConfig;
//import conf.alibaba.dubbo.config.ProviderConfig;
//import conf.alibaba.dubbo.config.RegistryConfig;
//import conf.alibaba.dubbo.rpc.Exporter;
//
///**
// * 多端口提供dubbo服务
// * 当你使用多端口提供服务，使用默认端口提供服务：需要加入在service上加上defaultProvider*
// */
////@Configuration
////@ConditionalOnClass(Exporter.class)
//public class DubboAutoConfiguration {
//
//    @Resource(name = "protocolConfig1")
//    private ProtocolConfig protocolConfig;
//
//    @Resource(name = "protocolConfig2")
//    private ProtocolConfig protocolConfig2;
//
//    /**
//     * 默认基于dubbo协议提供服务
//     *
//     * @return
//     */
//    @Bean(name = "protocolConfig1")
//    public ProtocolConfig protocolConfig() {
//        // 服务提供者协议配置
//        ProtocolConfig protocolConfig = new ProtocolConfig();
//        protocolConfig.setName("rmi");
//        protocolConfig.setPort(20881);
//        protocolConfig.setThreads(200);
//
//        System.out.println("protocolConfig1的hashCode: " + protocolConfig.hashCode());
//
//        return protocolConfig;
//    }
//
//    /**
//     * dubbo服务提供
//     *
//     * @param applicationConfig
//     * @param registryConfig
//     * @param protocolConfig
//     * @return
//     */
//    @Bean(name = "providerConfig1")
//    public ProviderConfig providerConfig(ApplicationConfig applicationConfig, RegistryConfig registryConfig) {
//        ProviderConfig providerConfig = new ProviderConfig();
//        providerConfig.setTimeout(1000);
//        providerConfig.setRetries(1);
//        providerConfig.setDelay(-1);
//        providerConfig.setApplication(applicationConfig);
//        providerConfig.setRegistry(registryConfig);
//        providerConfig.setProtocol(this.protocolConfig);
//        return providerConfig;
//    }
//
//    /**
//     * 默认基于dubbo协议提供服务
//     *
//     * @return
//     */
//    @Bean(name = "protocolConfig2")
//    public ProtocolConfig protocolConfig2() {
//        // 服务提供者协议配置
//        ProtocolConfig protocolConfig = new ProtocolConfig();
//        protocolConfig.setName("dubbo");
//        protocolConfig.setPort(20882);
//        protocolConfig.setThreads(200);
//
//        System.out.println("protocolConfig2的hashCode: " + protocolConfig.hashCode());
//
//        return protocolConfig;
//    }
//
//    /**
//     * dubbo服务提供
//     *
//     * @param applicationConfig
//     * @param registryConfig
//     * @param protocolConfig
//     * @return
//     */
//    @Bean(name = "providerConfig2")
//    public ProviderConfig providerConfig2(ApplicationConfig applicationConfig, RegistryConfig registryConfig) {
//        ProviderConfig providerConfig = new ProviderConfig();
//        providerConfig.setTimeout(1000);
//        providerConfig.setRetries(1);
//        providerConfig.setDelay(-1);
//        providerConfig.setApplication(applicationConfig);
//        providerConfig.setRegistry(registryConfig);
//        providerConfig.setProtocol(protocolConfig2);
//        return providerConfig;
//    }
//}
