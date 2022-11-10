package inventory.business.responses;

public class DeleteProductResponse extends ResponseBase{
	
	private long productId;

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public DeleteProductResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DeleteProductResponse(boolean success, String message) {
		super(success, message);
		// TODO Auto-generated constructor stub
	}

	public DeleteProductResponse(boolean success, String message, long productId) {
		super(success, message);
		this.productId = productId;
	}
}
