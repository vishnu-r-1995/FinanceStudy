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
			double workingCapitalRatio, BigDecimal upsideTargetPrice, double riskRewardRatio) {
		super();
		this.symbol = symbol;
		this.name = name;
		this.previousClosingPrice = previousClosingPrice;
		this.currentPrice = currentPrice;
		this.workingCapitalRatio = workingCapitalRatio;
		this.upsideTargetPrice = upsideTargetPrice;
		this.riskRewardRatio = riskRewardRatio;
		this.downsideTargetPrice = getDownsideTargetPrice(currentPrice, upsideTargetPrice, riskRewardRatio);
	}

	public BigDecimal getDownsideTargetPrice() 
	{
		return downsideTargetPrice;
	}

	public double getRiskRewardRatio(BigDecimal current, BigDecimal upside, BigDecimal downside) 
	{
		// (upside-current)/(current-downside) = risk-reward ratio
		// Some investors won't commit their money to any investment that isn't at least
		// 4:1, but 2:1 is considered the minimum by most
		// "https://www.investopedia.com/articles/stocks/11/calculating-risk-reward.asp"
		BigDecimal numerator = upside.subtract(current);
		BigDecimal denominator = current.subtract(downside);
		return numerator.divide(denominator).doubleValue();
	}
	
	public BigDecimal getDownsideTargetPrice(BigDecimal current, BigDecimal upside, double riskReward) 
	{
		// (upside-current)/(current-downside) = risk-reward ratio
		// Some investors won't commit their money to any investment that isn't at least
		// 4:1, but 2:1 is considered the minimum by most
		// "https://www.investopedia.com/articles/stocks/11/calculating-risk-reward.asp"
		BigDecimal numerator = upside.subtract(current);
		BigDecimal denominator = numerator.divide(new BigDecimal(riskReward));
		return current.subtract(denominator);
	}
}
