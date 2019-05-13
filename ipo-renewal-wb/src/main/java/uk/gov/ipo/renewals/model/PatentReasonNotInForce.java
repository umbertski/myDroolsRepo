package uk.gov.ipo.renewals.model;

public enum PatentReasonNotInForce {
	Ceased("00"),
	Expired("04"),
	Surrendered("05"),
	Revoked("07"),
	UKNoLongerDesignated("12"),
	RevokedByEPO("13");
	
	private final String value;
	
	PatentReasonNotInForce(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
