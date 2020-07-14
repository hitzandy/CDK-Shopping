package com.cdk.shopping.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdk.shopping.model.Customer;
import com.cdk.shopping.model.CustomerType;
import com.cdk.shopping.model.Discount;
import com.cdk.shopping.model.DiscountSlab;
import com.cdk.shopping.repo.CustomerRepository;
import com.cdk.shopping.repo.CustomerTypeRepository;
import com.cdk.shopping.repo.DiscountRepository;
import com.cdk.shopping.repo.DiscountSlabRepository;

@Service
@Transactional
public class InitializeDataServiceImpl implements InitializeDataService {

	
	@Autowired
	CustomerRepository custRepo;
	
	@Autowired
	CustomerTypeRepository custTypeRepo;
	
	@Autowired
	DiscountRepository discountRepo;
	
	@Autowired
	DiscountSlabRepository discountSlabRepo;
		
	@Override
	public void initializeData() {
		CustomerType regCustType = new CustomerType();
		regCustType.setName("Regular");
		
		CustomerType premCustType = new CustomerType();
		premCustType.setName("Premium");

		
		custTypeRepo.save(regCustType);
		
		Customer regCust = new Customer();
		regCust.setName("Cust1");
		regCust.setPhoneNumber("9876598765");
		regCust.setStatus("Active");
		regCust.setCustomerType(regCustType);
		
		custRepo.save(regCust);
		
		Customer premCust = new Customer();
		premCust.setName("Cust2");
		premCust.setPhoneNumber("1111111111");
		premCust.setStatus("Active");
		premCust.setCustomerType(premCustType);
		
		custRepo.save(premCust);
		
		DiscountSlab regSlab1 = new DiscountSlab();
		regSlab1.setSlabFromPercentage(BigDecimal.ZERO);
		regSlab1.setSlabToPercentage(new BigDecimal(5000));
		regSlab1.setPercentage(0f);
		
		
		DiscountSlab regSlab2 = new DiscountSlab();
		regSlab2.setSlabFromPercentage(new BigDecimal(5000));
		regSlab2.setSlabToPercentage(new BigDecimal(10000));
		regSlab2.setPercentage(10f);

		DiscountSlab regSlab3 = new DiscountSlab();
		regSlab3.setSlabFromPercentage(new BigDecimal(10000));
		regSlab3.setPercentage(20f);
		
		List<DiscountSlab> regSlabList = new ArrayList();
		
		regSlabList.add(regSlab1);
		regSlabList.add(regSlab2);
		regSlabList.add(regSlab3);
		

		DiscountSlab premSlab1 = new DiscountSlab();
		premSlab1.setSlabFromPercentage(BigDecimal.ZERO);
		premSlab1.setSlabToPercentage(new BigDecimal(4000));
		premSlab1.setPercentage(10f);

		DiscountSlab premSlab2 = new DiscountSlab();
		premSlab2.setSlabFromPercentage(new BigDecimal(4000));
		premSlab2.setSlabToPercentage(new BigDecimal(8000));
		premSlab2.setPercentage(15f);

		DiscountSlab premSlab3 = new DiscountSlab();
		premSlab3.setSlabFromPercentage(new BigDecimal(8000));
		premSlab3.setSlabToPercentage(new BigDecimal(12000));
		premSlab3.setPercentage(20f);
		
		DiscountSlab premSlab4 = new DiscountSlab();
		premSlab4.setSlabFromPercentage(new BigDecimal(12000));
		premSlab4.setPercentage(30f);
		
		List<DiscountSlab> premSlabList = new ArrayList();
		
		premSlabList.add(premSlab1);
		premSlabList.add(premSlab2);
		premSlabList.add(premSlab3);
		premSlabList.add(premSlab4);

		Discount regDiscount = new Discount();
		
		regDiscount.setCustomerType(regCustType);
		regDiscount.setFlatDiscountPercentage(BigDecimal.ZERO);
		regDiscount.setName("Christmas");
		regDiscount.setStatus("Active");
		
		regDiscount.setDiscountSlab(regSlabList);
		
		discountRepo.save(regDiscount);
		
		Discount premDiscount = new Discount();
		
		premDiscount.setCustomerType(premCustType);
		premDiscount.setFlatDiscountPercentage(BigDecimal.ZERO);
		premDiscount.setName("Christmas");
		premDiscount.setStatus("Active");
		
		premDiscount.setDiscountSlab(premSlabList);

		discountRepo.save(premDiscount);
	}

}
