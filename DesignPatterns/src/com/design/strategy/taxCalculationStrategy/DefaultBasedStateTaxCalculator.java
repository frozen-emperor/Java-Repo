package com.design.strategy.taxCalculationStrategy;

public class DefaultBasedStateTaxCalculator implements StateTaxCalculator {

	private double minimumTaxRate = 0.3;

	@Override
	public double calculateTax(double income) {
		System.out.println("30 takka tax lagega chahe kuch bhi ho!!");
		return income * minimumTaxRate;
	}

}
