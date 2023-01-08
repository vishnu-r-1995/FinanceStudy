package com.portfolio;

import java.math.BigDecimal;

public class MutualFund {
	private String name;
	private String fundHouse;
	private double expenseRatio;
	private BigDecimal netAssetValue = BigDecimal.ZERO;
	private BigDecimal fundSize = BigDecimal.ZERO;
	private MutualFundCategory mutualFundCategory = MutualFundCategory.UNCATEGORIZED;
	private String remarks;
	private CrisilRank crisilRank = CrisilRank.UNRANKED;
	private MutualFundRisk mutualFundRisk = MutualFundRisk.UNKNOWN;
	private Index benchmarkIndex;
	//private Component component;
}
