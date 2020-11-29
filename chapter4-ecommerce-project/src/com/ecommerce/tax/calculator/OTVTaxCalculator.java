package com.ecommerce.tax.calculator;

import com.ecommerce.money.Money;
import com.ecommerce.product.Product;
import com.ecommerce.tax.OTVTax;
import com.ecommerce.tax.Tax;

public class OTVTaxCalculator implements TaxCalculator{

	@Override
	public Tax calculate(Product product) {
		
		Money price = product.getPrice();
		
		double taxValue = price.getValue() * 0.10;
		
		return new OTVTax("ÖTV", new Money(taxValue, price.getCurrency()));
	}

}
