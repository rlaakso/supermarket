package com.risto.supermarket.stock.api;

import com.risto.supermarket.supermarket.api.SupermarketException;

public class NonWeightableItemException extends SupermarketException {

	private static final long serialVersionUID = 2763576992963013950L;

	public NonWeightableItemException(String message) {
		super(message);
	}

}
