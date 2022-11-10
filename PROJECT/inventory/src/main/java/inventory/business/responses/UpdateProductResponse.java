package inventory.business.responses;

public class UpdateProductResponse extends ResponseBase{
	
	private long productId;

	public UpdateProductResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UpdateProductResponse(boolean success, String message) {
		super(success, message);
		// TODO Auto-generated constructor stub
	}

	public UpdateProductResponse(boolean success, String message, long productId) {
		super(success, message);
		this.productId = productId;
	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}
}
