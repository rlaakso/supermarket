package com.risto.supermarket.model.supermarket;

/**
 * Class to represent weighted items, e.g. bananas
 * @author Risto Laakso <risto.laakso@iki.fi>
 *
 */
public final class WeightedItem implements Item {

	// item name
	private final String name;
	
	// item weight
	private final Weight weight;
	
	// item price
	private final Money price;
	
	/**
	 * Construct new weighted item
	 * @param name item name
	 * @param weight item weight
	 * @param price item price
	 */
	public WeightedItem(String name, Weight weight, Money price) {
		this.name = name;
		this.weight = weight;
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
	 * Get item weight
	 * @return
	 */
	public Weight getWeight() {
		return weight;
	}
	
	/**
	 * Get item price
	 * @return
	 */
	public Money getPrice() {
		return price;
	}

}
