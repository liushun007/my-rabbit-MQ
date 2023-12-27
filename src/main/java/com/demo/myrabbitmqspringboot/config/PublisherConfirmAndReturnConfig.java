package com.demo.myrabbitmqspringboot.config;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 *  指定RabbitTemplate对象，开启Confirm个Return，实现回调方法
 */
@Component
public class PublisherConfirmAndReturnConfig implements RabbitTemplate.ConfirmCallback,RabbitTemplate.ReturnCallback {
@Autowired
private RabbitTemplate rabbitTemplate;

//在类加载的时候回执行这个方法
@PostConstruct
public  void initMethod(){
    rabbitTemplate.setConfirmCallback(this::confirm);
    rabbitTemplate.setReturnCallback(this::returnedMessage);
}

@Override
public void confirm(CorrelationData correlationData, boolean ack, String cause) {
    if (ack){
        System.out.println("消息发送到Exchange成功!!!");
    }else {
        System.out.println("消息发送到Exchange失败");
    }

}

@Override
public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey) {
    System.out.println("消息发送到Queue失败！！！");

}

}

