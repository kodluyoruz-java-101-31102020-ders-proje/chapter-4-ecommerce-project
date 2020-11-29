package com.ecommerce.tax;

import com.ecommerce.money.Money;

public class KDVTax implements Tax {

	private String name;
	private Money value;
	
	public KDVTax(String name, Money value) {
		this.name = name;
		this.value = value;
	}
	
	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public Money getTaxValue() {
		return this.value;
	}

	@Override
	public String toString() {
		return "KDVTax [name=" + name + ", value=" + value + "]";
	}

	
}
