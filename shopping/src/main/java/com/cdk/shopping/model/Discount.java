package com.cdk.shopping.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Data;

/**
 * The persistent class for the account database table.
 *
 */
@Entity
@Data
@NamedQuery(name = "Discount.findAll", query = "SELECT d FROM Discount d")
public class Discount extends AbstractEntity implements Serializable {
  private static final long serialVersionUID = 1L;


  private String name;
  private Timestamp validFrom;
  private Timestamp validTill;
  private String status;
  private BigDecimal flatDiscountPercentage;
  // one-to-one association to CustomerType
  @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  private CustomerType customerType;
  
  //one-to-many association to DiscountSlab
  @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  private List<DiscountSlab> discountSlab;

  public String toString () {
	  return "";
  }
  
}
