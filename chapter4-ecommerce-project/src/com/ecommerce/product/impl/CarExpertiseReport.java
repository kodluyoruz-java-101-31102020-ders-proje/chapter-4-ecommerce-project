package com.ecommerce.product.impl;

import java.util.List;
import java.util.Set;

import com.ecommerce.money.Money;
import com.ecommerce.product.ReportProduct;

public class CarExpertiseReport implements ReportProduct {

	private String name;
	private Money price;
	
	private List<String> packages;
	private Set<ReportItem> extraServices;
	
	public CarExpertiseReport(String name, Money price, Set<ReportItem> extraServices) {
		this.name = name;
		this.price = price;
		this.extraServices = extraServices;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public Money getPrice() {
		return this.price;
	}

	@Override
	public void addReportItem(ReportItem reportItem) {
		this.extraServices.add(reportItem);
	}
	
	@Override
	public void setPackages(List<String> packages) {
		this.packages = packages;
	}
	

	public List<String> getPackages() {
		return packages;
	}

	public Set<ReportItem> getExtraServices() {
		return extraServices;
	}

	public void setExtraServices(Set<ReportItem> extraServices) {
		this.extraServices = extraServices;
	}

	@Override
	public String toString() {
		return "CarExpertiseReport [name=" + name + ", price=" + price + ", packages=" + packages + ", extraServices="
				+ extraServices + "]";
	}
	
	
}
