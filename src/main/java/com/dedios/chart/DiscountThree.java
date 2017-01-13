package com.dedios.chart;

import java.math.*;

public class DiscountThree extends DiscountHandler{
	
	private static final String DISCOUNT_THREE_ID = "2";
	
	@Override
	public Cart handleRequest(Cart request) {

		long countDiscountThree = request.getItems().stream().filter(i -> DISCOUNT_THREE_ID.equals(i.getId())).count();
		
		Item i4 = new Item();
				i4.setId("4");
				i4.setProductCode("1gb");
				i4.setProductName("1 GB Data-pack");
				i4.setProductPrice(new BigDecimal(0.0));
		
		for (int i = 0; i < countDiscountThree; i++) {
			request.addItem(i4);
		}
		
		request.setTotalPrice(request.total());
		
		return request;
	}
}
