package com.dedios.chart;

import java.util.*;

import com.dedios.intfaces.*;

public class PricingRuleOne implements IPricingRules {

	private static final String DISCOUNT_ONE_ID = "1";
	private static final String DISCOUNT_TWO_ID = "3";
	private static final String DISCOUNT_THREE_ID = "2";
	
	@Override
	public Cart getPricingRules(Cart cart) {
		
		List<DiscountHandler> lstOfDiscounts = new ArrayList<>();
		
		long countDiscountOne = cart.getItems().stream().filter(i -> DISCOUNT_ONE_ID.equals(i.getId())).count();
		long countDiscountTwo = cart.getItems().stream().filter(i -> DISCOUNT_TWO_ID.equals(i.getId())).count();
		long countDiscountThree = cart.getItems().stream().filter(i -> DISCOUNT_THREE_ID.equals(i.getId())).count();
		
		if(countDiscountOne >= 3)
			lstOfDiscounts.add(new DiscountOne());
		
		if(countDiscountTwo >= 3)
			lstOfDiscounts.add(new DiscountTwo());
		
		if(countDiscountThree > 0)
			lstOfDiscounts.add(new DiscountThree());
		
		if(cart.isTenPercentDiscount())
			lstOfDiscounts.add(new DiscountFour());
		
		
		for (DiscountHandler discountHandler : lstOfDiscounts) {
			cart = discountHandler.handleRequest(cart);
		}
		
		return cart;
	}

}
