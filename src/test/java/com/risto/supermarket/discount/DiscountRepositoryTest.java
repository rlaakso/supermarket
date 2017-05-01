package com.risto.supermarket.discount;

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

public class DiscountRepositoryTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
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

	@Test(expected = NotEmptyException.class)
	public void testCannotChangeCurrencyForNonEmptyStorage() throws InvalidDiscountException, InvalidCurrencyException, NotEmptyException {
		Discount d = new TwoForOnePoundDiscount("Coke 2 for -£1", "Coke", 2, new Money(100, "GBP"), new Money(100, "GBP"));
		DiscountRepository repo = new DiscountRepositoryImpl();
		repo.addDiscount(d);
		repo.changeCurrency("INR");
	}
}
