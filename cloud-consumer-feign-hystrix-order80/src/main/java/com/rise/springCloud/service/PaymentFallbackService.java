package com.rise.springCloud.service;

import org.springframework.stereotype.Component;

/**
 * @Author long
 * @Date 2020/4/10 22:14
 * @Title
 * @Description //TODO
 **/
@Component
public class PaymentFallbackService implements PaymentHystrixService {

    @Override
    public String paymentInfo_OK(Integer id) {
        return "-----------PaymentFallbackService fall back-paymentInfo_OK";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "-----------PaymentFallbackService fall back-paymentInfo_TIMEOUT";
    }
}
