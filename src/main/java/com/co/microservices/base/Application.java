package com.co.microservices.base;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
@EntityScan({"com.co.microservices.base.adapter.database.model"})
@SpringBootApplication
public class Application {


    final static Logger logger = Logger.getLogger(Application.class);
    
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
