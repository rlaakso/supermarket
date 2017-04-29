package com.risto.supermarket.supermarket;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

import com.risto.supermarket.discount.DiscountImpl;
import com.risto.supermarket.discount.api.Discount;
import com.risto.supermarket.discount.api.DiscountCalculatorService;
import com.risto.supermarket.stock.api.Item;
import com.risto.supermarket.stock.api.Money;
import com.risto.supermarket.stock.api.NonWeightableItemException;
import com.risto.supermarket.stock.api.Weight;
import com.risto.supermarket.supermarket.api.ShoppingCart;
import com.risto.supermarket.supermarket.api.Supermarket;
import com.risto.supermarket.discount.DiscountCalculatorServiceImpl;

/**
 * Shopping cart for a supermarket
 * @author Risto Laakso <risto.laakso@iki.fi>
 *
 */
public class ShoppingCartImpl implements ShoppingCart {

	private final UUID id;
	
	// Supermarket this shopping cart belongs to
	private Supermarket supermarket;
	
	// Items in cart
	private List<Item> items = new ArrayList<Item>();
	
	private final DiscountCalculatorService discountCalculatorService;
	
	/**
	 * Create new supermarket
	 * @param supermarket
	 */
	protected ShoppingCartImpl(Supermarket s) {
		this.supermarket = s;
		this.id = UUID.randomUUID();
		discountCalculatorService = AppInjector.getInstance().getInstance(DiscountCalculatorService.class);
	}
	
	/* (non-Javadoc)
	 * @see com.risto.supermarket.supermarket.ShoppingCart#addItem(com.risto.supermarket.stock.api.Item)
	 */
	@Override
	public void addItem(Item item) {
		items.add(item);
	}

	/* (non-Javadoc)
	 * @see com.risto.supermarket.supermarket.ShoppingCart#addItem(com.risto.supermarket.stock.api.Item, com.risto.supermarket.stock.api.Weight)
	 */
	@Override
	public void addItem(Item itemByName, Weight weight) throws NonWeightableItemException {
		items.add(itemByName.setWeight(weight));
	}

	/* (non-Javadoc)
	 * @see com.risto.supermarket.supermarket.ShoppingCart#getItemCount()
	 */
	@Override
	public int getItemCount() {
		return items.size();
	}

	/* (non-Javadoc)
	 * @see com.risto.supermarket.supermarket.ShoppingCart#getItemCountByName(java.lang.String)
	 */
	@Override
	public int getItemCountByName(String itemName) {
		return (int) items.stream()
				.filter(item -> item.getName().equals(itemName))
				.count();
	}

	/* (non-Javadoc)
	 * @see com.risto.supermarket.supermarket.ShoppingCart#getSubTotal()
	 */
	@Override
	public Money getSubTotal() {
		if (items.size() == 0) {
			return Money.zero(supermarket.getCurrency());
		}
		return new Money(items.stream().mapToInt(item -> item.getPrice().getValue()).sum(), items.get(0).getPrice().getCurrency());
	}

	/* (non-Javadoc)
	 * @see com.risto.supermarket.supermarket.ShoppingCart#getSavingsTotal()
	 */
	@Override
	public Money getSavingsTotal() {

		Collection<Discount> discounts = supermarket.getDiscounts();
		
		if (discounts.size() == 0) {
			return Money.zero(supermarket.getCurrency());
		}

		int totalSavings = 0;
		for (Discount d : discounts) {
			List<Discount> applyingDiscounts = discountCalculatorService.calculateDiscountFor(this, d);
			int discountTotalValue = applyingDiscounts.stream().mapToInt(discount -> discount.getDiscountValue().getValue()).sum();
			totalSavings += discountTotalValue;
		}
		return new Money(totalSavings, discounts.iterator().next().getItemValue().getCurrency());
	}
	
	/* (non-Javadoc)
	 * @see com.risto.supermarket.supermarket.ShoppingCart#getSupermarket()
	 */
	@Override
	public Supermarket getSupermarket() {
		return supermarket;
	}

	/* (non-Javadoc)
	 * @see com.risto.supermarket.supermarket.ShoppingCart#getTotalToPay()
	 */
	@Override
	public Money getTotalToPay() {
		Money subTotal = getSubTotal();
		Money savings = getSavingsTotal();
		return new Money(subTotal.getValue() - savings.getValue(), subTotal.getCurrency());
	}
}
