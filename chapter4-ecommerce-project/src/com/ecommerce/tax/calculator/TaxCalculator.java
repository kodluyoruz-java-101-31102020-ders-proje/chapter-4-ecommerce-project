package com.ecommerce.tax.calculator;

import com.ecommerce.product.Product;
import com.ecommerce.tax.Tax;

public interface TaxCalculator {

	public Tax calculate(Product product);
	
}
