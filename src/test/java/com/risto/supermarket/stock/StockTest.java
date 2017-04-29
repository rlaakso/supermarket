package com.risto.supermarket.stock;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.risto.supermarket.discount.api.NotEmptyException;
import com.risto.supermarket.stock.api.ItemNotStockedException;
import com.risto.supermarket.stock.api.Money;
import com.risto.supermarket.stock.api.Stock;
import com.risto.supermarket.supermarket.api.InvalidCurrencyException;

public class StockTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCanConstructStock() {
		new StockImpl();
	}

	@Test
	public void testCanAddItemToStock() throws InvalidCurrencyException, NotEmptyException {
		Stock s = new StockImpl();
		s.changeCurrency("GBP");
		s.addItemToStock(new SingleItem("Beans", new Money(70, "GBP")));
	}

	@Test(expected = InvalidCurrencyException.class)
	public void testStockCurrencyHasToMatch() throws InvalidCurrencyException, NotEmptyException {
		Stock s = new StockImpl();
		s.changeCurrency("GBP");
		s.addItemToStock(new SingleItem("Beans", new Money(70, "EUR")));
	}

	@Test(expected = ItemNotStockedException.class)
	public void testGetNonexistentItemStock() throws InvalidCurrencyException, ItemNotStockedException, NotEmptyException {
		Stock s = new StockImpl();
		s.changeCurrency("GBP");
		s.addItemToStock(new SingleItem("Beans", new Money(70, "GBP")));
		s.getItemByName("Coke");
	}
	
	@Test(expected = NotEmptyException.class)
	public void testCannotChangeCurrencyForNonEmptyStorage() throws InvalidCurrencyException, NotEmptyException {
		Stock s = new StockImpl();
		s.addItemToStock(new SingleItem("Beans", new Money(70, "GBP")));
		s.changeCurrency("INR");
	}

}

