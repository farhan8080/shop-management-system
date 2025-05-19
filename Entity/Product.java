package Entity;
public abstract class Product 
{
	private int productId;
	private String productName;
	private double productPrice;
	private int quantity;
	
	public Product(){}	
	
	public Product(int productId, String productName, double productPrice, int quantity)
	{
		this.productId = productId;
		this.productName = productName;
		this.productPrice = productPrice;
		this.quantity = quantity;
	}
	
	//Product Id
	public void setProductId(int productId)
	{
		this.productId = productId;
	}
	public int getProductId()
	{
		return this.productId;
	}
	
	//Product Name
	public void setProductName(String productName)
	{
		this.productName = productName;
	}
	public String getProductName()
	{
		return this.productName;
	}
	
	//Product Price
	public void setProductPrice(double productPrice)
	{
		this.productPrice = productPrice;
	}
	public double getProductPrice()
	{
		return this.productPrice;
	}
	
	// product Quantity
	public void setQuantity(int quantity){
		this.quantity = quantity;
	}
	public int getQuantity(){
		return this.quantity;
	}
	
	public void show()
	{
		System.out.println("================================");
		System.out.println("The Product ID is: " + this.productId);
		System.out.println("Product Name is: " + this.productName);
		System.out.println("Price of the Product is: " + this.productPrice + " Taka");
	}
	
}