package inventory.business.responses;

public class DeleteCategoryResponse extends ResponseBase{
	
	private long categoryId;

	public long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}

	public DeleteCategoryResponse(boolean success, String message, long categoryId) {
		super(success, message);
		this.categoryId = categoryId;
	}

	public DeleteCategoryResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DeleteCategoryResponse(boolean success, String message) {
		super(success, message);
		// TODO Auto-generated constructor stub
	}
	
}
