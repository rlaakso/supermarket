package com.risto.supermarket.discount;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.risto.supermarket.discount.DiscountImpl;
import com.risto.supermarket.discount.DiscoutListImpl;
import com.risto.supermarket.discount.TwoForOnePoundDiscount;
import com.risto.supermarket.discount.api.DiscountNotAvailableException;
import com.risto.supermarket.discount.api.DiscountList;
import com.risto.supermarket.discount.api.InvalidDiscountException;
import com.risto.supermarket.discount.api.NotEmptyException;
import com.risto.supermarket.stock.api.Money;
import com.risto.supermarket.supermarket.api.InvalidCurrencyException;

public class TwoForOnePoundDiscountTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testCanConstructTwoForOnePoundDiscount() throws InvalidDiscountException, InvalidCurrencyException {
		TwoForOnePoundDiscount d = new TwoForOnePoundDiscount("Coke 2 for £1", "Coke", 2, new Money(100, "GBP"), new Money(100, "GBP"));
		assertEquals("Coke", d.getItemName());
		assertEquals(2, d.getItemCount());
		assertEquals(100, d.getTotalPrice().getValue());
	}
	
	@Test(expected = InvalidDiscountException.class)
	public void testInvalidTwoForOnePoundDiscountCurrencyAmount() throws InvalidDiscountException, InvalidCurrencyException {
		new TwoForOnePoundDiscount("Coke 2 for -£1", "Coke", 2, new Money(-100, "GBP"), new Money(100, "GBP"));
	}

	@Test(expected = InvalidCurrencyException.class)
	public void testInvalidCurrencyForDiscount() throws InvalidDiscountException, InvalidCurrencyException {
		new TwoForOnePoundDiscount("Coke 2 for -£1", "Coke", 2, new Money(100, "EUR"), new Money(100, "GBP"));
	}

	@Test(expected = InvalidCurrencyException.class)
	public void testDiscountCurrencyDoesntMatchStoreCurrency() throws InvalidDiscountException, InvalidCurrencyException, NotEmptyException {
		DiscountImpl ad = new TwoForOnePoundDiscount("Coke 2 for -£1", "Coke", 2, new Money(100, "GBP"), new Money(100, "GBP"));
		DiscountList d = new DiscoutListImpl();
		d.changeCurrency("EUR");
		d.addDiscount(ad);
	}

	@Test(expected = DiscountNotAvailableException.class)
	public void testDiscountQueryWhenDiscountDoesntExist() throws InvalidDiscountException, InvalidCurrencyException, DiscountNotAvailableException, NotEmptyException {
		DiscountImpl ad = new TwoForOnePoundDiscount("Coke 2 for -£1", "Coke", 2, new Money(100, "GBP"), new Money(100, "GBP"));
		DiscountList d = new DiscoutListImpl();
		d.changeCurrency("GBP");
		d.addDiscount(ad);
		d.getDiscountByName("Coke 2 for £1");
	}

}
