package inventory.business.responses;

public class GetCategoryByIdResponse extends ResponseBase{

	private String categoryName;
	
	public GetCategoryByIdResponse(boolean success, String message, String categoryName) {
		super(success, message);
		this.categoryName = categoryName;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public GetCategoryByIdResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GetCategoryByIdResponse(boolean success, String message) {
		super(success, message);
		// TODO Auto-generated constructor stub
	}
}
