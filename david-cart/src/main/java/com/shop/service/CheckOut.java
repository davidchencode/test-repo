package com.shop.service;

import java.util.List;
import java.util.Map;

import com.shop.service.offer.Offer;

public interface CheckOut {

	Double calculateTotalCost(List<String> purchasedProducts, Map<String, Offer> offers);

}
