package com.risto.supermarket.discount.api;

import com.risto.supermarket.supermarket.api.SupermarketException;

public class DiscountNotAvailableException extends SupermarketException {

	private static final long serialVersionUID = 4061965192577566330L;

	public DiscountNotAvailableException(String message) {
		super(message);
	}
	
}
