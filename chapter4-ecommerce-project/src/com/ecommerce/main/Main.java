package com.ecommerce.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.ecommerce.basket.BasketItem;
import com.ecommerce.basket.BasketType;
import com.ecommerce.basketitem.builder.BasketItemBuilder;
import com.ecommerce.money.Currency;
import com.ecommerce.money.Money;
import com.ecommerce.payment.integrator.ClassifiedPaymentIntegrator;
import com.ecommerce.payment.integrator.ExpertiseReportPaymentIntegrator;
import com.ecommerce.payment.integrator.PaymentIntegrator;
import com.ecommerce.payment.provider.PaymentProvider;
import com.ecommerce.payment.provider.model.AssecoPaymentProvider;
import com.ecommerce.payment.provider.model.IyzicoPaymentProvider;
import com.ecommerce.payment.provider.model.PreviousPayment;
import com.ecommerce.product.ClassifiedProduct;
import com.ecommerce.product.ReportProduct;
import com.ecommerce.product.impl.CarExpertiseReport;
import com.ecommerce.product.impl.Classified;
import com.ecommerce.product.impl.Doping;
import com.ecommerce.product.impl.ReportItem;
import com.ecommerce.product.impl.type.DopingType;
import com.ecommerce.shoppingchart.ShoppingChart;
import com.ecommerce.tax.calculator.KDVTaxCalculator;
import com.ecommerce.tax.calculator.OTVTaxCalculator;
import com.ecommerce.tax.calculator.TaxCalculator;

public class Main {

	public static void main(String[] args) {
		
		Set<Doping> dopings = new HashSet<Doping>();
		dopings.add(new Doping("Güncelim Dopingi", new Money(100, Currency.TL), DopingType.UptoDate));
		ClassifiedProduct classified = new Classified("Araç ilanı", new Money(100000, Currency.TL), dopings);
		((Classified)classified).setTitle("Sıfır araç temiz!");
		((Classified)classified).setDescription("ALKKJFALSJLKDAJLSKJLAK JLAKSJLDA");
		
		
		Set<ReportItem> extraServices = new HashSet<ReportItem>();
		extraServices.add(new ReportItem("Vale hizmeti", new Money(50, Currency.TL)));
		extraServices.add(new ReportItem("Araç yıkama hizmeti", new Money(100, Currency.TL)));
		ReportProduct expertiseReport = new CarExpertiseReport("Otomobil Ekspertiz Raporu", new Money(200, Currency.TL), extraServices);
		
		
		List<TaxCalculator> taxCalculatorForClassified = Arrays.asList(new KDVTaxCalculator(), new OTVTaxCalculator());
		BasketItem classifiedbasketItem = BasketItemBuilder.buildBasketItem(classified, taxCalculatorForClassified, BasketType.Classified);
		
		List<TaxCalculator> taxCalculatorForExpertiseReport = Arrays.asList(new OTVTaxCalculator());
		BasketItem expertiseReportbasketItem = BasketItemBuilder.buildBasketItem(expertiseReport, taxCalculatorForExpertiseReport, BasketType.CarExpertiseReport);
		
		
		ShoppingChart shoppingChart = new ShoppingChart(new ArrayList<BasketItem>());
		shoppingChart.addBasketItem(classifiedbasketItem);
		shoppingChart.addBasketItem(expertiseReportbasketItem);
		
		System.out.println("Alışveriş Sepetimiz");
		printShoppingChart(shoppingChart);
		
		
		
		PaymentProvider iyzico = new IyzicoPaymentProvider(new HashMap<Integer, PreviousPayment>());
		PaymentProvider asseco = new AssecoPaymentProvider(new HashMap<Integer, PreviousPayment>());
		
		PaymentIntegrator classifiedIntegrator = new ClassifiedPaymentIntegrator(asseco, BasketType.Classified);
		PaymentIntegrator expertiseIntegrator = new ExpertiseReportPaymentIntegrator(iyzico, BasketType.CarExpertiseReport);

		int chargeIdForClassified = classifiedIntegrator.makePayment(shoppingChart);
		int chargeIdForExpertiseReport = expertiseIntegrator.makePayment(shoppingChart);
		
		System.out.println("Ödenmiş Faturalar");
		System.out.println(asseco.loadInvoice(chargeIdForClassified));
		System.out.println(iyzico.loadInvoice(chargeIdForExpertiseReport));
		
	}
	
	private static void printShoppingChart(ShoppingChart shoppingChart) {
		
		for(BasketItem basketItem : shoppingChart.getBasketItemList()) {
			System.out.println(basketItem);
		}
		
		System.out.println();
	}

}
