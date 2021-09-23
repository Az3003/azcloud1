package cn.az.springcloud.controller;

import cn.az.springcloud.entity.CommonResult;
import cn.az.springcloud.entity.Payment;
import cn.az.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class PaymentController {
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @Autowired
    public void setPaymentService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/payment/add")
    public CommonResult<Payment> addPayment(@RequestBody Payment payment) {
        if (payment.getSerial() != null) {
            int result = paymentService.addPayment(payment);
            log.info("插入结果：-----" + result);

            if (result > 0) {
                return new CommonResult<>(200, "插入到数据库成功");
            } else {
                return new CommonResult<>(444, "插入数据库失败", null);
            }
        } else {
            return new CommonResult<>(445, "serial属性不能为空", null);
        }
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {

        Payment result = paymentService.getPaymentById(id);
        log.info("查询结果：" + result);

        if (result != null) {
            return new CommonResult<>(200, "查询数据库成功，serverPort:" + serverPort, result);
        } else {
            return new CommonResult<>(444, "查询失败，没有id：" + id + "，serverPort:" + serverPort, null);
        }
    }

}
