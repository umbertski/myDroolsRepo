/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.gov.ipo.renewals.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 *
 * @author simon chance
 */
@JsonPropertyOrder({
	"BusinessTranId",
    "Domain",
    "ReferenceId",
    "ConversationId",
    "FunctionalArea",
    "DateTime",
    "SenderParty",
    "RecipientParty",
    "Verb",
    "Logging"
})

public class CommonHeader {
    static final long serialVersionUID = 1L;

	@JsonProperty("BusinessTranId")
	private String businessTranId;
	@JsonProperty("Domain")
    private String domain;
	@JsonProperty("ReferenceId")
    private String referenceId;
	@JsonProperty("ConversationId")
	@JsonInclude(Include.NON_NULL)
    private String conversationId;
	@JsonProperty("FunctionalArea")
    private String functionalArea;
	@JsonProperty("DateTime")
    private String DateTime;
	@JsonProperty("SenderParty")
    private String senderParty;
	@JsonProperty("RecipientParty")
    private String recipientParty;
	@JsonProperty("Verb")
	@JsonInclude(Include.NON_NULL)
    private String verb;
	@JsonProperty("Logging")
	@JsonInclude(Include.NON_NULL)
    private String logging;
	
	DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern( "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
	
    public CommonHeader() {
    }

    public CommonHeader(String businessTranId, String domain,String functionalArea, String senderParty, String recipientParty) {
    	this.businessTranId = businessTranId;
    	this.domain = domain;
    	this.functionalArea = functionalArea;
    	this.senderParty = senderParty;
    	this.recipientParty = recipientParty;
    	LocalDateTime now = LocalDateTime.now();
    	this.DateTime = dateTimeFormatter.format(now);
    	this.referenceId =  UUID.randomUUID().toString();
    }

}
