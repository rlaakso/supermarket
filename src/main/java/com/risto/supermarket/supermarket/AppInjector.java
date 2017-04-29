package com.risto.supermarket.supermarket;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.risto.supermarket.discount.DiscountCalculatorServiceImpl;
import com.risto.supermarket.discount.DiscoutListImpl;
import com.risto.supermarket.discount.api.DiscountCalculatorService;
import com.risto.supermarket.discount.api.DiscountList;
import com.risto.supermarket.stock.StockImpl;
import com.risto.supermarket.stock.api.Stock;

/**
 * Guice injector class
 * @author Risto Laakso <risto.laakso@iki.fi>
 *
 */
public class AppInjector extends AbstractModule {

	private static final Injector instance = Guice.createInjector(new AppInjector());
	
	@Override
	protected void configure() {
		bind(Stock.class).to(StockImpl.class);
		bind(DiscountList.class).to(DiscoutListImpl.class);
		bind(DiscountCalculatorService.class).to(DiscountCalculatorServiceImpl.class);
	}
	
	public static Injector getInstance() {
		return instance;
	}
}
