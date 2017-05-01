package com.risto.supermarket.common;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.risto.supermarket.discount.DiscountCalculatorServiceImpl;
import com.risto.supermarket.discount.DiscountRepositoryImpl;
import com.risto.supermarket.discount.api.DiscountCalculatorService;
import com.risto.supermarket.discount.api.DiscountRepository;
import com.risto.supermarket.shoppingcart.ShoppingCartServiceImpl;
import com.risto.supermarket.shoppingcart.api.ShoppingCartService;
import com.risto.supermarket.stock.StockRepositoryImpl;
import com.risto.supermarket.stock.api.StockRepository;

/**
 * Guice injector class
 * @author Risto Laakso <risto.laakso@iki.fi>
 *
 */
public class AppInjector extends AbstractModule {

	private static final Injector instance = Guice.createInjector(new AppInjector());
	
	@Override
	protected void configure() {
		bind(StockRepository.class).to(StockRepositoryImpl.class);
		bind(DiscountRepository.class).to(DiscountRepositoryImpl.class);
		bind(DiscountCalculatorService.class).to(DiscountCalculatorServiceImpl.class);
		bind(ShoppingCartService.class).to(ShoppingCartServiceImpl.class);
	}
	
	public static Injector getInstance() {
		return instance;
	}
}
