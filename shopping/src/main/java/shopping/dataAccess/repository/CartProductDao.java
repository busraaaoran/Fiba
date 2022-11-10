package shopping.dataAccess.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import shopping.dataAccess.entity.CartProduct;

@Repository
public interface CartProductDao extends JpaRepository<CartProduct, Long>{
	
	@Query(value = "SELECT p FROM CartProduct p WHERE (p.productId= :productId AND p.cart_id= :cartId)",
			nativeQuery = true)
	CartProduct findCartProductByProductId(@Param("productId") long productId, @Param("cartId") long cartId);
}
