package shopping.presentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import shopping.business.service.CartProductService;
import shopping.dataAccess.entity.CartProduct;
import shopping.dataAccess.repository.CartProductDao;

@Controller
public class CartProductController {
	
	@Autowired
	private CartProductService cartProductService;
	
	@Autowired
	private CartProductDao cartProductDao;
	
	@PostMapping("/shopping/cartProduct/add")
	@ResponseBody
	public long add(@RequestBody CartProduct cartProduct) {
		return this.cartProductService.addCartProduct(cartProduct);
	}
	
	@PostMapping("/shopping/cartProduct/{cartProductId}")
	@ResponseBody
	public CartProduct getById(@PathVariable("cartProductId") long cartProductId) {
		return this.cartProductDao.findById(cartProductId).get();
	}
}
