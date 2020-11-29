package com.ecommerce.tax;

import com.ecommerce.money.Money;

public interface Tax {

	public String getName();
	public Money getTaxValue();
	
}
