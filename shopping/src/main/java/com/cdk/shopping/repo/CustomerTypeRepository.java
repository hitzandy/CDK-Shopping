package com.cdk.shopping.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cdk.shopping.model.Customer;
import com.cdk.shopping.model.CustomerType;

public interface CustomerTypeRepository extends JpaRepository<CustomerType, String> {
	CustomerType findByName(String name);
}
