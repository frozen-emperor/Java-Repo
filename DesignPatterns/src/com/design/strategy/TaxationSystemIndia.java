package com.design.strategy;

import java.util.Scanner;

import com.design.strategy.stateTaxCalculationSystem.AbstractStateTaxCalculationSystem;
import com.design.strategy.stateTaxCalculationSystem.DelhiTaxCalculationSystem;
import com.design.strategy.stateTaxCalculationSystem.MaharastaTaxCalculationSystem;
import com.design.strategy.stateTaxCalculationSystem.UPTaxCalculationSystem;
import com.design.strategy.taxCalculationStrategy.DefaultBasedStateTaxCalculator;
import com.design.strategy.taxCalculationStrategy.StateTaxCalculator;
import com.design.strategy.taxCalculationStrategy.ThresholdBasedStateTaxCalculator;

public class TaxationSystemIndia {

	public static void main(String[] args) {
		AbstractStateTaxCalculationSystem abstractStateTaxCalculationSystem;
		StateTaxCalculator stateTaxCalculator;

		try (Scanner sc = new Scanner(System.in)) {
			while (sc.next() != "exit") {
				System.out.println("Enter your state:");
				System.out.println("1.Maharastra 2.UP 3.Delhi");
				int state = sc.nextInt();
				System.out.println("Enter your income:");
				double income = sc.nextDouble();
				
				switch (state) {
				case 1:
					stateTaxCalculator = new DefaultBasedStateTaxCalculator();
					abstractStateTaxCalculationSystem = new MaharastaTaxCalculationSystem(stateTaxCalculator);
					break;
				case 2:
					stateTaxCalculator = new ThresholdBasedStateTaxCalculator();
					abstractStateTaxCalculationSystem = new UPTaxCalculationSystem(stateTaxCalculator);
					break;
				case 3:
					stateTaxCalculator = new DefaultBasedStateTaxCalculator();
					abstractStateTaxCalculationSystem = new DelhiTaxCalculationSystem(stateTaxCalculator);
					break;
				default:
					throw new Exception("select proper state");
				}
				abstractStateTaxCalculationSystem.display(income);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
