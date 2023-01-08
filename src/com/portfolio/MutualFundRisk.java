package com.portfolio;

public enum MutualFundRisk {
	UNKNOWN(0),
	HIGH(1),
	MEDIUM(2),
	LOW(3);
	
	private int risk;
	private MutualFundRisk(int risk) {
		this.risk = risk;
	}
}
