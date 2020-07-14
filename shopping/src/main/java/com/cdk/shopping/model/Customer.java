package com.cdk.shopping.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.ToString;

/**
 * The persistent class for the account database table.
 *
 */
@Entity
@Data
@NamedQuery(name = "Customer.findAll", query = "SELECT c FROM Customer c")
public class Customer extends AbstractEntity implements Serializable {
  private static final long serialVersionUID = 1L;


  private String name;
  private String phoneNumber;
  private String status;
  // one-to-one association to CustomerType
  @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  private CustomerType customerType;
  
  public String toString () {
	  return "";
  }


}
