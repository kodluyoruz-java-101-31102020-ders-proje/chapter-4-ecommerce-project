package com.ecommerce.basketitem.collector;

import java.util.List;

import com.ecommerce.basket.BasketItem;
import com.ecommerce.money.Currency;
import com.ecommerce.money.Money;
import com.ecommerce.money.MoneyCalculator;
import com.ecommerce.tax.calculator.TotalTaxValueFinder;

public class TotalBasketItemFinder {

	public static Money sum(List<BasketItem> items) {
		
		double totalValue = 0;
		Currency currency = null;
		
		for(BasketItem item : items) {
			
			Money productPrice = item.getProduct().getPrice();
			Money taxMoney = TotalTaxValueFinder.sum(item.getTaxList());
			Money total = MoneyCalculator.sum(productPrice, taxMoney);
			
			if(currency == null && total != null) {
				currency = total.getCurrency();
			}
			
			if(total != null) {
				totalValue += total.getValue();
			}
		}
		
		return new Money(totalValue, currency);
	}
}
