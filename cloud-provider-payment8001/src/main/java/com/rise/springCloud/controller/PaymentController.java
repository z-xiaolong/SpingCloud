package com.rise.springCloud.controller;

import com.rise.springCloud.entities.CommonResult;
import com.rise.springCloud.entities.Payment;
import com.rise.springCloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.bouncycastle.util.Times;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @Author long
 * @Date 2020/4/1 9:30
 * @Title
 * @Description //TODO
 **/
@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("插入结果" + payment);
        if (result > 0) {
            return new CommonResult(200, "插入数据库成功，serverPort: " + serverPort, result);
        } else {
            return new CommonResult(444, "插入数据库失败，serverPort: " + serverPort, null);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") long id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("查询结果" + payment);
        if (payment != null) {
            return new CommonResult(200, "查询成功，serverPort: " + serverPort, payment);
        } else {
            return new CommonResult(444, "没有对应记录+查询id:" + id + " serverPort: " + serverPort, null);
        }
    }

    @GetMapping(value = "/payment/discovery")
    public Object discovery() {
        List<String> services = discoveryClient.getServices();
        for (String str : services) {
            log.info("service: " + str);
        }
        List<ServiceInstance> serviceInstances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : serviceInstances) {
            log.info(instance.getServiceId() + "\t" + instance.getPort() + "\t" + instance.getHost() + "\t" + instance.getUri());
        }
        return this.discoveryClient;
    }

    @GetMapping("/payment/lb")
    public String getPaymentLB() {
        return serverPort;
    }

    @GetMapping("/payment/feign/timeout")
    public String paymentFeignTimeout() {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return serverPort;
    }
}
