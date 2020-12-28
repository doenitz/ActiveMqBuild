package com.hs.bootmq.config;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.TextMessage;

/**
 * @Author: yc
 * @Description:
 * @Date: Create in 16:22 2020/12/23
 */
@Component
public class QueueConsumer {
    @JmsListener(destination = "${myqueue}")
    public void receiveQueue(TextMessage textMessage) throws Exception{
        System.out.println("***消费者收到消息***"+textMessage.getText());
    }
    @JmsListener(destination = "${mytopic}")
    public void receiveTopic(TextMessage textMessage) throws Exception{
        System.out.println("***订阅消费者收到发布消息***"+textMessage.getText());
    }
}
