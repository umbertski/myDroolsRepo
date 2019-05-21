/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.gov.ipo.renewals.model;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author simon chance
 */



public class NonWorkingDay {
    static final long serialVersionUID = 1L;

    private LocalDate date;
    
    public NonWorkingDay(String date) {
    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-MMM-yyyy");
    	this.date = LocalDate.parse(date, formatter);
    }

    public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	@Override
    public String toString() {
        return "nonWorkingDate{" + 
		"date=" + date +
		"}";
    }   
    
    
}