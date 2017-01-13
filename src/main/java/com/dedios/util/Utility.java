package com.dedios.util;

import java.math.*;
import java.util.*;

import com.dedios.chart.*;
import com.dedios.enm.*;
import com.dedios.intfaces.*;

public class Utility {

	private List<Item> items;

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
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

	public static Cart addItem(List<Item> lstItems, Cart cart) {

		lstItems.stream().forEach(i -> {
			System.out.println("------------------------");
			System.out.println("Product ID Number: " + i.getId());
			System.out.println("Product Code : " + i.getProductCode());
			System.out.println("Product Name : " + i.getProductName());
			System.out.println("Product Price : " + i.getProductPrice());
			System.out.println("------------------------");
		});

		System.out.print("Select ID Number:");

		String idNumber = System.console().readLine();

		System.out.println("");

		System.out.print("Quantity:");

		String quantity = System.console().readLine();
		
		System.out.print("Do you want to add promo code I<3AMAYSIM [Y/N]:");

		String rep = System.console().readLine();
		
		if("Y".equalsIgnoreCase(rep))
				cart.setTenPercentDiscount(Boolean.TRUE);

		Item item = lstItems.stream().filter(i -> idNumber.equals(i.getId())).findAny().orElse(null);

		for (int j = 0; j < Integer.parseInt(quantity); j++) {
			cart.addItem(item);
		}

		return cart;
	}

	public static Cart removeItem(List<Item> lstItems, Cart cart) {

		cart.getItems().stream().forEach(i -> {
			System.out.println("------------------------");
			System.out.println("Product ID Number: " + i.getId());
			System.out.println("Product Code : " + i.getProductCode());
			System.out.println("Product Name : " + i.getProductName());
			System.out.println("Product Price : " + i.getProductPrice());
			System.out.println("------------------------");
		});

		System.out.print("Select ID Number:");

		String idNumber = System.console().readLine();

		System.out.println("");

		System.out.print("Quantity:");

		String quantity = System.console().readLine();

		Item item = lstItems.stream().filter(i -> idNumber.equals(i.getId())).findAny().orElse(null);

		for (int j = 0; j < Integer.parseInt(quantity); j++) {
			cart.removeItem(item);
		}

		return cart;
	}

	public static void listItems(List<Item> lstItems, Cart cart) {
		cart.getItems().stream().forEach(i -> {
			System.out.println("------------------------");
			System.out.println("Product ID Number: " + i.getId());
			System.out.println("Product Code : " + i.getProductCode());
			System.out.println("Product Name : " + i.getProductName());
			System.out.println("Product Price : " + i.getProductPrice());
			System.out.println("------------------------");
		});
	}
	
	public static Cart totalPrice(Cart cart) {
		DiscountFactory df = new DiscountFactory();
		IPricingRules iPricingRules = df.getDiscount(DiscountCode.ONE.getValue());
		
		cart = iPricingRules.getPricingRules(cart);
		
		return cart;
	}
	
	public static void printTotalPrice(Cart cart){
		Cart c = totalPrice(cart);
		System.out.println("Total Price is " + c.getTotalPrice().setScale(2, RoundingMode.CEILING));
	}

	public static Cart clearItems(Cart cart) {
		cart.clearItems();
		return cart;
	}

	public static Cart selectOPtion(String select, List<Item> lstItems, Cart cart) {

		switch (select) {
		case "1":
			cart = addItem(lstItems, cart);
			break;
		case "2":
			cart = removeItem(lstItems, cart);
			break;
		case "3":
			listItems(lstItems, cart);
			break;
		case "4":
			printTotalPrice(cart);
			break;
		case "5":
			cart = clearItems(cart);
			break;
		default:
			break;
		}

		return cart;
	}
}
