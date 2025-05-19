package EntityList;
import java.util.ArrayList;
import Entity.Customer;
public class CustomerList{
	private ArrayList <Customer> customers = new ArrayList<Customer>();
	
	public void insert(Customer c){
		customers.add(c);
	}
	public Customer getByID(int id){
		for(int i=0;i<customers.size();i++){
			if(customers.get(i).getCustomerId() == id){
				return customers.get(i);
			}
		}
		return null;
	}
	public boolean removeByID(int id){
		for(int i=0;i<customers.size();i++){
			if(customers.get(i).getCustomerId() == id){
				customers.remove(i);
				return true;
			}
		}
		return false;
	}
	
	public void showAll(){
		for(int i=0;i<customers.size();i++){
			customers.get(i).show();
		}
	}
	
	public ArrayList <Customer> getAll(){
		return customers;
	}
	
}