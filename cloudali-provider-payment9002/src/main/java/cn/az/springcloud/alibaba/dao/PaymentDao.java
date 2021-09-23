package cn.az.springcloud.alibaba.dao;

import cn.az.springcloud.entity.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface PaymentDao {
    int addPayment(Payment payment);

    Payment getPaymentById(Long id);
}
