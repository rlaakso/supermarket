package com.risto.supermarket.stock;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.risto.supermarket.common.api.Money;
import com.risto.supermarket.stock.SingleItem;
import com.risto.supermarket.stock.WeightedItem;
import com.risto.supermarket.stock.api.NonWeightableItemException;
import com.risto.supermarket.stock.api.UnsupportedUnitException;
import com.risto.supermarket.stock.api.Weight;

public class ItemTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCanConstructSingleItem() {
		SingleItem soap = new SingleItem("Soap", new Money(100, "GBP"));
		assertEquals("Soap", soap.getName());
		assertEquals(100, soap.getPrice().getValue());
	}

	@Test(expected = NonWeightableItemException.class)
	public void testCannotSetWeightForSingleItem() throws NonWeightableItemException, UnsupportedUnitException {
		SingleItem soap = new SingleItem("Soap", new Money(100, "GBP"));
		soap.setWeight(new Weight(1.00, "kg"));
	}

	@Test
	public void testCanConstructWeightedItem() throws UnsupportedUnitException {
		WeightedItem bananas = new WeightedItem("Bananas", new Weight(1.2, "kg"), new Money(199, "GBP"));
		assertEquals("Bananas", bananas.getName());
		assertEquals(1.2, bananas.getWeight().getWeight(), 1e-5);
		assertEquals(239, bananas.getPrice().getValue());
	}
	
}
