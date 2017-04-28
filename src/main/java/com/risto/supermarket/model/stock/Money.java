package com.risto.supermarket.model.stock;

/**
 * Class for Money value object
 * @author Risto Laakso <risto.laakso@iki.fi>
 *
 */
public final class Money {

	// Value in pennies/cents, e.g. 100 for £1.00
	private final int value;
	// ISO 4217 currency, e.g. GBP
	private final String currency;
		
	/**
	 * Construct new immutable money value object
	 * @param value Monetary value in pennies/cents, e.g. 100 for £1.00
	 * @param currency ISO 4217 currency code, e.g. GBP
	 */
	public Money(int value, String currency) {
		this.value = value;
		this.currency = currency;
		
		// TODO maybe check that currency is one of supported ones, e.g. limit to GBP, EUR, USD ?
	}

	/**
	 * Get value in pennies/cents
	 * @return
	 */
	public int getValue() {
		return value;
	}
	
	/**
	 * Get ISO 4217 currency code, e.g. GBP
	 * @return
	 */
	public String getCurrency() {
		return currency;
	}
	
	/**
	 * Add monetary value to current value
	 * @param addition
	 * @return
	 */
	public Money add(int addition) {
		return new Money(this.value + addition, this.currency);
	}

	/**
	 * Multiply money value by a factor
	 * @param factor
	 * @return
	 */
	public Money multiply(double factor) {
		return new Money((int) Math.round(this.value * factor), this.currency);
	}

	/**
	 * Construct zero monetary value.
	 * @param currency
	 * @return
	 */
	public static Money zero(String currency) {
		return new Money(0, currency);
	}
}
