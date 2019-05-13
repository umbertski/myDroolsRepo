/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.gov.ipo.renewals.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.util.ArrayList;
import java.util.List;
import java.time.*;

import com.fasterxml.jackson.annotation.JsonView;
import uk.gov.ipo.renewals.output.View;
import uk.gov.ipo.renewals.config.*;
/**
 *
 * @author simon chance
 */

@JsonPropertyOrder({
	"type",
	"firstOwnerName",
	"firstOwnerAddress",
	"correspondenceName",
	"correspondenceAddress",
	"applicationId",
	"rightId",
	"scope",
	"renewalDate",
	"filingDate",
	"grantDate",
	"lorDate",
	"classes",
	"status",
	"milestone",
	"lastRenewalYear",
	"reasonNotInForce",
	"fee",
	"lateFee",
	"renewalFromYearNumber",
	"renewalToYearNumber",
	"productCode",
	"renewalPeriod",
	"logCode",
	"logMessage"
})


@JsonIgnoreProperties({
	"earliestRenewalDate",
	"latestRestoreDate", 
	"anniversary", 
	"numberOfClasses", 
	"paymentDueDate", 
	"lateGrant", 
	"lorApplies",
	"eligibleForRenewal", 
	"lorPending", 
	"lorCancelled", 
	"renewalBlocked",
	"renewalAnniversaryDate",
	"lateGrantWithSpecialConditions",
	"waiveLateFee",
	"classFees",
	"wipoClone",
	"euipoClone"
})

public class Right {
    static final long serialVersionUID = 1L;
	
	@JsonView({View.Renew.class, View.Reminders.class})
    private String type;
	@JsonView(View.Renew.class)
    private String applicationId;
	@JsonView({View.Renew.class, View.Price.class, View.CreateOrder.class,View.UpdateInfo.class})
    private String rightId;
	@JsonView(View.Renew.class)
    private String scope;
//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	@JsonView({View.Renew.class,View.Reminders.class})
    private LocalDate renewalDate;
//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	@JsonView(View.Renew.class)
    private LocalDate filingDate;
//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	@JsonView(View.Renew.class)
    private LocalDate grantDate;
    private LocalDate reasonNotInForceDate;
//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
 //   @JsonIgnore
	@JsonView(View.Renew.class)
    private String firstOwnerName;
	@JsonView(View.Renew.class)
    private String firstOwnerAddress;
	@JsonView(View.Renew.class)
    private String correspondenceName;
	@JsonView(View.Renew.class)
    private String correspondenceAddress;
	@JsonView(View.Renew.class)
    private LocalDate lorDate;
	@JsonView(View.Renew.class)
    private Integer lastRenewalYear;
	@JsonView(View.Renew.class)
    private String status;
	@JsonView(View.Renew.class)
    private String milestone;
	@JsonView(View.Renew.class)
    private String reasonNotInForce;
	@JsonView(View.Renew.class)
    private String renewalBlocked;
	@JsonView(View.Renew.class)
    private String lorCancelled;
	@JsonView(View.Renew.class)
    private String lorPending;
	@JsonView({View.Renew.class, View.Price.class, View.UpdateInfo.class} )
    private double fee;
	@JsonView({View.Renew.class, View.Price.class, View.UpdateInfo.class} )
    private double lateFee;
	@JsonView(View.UpdateInfo.class)
    private double totalFee;
	@JsonView(View.Renew.class)
    private Integer renewalFromYearNumber;
	@JsonView({View.Renew.class,  View.UpdateInfo.class})
    private Integer renewalToYearNumber;
	@JsonView({View.Renew.class,  View.UpdateInfo.class})
    private Integer renewalPeriod;
	@JsonView(View.Renew.class)
    private boolean lastRenewal;
	@JsonView(View.Renew.class)
	@JsonProperty("logCode")
    private String eligibilityStatus;
	@JsonView(View.Renew.class)
	@JsonProperty("logMessage")
    private String eligibilityMessage;
	@JsonView({View.Renew.class} )
	private List<IpClass> classes = new ArrayList<IpClass>();
	@JsonView(View.CreateOrder.class)
	private String tmClass;
	@JsonView(View.UpdateInfo.class)
    private int enlargementPeriod;
	@JsonView(View.UpdateInfo.class)
    private int monthsLate;

	
	@JsonView(View.Reminders.class)
    private LocalDate renewalReminderOverdueDate;
	@JsonView(View.Reminders.class)
    private LocalDate latestRenewalDate;
	@JsonView(View.Reminders.class)
    private LocalDate latestRenewalDateNoLateFee;
	
// inferred     
    boolean lateGrant;
    private Integer anniversary;
    private LocalDate earliestRenewalDate;
    private LocalDate latestRestoreDate;
    private LocalDate renewalAnniversaryDate;
    private LocalDate today;
    private LocalDate paymentDueDate;
    private boolean lorApplies;
    private boolean eligibleForRenewal = true;
    private boolean lateGrantWithSpecialConditions;
    private boolean waiveLateFee;
    private Double classFees;
    private boolean wipoClone;
    private boolean euipoClone;
    
    public Right() {
    }

    public Right(String rightId, String type) {
    	this.rightId = rightId;
    	this.type = type;
    }
    
    public Right(String rightId, String type, LocalDate today) {
    	this.rightId = rightId;
    	this.type = type;
    	this.today = today;
    }
    
    public int getEnlargementPeriod() {
		return enlargementPeriod;
	}

	public void setEnlargementPeriod(int enlargementPeriod) {
		this.enlargementPeriod = enlargementPeriod;
	}

	public Right(String rightId, String type, LocalDate today, LocalDate renewalDate) {
    	this.rightId = rightId;
    	this.type = type;
    	this.today = today;
    	this.renewalDate = renewalDate;
    }
    
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    public String getRightId() {
        return rightId;
    }

    public void setRightId(String rightId) {
        this.rightId = rightId;
    }

    public String getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(String applicationId) {
        this.applicationId = applicationId;
    }
    
    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    @JsonSerialize(using = LocalDateSerializer.class)  
    public LocalDate getRenewalDate() {
        return renewalDate;
    }

    @JsonDeserialize(using = LocalDateDeserializer.class)  
    public void setRenewalDate(LocalDate renewalDate) {
        this.renewalDate = renewalDate;
    }

    @JsonSerialize(using = LocalDateSerializer.class)  
    public LocalDate getGrantDate() {
        return grantDate;
    }

    @JsonDeserialize(using = LocalDateDeserializer.class)  
    public void setGrantDate(LocalDate grantDate) {
        this.grantDate = grantDate;
    }

    @JsonSerialize(using = LocalDateSerializer.class)  
    public LocalDate getFilingDate() {
        return filingDate;
    }

    @JsonDeserialize(using = LocalDateDeserializer.class)  
    public void setFilingDate(LocalDate filingDate) {
        this.filingDate = filingDate;
    }

    @JsonSerialize(using = LocalDateSerializer.class)  
    public LocalDate getLorDate() {
        return lorDate;
    }

    @JsonProperty
    @JsonDeserialize(using = LocalDateDeserializer.class)  
    public void setLorDate(LocalDate lorDate) {
        this.lorDate = lorDate;
    }
    
    @JsonIgnore
    @JsonSerialize(using = LocalDateSerializer.class)  
    public LocalDate getReasonNotInForceDate() {
        return reasonNotInForceDate;
    }

    @JsonDeserialize(using = LocalDateDeserializer.class)  
    public void setReasonNotInForceDate(LocalDate reasonNotInForceDate) {
        this.reasonNotInForceDate = reasonNotInForceDate;
    }

    
    public LocalDate getEarliestRenewalDate() {
        return earliestRenewalDate;
    }

    public void setEarliestRenewalDate(LocalDate earliestRenewalDate) {
        this.earliestRenewalDate = earliestRenewalDate;
    }

    public LocalDate getLatestRenewalDate() {
        return latestRenewalDate;
    }
    
    @JsonSerialize(using = LocalDateSerializer.class)  
    public void setLatestRenewalDate(LocalDate latestRenewalDate) {
        this.latestRenewalDate = latestRenewalDate;
    }

    public LocalDate getLatestRestoreDate() {
		return latestRestoreDate;
	}

	public void setLatestRestoreDate(LocalDate latestRestoreDate) {
		this.latestRestoreDate = latestRestoreDate;
	}

	public LocalDate getPaymentDueDate() {
        return paymentDueDate;
    }

    public void setPaymentDueDate(LocalDate paymentDueDate) {
        this.paymentDueDate = paymentDueDate;
    }
    
    @JsonIgnore
    @JsonSerialize(using = LocalDateSerializer.class)  
    public LocalDate getToday() {
        return today;
    }

    @JsonProperty
    @JsonDeserialize(using = LocalDateDeserializer.class)  
    public void setToday(LocalDate today) {
        this.today = today;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getReasonNotInForce() {
        return reasonNotInForce;
    }

    public void setReasonNotInForce(String reasonNotInForce) {
        this.reasonNotInForce = reasonNotInForce;
    }

    public String getRenewalBlocked() {
        return renewalBlocked;
    }

    public void setRenewalBlocked(String renewalBlocked) {
        this.renewalBlocked = renewalBlocked;
    }

    public String getLorCancelled() {
        return lorCancelled;
    }

    public void setLorCancelled(String lorCancelled) {
        this.lorCancelled = lorCancelled;
    }

    public String getLorPending() {
        return lorPending;
    }

    public void setLorPending(String lorPending) {
        this.lorPending = lorPending;
    }

    public String getMilestone() {
        return milestone;
    }

    public void setMilestone(String milestone) {
        this.milestone = milestone;
    }

    public Integer getLastRenewalYear() {
		return lastRenewalYear;
	}

	public void setLastRenewalYear(Integer lastRenewalYear) {
		this.lastRenewalYear = lastRenewalYear;
	}

	@JsonSerialize(using = LocalDoubleSerializer.class)
	public Double getFee() {
        return fee;
    }

    public void setFee(Double fee) {
        this.fee = fee;
    }

    public Integer getAnniversary() {
        return anniversary;
    }

    public void setAnniversary(Integer anniversary) {
        this.anniversary = anniversary;
    }

    public int getMonthsLate() {
        return monthsLate;
    }

    public void setMonthsLate(int monthsLate) {
        this.monthsLate = monthsLate;
    }
    
    @JsonSerialize(using = LocalDoubleSerializer.class)  
    public Double getLateFee() {
        return lateFee;
    }

    public void setLateFee(Double lateFee) {
        this.lateFee = lateFee;
    }

    @JsonSerialize(using = LocalDoubleSerializer.class)  
    public double getTotalFee() {
		return totalFee;
	}

	public void setTotalFee(double totalFee) {
		this.totalFee = totalFee;
	}

	public boolean isEligibleForRenewal() {
        return eligibleForRenewal;
    }

    public void setEligibleForRenewal(boolean eligibleForRenewal) {
        this.eligibleForRenewal = eligibleForRenewal;
    }

    public String getEligibilityStatus() {
        return eligibilityStatus;
    }

    public void setEligibilityStatus(String eligibilityStatus) {
        this.eligibilityStatus = eligibilityStatus;
    }

    public String getEligibilityMessage() {
        return eligibilityMessage;
    }

    public void setEligibilityMessage(String eligibilityMessage) {
        this.eligibilityMessage = eligibilityMessage;
    }

    public List<IpClass> getClasses() {
        return classes;
    }

    public void setClasses(List<IpClass> classes) {
        this.classes = classes;
    }

    public boolean isLateGrant() {
		return lateGrant;
	}

	public void setLateGrant(boolean lateGrant) {
		this.lateGrant = lateGrant;
	}
    
	public String getFirstOwnerName() {
		return firstOwnerName;
	}

	public void setFirstOwnerName(String firstOwnerName) {
		this.firstOwnerName = firstOwnerName;
	}

	public String getFirstOwnerAddress() {
		return firstOwnerAddress;
	}

	public void setFirstOwnerAddress(String firstOwnerAddress) {
		this.firstOwnerAddress = firstOwnerAddress;
	}

	public String getCorrespondenceName() {
		return correspondenceName;
	}

	public void setCorrespondenceName(String correspondenceName) {
		this.correspondenceName = correspondenceName;
	}

	public String getCorrespondenceAddress() {
		return correspondenceAddress;
	}

	public void setCorrespondenceAddress(String correspondenceAddress) {
		this.correspondenceAddress = correspondenceAddress;
	}

	public Integer getRenewalFromYearNumber() {
		return renewalFromYearNumber;
	}

	public void setRenewalFromYearNumber(Integer renewalFromYearNumber) {
		this.renewalFromYearNumber = renewalFromYearNumber;
	}

	public Integer getRenewalToYearNumber() {
		return renewalToYearNumber;
	}

	public void setRenewalToYearNumber(Integer renewalToYearNumber) {
		this.renewalToYearNumber = renewalToYearNumber;
	}

	public Integer getRenewalPeriod() {
		return renewalPeriod;
	}

	public void setRenewalPeriod(Integer renewalPeriod) {
		this.renewalPeriod = renewalPeriod;
	}

	public boolean isLastRenewal() {
		return lastRenewal;
	}

	public void setLastRenewal(boolean lastRenewal) {
		this.lastRenewal = lastRenewal;
	}

	public boolean isLorApplies() {
		return lorApplies;
	}

	public void setLorApplies(boolean lorApplies) {
		this.lorApplies = lorApplies;
	}

	public LocalDate getRenewalAnniversaryDate() {
		return renewalAnniversaryDate;
	}

	public void setRenewalAnniversaryDate(LocalDate renewalAnniversaryDate) {
		this.renewalAnniversaryDate = renewalAnniversaryDate;
	}

	public boolean isLateGrantWithSpecialConditions() {
		return lateGrantWithSpecialConditions;
	}

	public void setLateGrantWithSpecialConditions(boolean lateGrantWithSpecialConditions) {
		this.lateGrantWithSpecialConditions = lateGrantWithSpecialConditions;
	}

	public boolean isWaiveLateFee() {
		return waiveLateFee;
	}

	public void setWaiveLateFee(boolean waveLateFee) {
		this.waiveLateFee = waveLateFee;
	}

    public boolean isWipoClone() {
		return wipoClone;
	}

	public void setWipoClone(boolean wipoClone) {
		this.wipoClone = wipoClone;
	}

	public boolean isEuipoClone() {
		return euipoClone;
	}

	public void setEuipoClone(boolean euipoClone) {
		this.euipoClone = euipoClone;
	}

	@JsonSerialize(using = LocalDateSerializer.class)  
	public LocalDate getLatestRenewalDateNoLateFee() {
		return latestRenewalDateNoLateFee;
	}

	public void setLatestRenewalDateNoLateFee(LocalDate latestRenewalDateNoLateFee) {
		this.latestRenewalDateNoLateFee = latestRenewalDateNoLateFee;
	}

    @JsonSerialize(using = LocalDateSerializer.class)  
	public LocalDate getRenewalReminderOverdueDate() {
		return renewalReminderOverdueDate;
	}

	public void setRenewalReminderOverdueDate(LocalDate renewalReminderOverdueDate) {
		this.renewalReminderOverdueDate = renewalReminderOverdueDate;
	}
	
	public String getTmClass() {
		return tmClass;
	}

	public void setTmClass(String tmClass) {
		this.tmClass = tmClass;
	}

	public Double getClassFees() {
		return classFees;
	}

	public void setClassFees(Double classFees) {
		this.classFees = classFees;
	}

	@Override
    public String toString() {
        return "Right{" + 
        		"type=" + type + 
        		", rightId=" + rightId + 
        		", scope=" + scope + 
        		", renewalDate=" + renewalDate + 
        		", filingDate=" + filingDate + 
        		", paymentDueDate=" + paymentDueDate + 
        		", earliestRenewalDate=" + earliestRenewalDate + 
        		", latestRenewalDate=" + latestRenewalDate + 
        		", lorDate=" + lorDate + 
        		", today=" + today + 
        		", eligibleForRenewal=" + eligibleForRenewal + 
        		", fee=" + fee + 
        		", lateFee=" + lateFee + 
        		", status=" + status + 
        		", reasonNotInForce=" + reasonNotInForce + 
        		", anniversary=" + anniversary + 
        		", monthsLate=" + monthsLate + " }";
    }
    
	public String toStringDates() {
        return "Right{" + 
        		"type=" + type + 
        		", rightId=" + rightId + 
        		", renewalDate=" + renewalDate +
        		", paymentDueDate=" + paymentDueDate + 		
        		", earliestRenewalDate=" + earliestRenewalDate + 
        		", latestRenewalDate=" + latestRenewalDate + 
        		", latestRestoreDate=" + latestRestoreDate +
        		", latestRenewalDateNoLateFees" + latestRenewalDateNoLateFee +
        		", renewalReminderDate=" + renewalReminderOverdueDate +
        		", today=" + today + " }";
    }
}
