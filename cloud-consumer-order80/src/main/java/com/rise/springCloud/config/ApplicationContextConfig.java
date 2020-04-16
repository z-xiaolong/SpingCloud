package com.rise.springCloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Author long
 * @Date 2020/4/1 20:29
 * @Title
 * @Description //TODO
 **/
@Configuration
public class ApplicationContextConfig {

    @Bean
    //@LoadBalanced //RestTemplate 负载均衡
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
