package com.ecommerce.product.impl;

import java.util.Set;

import com.ecommerce.money.Money;
import com.ecommerce.product.ClassifiedProduct;

public class Classified implements ClassifiedProduct {

	private String name;
	private Money price;
	
	private String title;
	private String description;
	private Set<Doping> dopingList;
	
	
	public Classified(String name, Money price, Set<Doping> dopingList) {
		this.name = name;
		this.price = price;
		this.dopingList = dopingList;
	}
	
	@Override
	public void addDoping(Doping doping) {
		this.dopingList.add(doping);
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public Money getPrice() {
		return this.price;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Classified [name=" + name + ", price=" + price + ", title=" + title + ", description=" + description
				+ ", dopingList=" + dopingList + "]";
	}

	
}
