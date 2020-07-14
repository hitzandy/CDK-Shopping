package com.cdk.shopping.service;

import java.math.BigDecimal;

import com.cdk.shopping.response.BillingInfoResponse;


public interface BillingService {

  public BillingInfoResponse getBillAfterDiscount(String customerId, BigDecimal amount);
  
}
