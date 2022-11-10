package shopping.business.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import shopping.business.dtos.CartProductDto;
import shopping.dataAccess.entity.CartProduct;
import shopping.dataAccess.repository.CartDao;
import shopping.dataAccess.repository.CartProductDao;

@Service
@Transactional
public class CartProductServiceImpl implements CartProductService{

	@Autowired
	private CartProductDao cartProductDao;
	
	@Autowired
	private CartDao cartDao;
	

	@Override
	public long addCartProduct(CartProduct cartProduct) {
		
		CartProduct product = new CartProduct();
		product.setProductId(cartProduct.getProductId());
		product.setLineAmount(cartProduct.getSalesPrice()*cartProduct.getSalesQuantity());
		product.setCart(cartProduct.getCart());
		product.setSalesPrice(cartProduct.getSalesPrice());
		product.setSalesQuantity(cartProduct.getSalesQuantity());
		this.cartProductDao.save(product);
		
		return product.getCartProductId();
	}

	@Override
	public CartProductDto convertToCartProductDto(CartProduct cartProduct) {
		
		CartProductDto cartProductDto = new CartProductDto();
		cartProductDto.setLineAmount(cartProduct.getLineAmount());
		cartProductDto.setSalesPrice(cartProduct.getSalesPrice());
		cartProductDto.setSalesQuantity(cartProduct.getSalesQuantity());
		cartProductDto.setProductName("Default Product Name");
		
		return cartProductDto;
	}
	
	

}
