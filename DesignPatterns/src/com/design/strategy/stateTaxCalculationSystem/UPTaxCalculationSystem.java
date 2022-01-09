package com.design.strategy.stateTaxCalculationSystem;

import com.design.strategy.taxCalculationStrategy.StateTaxCalculator;

public class UPTaxCalculationSystem extends AbstractStateTaxCalculationSystem {

	public UPTaxCalculationSystem(StateTaxCalculator stateTaxCalculator) {
		super(stateTaxCalculator);		
	}

	@Override
	public void display(double income) {
		System.out.println("UP tax:"+this.calculateTax(income));
		
	}

}
