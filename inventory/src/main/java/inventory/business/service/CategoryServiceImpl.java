package inventory.business.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import inventory.business.responses.CreateCategoryResponse;
import inventory.business.responses.DeleteCategoryResponse;
import inventory.business.responses.GetAllCategoriesResponse;
import inventory.business.responses.GetCategoryByIdResponse;
import inventory.business.responses.UpdateCategoryResponse;
import inventory.dataAccess.entity.Category;
import inventory.dataAccess.repository.CategoryDao;

@Service
public class CategoryServiceImpl implements CategoryService{
	
	@Autowired
	private CategoryDao categoryDao;
	
	@Override
	public GetAllCategoriesResponse getAll() {
		
		GetAllCategoriesResponse response = new GetAllCategoriesResponse();
		List<Category> categories = this.categoryDao.findAll();
		response.setCategoryList(categories);
		response.setMessage("All categories listed");
		response.setSuccess(true);
		
		return response;
	}

	@Override
	public CreateCategoryResponse createCategory(Category category) {
		
		CreateCategoryResponse response = new CreateCategoryResponse();
		Category category_ = this.categoryDao.save(category);
		
		response.setId(category_.getCategoryId());
		response.setMessage("Category created with id:" + response.getId());
		response.setSuccess(true);
		
		return response;
	}

	@Override
	public UpdateCategoryResponse updateCategory(Category category) {
		
		UpdateCategoryResponse response = new UpdateCategoryResponse();
		Category category_ = this.categoryDao.save(category);
		
		response.setCategoryId(category_.getCategoryId());
		response.setMessage("Category updated with id:" + response.getCategoryId());
		response.setSuccess(true);
		
		return response;
	}

	@Override
	public DeleteCategoryResponse deleteCategory(long categoryId) {
		
		DeleteCategoryResponse response = new DeleteCategoryResponse();
		this.categoryDao.delete(this.categoryDao.findById(categoryId).get());
		
		response.setCategoryId(categoryId);
		response.setMessage("Category deleted with id: "+response.getCategoryId());
		response.setSuccess(true);
		
		return response;
	}

	@Override
	public GetCategoryByIdResponse getCategoryById(long categoryId) {
		
		GetCategoryByIdResponse response = new GetCategoryByIdResponse();
		String categoryName = this.categoryDao.findById(categoryId).get().getCategoryName();
		
		response.setCategoryName(categoryName);
		response.setMessage("Category found with id: "+response.getCategoryName());
		response.setSuccess(true);
		
		return response;
	}

}
