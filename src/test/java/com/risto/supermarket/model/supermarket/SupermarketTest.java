package com.risto.supermarket.model.supermarket;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
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
	public void testCanPopulateStock() throws UnsupportedUnitException {
		StockFactory stockFactory = new StockFactory();
		Supermarket s = new Supermarket("Aldi");
		stockFactory.populate(s);
		assertEquals(stockFactory.getItemCount(), s.getItemCount());
	}

	@Test
	public void testCanPopulateDiscounts() {
		DiscountFactory discountFactory = new DiscountFactory();
		Supermarket s = new Supermarket("KaDeWe");
		discountFactory.populate(s);
		assertEquals(discountFactory.getDiscountCount(), s.getDiscountCount());
	}

}
