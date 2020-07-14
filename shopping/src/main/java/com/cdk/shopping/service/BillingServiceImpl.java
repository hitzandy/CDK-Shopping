package com.cdk.shopping.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdk.shopping.model.Customer;
import com.cdk.shopping.model.CustomerType;
import com.cdk.shopping.model.Discount;
import com.cdk.shopping.model.DiscountSlab;
import com.cdk.shopping.repo.CustomerRepository;
import com.cdk.shopping.repo.DiscountRepository;
import com.cdk.shopping.response.BillingInfoResponse;

@Service
public class BillingServiceImpl implements BillingService {

	
	@Autowired
	CustomerRepository custRepo;
	
	@Autowired
	DiscountRepository discountRepo;
	
	@Override
	public BillingInfoResponse getBillAfterDiscount(String customerId, BigDecimal amount) {
		
		BillingInfoResponse response = new BillingInfoResponse();
		
		Customer cust = custRepo.findByName(customerId);
		
		if(cust == null) {
			// Should throw custom bad request exception
			response.setResponse("customer not found");
			return response;
			
		}
		
		CustomerType custType = cust.getCustomerType();
		
		if(custType == null) {
			// Should throw custom bad request exception
			response.setResponse("Customer Type not found");
			return response;
		}
		
		Discount discount = discountRepo.findByCustomerType(custType);
		
		if(discount == null) {
			// Should throw custom bad request exception
			response.setResponse("Discount not found");
			return response;
			
		}
		
		List<DiscountSlab> slabList =  discount.getDiscountSlab();
		
		if(slabList.isEmpty()) {
			// Should throw custom bad request exception
			response.setResponse("Discount Slab not found");
			return response;
			
		}
		
		BigDecimal discountAmount = new BigDecimal(0);
		
		for(DiscountSlab slab : slabList) {

			if(null != slab.getSlabToPercentage() && 
					amount.compareTo(slab.getSlabFromPercentage()) > 0 &&
					amount.compareTo(slab.getSlabToPercentage()) >= 0) {
				BigDecimal amtForDisc = slab.getSlabToPercentage().subtract(slab.getSlabFromPercentage());
				BigDecimal discountedAmount = amtForDisc.multiply(new BigDecimal(slab.getPercentage())).divide(new BigDecimal(100));
				
				discountAmount = discountAmount.add(discountedAmount);
			} else if(null != slab.getSlabToPercentage() && 
					amount.compareTo(slab.getSlabFromPercentage()) > 0 &&
					amount.compareTo(slab.getSlabToPercentage()) < 0) {
				BigDecimal amtForDisc = amount.subtract(slab.getSlabFromPercentage());
				BigDecimal discountedAmount = amtForDisc.multiply(new BigDecimal(slab.getPercentage())).divide(new BigDecimal(100));
				
				discountAmount = discountAmount.add(discountedAmount);
			}
			else if(null == slab.getSlabToPercentage() && amount.compareTo(slab.getSlabFromPercentage()) > 0) {
				BigDecimal amtForDisc = amount.subtract(slab.getSlabFromPercentage());
				BigDecimal discountedAmount = amtForDisc.multiply(new BigDecimal(slab.getPercentage())).divide(new BigDecimal(100));
				
				discountAmount = discountAmount.add(discountedAmount);
			}
		}
		response.setResponse(amount.subtract(discountAmount).toString());
		return response;
	}

}
