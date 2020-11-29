package com.ecommerce.basketitem.builder;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.ecommerce.basket.BasketItem;
import com.ecommerce.basket.BasketType;
import com.ecommerce.product.Product;
import com.ecommerce.tax.Tax;
import com.ecommerce.tax.calculator.TaxCalculator;

public class BasketItemBuilder {

	public static BasketItem buildBasketItem(Product product, List<TaxCalculator> calculators, BasketType basketType) {
	
		Set<Tax> taxList = new HashSet<Tax>();
		
		for(TaxCalculator calculator : calculators) {
			
			Tax tax = calculator.calculate(product);
			taxList.add(tax);
		}
		
		return new BasketItem(product, taxList, basketType);
	}
	
}
