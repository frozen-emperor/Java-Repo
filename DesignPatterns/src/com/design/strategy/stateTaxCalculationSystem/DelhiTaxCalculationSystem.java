package com.design.strategy.stateTaxCalculationSystem;

import com.design.strategy.taxCalculationStrategy.StateTaxCalculator;

public class DelhiTaxCalculationSystem extends AbstractStateTaxCalculationSystem {

	public DelhiTaxCalculationSystem(StateTaxCalculator stateTaxCalculator) {
		super(stateTaxCalculator);
	}

	@Override
	public void display(double income) {
		System.out.println("delhi tax:" + this.calculateTax(income));

	}

}
