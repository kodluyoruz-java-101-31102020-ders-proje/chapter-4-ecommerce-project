package com.ecommerce.basketitem.collector;

import java.util.ArrayList;
import java.util.List;

import com.ecommerce.basket.BasketItem;
import com.ecommerce.basket.BasketType;
import com.ecommerce.shoppingchart.ShoppingChart;

public class BasketItemCollector {

	public static List<BasketItem> collectBasketItems(BasketType type, ShoppingChart shoppingChart) {
		
		List<BasketItem> basketItems = new ArrayList<BasketItem>();
		
		for(BasketItem item : shoppingChart.getBasketItemList()) {
			
			if(type.equals(item.getType())) {
				basketItems.add(item);
			}
		}
		
		return basketItems;
	}
	
}
