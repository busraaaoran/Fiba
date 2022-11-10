package shopping.business.service;

import shopping.business.dtos.CartProductDto;
import shopping.dataAccess.entity.CartProduct;

public interface CartProductService {
	
	long addCartProduct(CartProduct cartProduct);
	
	CartProductDto convertToCartProductDto(CartProduct cartProduct);
}
