package com.dedios.chart;

public class DiscountOne extends DiscountHandler{

	private static final String DISCOUNT_ONE_ID = "1";
	
	@Override
	public Cart handleRequest(Cart request) {
		
		Item item = request.getItems().stream().filter(i -> DISCOUNT_ONE_ID.equals(i.getId())).findAny().orElse(null);
		
		request.setTotalPrice(request.total());
		
		request.setTotalPrice(request.getTotalPrice().subtract(item.getProductPrice()));
		
		return request;
	}


}
