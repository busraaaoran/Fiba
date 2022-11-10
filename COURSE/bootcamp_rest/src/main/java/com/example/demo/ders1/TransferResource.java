package com.example.demo.ders1;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransferResource {

	
	@GetMapping("/transfer/header")
	public ResponseEntity<?> getHeader(
			@RequestHeader(value="input",defaultValue="BOŞ")String input){
		
		String output = "Giren :" + input;
		
		return ResponseEntity.ok(output);
	}
}
