package com.design.strategy.stateTaxCalculationSystem;

import com.design.strategy.taxCalculationStrategy.StateTaxCalculator;

public abstract class AbstractStateTaxCalculationSystem {

	private StateTaxCalculator stateTaxCalculator;

	public AbstractStateTaxCalculationSystem(StateTaxCalculator stateTaxCalculator) {
		super();
		this.stateTaxCalculator = stateTaxCalculator;
	}

	public void setStateTaxCalculator(StateTaxCalculator stateTaxCalculator) {
		this.stateTaxCalculator = stateTaxCalculator;
	}

	protected double calculateTax(double income) {
		return this.stateTaxCalculator.calculateTax(income);
	}
	
	public abstract void display(double income);

}
