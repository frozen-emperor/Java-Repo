package com.design.strategy.taxCalculationStrategy;

public class ThresholdBasedStateTaxCalculator implements StateTaxCalculator {

	double minimumTax = 200;

	@Override
	public double calculateTax(double income) {
		System.out.println("minimum tax is 200 rs peasant!!!ha ha ha");
		return (income < minimumTax) ? income : minimumTax;
	}

}
