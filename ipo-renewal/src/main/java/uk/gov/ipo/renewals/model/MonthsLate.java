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


public class MonthsLate {
    static final long serialVersionUID = 1L;

	private Right right;
    private int monthsLate;
    private LocalDate startDate;
    private LocalDate endDate;
    
    public MonthsLate(Right right, int monthsLate, LocalDate startDate, LocalDate endDate) {
    	this.right = right;
    	this.monthsLate = monthsLate;
    	this.startDate = startDate;
    	this.endDate = endDate;
    }

    public Right getRight() {
		return right;
	}

	public void setRight(Right right) {
		this.right = right;
	}

	public int getMonthsLate() {
		return monthsLate;
	}

	public void setMonthsLate(int monthsLate) {
		this.monthsLate = monthsLate;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	@Override
    public String toString() {
        return "monthsLate{" + 
        "right=" + right.getRightId() +		
		",monthsLate=" + monthsLate + 
		", startDate=" + startDate + 
		", endDate=" + endDate +
		"}";
    }   
    
    
}
