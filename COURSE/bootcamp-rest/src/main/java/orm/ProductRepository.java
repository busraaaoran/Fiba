package orm;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ProductRepository extends CrudRepository<Product, Integer>{
	
	//JPQL
	@Query("select p from Product as p where p.productPrice >= :minPrice")
	List<Product> findBySalesPriceMin(@Param("minPrice") double minPrice);
}
