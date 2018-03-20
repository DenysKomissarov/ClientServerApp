package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.concurrent.atomic.AtomicInteger;



@SpringBootApplication(scanBasePackages = "com")
public class ServerApplication {

	private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(ServerApplication.class.getName());
	//public static Integer tempCountRequest = 0;


	public static void main(String[] args) {
		SpringApplication.run(ServerApplication.class, args);
		logger.info("####### Start Server  #######");
	}
}
