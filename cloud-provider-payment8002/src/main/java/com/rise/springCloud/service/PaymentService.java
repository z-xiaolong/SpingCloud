package com.rise.springCloud.service;

import com.rise.springCloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @Author long
 * @Date 2020/4/1 9:27
 * @Title
 * @Description //TODO
 **/
public interface PaymentService {
    public int create(Payment payment);

    public Payment getPaymentById(@Param("id") long id);
}
