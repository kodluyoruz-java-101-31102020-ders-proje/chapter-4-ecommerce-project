package com.ecommerce.money;

public class MoneyCalculator {

	public static Money sum(Money money1, Money money2) {
		
		if(!money1.getCurrency().equals(money2.getCurrency())) {
			throw new RuntimeException("Money currency values mut be matched!");
		}
		
		double total = money1.getValue() + money2.getValue();
		return new Money(total, money1.getCurrency());
	}
}
