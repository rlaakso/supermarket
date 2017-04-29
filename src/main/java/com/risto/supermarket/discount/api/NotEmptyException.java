package com.risto.supermarket.discount.api;

public class NotEmptyException extends Exception {

	private static final long serialVersionUID = -5121671538350826479L;

	public NotEmptyException(String message) {
		super(message);
	}
}
