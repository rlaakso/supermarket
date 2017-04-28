package com.risto.supermarket.model.supermarket;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SupermarketTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCanConstructSupermarket() {
		Supermarket s = new Supermarket("Sainsburys");
		assertEquals("Sainsburys", s.getName());
	}
	
	@Test
	public void testCanPopulateStock() throws UnsupportedUnitException, ItemNotStockedException {
		Supermarket s = new Supermarket("Zona Sul");
		SupermarketTestHelper.populateSupermarketStock(s);
		assertEquals("Beans", s.getItemByName("Beans").getName());
		assertEquals(3, s.getItemCount());
	}

	@Test
	public void testCanPopulateDiscounts() throws InvalidDiscountException, ItemNotStockedException, UnsupportedUnitException {
		Supermarket s = new Supermarket("KaDeWe");
		SupermarketTestHelper.populateSupermarketStock(s);
		SupermarketTestHelper.populateSupermarketDiscounts(s);
		assertEquals(2, s.getDiscountCount());
	}

}
