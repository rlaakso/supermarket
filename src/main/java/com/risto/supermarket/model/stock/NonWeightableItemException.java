package com.risto.supermarket.model.stock;

import com.risto.supermarket.model.supermarket.SupermarketException;

public class NonWeightableItemException extends SupermarketException {

	private static final long serialVersionUID = 2763576992963013950L;

	public NonWeightableItemException(String message) {
		super(message);
	}

}
