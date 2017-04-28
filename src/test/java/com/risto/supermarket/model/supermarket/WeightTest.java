package com.risto.supermarket.model.supermarket;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class WeightTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCanConstructWeight() throws UnsupportedUnitException {
		Weight w = new Weight(1.200, "kg");
		assertEquals(1.200, w.getWeight(), 1e-5);
		assertEquals("kg", w.getUnit());
	}
	
	@Test(expected = UnsupportedUnitException.class)
	public void testCanOnlyConstructKgWeights() throws UnsupportedUnitException {
		Weight w = new Weight(1.200, "lbs");
	}

}