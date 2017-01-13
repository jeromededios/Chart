package com.dedios.chart;

import java.io.*;
import java.util.*;

import com.dedios.util.*;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) throws IOException {
		String input = "";

		Cart cart = new Cart();

		List<Item> lstItemsLoaded = ReadData.loadData();

		while (!input.equals("6")) {

			System.out.println("|1| Add Item");
			System.out.println("|2| Remove Item");
			System.out.println("|3| View Items");
			System.out.println("|4| Total Price");
			System.out.println("|5| Clear Items");
			System.out.println("|6| Exit");

			System.out.print("Select:");

			input = System.console().readLine();

			cart = Utility.selectOPtion(input, lstItemsLoaded, cart);

			if (!input.equals("6")) {
				System.out.println("Press Enter to Continue....");
				System.console().readLine();
			}

		}

	}
}
