package cn.az.springcloud.alibaba.cn.az.springcloud.alibaba.controller;

import cn.az.springcloud.entity.CommonResult;
import cn.az.springcloud.entity.Payment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class orderController {

    @Resource
    private RestTemplate restTemplate;


    @GetMapping("/consumer/payment/nacos/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {

//        String url = String.format("http://%s/payment/nacos/%d", "nacos-payment-provider", id);

        return restTemplate.getForObject("http://provider/payment/nacos/" + id, CommonResult.class);
    }

}
