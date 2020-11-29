package com.ecommerce.product;

import java.util.List;

import com.ecommerce.product.impl.ReportItem;

public interface ReportProduct extends Product{

	public void addReportItem(ReportItem reportItem);
	public void setPackages(List<String> packages);
}
