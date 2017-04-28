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
		assertEquals(5.00, d.getDiscountAmount());
	}

	@Test
	public void testCanConstructFixedDiscount() {
		FixedDiscount d = new FixedDiscount(1.00);
		assertEquals(1.00, d.getDiscountAmount());
	}
	
	@Test
	public void testCanApplyFixedDiscount() {
		FixedDiscount d = new FixedDiscount(1.00);
		Money billTotal = new Money(10.00, "GBP");
		Money discountedTotal = d.applyTo(billTotal);
		assertEquals(9.00, discountedTotal.getValue());
	}
	

}
