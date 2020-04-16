package com.rise.springCloud.service.impl;

import com.rise.springCloud.dao.PaymentDao;
import com.rise.springCloud.entities.Payment;
import com.rise.springCloud.service.PaymentService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author long
 * @Date 2020/4/1 9:28
 * @Title
 * @Description //TODO
 **/
@Service
public class PaymentServiceImpl implements PaymentService {
    @Resource
    private PaymentDao paymentDao;

    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    public Payment getPaymentById(@Param("id") long id) {
        return paymentDao.getPaymentById(id);
    }
}
