/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.gov.ipo.renewals.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import uk.gov.ipo.renewals.config.*;

/**
 *
 * @author simon chance
 */

public class LineItem {
    static final long serialVersionUID = 1L;

	private String entityNumber;
    private int sequenceNumber;
    private Double unitPrice;
    private String productCode;
	private String productDescription;
	private String taxCode;
	private double unitTaxAmount;
	private int quantity = 1;

    public LineItem() {
    }

    public LineItem(String entityNumber, double unitPrice, String productCode, String productDescription) {
    	this.entityNumber = entityNumber;
    	this.unitPrice = unitPrice;
    	this.productCode = productCode;
    	this.productDescription = productDescription;
    }

    public LineItem(String entityNumber, double unitPrice, int quantity, String productCode, String productDescription) {
    	this.entityNumber = entityNumber;
    	this.unitPrice = unitPrice;
    	this.productCode = productCode;
    	this.productDescription = productDescription;
    	this.quantity = quantity;
    }
    
	public String getEntityNumber() {
		return entityNumber;
	}

	public void setEntityNumber(String entityNumber) {
		this.entityNumber = entityNumber;
	}

	@JsonSerialize(using = LocalDoubleSerializer.class)
    public Double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public int getSequenceNumber() {
		return sequenceNumber;
	}

	public void setSequenceNumber(int sequence) {
		this.sequenceNumber = sequence;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public String getTaxCode() {
		return taxCode;
	}

	public void setTaxCode(String taxCode) {
		this.taxCode = taxCode;
	}

	@JsonSerialize(using = LocalDoubleSerializer.class)
	public double getUnitTaxAmount() {
		return unitTaxAmount;
	}

	public void setUnitTaxAmount(double unitTaxAmount) {
		this.unitTaxAmount = unitTaxAmount;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
    public String toString() {
        return "LineItem{" + 
        "sequenceNumber=" + sequenceNumber + 
		", unitPrice=" + unitPrice +
		", productDescription=" + productDescription + " }";
    }
}
