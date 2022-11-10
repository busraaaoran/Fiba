package orm;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/inventory")
public class ProductController {
	
	private ProductRepository productRepository;
	
	@Autowired
	public ProductController(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}
	
	@GetMapping("/product/insert")
	@ResponseBody
	public String insertProduct() {
		Product product = new Product(0,"Bardak",1430);
		productRepository.save(product);
		
		return "inserted" + product.getProductId();
	}
	
	@GetMapping("/product")
	@ResponseBody
	public String findProduct() {
		int productId = 1;
		Optional<Product> optional = productRepository.findById(productId);
		
		if(optional.isPresent()) {
			Product product = optional.get();
			System.out.println(product.getProductId() + " "+
			product.getProductName() + " " +
					product.getProductPrice());
			
			return "Product found " + product.getProductName(); 
		}
		return "No such product";
	}
	
	@GetMapping("/product/list")
	@ResponseBody
	public String listProducts() {
		Iterable<Product> products = productRepository.findAll();
		int count = 0;
		for(Product product:products) {
			System.out.println(product.getProductId() + " "+
			product.getProductName() + " " +
					product.getProductPrice());
			count++;
			
			
		}
		return "Number of products: "+count;
	}
	
	@GetMapping("/product/expensive")
	@ResponseBody
	public String listExpensiveProducts() {
		double minPrice = 355;
		int count = 0;
		Iterable<Product> products = productRepository.findBySalesPriceMin(minPrice);
		
		for(Product product:products) {
			System.out.println(product.getProductId() + " "+
			product.getProductName() + " " +
					product.getProductPrice());
			count++;
			
			
		}
		return "Number of products: "+count;
	}
	
	
	@GetMapping("/product/delete")
	@ResponseBody
	public String deleteProduct() {
		int productId = 2;
		if(!productRepository.existsById(productId)) {
			return "No such product with Id: " + productId;
		}
		productRepository.deleteById(productId);
		 
		return "Product with id: " + productId + " deleted";
	}
}
