package com.dedios.util;

import java.math.*;
import java.util.*;

import com.dedios.chart.*;

public class ReadData {

	public static List<Item> loadData() {

		List<Item> lst = new ArrayList<>();

		Item i1 = new Item();
		i1.setId("1");
		i1.setProductCode("ult_small");
		i1.setProductName("Unlimited 1GB");
		i1.setProductPrice(new BigDecimal(24.90));

		Item i2 = new Item();
		i2.setId("2");
		i2.setProductCode("ult_medium");
		i2.setProductName("Unlimited 2GB");
		i2.setProductPrice(new BigDecimal(29.90));
		
		Item i3 = new Item();
		i3.setId("3");
		i3.setProductCode("ult_large");
		i3.setProductName("Unlimited 5GB");
		i3.setProductPrice(new BigDecimal(44.90));
		
		Item i4 = new Item();
		i4.setId("4");
		i4.setProductCode("1gb");
		i4.setProductName("1 GB Data-pack");
		i4.setProductPrice(new BigDecimal(9.90));

		lst.add(i1);
		lst.add(i2);
		lst.add(i3);
		lst.add(i4);
		
		return lst;
	}
}
