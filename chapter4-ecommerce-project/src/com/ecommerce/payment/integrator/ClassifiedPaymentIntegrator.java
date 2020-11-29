package com.ecommerce.payment.integrator;

import java.util.List;

import com.ecommerce.basket.BasketItem;
import com.ecommerce.basket.BasketType;
import com.ecommerce.basketitem.collector.BasketItemCollector;
import com.ecommerce.basketitem.collector.TotalBasketItemFinder;
import com.ecommerce.money.Money;
import com.ecommerce.payment.provider.PaymentProvider;
import com.ecommerce.shoppingchart.ShoppingChart;

public class ClassifiedPaymentIntegrator implements PaymentIntegrator {

	private BasketType type;
	private PaymentProvider paymentProvider;
	
	public ClassifiedPaymentIntegrator(PaymentProvider paymentProvider, BasketType type) {
		this.type = type;
		this.paymentProvider = paymentProvider;
	}

	@Override
	public int makePayment(ShoppingChart shoppingChart) {
		
		List<BasketItem> items = BasketItemCollector.collectBasketItems(type, shoppingChart);
		
		Money total = TotalBasketItemFinder.sum(items);
		
		int chargeId = paymentProvider.charge(total);
		
		return chargeId;
	}

}
