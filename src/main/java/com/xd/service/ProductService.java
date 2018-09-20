package com.xd.service;

import java.util.List;

import com.xd.domain.Product;

public interface ProductService {
	void updateAllStock();
	List <Product> getAllProducts();
	List<Product> getProductsByCategory(String category);
	Product getProductById(String productID);
}
