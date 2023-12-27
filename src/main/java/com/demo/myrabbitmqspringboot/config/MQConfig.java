package com.demo.myrabbitmqspringboot.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 创建config配置，声明exchange和queue，并且绑定在一起
 */
@Configuration
public class MQConfig {


    //1、创建exchange topic
    @Bean
    public TopicExchange getTopicExchage() {
        return new TopicExchange("boot-topic-exchange", true, false);
    }

    //2、创建queue
    @Bean
    public Queue getQueue(){
        return new Queue("topic-queue",true,false,false,null);
    }


    //3、绑定
    @Bean
    public Binding geteBinding(TopicExchange topicExchange, Queue queue){
        return BindingBuilder.bind(queue).to(topicExchange).with("INFO");
    }

}

