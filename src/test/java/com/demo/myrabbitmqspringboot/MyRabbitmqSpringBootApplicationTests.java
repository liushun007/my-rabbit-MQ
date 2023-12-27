package com.demo.myrabbitmqspringboot;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@SpringBootTest
class MyRabbitmqSpringBootApplicationTests {

    @Autowired
    RabbitTemplate rabbitTemplate;

    //测试创建生产提供者发送消息
    @Test
    void contextLoads() throws IOException {
        rabbitTemplate.convertAndSend("boot-topic-exchange","INFO","hahaha");
        System.out.println("生产者发送消息成功");
    }


}
