package com.shop.service;

import java.util.List;

public class CheckOutImp implements CheckOut {

	public Double calculateTotalCost(List<String> purchasedProducts) {
		Double totalCost = 0.0;
		for(String productItem : purchasedProducts){
			switch(productItem){
			case "Apple":	
				totalCost = totalCost + ProductOriginalPrice.Apple;
				break;
			case "Orange":
				totalCost = totalCost + ProductOriginalPrice.Orange;			
		    	break;				
			}				
		}
		return totalCost;
	}

}
