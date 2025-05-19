package Entity;

public class MeatAndFish extends Product {
	private String catagory;
	
	public MeatAndFish(){}
	public MeatAndFish(int productId, String productName, double productPrice,int quantity, String catagory){
		super(productId,productName,productPrice,quantity);
		this.catagory = catagory;
	}
	public void setCatagory(String catagory){
		this.catagory = catagory;
	}
	public String getCatagory(){
		return this.catagory;
	}
	
	
	
	public void show(){
		super.show();
		System.out.println("Catagory: "+catagory);
	}
}
	
	