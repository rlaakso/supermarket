package com.risto.supermarket.stock.api;

import com.risto.supermarket.supermarket.api.SupermarketException;

public class ItemNotStockedException extends SupermarketException {

	private static final long serialVersionUID = -3682545678070396888L;

	public ItemNotStockedException(String message) {
		super(message);
	}
	
}
