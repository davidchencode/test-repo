package com.shop.service.offer;

import com.shop.service.ProductOriginalPrice;

public class OrangeOffer implements Offer {
	   //3 for the price of 2 on Oranges
		@Override
		public Double offerPolicy(Integer value) {
			double offerPrice = (value/3)*ProductOriginalPrice.Orange*2 + (value%3)*ProductOriginalPrice.Orange;
			return offerPrice;
		}


}
