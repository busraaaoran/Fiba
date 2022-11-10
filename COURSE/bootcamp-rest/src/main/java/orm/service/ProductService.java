package orm.service;

import java.util.List;

import orm.dtos.ProductDto;

public interface ProductService {
	
	int create(ProductDto productDto);
	
	void update(ProductDto productDto);
	
	ProductDto find(int productId);
	
	List<ProductDto> findAll();
	
	void delete(int productId);
}
