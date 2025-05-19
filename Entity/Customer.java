package Entity;
import java.lang.*;
import EntityList.ProductList;
import Interface.ICustomer;

public class Customer{
	private String customerName;
	private int customerId;
    private String customerNumber;
    private String membership;
	private ProductList products = new ProductList();
	
	public Customer(){}
	public Customer(int customerId,String customerName, String customerNumber, String membership){
		this.customerName = customerName;
		this.customerId = customerId;
		this.customerNumber = customerNumber;
		this.membership = membership;
	}
	
	// Customer Name
	public void setCustomerName(String customerName){
		this.customerName = customerName;
	}
	public String getCustomerName(){
		return this.customerName;
	}
	
	// Customer Id
	public void setCustomerId(int customerId){
	    this.customerId = customerId;
	}
	public int getCustomerId(){
		return this.customerId;
	}
	
	// Customer Number
	public void setCustomerNumber(String customerNumber){
		this.customerNumber = customerNumber;
	}
	public String getCustomerNumber(){
		return this.customerNumber;
	}
	
	// Customer Membership
	public void setMembership(String membership){
		this.membership = membership;
	}
	public String getMembership(){
		return this.membership;
	}
	
	// Product List
	public void setProductList(ProductList products){
		this.products = products;
	}
	
	public ProductList getProductList(){
		return products;
	}
	
	// Display Information
	public void show(){
		System.out.println("--------------------------");
		System.out.println("Customer Name : "+customerName);
		System.out.println("Customer ID: "+customerId);
		System.out.println("Customer Phone Number: "+customerNumber);
		System.out.println("Customer Membership: "+membership);
		products.showAll();
	}
}