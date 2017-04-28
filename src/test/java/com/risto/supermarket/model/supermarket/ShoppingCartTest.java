package com.risto.supermarket.model.supermarket;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.risto.supermarket.model.supermarket.InvalidDiscountException;
import com.risto.supermarket.model.supermarket.ShoppingCart;
import com.risto.supermarket.model.supermarket.Supermarket;
import com.risto.supermarket.model.supermarket.UnsupportedUnitException;

public class ShoppingCartTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCanConstructShoppingCart() throws UnsupportedUnitException, InvalidDiscountException {
		Supermarket s = SupermarketFactory.createSupermarket();
		ShoppingCart sc = s.createShoppingCart();
	}
	
	private void populateCart(ShoppingCart sc, Supermarket s) throws ItemNotStockedException, NonWeightableItemException, UnsupportedUnitException {
		sc.addItem(s.getItemByName("Beans"));
		sc.addItem(s.getItemByName("Beans"));
		sc.addItem(s.getItemByName("Beans"));
		sc.addItem(s.getItemByName("Coke"));
		sc.addItem(s.getItemByName("Coke"));
		sc.addItem(s.getItemByName("Oranges"), new Weight(0.200, "kg"));
	}
	
	@Test
	public void testCanAddItemsToCart() throws UnsupportedUnitException, InvalidDiscountException, ItemNotStockedException, NonWeightableItemException {		
		Supermarket s = SupermarketFactory.createSupermarket();
		
		ShoppingCart sc = s.createShoppingCart();
		populateCart(sc, s);
		
		assertEquals(6, sc.getItemCount());
		assertEquals(3, sc.getItemCountByName("Beans"));
		assertEquals(2, sc.getItemCountByName("Coke"));
		assertEquals(1, sc.getItemCountByName("Oranges"));
	}
	
	@Test
	public void testCanCreateCartBill() throws UnsupportedUnitException, InvalidDiscountException, ItemNotStockedException, NonWeightableItemException {		
		Supermarket s = SupermarketFactory.createSupermarket();
		
		ShoppingCart sc = s.createShoppingCart();
		populateCart(sc, s);

		int subTotal = sc.getSubTotal();
		assertEquals(330, subTotal);
	}
	
}
