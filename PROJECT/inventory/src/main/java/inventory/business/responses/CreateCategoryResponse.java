package inventory.business.responses;

public class CreateCategoryResponse extends ResponseBase{
	
	private long id;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public CreateCategoryResponse(boolean success, String message, long id) {
		super(success, message);
		this.id = id;
	}

	public CreateCategoryResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CreateCategoryResponse(boolean success, String message) {
		super(success, message);
		// TODO Auto-generated constructor stub
	}
	

}
