package com.dedios.chart;

import java.math.*;
import java.util.*;

import com.dedios.enm.*;

public class Cart{

	private List<Item> items;
	
	private boolean tenPercentDiscount  = Boolean.FALSE;
	
	private BigDecimal totalPrice = new BigDecimal(0);

	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Cart() {
		items = new ArrayList<Item>();
	}

	public void addItem(Item item) {
		items.add(item);
	}

	public void addItemPromo(Item item, PromoCode promo) {
		if(promo.getValue().equalsIgnoreCase(PromoCode.AMAYSIM_Iless3.getValue()))
			tenPercentDiscount = Boolean.TRUE;
		items.add(item);
	}

	public boolean isTenPercentDiscount() {
		return tenPercentDiscount;
	}

	public void setTenPercentDiscount(boolean tenPercentDiscount) {
		this.tenPercentDiscount = tenPercentDiscount;
	}

	public Integer getTotalItems() {
		return items.size();
	}

	
	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public void removeItem(Item item) {
		this.items.remove(item);
	}

	public BigDecimal total() {
		return items.stream()
				.map(Item::getProductPrice)
				.reduce(BigDecimal.ZERO, BigDecimal::add);
	}

	public void items() {
		this.items.stream().forEach(i -> {
			System.out.println("------------------------");
			System.out.println("Product Code : " + i.getProductCode());
			System.out.println("Product Name : " + i.getProductName());
			System.out.println("Product Price : " + i.getProductPrice());
			System.out.println("------------------------");
		});
	}

	public void clearItems() {
		items = new ArrayList<Item>();
	}
}
