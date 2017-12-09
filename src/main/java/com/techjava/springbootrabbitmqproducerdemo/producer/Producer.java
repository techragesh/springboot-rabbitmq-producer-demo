package com.techjava.springbootrabbitmqproducerdemo.producer;

import com.techjava.springbootrabbitmqproducerdemo.model.Category;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Producer {

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Value("${jsa.rabbitmq.exchange}")
    private String exchange;
    @Value("${jsa.rabbitmq.routingkey}")
    private String routerkey;

    public void produce(Category category){
        amqpTemplate.convertAndSend(exchange,routerkey,category);
        System.out.println("Sending information--->" +category);
    }

}
