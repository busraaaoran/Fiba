package inventory.dataAccess.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import inventory.dataAccess.entity.Category;

@Repository
public interface CategoryDao extends JpaRepository<Category, Long>{

}
