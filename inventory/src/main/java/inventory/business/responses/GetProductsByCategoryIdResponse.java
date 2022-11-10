package inventory.business.responses;

import java.util.List;

import inventory.business.dtos.ProductDto;

public class GetProductsByCategoryIdResponse extends ResponseBase {

	private List<ProductDto> productList;
	
	public GetProductsByCategoryIdResponse(boolean success, String message, List<ProductDto> productList) {
		super(success, message);
		this.productList = productList;
	}

	public GetProductsByCategoryIdResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GetProductsByCategoryIdResponse(boolean success, String message) {
		super(success, message);
		// TODO Auto-generated constructor stub
	}

	public List<ProductDto> getProductList() {
		return productList;
	}

	public void setProductList(List<ProductDto> productList) {
		this.productList = productList;
	}

	
}
