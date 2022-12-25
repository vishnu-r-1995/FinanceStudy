package com.portfolio;

import java.math.BigDecimal;

public class CommonStock {

	private String symbol;
	private String name;
	private BigDecimal previousClosingPrice = BigDecimal.ZERO;
	private BigDecimal currentPrice = BigDecimal.ZERO;
	private double workingCapitalRatio = 0d;
	private BigDecimal upsideTargetPrice = BigDecimal.ZERO;
	private BigDecimal downsideTargetPrice = BigDecimal.ZERO;
	private double riskRewardRatio = 0d;
	
	public CommonStock(String symbol, String name, BigDecimal previousClosingPrice, BigDecimal currentPrice,
			double workingCapitalRatio, BigDecimal upsideTargetPrice, BigDecimal downsideTargetPrice) {
		super();
		this.symbol = symbol;
		this.name = name;
		this.previousClosingPrice = previousClosingPrice;
		this.currentPrice = currentPrice;
		this.workingCapitalRatio = workingCapitalRatio;
		this.upsideTargetPrice = upsideTargetPrice;
		this.downsideTargetPrice = downsideTargetPrice;
		this.riskRewardRatio = getRiskRewardRatio(currentPrice, upsideTargetPrice, downsideTargetPrice);
	}

	public double getRiskRewardRatio(BigDecimal current, BigDecimal upside, BigDecimal downside) 
	{
		BigDecimal numerator = upside.subtract(current);
		BigDecimal denominator = current.subtract(downside);
		return numerator.divide(denominator).doubleValue();
	}
}
