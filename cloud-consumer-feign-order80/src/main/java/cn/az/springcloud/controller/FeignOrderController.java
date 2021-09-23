package cn.az.springcloud.controller;

import cn.az.springcloud.entity.CommonResult;
import cn.az.springcloud.entity.Payment;
import cn.az.springcloud.service.FeignPaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class FeignOrderController {

    private FeignPaymentService feignPaymentService;

    @Autowired
    public void setFeignPaymentService(FeignPaymentService feignPaymentService) {
        this.feignPaymentService = feignPaymentService;
    }

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        return feignPaymentService.getPaymentById(id);
    }
}
