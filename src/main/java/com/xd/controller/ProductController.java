package com.xd.controller;

import java.math.BigDecimal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xd.domain.Product;
@Controller
public class ProductController {
@RequestMapping("/products")
@ResponseBody
public String list(Model model) {
Product iphone = new Product("P1234","iPhone 6s", new BigDecimal(500));
iphone.setDescription("Apple iPhone 6s smartphone with 4.00-inch 640x1136 display and 8-megapixel rear camera");
iphone.setCategory("Smartphone");
iphone.setManufacturer("Apple");
iphone.setUnitsInStock(1000);
model.addAttribute("product", iphone);
return "products";
}
}