package com.risto.supermarket.model.supermarket;

/**
 * Interface for supermarket items
 * @author Risto Laakso <risto.laakso@iki.fi>
 *
 */
public interface Item {
	
	/**
	 * Get item price
	 * @return
	 */
	public Money getPrice();

	/**
	 * Get item name
	 * @return
	 */
	public String getName();

	/**
	 * Set item weight
	 * @param weight
	 * @return
	 * @throws NonWeightableItemException 
	 */
	public Item setWeight(Weight weight) throws NonWeightableItemException;
}
