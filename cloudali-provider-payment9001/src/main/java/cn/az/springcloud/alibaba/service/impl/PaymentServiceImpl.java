package cn.az.springcloud.alibaba.service.impl;

import cn.az.springcloud.alibaba.dao.PaymentDao;
import cn.az.springcloud.alibaba.service.PaymentService;
import cn.az.springcloud.entity.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {

    private PaymentDao paymentDao;

    @Autowired
    public void getPaymentDao(PaymentDao paymentDao){
        this.paymentDao = paymentDao;
    }

    @Override
    public int addPayment(Payment payment) {
        return paymentDao.addPayment(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
