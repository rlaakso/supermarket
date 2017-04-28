package com.risto.supermarket.model.supermarket;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MoneyTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCanConstructMoney() {
		Money money = new Money(12.34, "GBP");
		assertEquals(12.34, money.getValue());
		assertEquals("GBP", money.getCurrency());
	}
	
	@Test
	public void testCanAddMoney() {
		Money moneyA = new Money(10.00, "GBP");
		Money moneyB = moneyA.add(5.00);
		assertEquals(15.00, moneyB.getValue());
	}

}
