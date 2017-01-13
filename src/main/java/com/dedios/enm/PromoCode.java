package com.dedios.enm;

public enum PromoCode {
	AMAYSIM_Iless3("I<3AMAYSI");
	
	private String value;
	 
	private PromoCode(String value) {
		this.setValue(value);
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
