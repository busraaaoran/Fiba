package inventory.dataAccess.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import inventory.dataAccess.entity.Product;

@Repository
public interface ProductDao extends JpaRepository<Product, Long>{
	
	
	@Query(value= "select * from Product p where p.category_id= :categoryId",
			nativeQuery = true)
	List<Product> getProductsByCategoryId(@Param("categoryId") long categoryId);
	
}
