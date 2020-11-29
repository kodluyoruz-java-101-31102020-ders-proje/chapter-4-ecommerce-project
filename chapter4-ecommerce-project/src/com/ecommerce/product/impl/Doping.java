package com.ecommerce.product.impl;

import com.ecommerce.money.Money;
import com.ecommerce.product.Product;
import com.ecommerce.product.impl.type.DopingType;

public class Doping implements Product {

	private String name;
	private Money price;
	private DopingType type;
	
	public Doping(String name, Money price, DopingType type) {
		this.name = name;
		this.price = price;
		this.type = type;
	}
	
	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public Money getPrice() {
		return this.price;
	}

	public DopingType getType() {
		return type;
	}

	public void setType(DopingType type) {
		this.type = type;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Doping other = (Doping) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (type != other.type)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Doping [name=" + name + ", price=" + price + ", type=" + type + "]";
	}
	
	
}
