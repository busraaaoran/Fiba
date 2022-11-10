package inventory.business.service;

import inventory.business.responses.CreateCategoryResponse;
import inventory.business.responses.DeleteCategoryResponse;
import inventory.business.responses.GetAllCategoriesResponse;
import inventory.business.responses.GetCategoryByIdResponse;
import inventory.business.responses.UpdateCategoryResponse;
import inventory.dataAccess.entity.Category;

public interface CategoryService {
	
	GetAllCategoriesResponse getAll();
	
	CreateCategoryResponse createCategory(Category category);
	
	UpdateCategoryResponse updateCategory(Category category);
	
	DeleteCategoryResponse deleteCategory(long categoryId);
	
	GetCategoryByIdResponse getCategoryById(long categoryId);
}
