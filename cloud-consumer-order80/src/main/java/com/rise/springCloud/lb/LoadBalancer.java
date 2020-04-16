package com.rise.springCloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @Author long
 * @Date 2020/4/4 22:36
 * @Title
 * @Description //TODO
 **/
public interface LoadBalancer {
    ServiceInstance instance(List<ServiceInstance> serviceInstances);
}
