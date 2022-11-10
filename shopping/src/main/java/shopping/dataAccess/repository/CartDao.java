package shopping.dataAccess.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import shopping.dataAccess.entity.Cart;

@Repository
public interface CartDao extends JpaRepository<Cart, Long>{
	
	
}
