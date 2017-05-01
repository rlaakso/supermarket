package com.risto.supermarket.shoppingcart.api;

import com.risto.supermarket.supermarket.api.Supermarket;

/**
 * Shopping cart service API
 * @author Risto Laakso <risto.laakso@iki.fi>
 *
 */
public interface ShoppingCartService {

	/**
	 * Create a new shopping cart
	 * @param s
	 * @return
	 */
	ShoppingCart create(Supermarket s);
}
