package com.ecommerce.tax.calculator;

import com.ecommerce.money.Money;
import com.ecommerce.product.Product;
import com.ecommerce.tax.KDVTax;
import com.ecommerce.tax.Tax;

public class KDVTaxCalculator implements TaxCalculator {
	
	@Override
	public Tax calculate(Product product) {
		
		Money price = product.getPrice();
		double taxValue = price.getValue() * 0.08;
		
		return new KDVTax("KDV", new Money(taxValue, price.getCurrency()));
	}

}
