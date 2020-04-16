package com.rise.springCloud.controller;

import com.rise.springCloud.entities.CommonResult;
import com.rise.springCloud.entities.Payment;
import com.rise.springCloud.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author long
 * @Date 2020/4/6 21:59
 * @Title
 * @Description //TODO
 **/
@RestController
@Slf4j
public class OrderFeignController {

    @Resource
    private PaymentFeignService feignService;

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") long id) {
        return feignService.getPaymentById(id);
    }

    @GetMapping("/consumer/payment/feign/timeout")
    public String paymentFeignTimeout() {
        //openFeign-ribbon, 客户端一般默认等待1s.
        return feignService.paymentFeignTimeout();
    }
}
