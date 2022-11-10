package shopping.presentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import shopping.business.service.CartService;
import shopping.dataAccess.entity.Cart;

@Controller
@RequestMapping("/shopping")
public class CartController {
	
	@Autowired
	private CartService cartService;
	
	@PostMapping("/cart/create")
	@ResponseBody
	public long createCart(@RequestBody Cart cart) {
		return this.cartService.createCart(cart);
	}
	
	@PostMapping("/checkout/{cartId}")
	@ResponseBody
	public String checkout(@PathVariable("cartId") long cartId) {
		return this.cartService.checkout(cartId);
	}
	
	@PostMapping("/cart/{cartId}/remove/{productId}")
	@ResponseBody
	public String removeProductFromCart(@PathVariable("cartId") long cartId, @PathVariable("productId") long productId) {
		
		return this.cartService.removeProductFromCart(cartId, productId);
	}
}
