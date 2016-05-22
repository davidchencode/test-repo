package com.shop.service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.junit.Before;
import org.junit.Test;

import com.shop.service.offer.AppleOffer;
import com.shop.service.offer.Offer;
import com.shop.service.offer.OrangeOffer;

import static org.junit.Assert.*;

public class CheckOutTest {
	CheckOut checkOut;
	
	@Before
	public void setUp(){
		checkOut = new CheckOutImp();
	}
	
	@Test
	public void testCalculateTotoalCostWithOffers(){
		List<String> purchasedProducts = Arrays.asList("Apple","Apple","Orange","Apple","Orange","Orange");
		Map<String,Offer> offers = new ConcurrentHashMap<>();
		offers.put("Apple", new AppleOffer());
		offers.put("Orange",new OrangeOffer());
		Double result = checkOut.calculateTotalCost(purchasedProducts,offers);
		Double expected = 1.7;
		assertEquals(expected, result);
	}
	
	@Test
	public void testCalculateTotoalCostWithNoOffers(){
		CheckOut checkOut = new CheckOutImp();
		List<String> purchasedProducts = Arrays.asList("Apple","Apple","Orange","Apple");
		Double result = checkOut.calculateTotalCost(purchasedProducts,null); //If there is no offer policy, then it's null
		Double expected = 2.05;
		assertEquals(expected, result);
	}
	

	public void tearDown(){
		checkOut = null;
	}

}
