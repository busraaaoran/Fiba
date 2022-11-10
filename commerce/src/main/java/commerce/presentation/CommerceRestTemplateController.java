package commerce.presentation;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import commerce.business.dtos.ProductDto;
import commerce.data.entity.Cart;
import commerce.data.entity.Category;

@RestController
@RequestMapping("/commerce")
public class CommerceRestTemplateController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/inventory/categories")
	public List<Category> getCategories(){
		
		String url = "http://localhost:8081/inventory/categories";
		Category[] categories = restTemplate.getForObject(url, Category[].class);
			
		return Arrays.asList(categories);
	}
	
	@PostMapping("/inventory/product/{id}")
	public ProductDto getProductById(@PathVariable("id") long productId) {
		
		String url = "http://localhost:8081/inventory/product/" + productId;
		ProductDto productDto = restTemplate.postForObject(url, null, ProductDto.class);
		
		return productDto;
	}
	
	@PostMapping("/inventory/products/{categoryId}")
	public List<ProductDto> getProductsByCategoryId(@PathVariable("categoryId") long categoryId){
		
		String url = "http://localhost:8081/inventory/products/" + categoryId;
		ProductDto[] products = restTemplate.postForObject(url, null, ProductDto[].class);
		
		return Arrays.asList(products);
	}
	
	@PostMapping("/shopping/cart/create")
	public long createCart(@RequestBody Cart cart) {
		
		String url = "http://localhost:8082/shopping/cart/create";
		long cartId = restTemplate.postForObject(url, cart, long.class);
		
		return cartId;
	}
	
	@PostMapping("/shopping/checkout/{cartId}")
	public String checkout(@PathVariable("cartId") long cartId) {
		String url = "http://localhost:8082/shopping/checkout/" + cartId;
		String responseMessage = restTemplate.postForObject(url, null, String.class);
		
		return responseMessage;
	}
	
	@PostMapping("/shopping/cart/{cartId}/remove/{productId}")
	public String removeProductFromCart(@PathVariable("cartId") long cartId,
			@PathVariable("productId") long productId) {
		
		String url = "http://localhost:8082/shopping/cart/" + cartId +"/remove/"+productId;
		String responseMessage = restTemplate.postForObject(url, url, String.class);
		
		return responseMessage;
	}
}
