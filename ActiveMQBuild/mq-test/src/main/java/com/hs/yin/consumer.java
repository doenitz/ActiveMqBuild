package com.hs.yin;
import java.util.concurrent.CopyOnWriteArraySet;

import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;
/**
 * @Author: yc
 * @Description:
 * @Date: Create in 9:48 2020/12/18
 */
public class consumer {
        private static final String url = "tcp://127.0.0.1:61616";
        private static final String queueName = "testActivemq";
        //private static final String username = "111";
        //private static final String password = "111";

        //public static CopyOnWriteArraySet<Connection> ConsumerConnectionSet = new CopyOnWriteArraySet<Connection>();

        public static void main(String[] args) throws JMSException {
            //1. 创建ConnectionFactory
            //ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(username,password,url);
            ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
            //2. 创建Connection
            Connection connection = connectionFactory.createConnection();
            //3. 启动连接
            connection.start();
            //4. 创建会话
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            //5. 创建一个目标
            Destination destination = session.createQueue(queueName);
            //6. 创建一个消费者
            MessageConsumer consumer = session.createConsumer(destination);
            //7. 创建一个监听器
            //ConsumerConnectionSet.add(connection);
            consumer.setMessageListener(new MessageListener() {
                public void onMessage(Message message) {
                    try {
                        String messageText = ((TextMessage) message).getText();
                        System.out.println("接收消息  = [" + messageText + "]");

                    } catch (JMSException e) {
                        e.printStackTrace();
                    }
                }
            });
        }

    }

