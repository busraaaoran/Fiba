package inventory.business.responses;

import java.util.List;

import inventory.business.dtos.ProductDto;

public class GetAllProductsResponse extends ResponseBase{
	
	private List<ProductDto> productList;

	public List<ProductDto> getProductList() {
		return productList;
	}

	public void setProductList(List<ProductDto> productList) {
		this.productList = productList;
	}

	public GetAllProductsResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GetAllProductsResponse(boolean success, String message) {
		super(success, message);
		// TODO Auto-generated constructor stub
	}

	public GetAllProductsResponse(boolean success, String message, List<ProductDto> productList) {
		super(success, message);
		this.productList = productList;
	}
}
