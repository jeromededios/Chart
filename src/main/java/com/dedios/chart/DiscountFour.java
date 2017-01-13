package com.dedios.chart;

import java.math.*;

public class DiscountFour extends DiscountHandler{

	@Override
	public Cart handleRequest(Cart request) {
		
		BigDecimal total = request.total();
		BigDecimal totalTenPercent = new BigDecimal(0);
		
		totalTenPercent = total.multiply(new BigDecimal(0.10));
		total = total.subtract(totalTenPercent);
		
		request.setTotalPrice(total);
		
		return request;
	}

}
