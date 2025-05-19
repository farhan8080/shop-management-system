package EntityList;
import java.util.ArrayList;
import Entity.*;
public class ProductList{
	private ArrayList<Product> products = new ArrayList<Product>();
	
	public void insert(Product c){
		products.add(c);
	}
	
	public Product getById(int id){
		for(int i = 0; i < products.size(); i++){
			if(products.get(i).getProductId() == id){
				return products.get(i);
			}
		}
		return null;
	}
	
	public boolean removeById(int id){
		for(int i = 0; i<products.size(); i++){
			if(products.get(i).getProductId() == id){
				return true;
			}
		}
		return false;
	}
	
	public void showAll(){
		for(int i = 0; i<products.size(); i++){
			products.get(i).show();
		}
	}
	
	public ArrayList <Product> getAll(){
		return products;
	}
}