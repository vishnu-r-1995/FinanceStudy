package com.generalfinance;

import java.math.BigDecimal;

public class FinanceEngine {

	public static void main(String[] args) {
		displayPriceOfAnItemAtSpecifiedYear(new BigDecimal(50000), 2023, 2035, 7.5);
		displayAmountNeededAfterRetirement(new BigDecimal(50000), 2023, 2035, 10, 7.5);
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

	private static void displayAmountNeededAfterRetirement(BigDecimal currentMonthlyExpense, int currentYear,
			int yearOfRetirement, int numberOfYearsAfterRetirement, double inflationPercentage) 
	{
		int numberOfYearsTillRetirement = yearOfRetirement - currentYear;
		double inflationValue = inflationPercentage / 100;
		BigDecimal monthlyExpenseAtTheTimeOfRetirement = currentMonthlyExpense;

		for (int i = 0; i < numberOfYearsTillRetirement; i++) 
		{
			BigDecimal increaseInPriceUnderInflation = new BigDecimal(inflationValue)
					.multiply(monthlyExpenseAtTheTimeOfRetirement);
			monthlyExpenseAtTheTimeOfRetirement = monthlyExpenseAtTheTimeOfRetirement
					.add(increaseInPriceUnderInflation);
		}

		BigDecimal monthlyExpenseAfterRetirement = monthlyExpenseAtTheTimeOfRetirement;
		BigDecimal amountNeededAfterRetirement = new BigDecimal(1.0);

		for (int i = 0; i < numberOfYearsAfterRetirement; i++) 
		{
			BigDecimal increaseInPriceUnderInflation = new BigDecimal(inflationValue)
					.multiply(monthlyExpenseAfterRetirement);
			monthlyExpenseAfterRetirement = monthlyExpenseAfterRetirement.add(increaseInPriceUnderInflation);
			BigDecimal yearlyExpense = monthlyExpenseAfterRetirement.multiply(new BigDecimal(12.0));
			amountNeededAfterRetirement = amountNeededAfterRetirement.add(yearlyExpense);
		}
		System.out.println("Amount Needed After Retirement: " + amountNeededAfterRetirement.doubleValue());
		//todo - Display amount is not properly formatted
	}
}
