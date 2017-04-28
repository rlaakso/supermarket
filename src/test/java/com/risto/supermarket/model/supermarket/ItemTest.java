package com.risto.supermarket.model.supermarket;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ItemTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCanConstructSingleItem() {
		SingleItem soap = new SingleItem("Soap", new Money(1.00, "GBP"));
		assertEquals("Soap", soap.getName());
		assertEquals(1.00, soap.getPrice().getValue());
	}

	@Test
	public void testCanConstructWeightedItem() {
		WeightedItem bananas = new WeightedItem("Bananas", new Weight(1.2, "kg"), new Money(1.99, "GBP"));
		assertEquals("Bananas", bananas.getName());
		assertEquals(1.2, bananas.getWeight().getValue());
		assertEquals(1.99, bananas.getPrice().getValue());
	}

}
