package com.hs.bootmq.config;

/**
 * @Author: yc
 * @Description:
 * @Date: Create in 10:38 2020/12/23
 */

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.stereotype.Component;

import javax.jms.Queue;
import javax.jms.Topic;

@Component
@EnableJms
public class ActiveMqConfig {
    @Value("${myqueue}")
    private String myQueue;
    @Value("${mytopic}")
    private String myTopic;
    @Bean
    public Queue queue(){
        return new ActiveMQQueue(myQueue);
    }
    @Bean
    public Topic topic(){
        return new ActiveMQTopic(myTopic);
    }

}
