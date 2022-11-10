package inventory.business.responses;

public class CreateProductResponse extends ResponseBase {
	
	private long productId;

	public CreateProductResponse(boolean success, String message, long productId) {
		super(success, message);
		this.productId = productId;
	}

	public CreateProductResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CreateProductResponse(boolean success, String message) {
		super(success, message);
		// TODO Auto-generated constructor stub
	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}
}
