package com.cdk.shopping.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

import lombok.Data;

/**
 * The persistent class for the account database table.
 *
 */
@Entity
@Data
@NamedQuery(name = "DiscountSlab.findAll", query = "SELECT ds FROM DiscountSlab ds")
public class DiscountSlab extends AbstractEntity implements Serializable {
  private static final long serialVersionUID = 1L;


  private String name;
  private Timestamp validFrom;
  private Timestamp validTill;
  private String status;
  
  private BigDecimal slabFromPercentage;
  private BigDecimal slabToPercentage;
  
  private float percentage;

  public String toString () {
	  return "";
  }
}
