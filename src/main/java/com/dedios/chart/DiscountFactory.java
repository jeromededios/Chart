package com.dedios.chart;

import com.dedios.enm.*;
import com.dedios.intfaces.*;

public class DiscountFactory {

	public IPricingRules getDiscount(String pricingRule) {

		if (pricingRule.equalsIgnoreCase(DiscountCode.ONE.getValue())) {
				return new PricingRuleOne();
		}
		
		return null;
	}
}
