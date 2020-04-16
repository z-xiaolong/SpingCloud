package com.rise.springCloud.service;

import com.rise.springCloud.entities.CommonResult;
import com.rise.springCloud.entities.Payment;
import feign.Param;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author long
 * @Date 2020/4/6 21:54
 * @Title
 * @Description //TODO
 **/
@Component
@FeignClient(value = "ClOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {

    @GetMapping(value = "/payment/get/{id}")
    CommonResult getPaymentById(@PathVariable("id") long id);

    @GetMapping("/payment/feign/timeout")
    public String paymentFeignTimeout();
}
