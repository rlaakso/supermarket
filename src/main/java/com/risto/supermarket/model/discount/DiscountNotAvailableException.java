package com.risto.supermarket.model.discount;

import com.risto.supermarket.model.supermarket.SupermarketException;

public class DiscountNotAvailableException extends SupermarketException {

	private static final long serialVersionUID = 4061965192577566330L;

	public DiscountNotAvailableException(String message) {
		super(message);
	}
	
}
