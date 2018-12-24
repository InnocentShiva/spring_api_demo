package com.example.spring_api_demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.spring_api_demo.logic.TransactionHistoryRepository;

@SpringBootApplication
public class SpringApiDemoApplication {
	
	
	@Autowired
	TransactionHistoryRepository repository;
	
	
	public static void main(String[] args) {
		
		SpringApplication.run(SpringApiDemoApplication.class, args);
	}

}

