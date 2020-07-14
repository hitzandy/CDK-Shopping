package com.cdk.shopping.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cdk.shopping.model.Customer;
import com.cdk.shopping.model.CustomerType;
import com.cdk.shopping.model.Discount;

public interface DiscountRepository extends JpaRepository<Discount, String> {
	Discount findByCustomerType(CustomerType custType);
}
