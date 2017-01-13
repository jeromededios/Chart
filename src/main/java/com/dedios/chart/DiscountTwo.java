package com.dedios.chart;

import java.math.*;

public class DiscountTwo extends DiscountHandler{

	private static final String DISCOUNT_TWO_ID = "3";
	
	@Override
	public Cart handleRequest(Cart request) {
		
		BigDecimal discountPrice = new BigDecimal(39.90);
		
		BigDecimal lessPrice = new BigDecimal(0);
		
		Item item = request.getItems().stream().filter(i -> DISCOUNT_TWO_ID.equals(i.getId())).findAny().orElse(null);
		
		long countDiscountTwo = request.getItems().stream().filter(i -> DISCOUNT_TWO_ID.equals(i.getId())).count();
		
		lessPrice = item.getProductPrice().subtract(discountPrice);
		
		lessPrice = lessPrice.multiply(new BigDecimal(countDiscountTwo));
		
		request.setTotalPrice(request.total());
		
		request.setTotalPrice(request.getTotalPrice().subtract(lessPrice));
		
		return request;
	}



}
