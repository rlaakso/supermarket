package com.risto.supermarket.stock;

import com.risto.supermarket.common.api.Money;
import com.risto.supermarket.stock.api.Item;
import com.risto.supermarket.stock.api.NonWeightableItemException;
import com.risto.supermarket.stock.api.Weight;

/**
 * Class to represent items that are sold as wholes.
 * 
 * @author Risto Laakso <risto.laakso@iki.fi>
 *
 */
final class SingleItem implements Item {

	// item name
	private final String name;
	
	// item price
	private final Money price;
	
	/**
	 * Construct a new single item
	 * @param name item name
	 * @param price item price
	 */
	public SingleItem(String name, Money price) {
		this.name = name;
		this.price = price;
	}

	/**
	 * Get item name
	 * @return
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Get item price
	 * @return
	 */
	public Money getPrice() {
		return price;
	}

	@Override
	public Item setWeight(Weight weight) throws NonWeightableItemException {
		throw new NonWeightableItemException("Cannot set weight for single items");
	}
}
