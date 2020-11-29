package com.ecommerce.basket;

import java.util.Set;

import com.ecommerce.product.Product;
import com.ecommerce.tax.Tax;

public class BasketItem {

	private Product product;
	private Set<Tax> taxList;
	private BasketType type;
	
	public BasketItem(Product product, Set<Tax> taxList, BasketType type) {
		this.product = product;
		this.taxList = taxList;
		this.type = type;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Set<Tax> getTaxList() {
		return taxList;
	}

	public void setTaxList(Set<Tax> taxList) {
		this.taxList = taxList;
	}

	public BasketType getType() {
		return type;
	}

	public void setType(BasketType type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "BasketItem [product=" + product + ", taxList=" + taxList + ", type=" + type + "]";
	}
	
	
}
