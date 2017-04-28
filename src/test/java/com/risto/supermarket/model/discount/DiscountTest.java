package com.risto.supermarket.model.discount;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.risto.supermarket.model.discount.InvalidDiscountException;
import com.risto.supermarket.model.discount.ThreeForTwoDiscount;
import com.risto.supermarket.model.discount.TwoForOnePoundDiscount;
import com.risto.supermarket.model.stock.Money;
import com.risto.supermarket.model.supermarket.InvalidCurrencyException;

public class DiscountTest {

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
	
	@Test
	public void testCanConstructTwoForOnePoundDiscount() throws InvalidDiscountException, InvalidCurrencyException {
		TwoForOnePoundDiscount d = new TwoForOnePoundDiscount("Coke 2 for £1", "Coke", 2, new Money(100, "GBP"), new Money(100, "GBP"));
		assertEquals("Coke", d.getItemName());
		assertEquals(2, d.getItemCount());
		assertEquals(100, d.getTotalPrice().getValue());
	}
	
	@Test(expected = InvalidDiscountException.class)
	public void testInvalidTwoForOnePoundDiscount() throws InvalidDiscountException, InvalidCurrencyException {
		new TwoForOnePoundDiscount("Coke 2 for -£1", "Coke", 2, new Money(-100, "GBP"), new Money(100, "GBP"));
	}

	@Test(expected = InvalidCurrencyException.class)
	public void testInvalidCurrencyForDiscount() throws InvalidDiscountException, InvalidCurrencyException {
		new TwoForOnePoundDiscount("Coke 2 for -£1", "Coke", 2, new Money(-100, "EUR"), new Money(100, "GBP"));
	}
}
