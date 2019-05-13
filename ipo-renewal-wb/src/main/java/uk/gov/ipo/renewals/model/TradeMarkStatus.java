package uk.gov.ipo.renewals.model;

public enum TradeMarkStatus {
	Open("1"),
	Expired("11"),
	Removed("14"),
	Dead("15");
	
	private String value;
	
	TradeMarkStatus(String value) {
		this.value = value;
	}
	public String getValue() {
		return value;
	};
		
}
