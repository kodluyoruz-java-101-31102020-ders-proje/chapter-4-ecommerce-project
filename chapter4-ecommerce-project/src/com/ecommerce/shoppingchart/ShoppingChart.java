package com.ecommerce.shoppingchart;

import java.util.List;

import com.ecommerce.basket.BasketItem;

public class ShoppingChart {

	private List<BasketItem> basketItemList;
	
	public ShoppingChart(List<BasketItem> basketItemList) {
		this.setBasketItemList(basketItemList);
	}
	
	public void addBasketItem(BasketItem basketItem) {
		
		this.basketItemList.add(basketItem);
	}
	
	public BasketItem removeBasketItem(BasketItem basketItem) {
		
		if(this.basketItemList.remove(basketItem)) {
			return basketItem;
		}
		
		return null;
	}

	public List<BasketItem> getBasketItemList() {
		return basketItemList;
	}

	public void setBasketItemList(List<BasketItem> basketItemList) {
		this.basketItemList = basketItemList;
	}

	@Override
	public String toString() {
		return "ShoppingChart [basketItemList=" + basketItemList + "]";
	}
}
