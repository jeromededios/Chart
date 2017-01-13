package com.dedios.enm;

public enum DiscountCode {
	ONE("ONE"),TWO("TWO"),THREE("THREE"),FOUR("FOUR");
	
	private String value;
	 
	private DiscountCode(String value) {
		this.setValue(value);
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
