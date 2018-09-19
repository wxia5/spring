package com.xd.domain.repository;

import java.util.List;
import com.xd.domain.Product;
public interface ProductRepository {
	
List <Product> getAllProducts();

void updateStock(String productId, long noOfUnits);
}