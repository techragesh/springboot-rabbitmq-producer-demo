package com.techjava.springbootrabbitmqproducerdemo;

import com.techjava.springbootrabbitmqproducerdemo.model.Category;
import com.techjava.springbootrabbitmqproducerdemo.model.Item;
import com.techjava.springbootrabbitmqproducerdemo.producer.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class SpringbootRabbitmqProducerDemoApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(SpringbootRabbitmqProducerDemoApplication.class, args);
	}

	@Autowired
	Producer producer;

	@Override
	public void run(String... strings) throws Exception {

		/*
		 * Init Java objects
		 */
		Item iphone7 = new Item("iphone8");
		Item iPadPro = new Item("iphoneX");

		List<Item> appleProducts = new ArrayList<Item>(Arrays.asList(iphone7, iPadPro));

		Category apple = new Category("Apple", appleProducts);

		iphone7.setCategory(apple);
		iPadPro.setCategory(apple);

		/*
		 * send message to RabbitMQ
		 */
		for (int i = 0; i < 20; i++) {
			producer.produce(apple);
			Thread.sleep(2000);
		}

		//producer.produce(apple);
	}
}
