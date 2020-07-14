package com.cdk.shopping.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.NamedQuery;

import lombok.Data;

/**
 * The persistent class for the CustomerType database table.
 *
 */
@Entity
@Data
@NamedQuery(name = "CustomerType.findAll", query = "SELECT ct FROM CustomerType ct")
public class CustomerType extends AbstractEntity implements Serializable {
  private static final long serialVersionUID = 1L;
  private String name;
  
  public String toString () {
	  return "";
  }

}
