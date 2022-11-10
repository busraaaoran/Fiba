package inventory.business.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import inventory.business.dtos.ProductDto;
import inventory.business.responses.CreateProductResponse;
import inventory.business.responses.DeleteProductResponse;
import inventory.business.responses.GetAllProductsResponse;
import inventory.business.responses.GetProductByIdResponse;
import inventory.business.responses.GetProductsByCategoryIdResponse;
import inventory.business.responses.UpdateProductResponse;
import inventory.dataAccess.entity.Product;
import inventory.dataAccess.repository.CategoryDao;
import inventory.dataAccess.repository.ProductDao;

@Service
public class ProductServiceImpl implements ProductService {
	
	private ProductDao productDao;
	private CategoryDao categoryDao;
	
	public ProductServiceImpl(ProductDao productDao, CategoryDao categoryDao) {
		this.productDao = productDao;
		this.categoryDao = categoryDao;
	}

	@Override
	public GetProductByIdResponse getProductById(long productId) {
		
		GetProductByIdResponse response = new GetProductByIdResponse();
		Product product = this.productDao.findById(productId).get();
		ProductDto productDto = this.convertProductToProductDto(product);
		
		response.setProduct(productDto);
		response.setSuccess(true);
		response.setMessage("Product found by id: "+productId);
		
		return response;
	}

	@Override
	public CreateProductResponse createProduct(Product product) {
		
		CreateProductResponse response = new CreateProductResponse();
		Product product_ = this.productDao.save(product);
		
		response.setProductId(product_.getProductId());
		response.setMessage("Product created with id: "+product_.getProductId());
		response.setSuccess(true);
		
		return response;
		
	}

	@Override
	public UpdateProductResponse updateProduct(Product product) {
		
		UpdateProductResponse response = new UpdateProductResponse();
		Product product_ = this.productDao.save(product);
		
		response.setProductId(product_.getProductId());
		response.setMessage("Product updated with id: "+product_.getProductId());
		response.setSuccess(true);
		
		return response;
		
	}

	@Override
	public DeleteProductResponse deleteProduct(long productId) {
		
		DeleteProductResponse response = new DeleteProductResponse();
		this.productDao.delete(this.productDao.findById(productId).get());
		
		response.setMessage("Product deleted with id: "+productId);
		response.setProductId(productId);
		response.setSuccess(true);
		
		return response;
		
	}
	
	
	@Override
	public GetProductsByCategoryIdResponse getProductsByCategoryId(long categoryId) {
		
		GetProductsByCategoryIdResponse response = new GetProductsByCategoryIdResponse();
		
		List<Product> products = this.productDao.getProductsByCategoryId(categoryId);
		List<ProductDto> productDtos = new ArrayList<>();
		for(Product product:products) {
			productDtos.add(this.convertProductToProductDto(product));
		}
		
		response.setProductList(productDtos);
		response.setMessage("Products under same category are listed");
		response.setSuccess(true);
		
		return response;
	}

	@Override
	public GetAllProductsResponse getAll() {
		
		GetAllProductsResponse response = new GetAllProductsResponse();
		List<Product> products = this.productDao.findAll();
		List<ProductDto> productDtos = new ArrayList<>();
		
		for(Product product:products) {
			productDtos.add(this.convertProductToProductDto(product));
		}
		
		response.setProductList(productDtos);
		response.setMessage("Products listed");
		response.setSuccess(true);
		
		return response;
	}

	@Override
	public ProductDto convertProductToProductDto(Product product) {
		
		ProductDto productDto = new ProductDto();
		productDto.setSalesPrice(product.getSalesPrice());
		productDto.setProductName(product.getProductName());
		productDto.setCategoryName(this.categoryDao.findById(product.getCategory().getCategoryId()).get().getCategoryName());
		
		return productDto;
	}

}
