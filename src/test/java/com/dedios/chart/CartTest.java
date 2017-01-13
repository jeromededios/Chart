package com.dedios.chart;

import java.math.*;
import java.util.*;

import org.junit.*;

import com.dedios.enm.*;
import com.dedios.util.*;

public class CartTest {

	Cart cart;
	
    @BeforeClass
    public static void runOnceBeforeClass() {
        System.out.println("@BeforeClass - CartTest-------------------------------");
        
    }

    @AfterClass
    public static void runOnceAfterClass() {
        System.out.println("@AfterClass - CartTest-------------------------------");
    }

    @Before
    public void runBeforeTestMethod() {
        System.out.println("[	@Before - Test methods	]");
        cart = new Cart();
    }

    @After
    public void runAfterTestMethod() {
        System.out.println("[	@After - Test methods	]");
    }
    
    @Test
    public void testAddItem() {
        System.out.println("@Test - testAddItem");
        
		Item item = new Item();
			item.setProductName("Unlimited 1GB");
			item.setProductCode("ult_small ");
			item.setProductPrice(new BigDecimal(24.90));
		
		cart.addItem(item);
		
        cart.items();
        
		Assert.assertEquals(cart.getTotalItems(), Integer.valueOf(1));
		
		Assert.assertEquals(cart.getItems().get(0).getProductName(), item.getProductName());
		
    }
    
    @Test
    public void testAddItemsWithCode() {
        System.out.println("@Test - testAddItemsWithCode");
        
		Item item = new Item();
			item.setProductName("Unlimited 1GB");
			item.setProductCode("ult_small ");
			item.setProductPrice(new BigDecimal(24.90));
		
		cart.addItemPromo(item,PromoCode.AMAYSIM_Iless3);
		
		Assert.assertEquals(cart.getTotalItems(), Integer.valueOf(1));
		
		Assert.assertEquals(cart.getItems().get(0).getProductName(), item.getProductName());
    }
    
    @Test
    public void testCalculateTotal() {

        System.out.println("@Test - testRemoveItem");
        
		Item item1 = new Item();
			item1.setProductName("Unlimited 1GB");
			item1.setProductCode("ult_small ");
			item1.setProductPrice(new BigDecimal(24.90));
			
		Item item2 = new Item();
			item2.setProductName("Unlimited 2GB");
			item2.setProductCode("ult_medium ");
			item2.setProductPrice(new BigDecimal(29.90));
			
    	//Invoke items
		cart.addItem(item1);
		cart.addItem(item2);
		
		BigDecimal tot = new BigDecimal("0");
		
		tot = tot.add(item1.getProductPrice()).add(item2.getProductPrice());
			
		Assert.assertEquals(cart.total(), tot);
    }
    
    @Test
    public void testRemoveItem() {

        System.out.println("@Test - testRemoveItem");
        
		Item item = new Item();
			item.setProductName("Unlimited 1GB");
			item.setProductCode("ult_small ");
			item.setProductPrice(new BigDecimal(24.90));
			
    	//Invoke testAddItem method
		cart.addItem(item);
			
		cart.removeItem(item);
		
		Assert.assertEquals(cart.getTotalItems(), Integer.valueOf(0));
    }
    
    @Test
    public void testClearItems() {

        System.out.println("@Test - testClearItems");
    	//Invoke testAddItem method
		cart.clearItems();
		
		Assert.assertEquals(cart.getTotalItems(), Integer.valueOf(0));
    }
     
    
    @Test
    public void testScenarioOne() {
        System.out.println("@Test - testScenarioOce");
      
        Cart cart1 = new Cart();
        
		Item item = new Item();
				item.setId("1");
				item.setProductName("Unlimited 1GB");
				item.setProductCode("ult_small ");
				item.setProductPrice(new BigDecimal(24.90));
		
		for (int i = 0; i < 3; i++) {
			cart1.addItem(item);
		}
		
		Item i3 = new Item();
				i3.setId("3");
				i3.setProductCode("ult_large");
				i3.setProductName("Unlimited 5GB");
				i3.setProductPrice(new BigDecimal(44.90));
				
			cart1.addItem(i3);
		
			cart1 = Utility.totalPrice(cart1);
		
		long one = cart1.getItems().stream().filter(i -> "1".equals(i.getId())).count();
		
		long two = cart1.getItems().stream().filter(i -> "3".equals(i.getId())).count();
		
		Assert.assertEquals(cart1.getTotalPrice().setScale(2, RoundingMode.CEILING), new BigDecimal(94.70).setScale(2, RoundingMode.FLOOR));
		
		Assert.assertEquals(one, 3);
		
		Assert.assertEquals(two, 1);
    }

    @Test
    public void testScenarioTwo() {
        System.out.println("@Test - testScenarioTwo");
        
        Cart cart1 = new Cart();
        
		Item item = new Item();
				item.setId("1");
				item.setProductName("Unlimited 1GB");
				item.setProductCode("ult_small ");
				item.setProductPrice(new BigDecimal(24.90));
		
		for (int i = 0; i < 2; i++) {
			cart1.addItem(item);
		}
		
		Item i3 = new Item();
				i3.setId("3");
				i3.setProductCode("ult_large");
				i3.setProductName("Unlimited 5GB");
				i3.setProductPrice(new BigDecimal(44.90));
				
		for (int i = 0; i < 4; i++) {
			cart1.addItem(i3);
		}
		
		cart1 = Utility.totalPrice(cart1);
		
		long one = cart1.getItems().stream().filter(i -> "1".equals(i.getId())).count();
		
		long two = cart1.getItems().stream().filter(i -> "3".equals(i.getId())).count();
		
		Assert.assertEquals(cart1.getTotalPrice().setScale(2, RoundingMode.CEILING), new BigDecimal(209.40).setScale(2, RoundingMode.FLOOR));
		
		Assert.assertEquals(one, 2);
		
		Assert.assertEquals(two, 4);
    }
    
    @Test
    public void testScenarioThree() {
        System.out.println("@Test - testScenarioThree");
        
        Cart cart1 = new Cart();
        
		Item item = new Item();
				item.setId("1");
				item.setProductName("Unlimited 1GB");
				item.setProductCode("ult_small ");
				item.setProductPrice(new BigDecimal(24.90));
		

		cart1.addItem(item);

		
		Item i2 = new Item();
				i2.setId("2");
				i2.setProductCode("ult_medium");
				i2.setProductName("Unlimited 2GB");
				i2.setProductPrice(new BigDecimal(29.90));
				
		for (int i = 0; i < 2; i++) {
			cart1.addItem(i2);
		}
		
		cart1 = Utility.totalPrice(cart1);
		
		long one = cart1.getItems().stream().filter(i -> "1".equals(i.getId())).count();
		
		long two = cart1.getItems().stream().filter(i -> "2".equals(i.getId())).count();
		
		long three = cart1.getItems().stream().filter(i -> "4".equals(i.getId())).count();
		
		Assert.assertEquals(cart1.getTotalPrice().setScale(2, RoundingMode.CEILING), new BigDecimal(84.70).setScale(2, RoundingMode.FLOOR));
		
		Assert.assertEquals(one, 1);
		
		Assert.assertEquals(two, 2);
		
		Assert.assertEquals(three, 2);
    }
    
    @Test
    public  void testScenarioFour() {
        System.out.println("@Test - testScenarioFour");
        
        Cart cart1 = new Cart();
        
   		Item item = new Item();
   				item.setId("1");
   				item.setProductName("Unlimited 1GB");
   				item.setProductCode("ult_small ");
   				item.setProductPrice(new BigDecimal(24.90));
   		

   		cart1.addItem(item);

   		
   		Item i2 = new Item();
   				i2.setId("4");
   				i2.setProductCode("1gb");
   				i2.setProductName("1 GB Data-pack");
   				i2.setProductPrice(new BigDecimal(9.90));
   				
		cart1.addItem(i2);

		cart1.setTenPercentDiscount(Boolean.TRUE);
   		
   		cart1 = Utility.totalPrice(cart1);
   		
   		long one = cart1.getItems().stream().filter(i -> "1".equals(i.getId())).count();
   		
   		long three = cart1.getItems().stream().filter(i -> "4".equals(i.getId())).count();
   		
   		Assert.assertEquals(cart1.getTotalPrice().setScale(2, RoundingMode.CEILING), new BigDecimal(31.32).setScale(2, RoundingMode.FLOOR));
   		
   		Assert.assertEquals(one, 1);
   
   		Assert.assertEquals(three, 1);
    }
    
    
   //public static void main(String[] args) {
	   //testScenarioFour();
	//}
}
