package com.ecommerce.payment.provider.model;

import java.util.Date;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import com.ecommerce.money.Money;
import com.ecommerce.payment.provider.PaymentProvider;

public class IyzicoPaymentProvider extends PaymentProvider {

	public IyzicoPaymentProvider(Map<Integer, PreviousPayment> previousPaymentMap) {
		super(previousPaymentMap);
	}

	@Override
	public boolean cancelCharge(int chargeId) {
		
		PreviousPayment previousPayment = super.previousPaymentMap.get(chargeId);
		
		if(previousPayment == null) {
			return false;
		}
		
		Date now = new Date();
		Date paymentRecordDate = previousPayment.getRecordDate();
		long millisecondDiff = now.getTime() - paymentRecordDate.getTime();
		long timeDiffAsHour = TimeUnit.HOURS.convert(millisecondDiff, TimeUnit.MILLISECONDS);
		
		if(timeDiffAsHour < 24) {
			super.previousPaymentMap.remove(chargeId);
			return true;
		}
		
		return false;
	}

	@Override
	public int charge(Money totalPrice) {
		
		int chargeID = (int)Math.random() * 10000;
		
		PreviousPayment payment = new PreviousPayment(totalPrice, new Date());
		super.putPreviousPayment(chargeID, payment);
		return chargeID;
	}

	@Override
	public PreviousPayment loadInvoice(int chargeId) {
		return super.previousPaymentMap.get(chargeId);
	}

}
