package Entity;
public class VegetableAndFruit extends Product {
	private String Season;
	
	public VegetableAndFruit(){}
	
	public VegetableAndFruit(int productId, String productName, double productPrice,int quantity, String Season){
		super(productId,productName,productPrice,quantity);
		this.Season = Season;
	} 
	
	//Product Season
	public void setSeason(String Season){
		this.Season = Season;
	}
	public String getSeason(){
		return this.Season;
	}
	
	public void show(){
		super.show();
		System.out.println("Season: "+Season);
	}
}