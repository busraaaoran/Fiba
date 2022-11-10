package shopping.business.service;

import shopping.business.dtos.CartDto;
import shopping.business.dtos.CartProductDto;
import shopping.dataAccess.entity.Cart;

public interface CartService {
	
	long createCart(Cart cart);
	
	long updateCart(Cart cart);
	
	String checkout(long cartId);
	
	CartDto findCartById(long cartId);
	
	String removeProductFromCart(long cartId,long productId);
	
	CartDto convertCartToCartDto(Cart cart);
	
	//double addProductToCart(CartProductDto product);
}
