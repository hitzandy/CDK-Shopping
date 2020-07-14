package com.cdk.shopping.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cdk.shopping.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, String> {
	Customer findByName(String customerName);
}
