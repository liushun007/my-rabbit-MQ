package com.demo.myrabbitmqspringboot.consumer;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * 创建消费者监听器接收消息
 */
@Component
public class Consumer {
//    @RabbitListener(queues = "topic-queue")
//    public void getMassage(Object massage){
//        System.out.println("接收到消息："+massage);
//    }


    //    修改消费者类为手动ack
    @RabbitListener(queues = "topic-queue")
    public void getMassage(String msg, Channel channel, Message message) throws IOException {
        System.out.println("接收到消息："+msg);
        //手动ack
        channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
    }

}

