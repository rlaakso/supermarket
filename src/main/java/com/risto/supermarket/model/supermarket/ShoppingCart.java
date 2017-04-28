package com.risto.supermarket.model.supermarket;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.risto.supermarket.model.discount.AbstractDiscount;
import com.risto.supermarket.model.discount.DiscountCalculatorService;
import com.risto.supermarket.model.stock.Item;
import com.risto.supermarket.model.stock.Money;
import com.risto.supermarket.model.stock.NonWeightableItemException;
import com.risto.supermarket.model.stock.Weight;

/**
 * Shopping cart for a supermarket
 * @author Risto Laakso <risto.laakso@iki.fi>
 *
 */
public class ShoppingCart {

	// Supermarket this shopping cart belongs to
	private Supermarket supermarket;
	
	// Items in cart
	private List<Item> items = new ArrayList<Item>();
	
	/**
	 * Create new supermarket
	 * @param supermarket
	 */
	protected ShoppingCart(Supermarket supermarket) {
		this.supermarket = supermarket;
	}

	/**
	 * Add item to cart
	 * @param item
	 */
	public void addItem(Item item) {
		items.add(item);
	}

	/**
	 * Add item to cart with weight
	 * @param itemByName
	 * @param weight
	 * @throws NonWeightableItemException 
	 */
	public void addItem(Item itemByName, Weight weight) throws NonWeightableItemException {
		items.add(itemByName.setWeight(weight));
	}

	/**
	 * Get number of items in cart
	 * @return
	 */
	public int getItemCount() {
		return items.size();
	}

	/**
	 * Get number of specific items in cart
	 * @param itemName
	 * @return
	 */
	public int getItemCountByName(String itemName) {
		return (int) items.stream()
				.filter(item -> item.getName().equals(itemName))
				.count();
	}

	/**
	 * Get cart sub-total
	 * @return
	 */
	public Money getSubTotal() {
		if (items.size() == 0) {
			return Money.zero(supermarket.getCurrency());
		}
		return new Money(items.stream().mapToInt(item -> item.getPrice().getValue()).sum(), items.get(0).getPrice().getCurrency());
	}

	/**
	 * Get cart total savings
	 * @return
	 */
	public Money getSavingsTotal() {

		Collection<AbstractDiscount> discounts = supermarket.getDiscounts();
		
		if (discounts.size() == 0) {
			return Money.zero(supermarket.getCurrency());
		}

		int totalSavings = 0;
		for (AbstractDiscount d : discounts) {
			List<AbstractDiscount> applyingDiscounts = DiscountCalculatorService.calculateDiscountFor(this, d);
			int discountTotalValue = applyingDiscounts.stream().mapToInt(discount -> discount.getDiscountValue().getValue()).sum();
			totalSavings += discountTotalValue;
		}
		return new Money(totalSavings, discounts.iterator().next().getItemValue().getCurrency());
	}
	
	/**
	 * Get supermarket this cart belongs to
	 * @return
	 */
	public Supermarket getSupermarket() {
		return supermarket;
	}

	/**
	 * Get shopping cart total to pay
	 * @return
	 */
	public Money getTotalToPay() {
		Money subTotal = getSubTotal();
		Money savings = getSavingsTotal();
		return new Money(subTotal.getValue() - savings.getValue(), subTotal.getCurrency());
	}
}
