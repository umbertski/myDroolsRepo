/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.gov.ipo.renewals.model;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import uk.gov.ipo.renewals.output.View;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import uk.gov.ipo.renewals.config.*;

/**
 *
 * @author simon chance
 */
@JsonPropertyOrder({
	"IPOCommonHeader",
	"guid",
	"ordertotal",
	"rights",
	"lineItems"})

@JsonIgnoreProperties({
	"today",
	"type"
})


@XmlRootElement
public class Request {
    static final long serialVersionUID = 1L;

	@JsonProperty("IPOCommonHeader")
	private CommonHeader commonHeader;
	@JsonInclude(Include.NON_NULL)
    private String guid;
	@JsonView(View.CreateOrder.class)
	@JsonSerialize(using = LocalDoubleSerializer.class)
	private Double orderTotal;
	@JsonView({View.Renew.class, View.Price.class, View.Reminders.class, View.UpdateInfo.class})
    private List<Right> rights = new ArrayList<Right>();
    private LocalDate today;
	@JsonView(View.CreateOrder.class)
    private List<LineItem> lineItems = new ArrayList<LineItem>();
	private String type;
	
    public Request() {
    }
    
	public CommonHeader getCommonHeader() {
		return commonHeader;
	}

	public void setIPOCommonHeader(CommonHeader commonHeader) {
		this.commonHeader = commonHeader;
	}

	public String getGuid() {
		return guid;
	}

	public void setGuid(String guid) {
		this.guid = guid;
	}

    public Double getOrderTotal() {
		return orderTotal;
	}

    @JsonSerialize(using = LocalDoubleSerializer.class)  
	public void setOrderTotal(Double orderTotal) {
		this.orderTotal = orderTotal;
	}

	public List<Right> getRights() {
        return rights;
    }

    public void setRights(List<Right> rights) {
        this.rights = rights;
    }

	public List<LineItem> getLineItems() {
		return lineItems;
	}

	public void setLineItems(List<LineItem> lineItems) {
		this.lineItems = lineItems;
	}

	public LocalDate getToday() {
        return today;
    }

    public void setToday(LocalDate today) {
		this.today = today;
	}

	public void setDate(LocalDate today) {
        this.today = today;
    }

	public void setType(String type) {
		this.type = type;
	}   

	public String getType() {
		return type;
	}
	
    public void setDate(String today) {
    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        this.today = LocalDate.parse(today, formatter);
    }

    @Override
    public String toString() {
        return "rights:" + getRights() + "type:" + getType();
    }
    
    
}
