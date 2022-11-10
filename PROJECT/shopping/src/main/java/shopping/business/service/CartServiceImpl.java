package shopping.business.service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

import org.apache.tomcat.util.json.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import shopping.business.dtos.CartDto;
import shopping.business.dtos.CartProductDto;
import shopping.dataAccess.entity.Cart;
import shopping.dataAccess.entity.CartProduct;
import shopping.dataAccess.repository.CartDao;
import shopping.dataAccess.repository.CartProductDao;

@Service
@Transactional
public class CartServiceImpl implements CartService{
	
	@Autowired
	private CartDao cartDao;
	
	@Autowired
	private CartProductDao cartProductDao;
	
	@Autowired
	private CartProductService cartProductService;

	@Override
	public long createCart(Cart cart) {
		Cart cart_ = new Cart();
		cart_.setCartStatus(0);
		cart_.setCustomerName(cart.getCustomerName());
		cart_.setTotalAmount(0);
		
		this.cartDao.save(cart_);
		return cart_.getCartId();
	}

	@Override
	public long updateCart(Cart cart) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String checkout(long cartId) {
		
		Cart cart = this.cartDao.findById(cartId).get();
		cart.setCartStatus(1);
		this.cartDao.save(cart);
		System.out.println("Checked out");
		return "Checked out with cart id: " + cartId;
	}

	@Override
	public CartDto findCartById(long cartId) {
		Cart cart = this.cartDao.findById(cartId).get();
		List<CartProduct> cartProducts = cart.getProductList();
		
		for(CartProduct product: cartProducts) {
			HttpClient client = HttpClient.newHttpClient();
			HttpRequest request = HttpRequest.newBuilder().uri(URI.create("http://localhost:8081/inventory/product/"+product.getCartProductId())).build();
			
			client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
			.thenApply(HttpResponse::body)
			.thenAccept(System.out::println)
			.join();
			
			
		}
		
		return null;
	}

	@Override
	public String removeProductFromCart(long cartId,long productId) {
		
		Cart cart = this.cartDao.findById(cartId).get();
		if(cart.getCartStatus()==1)return "Cart with id: "+cartId+" is already closed!";
		CartProduct product = this.cartProductDao.findCartProductByProductId(productId, cartId);
		if(product==null)return "Could not find any macthing products with id "+productId;
		List<CartProduct> products = cart.getProductList();
		product.setCart(null);
		this.cartProductDao.save(product);
		products.remove(product);
		cart.setProductList(products);
		this.cartDao.save(cart);
		
		return "Product with id: " + productId + "removed from cart with id: " + cartId;
	}

	@Override
	public CartDto convertCartToCartDto(Cart cart) {
		
		 CartDto cartDto = new CartDto();
		 List<CartProductDto> productDtos = new ArrayList<>();
		 cartDto.setCustomerName(cart.getCustomerName());
		 cartDto.setTotalAmount(cart.getTotalAmount());
		 
		 for(CartProduct product: cart.getProductList()) {
			 productDtos.add(this.cartProductService.convertToCartProductDto(product));
		 }
		 
		 cartDto.setProducts(productDtos);
		 
		return cartDto;
	}
	
}
