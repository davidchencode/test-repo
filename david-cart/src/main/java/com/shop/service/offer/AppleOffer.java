package com.shop.service.offer;

import com.shop.service.ProductOriginalPrice;

public class AppleOffer implements Offer {
		//buy one, get one free on Apples
		@Override
		public Double offerPolicy(Integer value) {
			double offerPrice = (value/2)*ProductOriginalPrice.Apple + (value%2)*ProductOriginalPrice.Apple;
			return offerPrice;
		}
}
