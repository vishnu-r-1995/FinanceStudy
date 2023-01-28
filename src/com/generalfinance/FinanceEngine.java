package com.generalfinance;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

public class FinanceEngine {

	public static void main(String[] args) {
		displayPriceOfAnItemAtSpecifiedYear(new BigDecimal(50000), 2023, 2035, 7.5);
		displayAmountNeededAfterRetirement(new BigDecimal(30000), 2023, 2048, 20, 7.0);
		displayCorpusAmountInSWPForRetirementLife(new BigDecimal(30000), 12, 20, 8.0);
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
		NumberFormat nf = NumberFormat.getInstance(Locale.ENGLISH);
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
		BigDecimal amountNeededAfterRetirement = new BigDecimal(0.0);

		for (int i = 0; i < numberOfYearsAfterRetirement; i++) 
		{
			BigDecimal increaseInPriceUnderInflation = new BigDecimal(inflationValue)
					.multiply(monthlyExpenseAfterRetirement);
			monthlyExpenseAfterRetirement = monthlyExpenseAfterRetirement.add(increaseInPriceUnderInflation);
			BigDecimal yearlyExpense = monthlyExpenseAfterRetirement.multiply(new BigDecimal(12.0));
			amountNeededAfterRetirement = amountNeededAfterRetirement.add(yearlyExpense);
		}
		System.out.println("Amount Needed After Retirement: " + nf.format(amountNeededAfterRetirement.doubleValue()));
	}
	
	private static void displayCorpusAmountInSWPForRetirementLife(BigDecimal currentMonthlyExpense,
			int numberOfYearsAfterRetirement, double interestPercentageOfRetirementInvestment,
			double yearsTillRetirement) 
	{
		// TODO - Display Corpus Amount To Be Submitted In SWP
	}
}
