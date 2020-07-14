package com.cdk.shopping;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cdk.shopping.repo.CustomerRepository;
import com.cdk.shopping.service.BillingService;
import com.cdk.shopping.service.InitializeDataService;

@SpringBootApplication
public class ShoppingApplication {

	@Autowired
	InitializeDataService data;
	
	@Autowired
	BillingService service;

	@Autowired
	CustomerRepository custRepo;

	public static void main(String[] args) {
		SpringApplication.run(ShoppingApplication.class, args);
	}

	@PostConstruct
	private void initializeData() {
		custRepo.count();
		data.initializeData();

	}

}
