package com.tim.ying.eureka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaApplication {
    static Logger logger = LoggerFactory.getLogger(EurekaApplication.class);


	public static void main(String[] args) {
		logger.debug("start application ....");
		SpringApplication.run(EurekaApplication.class, args);
	}
}
