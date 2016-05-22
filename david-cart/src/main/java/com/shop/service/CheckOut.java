package com.shop.service;

import java.util.List;

public interface CheckOut {

	Double calculateTotalCost(List<String> purchasedProducts);

}
