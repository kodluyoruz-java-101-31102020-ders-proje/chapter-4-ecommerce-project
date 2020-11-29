package com.ecommerce.payment.integrator;

import com.ecommerce.shoppingchart.ShoppingChart;

public interface PaymentIntegrator {

	public int makePayment(ShoppingChart shoppingChart);
	
}
