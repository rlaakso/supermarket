package com.risto.supermarket.discount;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.risto.supermarket.common.api.Money;
import com.risto.supermarket.discount.ThreeForTwoDiscount;
import com.risto.supermarket.discount.api.InvalidDiscountException;

public class ThreeForTwoDiscountTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCanConstructThreeForTwoDiscount() throws InvalidDiscountException {
		ThreeForTwoDiscount d = new ThreeForTwoDiscount("Beans 3 for 2", "Beans", 3, 2, new Money(100, "GBP"));
		assertEquals("Beans", d.getItemName());
		assertEquals(3, d.getItemCount());
		assertEquals(1, d.getFreebieCount());
	}
	
	@Test(expected = InvalidDiscountException.class)
	public void testInvalidThreeForTwoDiscount() throws InvalidDiscountException {
		new ThreeForTwoDiscount("Beans 3 for 4", "Beans", 3, 4, new Money(100, "GBP"));
	}

}
