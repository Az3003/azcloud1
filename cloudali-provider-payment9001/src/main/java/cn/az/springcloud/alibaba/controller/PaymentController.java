package cn.az.springcloud.alibaba.controller;

import cn.az.springcloud.alibaba.service.PaymentService;
import cn.az.springcloud.entity.CommonResult;
import cn.az.springcloud.entity.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {

    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @Autowired
    public void setPaymentService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

//    @PostMapping
//    public int

    @GetMapping("/payment/nacos/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        Payment result = paymentService.getPaymentById(id);
        if (result != null) {
            return new CommonResult<>(200, "查询数据库成功，serverPort:" + serverPort, result);
        } else {
            return new CommonResult<>(444, "查询失败，没有id：" + id + "，serverPort:" + serverPort, null);
        }
    }
}
