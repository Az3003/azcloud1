package cn.az.springcloud.alibaba.service;

import cn.az.springcloud.entity.Payment;


public interface PaymentService {
    int addPayment(Payment payment);
    Payment getPaymentById(Long id);
}
