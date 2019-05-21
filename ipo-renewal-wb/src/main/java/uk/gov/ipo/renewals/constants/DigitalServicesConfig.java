/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.gov.ipo.renewals.constants;

/**
 *
 * @author simon chance
 */

public class DigitalServicesConfig{
	public static class RequestType{
		public static final String RENEWAL_REMINDERS = "renewalReminders";
		public static final String OVERDUE_REMINDERS = "overdueReminders";
	}

	public static class TradeMarkStatus{
		public static final String OPEN ="1";
		public static final String EXPIRED = "11";
		public static final String REMOVED = "14";
		public static final String DEAD = "15";		
	}

	public static class TradeMarkMilestone{
		public static final String REGISTERED ="4";
	}
	
	public static class PatentReasonNotInForce{
		public static final String CEASED = "00";
		public static final String EXPIRED = "04";
		public static final String SURRENDERED = "05";
		public static final String REVOKED = "07";
		public static final String UK_NO_LONGER_DESIGNATED= "12";
		public static final String REVOKED_BY_EPO = "13";
	}
}