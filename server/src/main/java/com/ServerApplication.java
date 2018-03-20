package com;

import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.concurrent.atomic.AtomicInteger;



@SpringBootApplication(scanBasePackages = "com")
public class ServerApplication {


	private  static final org.slf4j.Logger loger = LoggerFactory.getLogger(ServerApplication.class);
	//public static Integer tempCountRequest = 0;


	public static void main(String[] args) {
		SpringApplication.run(ServerApplication.class, args);
		loger.info("####### Start Server  #######");
	}
}
