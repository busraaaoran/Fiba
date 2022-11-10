package inventory.presentation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import inventory.business.dtos.ProductDto;
import inventory.business.responses.GetAllCategoriesResponse;
import inventory.business.service.CategoryService;
import inventory.business.service.CategoryServiceImpl;
import inventory.dataAccess.entity.Category;

@Controller
public class CategoryController {
	
	@Autowired
	private CategoryServiceImpl categoryService;
	
	@GetMapping("/inventory/categories")
	@ResponseBody
	public List<Category> getCategories() {
		
		return this.categoryService.getAll().getCategoryList();
		
	}
	
	
	
	
}
