package com.cdk.shopping.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cdk.shopping.model.Customer;
import com.cdk.shopping.model.DiscountSlab;

public interface DiscountSlabRepository extends JpaRepository<DiscountSlab, String> {
	DiscountSlab findByName(String name);
}
