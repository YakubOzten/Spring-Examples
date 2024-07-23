package com.yakubozten;

import com.yakubozten.model.Notification;
import com.yakubozten.producer.NotificationProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;
import java.util.UUID;

@SpringBootApplication
public class SpringBootRabbitmqApplication {



	public static void main(String[] args) {

		SpringApplication.run(SpringBootRabbitmqApplication.class, args);





	}

}
