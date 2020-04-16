package com.rise.springCloud.dao;

import com.rise.springCloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Author long
 * @Date 2020/4/1 8:50
 * @Title
 * @Description //TODO
 **/
@Mapper
public interface PaymentDao {
    public int create(Payment payment);

    public Payment getPaymentById(@Param("id") long id);
}
