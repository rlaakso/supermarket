package com.risto.supermarket.supermarket.api;

import com.risto.supermarket.stock.api.Item;
import com.risto.supermarket.stock.api.Money;
import com.risto.supermarket.stock.api.NonWeightableItemException;
import com.risto.supermarket.stock.api.Weight;

/**
 * Shopping cart API
 * @author Risto Laakso <risto.laakso@iki.fi>
 *
 */
public interface ShoppingCart {
	
	/**
	 * Add item to cart
	 * @param item
	 */
	void addItem(Item item);

	/**
	 * Add item to cart with weight
	 * @param itemByName
	 * @param weight
	 * @throws NonWeightableItemException 
	 */
	void addItem(Item itemByName, Weight weight) throws NonWeightableItemException;

	/**
	 * Get number of items in cart
	 * @return
	 */
	int getItemCount();

	/**
	 * Get number of specific items in cart
	 * @param itemName
	 * @return
	 */
	int getItemCountByName(String itemName);

	/**
	 * Get cart sub-total
	 * @return
	 */
	Money getSubTotal();

	/**
	 * Get cart total savings
	 * @return
	 */
	Money getSavingsTotal();

	/**
	 * Get supermarket this cart belongs to
	 * @return
	 */
	Supermarket getSupermarket();

	/**
	 * Get shopping cart total to pay
	 * @return
	 */
	Money getTotalToPay();

}