package com.cdk.shopping.controller;

import java.math.BigDecimal;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cdk.shopping.response.BillingInfoResponse;
import com.cdk.shopping.service.BillingService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value = "/v1/billing")
@Api(value = "Billing controller",
    description = "Billing operations")
public class BillingController {

  @Autowired
  private BillingService billingService;

  @ApiOperation(value = "Get payment profile response ledger balance",
      response = BillingInfoResponse.class)
  @RequestMapping(value = "/customer/{customerId}/amount/{amount}", method = RequestMethod.GET,
      produces = {MediaType.APPLICATION_JSON_VALUE})
  @ApiResponses(value = {@ApiResponse(code = 201, message = "Request succesfully accepted"),
      @ApiResponse(code = 500, message = "Internal Server Error"),
      @ApiResponse(code = 400, message = "Bad Request"),
      @ApiResponse(code = 404, message = "Not Found"),
      @ApiResponse(code = 503, message = "Service Unavailable")})

  public ResponseEntity<BillingInfoResponse> getPaymentProfileInfo(
      @PathVariable(value = "customerId") String customerId,
      @PathVariable(value = "amount") BigDecimal amount) {
    return ResponseEntity.status(HttpStatus.OK).body(billingService.getBillAfterDiscount(customerId, amount));
  }

}
  

