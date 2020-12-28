package com.hs.bootmq.controller;

import com.hs.bootmq.config.QueueProduce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: yc
 * @Description:
 * @Date: Create in 17:18 2020/12/23
 */
@RestController
public class HomeController {
    @Autowired
    QueueProduce queueProduce;
    @PostMapping("/queue")
    public void sendmsg(){
        queueProduce.produceMsg();
    }
    @PostMapping("/topic")
    public void sendmsgTopic(){
        queueProduce.produceTopicMsg();
    }
}
