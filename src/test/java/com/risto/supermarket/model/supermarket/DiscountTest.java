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
	public void testCanConstructThreeForTwoDiscount() throws InvalidDiscountException {
		ThreeForTwoDiscount d = new ThreeForTwoDiscount("Beans 3 for 2", "Beans", 3, 2);
		assertEquals("Beans", d.getItemName());
		assertEquals(3, d.getItemCount());
		assertEquals(1, d.getFreebieCount());
	}
	
	@Test(expected = InvalidDiscountException.class)
	public void testInvalidThreeForTwoDiscount() throws InvalidDiscountException {
		ThreeForTwoDiscount d = new ThreeForTwoDiscount("Beans 3 for 4", "Beans", 3, 4);
	}
	
	@Test
	public void testCanConstructTwoForOnePoundDiscount() throws InvalidDiscountException {
		TwoForOnePoundDiscount d = new TwoForOnePoundDiscount("Coke 2 for £1", "Coke", 2, new Money(100, "GBP"));
		assertEquals("Coke", d.getItemName());
		assertEquals(2, d.getItemCount());
		assertEquals(100, d.getTotalPrice().getValue());
	}
	
	@Test(expected = InvalidDiscountException.class)
	public void testInvalidTwoForOnePoundDiscount() throws InvalidDiscountException {
		TwoForOnePoundDiscount d = new TwoForOnePoundDiscount("Coke 2 for -£1", "Coke", 2, new Money(-100, "GBP"));
	}
}
