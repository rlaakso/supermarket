package com.risto.supermarket.stock.api;

import com.risto.supermarket.supermarket.api.SupermarketException;

public class UnsupportedUnitException extends SupermarketException {

	private static final long serialVersionUID = -4241529983152166215L;

	public UnsupportedUnitException(String message) {
		super(message);
	}

}
