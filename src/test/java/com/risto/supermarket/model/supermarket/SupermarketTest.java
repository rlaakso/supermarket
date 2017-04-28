package com.risto.supermarket.model.supermarket;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.risto.supermarket.model.discount.DiscountTestHelper;
import com.risto.supermarket.model.discount.InvalidDiscountException;
import com.risto.supermarket.model.stock.ItemNotStockedException;
import com.risto.supermarket.model.stock.StockTestHelper;
import com.risto.supermarket.model.stock.UnsupportedUnitException;

public class SupermarketTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCanConstructSupermarket() {
		Supermarket s = new Supermarket("Sainsburys", "GBP");
		assertEquals("Sainsburys", s.getName());
	}
	
	@Test
	public void testCanPopulateStock() throws UnsupportedUnitException, ItemNotStockedException, InvalidCurrencyException {
		Supermarket s = new Supermarket("Zona Sul", "BRL");
		StockTestHelper.populateSupermarketStock(s, s.getCurrency());
		assertEquals("Beans", s.getItemByName("Beans").getName());
		assertEquals(3, s.getItemCount());
	}

	@Test
	public void testCanPopulateDiscounts() throws InvalidDiscountException, ItemNotStockedException, UnsupportedUnitException, InvalidCurrencyException {
		Supermarket s = new Supermarket("KaDeWe", "EUR");
		StockTestHelper.populateSupermarketStock(s, s.getCurrency());
		DiscountTestHelper.populateSupermarketDiscounts(s, s.getCurrency());
		assertEquals(2, s.getDiscountCount());
	}
	
	@Test(expected = InvalidCurrencyException.class)
	public void testItemCurrencyHasToMatch() throws InvalidDiscountException, ItemNotStockedException, UnsupportedUnitException, InvalidCurrencyException {
		Supermarket s = new Supermarket("Whole Foods", "USD");
		StockTestHelper.populateSupermarketStock(s, "EUR");
	}

	@Test(expected = InvalidCurrencyException.class)
	public void testDiscountCurrencyHasToMatch() throws InvalidDiscountException, ItemNotStockedException, UnsupportedUnitException, InvalidCurrencyException {
		Supermarket s = new Supermarket("Whole Foods", "USD");
		StockTestHelper.populateSupermarketStock(s, "USD");
		DiscountTestHelper.populateSupermarketDiscounts(s, "GBP");
	}

}
