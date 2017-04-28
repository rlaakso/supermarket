package com.risto.supermarket.model.supermarket;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DiscountTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCanConstructPercentageDiscount() {
		PercentageDiscount d = new PercentageDiscount(5.00);
		assertEquals(5.00, d.getDiscount(), 1e-5);
	}

	@Test
	public void testCanConstructFixedDiscount() {
		FixedDiscount d = new FixedDiscount(100);
		assertEquals(100, d.getDiscount());
	}
	
	@Test
	public void testCanApplyFixedDiscount() {
		FixedDiscount d = new FixedDiscount(100);
		SingleItem item = new SingleItem("10-pack of soap", new Money(1000, "GBP"));
		Money discountedTotal = d.applyTo(item);
		assertEquals(900, discountedTotal.getValue());
	}
	

}
