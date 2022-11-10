package inventory.business.responses;

import inventory.business.dtos.ProductDto;

public class GetProductByIdResponse extends ResponseBase{
	
	private ProductDto product;

	public GetProductByIdResponse(boolean success, String message, ProductDto product) {
		super(success, message);
		this.product = product;
	}

	public GetProductByIdResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GetProductByIdResponse(boolean success, String message) {
		super(success, message);
		// TODO Auto-generated constructor stub
	}

	public ProductDto getProduct() {
		return product;
	}

	public void setProduct(ProductDto product) {
		this.product = product;
	}
}
