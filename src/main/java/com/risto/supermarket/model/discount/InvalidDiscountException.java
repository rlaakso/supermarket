package com.risto.supermarket.model.discount;

import com.risto.supermarket.model.supermarket.SupermarketException;

public class InvalidDiscountException extends SupermarketException {

	private static final long serialVersionUID = 1675054702862287080L;

	public InvalidDiscountException(String message) {
		super(message);
	}

}
