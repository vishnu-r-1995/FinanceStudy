package com.generalfinance;

import java.math.BigDecimal;

public class FinanceEngine {

	public static void main(String[] args) {
		displayPriceOfAnItemAtSpecifiedYear(new BigDecimal(100.00), 1960, 1961, 7.5);
	}

	private static void displayPriceOfAnItemAtSpecifiedYear(BigDecimal currentPrice, int currentYear, int targetYear, double inflationPercentage) 
	{
		double inflationValue = inflationPercentage / 100;
		int differenceInYears = targetYear - currentYear;
		BigDecimal targetPrice = currentPrice;
		for (int i = 0; i < differenceInYears; i++) {
			BigDecimal increaseInPriceUnderInflation = new BigDecimal(inflationValue).multiply(targetPrice);
			targetPrice = targetPrice.add(increaseInPriceUnderInflation);
		}
		System.out.println(String.join(" ", "The price of an item which is priced at",
				Double.toString(currentPrice.doubleValue()), "in", Integer.toString(currentYear), "will be",
				Double.toString(targetPrice.doubleValue()), "at the beginning of", Integer.toString(targetYear)));
	}

}
