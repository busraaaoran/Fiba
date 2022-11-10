package com.example.demo.ders1;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductResourceController {
	
	@GetMapping("/api/product/{id}")
	public Product getProduct(@PathVariable("id")int productId) {
		Product product = new Product(productId,"Laptop",12000);
		return product;
	}
	
	@GetMapping("/api/products")
	public List<Product> getProducts(){
		List<Product> products = new ArrayList<>();
		products.add(new Product(1,"Telefon",7000));
		products.add(new Product(2,"Televizyon",4500));
		products.add(new Product(3,"Mug",54));
		
		return products;
		
	}
	
	@PostMapping("/api/product")
	public Product postProduct(@RequestBody Product product) {
		product.setProductId(4);
		System.out.println("Eklenen ürün id:"+product.getProductId()+" ad:"+product.getProductName()+" fiyat:"+product.getProductPrice());
		
		return product;
	}
	
	@PutMapping("/api/product")
	public String putProduct(@RequestBody Product product) {
		System.out.println("Güncellenen ürün id:"+product.getProductId()+" ad:"+product.getProductName()+" fiyat:"+product.getProductPrice());
		
		return "Güncellenme başarılı!";
	}
}
