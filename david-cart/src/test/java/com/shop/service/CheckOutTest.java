package com.shop.service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class CheckOutTest {
	CheckOut checkOut;
	
	@Before
	public void setUp(){
		checkOut = new CheckOutImp();
	}
	
	@Test
	public void testCalculateTotoalCost(){
		CheckOut checkOut = new CheckOutImp();
		List<String> purchasedProducts = Arrays.asList("Apple","Apple","Orange","Apple");
		Double result = checkOut.calculateTotalCost(purchasedProducts);
		Double expected = 2.05;
		assertEquals(expected, result);
	}
	

	public void tearDown(){
		checkOut = null;
	}

}
