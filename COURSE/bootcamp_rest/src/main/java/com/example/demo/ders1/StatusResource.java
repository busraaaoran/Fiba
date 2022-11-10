package com.example.demo.ders1;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StatusResource {
	
	@GetMapping("/status/ok/{id}")
	public ResponseEntity<?> getOk(@PathVariable("id")int productId){
		Product product = new Product(productId,"Ayakkabı",1250);
		
		return ResponseEntity
				.ok()
				.body(product);
		
	}
	
	
	@GetMapping("/status/notfound/{id}")
	public ResponseEntity<?> getNotFound(@PathVariable("id")int productId){
		if(productId==0) {
			return ResponseEntity
					.status(HttpStatus.NOT_FOUND)
					.body("!!!Ürün bulunamadı!!!");
		}
		
		Product product = new Product(productId,"Bardak",34.5);
		return ResponseEntity.ok(product);
	}
}
