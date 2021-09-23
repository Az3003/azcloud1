package cn.az.springcloud.controller;

import cn.az.springcloud.entity.Payment;
import cn.az.springcloud.service.PaymentService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.client.match.MockRestRequestMatchers;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.Assert;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class PaymentControllerTest {

    private MockMvc mvc;
    @Autowired
    WebApplicationContext wac;

    @Autowired
    PaymentService paymentService;

    @BeforeAll
    void setupMockMvc() {
        mvc = MockMvcBuilders.webAppContextSetup(wac).build();

    }

    @Test
    void addPayment() throws Exception {
        String json = "{\"serial\":\"测试9\"}";
//        String s = "serial=测试5";
        mvc.perform(MockMvcRequestBuilders.post("/payment/add")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .content(json.getBytes())
        )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    void getPaymentById() throws Exception {
//        Payment payment = paymentService.getPaymentById(2l);
//        assertEquals(2,payment.getId(),"错误");
        mvc.perform(MockMvcRequestBuilders.get("/payment/get/1")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaType.APPLICATION_JSON_UTF8)
        )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.serial").value("测试1"))
                .andDo(MockMvcResultHandlers.print());
    }
}