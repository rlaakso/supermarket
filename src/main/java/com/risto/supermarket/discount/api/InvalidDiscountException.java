package com.risto.supermarket.discount.api;

import com.risto.supermarket.supermarket.api.SupermarketException;

public class InvalidDiscountException extends SupermarketException {

	private static final long serialVersionUID = 1675054702862287080L;

	public InvalidDiscountException(String message) {
		super(message);
	}

}
