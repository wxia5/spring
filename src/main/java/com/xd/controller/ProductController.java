package com.xd.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xd.service.ProductService;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
@Controller
public class ProductController {
	@Autowired
	private ProductService productService;
//@RequestMapping("/products")
//@ResponseBody
//public String list(Model model) {
//Product iphone = new Product("P1234","iPhone 6s", new BigDecimal(500));
//iphone.setDescription("Apple iPhone 6s smartphone with 4.00-inch 640x1136 display and 8-megapixel rear camera");
//iphone.setCategory("Smartphone");
//iphone.setManufacturer("Apple");
//iphone.setUnitsInStock(1000);
//model.addAttribute("product", iphone);
//return "products";
//}
@RequestMapping("/products")
public String list(Model model) {
model.addAttribute("products",
productService.getAllProducts());
return "products";
}
@RequestMapping("/update/stock")
public String updateStock(Model model) {
productService.updateAllStock();
return "redirect:/products";
}
@RequestMapping("/products/{category}")
public String getProductsByCategory(Model model,@PathVariable("category") String productCategory) {
	model.addAttribute("products",
			productService.getProductsByCategory(productCategory));
return "products";
}
@RequestMapping("/product")
public String getProductById(@RequestParam("id") String
		productId,Model model) {
	model.addAttribute("product",
			productService.getProductById(productId));
return "product";
}
@RequestMapping("/productjson")
@ResponseBody
public Object getProductByIdJSON(@RequestParam("id") String
		productId,Model model) {
	String jsonString = JSONArray.toJSONString(productService.getProductById(productId));
	return JSONObject.parse(jsonString);
}
}