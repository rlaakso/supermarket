package com.risto.supermarket.supermarket;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.risto.supermarket.discount.DiscountTestHelper;
import com.risto.supermarket.discount.api.InvalidDiscountException;
import com.risto.supermarket.discount.api.NotEmptyException;
import com.risto.supermarket.stock.StockTestHelper;
import com.risto.supermarket.stock.api.ItemNotStockedException;
import com.risto.supermarket.stock.api.UnsupportedUnitException;
import com.risto.supermarket.supermarket.api.InvalidCurrencyException;
import com.risto.supermarket.supermarket.api.Supermarket;

public class SupermarketTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testCanConstructSupermarket() throws NotEmptyException, UnsupportedUnitException, InvalidDiscountException, ItemNotStockedException, InvalidCurrencyException {
		Supermarket s = SupermarketTestHelper.createSupermarket("Sainsburys", "GBP");
		assertEquals("Sainsburys", s.getName());
	}
	
	@Test
	public void testCanPopulateStock() throws UnsupportedUnitException, ItemNotStockedException, InvalidCurrencyException, NotEmptyException, InvalidDiscountException {
		Supermarket s = SupermarketTestHelper.createSupermarket("Zona Sul", "BRL");
		StockTestHelper.populateSupermarketStock(s.getCurrency());
		assertEquals("Beans", s.getItemByName("Beans").getName());
		assertEquals(3, s.getItemCount());
	}

	@Test
	public void testCanPopulateDiscounts() throws InvalidDiscountException, ItemNotStockedException, UnsupportedUnitException, InvalidCurrencyException, NotEmptyException {
		Supermarket s = SupermarketTestHelper.createSupermarket("KaDeWe", "EUR");
		StockTestHelper.populateSupermarketStock(s.getCurrency());
		DiscountTestHelper.populateSupermarketDiscounts(s, s.getCurrency());
		assertEquals(2, s.getDiscountCount());
	}
	
	@Test(expected = InvalidCurrencyException.class)
	public void testItemCurrencyHasToMatch() throws InvalidDiscountException, ItemNotStockedException, UnsupportedUnitException, InvalidCurrencyException, NotEmptyException {
		SupermarketTestHelper.createSupermarket("Whole Foods", "USD");
		StockTestHelper.populateSupermarketStock("EUR");
	}

	@Test(expected = InvalidCurrencyException.class)
	public void testDiscountCurrencyHasToMatch() throws InvalidDiscountException, ItemNotStockedException, UnsupportedUnitException, InvalidCurrencyException, NotEmptyException {
		Supermarket s = SupermarketTestHelper.createSupermarket("Whole Foods", "USD");
		StockTestHelper.populateSupermarketStock("USD");
		DiscountTestHelper.populateSupermarketDiscounts(s, "GBP");
	}

}
