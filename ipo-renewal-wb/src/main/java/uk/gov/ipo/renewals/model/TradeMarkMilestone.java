package uk.gov.ipo.renewals.model;

public enum TradeMarkMilestone {
	Registered("4");
	
	private final String value;
	
	TradeMarkMilestone(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
