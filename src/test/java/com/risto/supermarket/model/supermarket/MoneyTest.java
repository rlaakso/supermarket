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
		Money money = new Money(1234, "GBP");
		assertEquals(1234, money.getValue());
		assertEquals("GBP", money.getCurrency());
	}
	
	@Test
	public void testCanAddMoney() {
		Money moneyA = new Money(1000, "GBP");
		Money moneyB = moneyA.add(500);
		assertEquals(1500, moneyB.getValue());
	}

}
