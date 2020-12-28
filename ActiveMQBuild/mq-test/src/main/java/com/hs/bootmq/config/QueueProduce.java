package com.hs.bootmq.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

import javax.jms.Queue;
import javax.jms.Topic;
import java.util.UUID;

/**
 * @Author: yc
 * @Description:
 * @Date: Create in 16:21 2020/12/23
 */
@Component
public class QueueProduce {
    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;
    @Autowired
    private Queue queue;
    @Autowired
    private Topic topic;
    public void produceMsg(){
        jmsMessagingTemplate.convertAndSend(queue,"****"+ UUID.randomUUID().toString().substring(0,9));
        System.out.println("***队列消息发送完毕***");
    }
    public void produceTopicMsg(){
        jmsMessagingTemplate.convertAndSend(topic,"主题发布消息："+UUID.randomUUID().toString());
        System.out.println("***发布订阅消息发送完毕***");
    }
}
