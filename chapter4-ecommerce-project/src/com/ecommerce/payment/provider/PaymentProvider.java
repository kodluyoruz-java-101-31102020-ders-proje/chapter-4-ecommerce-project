package com.ecommerce.payment.provider;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.ecommerce.money.Money;
import com.ecommerce.payment.provider.model.PreviousPayment;

public abstract class PaymentProvider {

	protected Map<Integer, PreviousPayment> previousPaymentMap;
	
	public PaymentProvider(Map<Integer, PreviousPayment> previousPaymentMap) {
		this.previousPaymentMap = previousPaymentMap;
	}
	
	public void putPreviousPayment(int chargeId, PreviousPayment previousPayment) {
		this.previousPaymentMap.put(chargeId, previousPayment);
	}
	
	public List<PreviousPayment> getPreviousPayments() {
		
		return new ArrayList<PreviousPayment>(this.previousPaymentMap.values());
	}
	
	
	public abstract boolean cancelCharge(int chargeId);
	
	public abstract int charge(Money totalPrice);
	
	public abstract PreviousPayment loadInvoice(int chargeId);
}
