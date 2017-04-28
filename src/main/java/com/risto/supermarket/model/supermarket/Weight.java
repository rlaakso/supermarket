package com.risto.supermarket.model.supermarket;

/**
 * Class to represent weight
 * @author Risto Laakso <risto.laakso@iki.fi>
 *
 */
public final class Weight {

	// weight as double
	private final double weight;
	// unit e.g. kg
	private final String unit;
	
	/**
	 * Construct new weight. Only kg is supported.
	 * @param weight weight, eg 1.200
	 * @param unit unit eg kg
	 * @throws UnsupportedUnitException
	 */
	public Weight(double weight, String unit) throws UnsupportedUnitException {
		this.weight = weight;
		this.unit = unit;
		
		// suppport only kg for now
		if (!"kg".equals(unit)) {
			throw new UnsupportedUnitException("Only kg is supported");
		}
	}

	/**
	 * Return item weight
	 * @return
	 */
	public double getWeight() {
		return weight;
	}
	
	/**
	 * Return item unit
	 * @return
	 */
	public String getUnit() {
		return unit;
	}
}
