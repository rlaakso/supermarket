package com.risto.supermarket.supermarket;

import com.risto.supermarket.discount.DiscountTestHelper;
import com.risto.supermarket.discount.api.DiscountList;
import com.risto.supermarket.discount.api.InvalidDiscountException;
import com.risto.supermarket.discount.api.NotEmptyException;
import com.risto.supermarket.stock.StockTestHelper;
import com.risto.supermarket.stock.api.ItemNotStockedException;
import com.risto.supermarket.stock.api.NonWeightableItemException;
import com.risto.supermarket.stock.api.Stock;
import com.risto.supermarket.stock.api.UnsupportedUnitException;
import com.risto.supermarket.stock.api.Weight;
import com.risto.supermarket.supermarket.SupermarketImpl;
import com.risto.supermarket.supermarket.api.InvalidCurrencyException;
import com.risto.supermarket.supermarket.api.ShoppingCart;
import com.risto.supermarket.supermarket.api.Supermarket;

public class SupermarketTestHelper {
	

	/**
	 * Create new supermarket with some stock and discounts
	 * @return
	 * @throws UnsupportedUnitException
	 * @throws InvalidDiscountException
	 * @throws ItemNotStockedException 
	 * @throws InvalidCurrencyException 
	 * @throws NotEmptyException 
	 */
	public static Supermarket createSupermarket(String name, String currency) throws UnsupportedUnitException, InvalidDiscountException, ItemNotStockedException, InvalidCurrencyException, NotEmptyException {
		Supermarket s = new SupermarketImpl(name, currency);

		Stock stock = AppInjector.getInstance().getInstance(Stock.class);
		DiscountList discounts = AppInjector.getInstance().getInstance(DiscountList.class);
		
		stock.clear(); // TODO FIXME should probably use mocks/proxies instead
		discounts.clear();

		stock.changeCurrency(currency);
		discounts.changeCurrency(currency);
		
		StockTestHelper.populateSupermarketStock(s.getCurrency());		
		DiscountTestHelper.populateSupermarketDiscounts(s, s.getCurrency());
		return s;
	}

	/**
	 * Populate shopping cart with some items
	 * @param sc
	 * @param s
	 * @throws ItemNotStockedException
	 * @throws NonWeightableItemException
	 * @throws UnsupportedUnitException
	 */
	public static void populateCart(ShoppingCart sc, Supermarket s) throws ItemNotStockedException, NonWeightableItemException, UnsupportedUnitException {
		sc.addItem(s.getItemByName("Beans"));
		sc.addItem(s.getItemByName("Beans"));
		sc.addItem(s.getItemByName("Beans"));
		sc.addItem(s.getItemByName("Coke"));
		sc.addItem(s.getItemByName("Coke"));
		sc.addItem(s.getItemByName("Oranges"), new Weight(0.200, "kg"));
	}

	
}
