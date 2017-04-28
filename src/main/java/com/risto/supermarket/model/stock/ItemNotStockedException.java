package com.risto.supermarket.model.stock;

import com.risto.supermarket.model.supermarket.SupermarketException;

public class ItemNotStockedException extends SupermarketException {

	private static final long serialVersionUID = -3682545678070396888L;

	public ItemNotStockedException(String message) {
		super(message);
	}
	
}
