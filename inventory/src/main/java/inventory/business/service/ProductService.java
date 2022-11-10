package inventory.business.service;

import java.util.List;

import inventory.business.dtos.ProductDto;
import inventory.business.responses.CreateProductResponse;
import inventory.business.responses.DeleteProductResponse;
import inventory.business.responses.GetAllProductsResponse;
import inventory.business.responses.GetProductByIdResponse;
import inventory.business.responses.GetProductsByCategoryIdResponse;
import inventory.business.responses.UpdateProductResponse;
import inventory.dataAccess.entity.Product;

public interface ProductService {
	
	GetProductByIdResponse getProductById(long productId);
	
	CreateProductResponse createProduct(Product product);
	
	UpdateProductResponse updateProduct(Product product);
	
	DeleteProductResponse deleteProduct(long productId);
	
	GetProductsByCategoryIdResponse getProductsByCategoryId(long categoryId);
	
	GetAllProductsResponse getAll();
	
	ProductDto convertProductToProductDto(Product product);
}
