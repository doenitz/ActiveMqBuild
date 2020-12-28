package com.hs.yin;
import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import lombok.extern.slf4j.Slf4j;
import org.apache.activemq.ActiveMQConnectionFactory;
/**
 * @Author: yc
 * @Description:
 * @Date: Create in 9:42 2020/12/18
 */
@Slf4j
public class provider {
        //activemq默认端口号
        private static final String url = "tcp://127.0.0.1:61616";
        private static final String queueName = "testActivemq";
        //private static final String username = "111";
        //private static final String password = "111";

        public static void main(String[] args) throws JMSException {
            //1.创建ConnectionFactory
            //ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(username,password,url);
            ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
            //2.创建Connection
            Connection connection = connectionFactory.createConnection();
            //3.启动连接
            connection.start();
            //4.创建会话
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            //5.创建一个目标
            Destination destination = session.createQueue(queueName);
            //6.创建一个生产者
            MessageProducer producer = session.createProducer(destination);
            for (int i = 0; i < 20; i++) {
                //7.创建消息
                TextMessage textMessage = session.createTextMessage("testMQ" + i);
                //8.发布消息
                producer.send(textMessage);
                log.info("发送消息"+textMessage.getText());
                //System.out.println("发送消息"+textMessage.getText());
            }
            //9.关闭连接
            connection.close();
}
}
