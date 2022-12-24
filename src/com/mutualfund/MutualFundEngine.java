package com.mutualfund;

import java.math.BigDecimal;

public class MutualFundEngine {

	public static void main(String[] args) {
		displaySIPPrincipalOnMaturity(12, 24, new BigDecimal(2000.0));
	}

	private static void displaySIPPrincipalOnMaturity(double interest, int numberOfInstallments, BigDecimal investmentPerMonth) 
	{
		BigDecimal principal = investmentPerMonth;
		for (int i = 1; i < numberOfInstallments; i++) {
			principal = principal.add(getInterestAsBigDecimal(interest, principal));
			principal = principal.add(investmentPerMonth);
		}
		//Add interest for the last installment as per calculation given in "https://cleartax.in/s/sip-calculator"
		principal = principal.add(getInterestAsBigDecimal(interest, principal));
		
		System.out.println("Principal at the end of " + numberOfInstallments + " installments of Rs."
				+ investmentPerMonth + " at " + interest + "% interest = " + Math.round(principal.doubleValue()));
	}

	private static BigDecimal getInterestAsBigDecimal(double interest, BigDecimal principal) 
	{
		BigDecimal denominator = new BigDecimal(100).multiply(new BigDecimal(12));
		return new BigDecimal(interest).multiply(principal).divide(denominator);
	}

}