/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.gov.ipo.renewals.model;
import java.time.LocalDate;

/**
 *
 * @author simon chance
 */


public class FeeForYear {
    static final long serialVersionUID = 1L;

	private Right right;
	private String type;
	private int year;
	private LocalDate renewalDate;
    private double fee;
    private boolean lastRenewal;
    
    public FeeForYear(Right right, String type, int year, LocalDate renewalDate) {
    	this.right = right;
    	this.type = type;
    	this.year = year;
    	this.renewalDate = renewalDate;
    }

	public void setRight(Right right) {
		this.right = right;
	}

	public Right getRight() {
		return right;
	}
    
	public void setType(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}
    
	public void setYear(int year) {
		this.year = year;
	}

	public int getYear() {
		return year;
	}


	public void setRenewalDate(LocalDate renewalDate) {
		this.renewalDate = renewalDate;
	}

	public LocalDate getRenewalDate() {
		return renewalDate;
	}

	public void setFee(double fee) {
		this.fee = fee;
	}

	public double getFee() {
		return fee;
	}
    
	public boolean isLastRenewal() {
		return lastRenewal;
	}

	public void setLastRenewal(boolean lastRenewal) {
		this.lastRenewal = lastRenewal;
	}

	@Override
    public String toString() {
        return "fee{" + 
        "right=" + right.getRightId() +		
        ",type=" + getType() +		
        ",year=" + getYear() +		
        ",renewalDate=" + getRenewalDate() +		
		",fee=" + getFee()  +
		"}";
    }   
    
    
}
