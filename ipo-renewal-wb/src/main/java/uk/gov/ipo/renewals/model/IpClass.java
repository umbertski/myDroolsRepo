/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.gov.ipo.renewals.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonView;

import uk.gov.ipo.renewals.output.View;

/**
 *
 * @author simon chance
 */
@JsonPropertyOrder({
	"tmClass"
})

@JsonIgnoreProperties({
	"fee"
})


public class IpClass {
    static final long serialVersionUID = 1L;

	@JsonView({View.Renew.class})
    private Integer tmClass;
	@JsonView({View.Renew.class})
    private String terms;
    private Double fee;
	
    public IpClass() {
    }

    public IpClass(Integer tmClass, int sequenceNumber) {
    	this.tmClass = tmClass;
    }

    
    public Integer getTmClass() {
        return tmClass;
    }

    public void setTmClass(Integer tmClass) {
        this.tmClass = tmClass;
    }

    public String getTerms() {
        return terms;
    }

    public void setTerms(String terms) {
        this.terms = terms;
    }

    public Double getFee() {
		return fee;
	}

	public void setFee(Double fee) {
		this.fee = fee;
	}

	@Override
    public String toString() {
        return "IpClass{" + 
		", tmClass=" + tmClass + 
		", fee=" + fee;
    }
}
