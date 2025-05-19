package Entity;
public class Drinks extends Product{
	private String Drinktype;

	public Drinks(){};
	public Drinks(int productId, String productName, double productPrice,int quantity,String Drinktype){
		super(productId,productName,productPrice,quantity);
		this.Drinktype=Drinktype;
	}
	
	// Drinks Type
	public void setDrinktype(String Drinktype){
		this.Drinktype=Drinktype;
	}
	public String getDrinktype(){
		return this.Drinktype;
	}


	public void show(){
		super.show();
		System.out.println("Drinks Type : "+Drinktype);
	}


}
