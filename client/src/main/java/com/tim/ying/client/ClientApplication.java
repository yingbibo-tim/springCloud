package com.tim.ying.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@RestController
public class ClientApplication {
	Logger logger = LoggerFactory.getLogger(ClientApplication.class);
	@Value("${server.port}")
	private String port;


	public static void main(String[] args) {
		SpringApplication.run(ClientApplication.class, args);

	}

	@RequestMapping("/hi")
	public String home(@RequestParam String name) {
		return "hi " + name + " i am from " + port;
	}
}
