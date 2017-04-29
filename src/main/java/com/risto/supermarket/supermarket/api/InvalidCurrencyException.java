package com.risto.supermarket.supermarket.api;

public class InvalidCurrencyException extends SupermarketException {

	private static final long serialVersionUID = -9032239047623508850L;

	public InvalidCurrencyException(String message) {
		super(message);
	}

}
