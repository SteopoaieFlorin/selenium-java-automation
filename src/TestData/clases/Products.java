package TestData.clases;

import Utils.Reader;

public class Products {
	private String productName;
	private String productDescription;
	private String productPrice;
	
	public Products(String filename) {
		this.productName = Reader.json(filename).get("productName").toString();
		this.productDescription = Reader.json(filename).get("productDescription").toString();
		this.productPrice = Reader.json(filename).get("productPrice").toString();
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public String getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(String productPrice) {
		this.productPrice = productPrice;
	}
	
	
}
