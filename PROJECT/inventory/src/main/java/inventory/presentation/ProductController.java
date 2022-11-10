package inventory.presentation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import inventory.business.dtos.ProductDto;
import inventory.business.service.ProductService;

@Controller
@RequestMapping("inventory")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@PostMapping("/product/{id}")
	@ResponseBody
	public ProductDto getProductById(@PathVariable("id") long productId) {
		return this.productService.getProductById(productId).getProduct();
	}
	
	@PostMapping("/products/{categoryId}")
	@ResponseBody
	public List<ProductDto> getProductsByCategoryId(@PathVariable("categoryId") long categoryId){
		return this.productService.getProductsByCategoryId(categoryId).getProductList();
	}
}
