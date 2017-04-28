package com.risto.supermarket.model.stock;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.risto.supermarket.model.supermarket.InvalidCurrencyException;

public class StockTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCanConstructStock() {
		new Stock("GBP");
	}

	@Test
	public void testCanAddItemToStock() throws InvalidCurrencyException {
		Stock s = new Stock("GBP");
		s.addItemToStock(new SingleItem("Beans", new Money(70, "GBP")));
	}

	@Test(expected = InvalidCurrencyException.class)
	public void testStockCurrencyHasToMatch() throws InvalidCurrencyException {
		Stock s = new Stock("GBP");
		s.addItemToStock(new SingleItem("Beans", new Money(70, "EUR")));
	}

	@Test(expected = ItemNotStockedException.class)
	public void testGetNonexistentItemStock() throws InvalidCurrencyException, ItemNotStockedException {
		Stock s = new Stock("GBP");
		s.addItemToStock(new SingleItem("Beans", new Money(70, "GBP")));
		s.getItemByName("Coke");
	}
}

