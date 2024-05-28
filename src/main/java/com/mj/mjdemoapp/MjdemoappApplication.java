package com.mj.mjdemoapp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MjdemoappApplication {

	static Logger logger = LoggerFactory.getLogger("mjlogger");

	public static void main(String[] args) {
		SpringApplication.run(MjdemoappApplication.class, args);
		logger.debug("Hello debug log");
	}

}
