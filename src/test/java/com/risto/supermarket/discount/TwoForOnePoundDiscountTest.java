package com.risto.supermarket.discount;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.risto.supermarket.common.api.Money;
import com.risto.supermarket.discount.api.Discount;
import com.risto.supermarket.discount.api.DiscountNotAvailableException;
import com.risto.supermarket.discount.api.DiscountRepository;
import com.risto.supermarket.discount.api.InvalidDiscountException;
import com.risto.supermarket.discount.api.NotEmptyException;
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
		Discount d = new TwoForOnePoundDiscount("Coke 2 for -£1", "Coke", 2, new Money(100, "GBP"), new Money(100, "GBP"));
		DiscountRepository repo = new DiscountRepositoryImpl();
		repo.changeCurrency("EUR");
		repo.addDiscount(d);
	}

	@Test(expected = DiscountNotAvailableException.class)
	public void testDiscountQueryWhenDiscountDoesntExist() throws InvalidDiscountException, InvalidCurrencyException, DiscountNotAvailableException, NotEmptyException {
		Discount d = new TwoForOnePoundDiscount("Coke 2 for -£1", "Coke", 2, new Money(100, "GBP"), new Money(100, "GBP"));
		DiscountRepository repo = new DiscountRepositoryImpl();
		repo.changeCurrency("GBP");
		repo.addDiscount(d);
		repo.getDiscountByName("Coke 2 for £1");
	}

}
