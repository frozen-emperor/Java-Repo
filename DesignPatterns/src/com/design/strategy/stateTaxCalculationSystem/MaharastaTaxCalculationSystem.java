package com.design.strategy.stateTaxCalculationSystem;

import com.design.strategy.taxCalculationStrategy.StateTaxCalculator;

public class MaharastaTaxCalculationSystem extends AbstractStateTaxCalculationSystem {

	public MaharastaTaxCalculationSystem(StateTaxCalculator stateTaxCalculator) {
		super(stateTaxCalculator);
	}

	@Override
	public void display(double income) {
		System.out.println("maharastra tax:" + this.calculateTax(income));

	}

}
