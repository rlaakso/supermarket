package com.risto.supermarket.shoppingcart;

import com.risto.supermarket.shoppingcart.api.ShoppingCart;
import com.risto.supermarket.shoppingcart.api.ShoppingCartService;
import com.risto.supermarket.supermarket.api.Supermarket;

/**
 * Shopping cart service implementation
 * @author Risto Laakso <risto.laakso@iki.fi>
 *
 */
public class ShoppingCartServiceImpl implements ShoppingCartService {

	@Override
	public ShoppingCart create(Supermarket s) {
		return new ShoppingCartImpl(s);
	}
}
