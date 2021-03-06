package com.shop.service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.shop.service.offer.AppleOffer;
import com.shop.service.offer.Offer;
import com.shop.service.offer.OrangeOffer;

public class CheckOutImp implements CheckOut {

	@Override
	public Double calculateTotalCost(List<String> purchasedProducts, Map<String, Offer> offers) {
		Double totalCost = 0.0;
		Map<String, Integer>purchasedProductMap = new ConcurrentHashMap<>();
				
		for(String productItem : purchasedProducts){
			switch(productItem){
			case "Apple":	
				if(purchasedProductMap.containsKey(productItem)){
					int appleAmount = purchasedProductMap.get(productItem);
					purchasedProductMap.put(productItem, appleAmount+1);
				}else{
				   purchasedProductMap.put(productItem, 1);
				}
				break;
			case "Orange":
				if(purchasedProductMap.containsKey(productItem)){
					int orangeAmount = purchasedProductMap.get(productItem);
					purchasedProductMap.put(productItem, orangeAmount+1);
				}else {
				    purchasedProductMap.put(productItem, 1);		
				}
		    	break;				
			}			
	
		}
		
		for(Map.Entry<String, Integer> entry : purchasedProductMap.entrySet()){
			switch(entry.getKey()){
			case "Apple":			
				if(offers!= null && offers.containsKey(entry.getKey())){
					totalCost = totalCost + new AppleOffer().offerPolicy(entry.getValue());
				}else{
					totalCost = totalCost+entry.getValue()* ProductOriginalPrice.Apple;
				}
				break;
			case "Orange":
				if(offers!= null && offers.containsKey(entry.getKey())){
					totalCost=totalCost + new OrangeOffer().offerPolicy(entry.getValue());
				}else {
				    totalCost = totalCost+entry.getValue()*ProductOriginalPrice.Orange;
				}
				break;
			
			}
		}
		
		return totalCost;
		
		

	}



}
