package com.risto.supermarket.model.stock;

import com.risto.supermarket.model.supermarket.SupermarketException;

public class UnsupportedUnitException extends SupermarketException {

	private static final long serialVersionUID = -4241529983152166215L;

	public UnsupportedUnitException(String message) {
		super(message);
	}

}
