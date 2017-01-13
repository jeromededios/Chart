package com.dedios.chart;

public abstract class DiscountHandler {

	DiscountHandler successor;

	public void setSuccessor(DiscountHandler successor) {
		this.successor = successor;
	}

	public abstract Cart handleRequest(Cart request);

}
