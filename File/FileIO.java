package File;
import java.util.Scanner;
import java.io.*;
import Entity.*;
import EntityList.*;
import java.util.Arrays;
import java.util.ArrayList;

public class FileIO{
	
	public static int checkUser(String uname, String upass, String fname) {
		int status = 0;
		try {
			Scanner sc = new Scanner(new File(fname));
			while (sc.hasNextLine()) {
				String row = sc.nextLine();
				String cols[] = row.split(";");
				if (cols.length >= 2) { 
					String name = cols[0];
					String pass = cols[1];
					if (uname.equals(name) && upass.equals(pass)) {
						status = 1;
						break;
					} else if (uname.equals(name) && !upass.equals(pass)) {
						status = 2;
					}
				} else {
					System.out.println("Invalid format in file: " + fname);
				}
			}
			sc.close();
		} catch (FileNotFoundException e) {
			System.out.println("Cannot Read From File: " + fname);
		}
		return status;
	}
	
	
	public static int checkCustomer(String uname, String fname){
		int status = 0;
		try{
			Scanner sc = new Scanner(new File(fname));
			while(sc.hasNextLine()){
				String row = sc.nextLine();
				String cols[] = row.split(";");
				String name = cols[1];
				
				if(uname.equals(name)){
					status = 1;
					break;
				}
			}
			sc.close();
		}
		catch(FileNotFoundException e){
			System.out.println("Cannot Read From File");
		}
		return status;
	}
	
	public static String checkMembership(String uname, String fname){
		String status = "Regular";
		try{
			Scanner sc = new Scanner(new File(fname));
			while(sc.hasNextLine()){
				String row = sc.nextLine();
				String cols[] = row.split(";");
				String name = cols[1];
				String membership = cols[3];
				
				if(uname.equals(name)){
					status = membership;
				}
				
			}
			sc.close();
		}
		catch(FileNotFoundException e){
			System.out.println("Cannot Read From File");
		}
		return status;
	}

	public static boolean registerUser(String uname, String upass, String fname){
		if(checkUser(uname,upass,fname) == 0){
			writeInFile(uname+";"+upass,fname,true);
			return true;
		}
		return false;
	}

	public static void readFromFile(String fname){
		try{
			Scanner sc = new Scanner(new File(fname));
			while(sc.hasNextLine()){
				String row = sc.nextLine();
				String cols[] = row.split(";");
				String name = cols[0];
				String pass = cols[1];
				
			}
			sc.close();
		}
		catch(FileNotFoundException e){
			System.out.println("Cannot Read From File");
		}
	}

	public static void writeInFile(String line,String fname,boolean append){
		try{
			FileWriter fw = new FileWriter(new File(fname),append);
			fw.write(line+"\n");
			fw.close();
			
		}
		catch(FileNotFoundException e){
			System.out.println("Cannot Read From File");
		}
		catch(Exception e){
			System.out.println("Cannot Read From File");
		}
	}

	public static void loadEmployeeFromFile(EmployeeList employees, String fname){
		try{
			Scanner sc = new Scanner(new File(fname));
			while(sc.hasNextLine()){
				String row = sc.nextLine();
				String cols[] = row.split(";");
				
				int id = Integer.parseInt( cols[0] );
				String name = cols[1];
				double salary = Double.parseDouble( cols[2] );
				String gender = cols[3];
				employees.insert(new Employee(id,name,gender,salary));
			}
			sc.close();
		}
		catch(FileNotFoundException e){
			System.out.println("Cannot Read From File");
		}
	}

	public static void loadCustomerFromFile(CustomerList customers, String fname){
		try{
			Scanner sc = new Scanner(new File(fname));
			while(sc.hasNextLine()){
				String row = sc.nextLine();
				String cols[] = row.split(";");
				
				int id = Integer.parseInt( cols[0] );
				String name = cols[1];
				String number =  cols[2];
				String membership = cols[3];
				customers.insert(new Customer(id,name,number,membership));
			}
			sc.close();
		}
		catch(FileNotFoundException e){
			System.out.println("Cannot Read From File");
		}
	}


	public static void loadProductFromFile(ProductList products, String fname){
		try{
			Scanner sc = new Scanner(new File(fname));
			while(sc.hasNextLine()){
				String row = sc.nextLine();
				String cols[] = row.split(";");
				
				int id = Integer.parseInt( cols[0] );
				String name = cols[1];
				double price = Double.parseDouble( cols[2] );
				int quantity = Integer.parseInt( cols[3] );
				String season = cols[4];
				String drink = cols[5];
				String meatFish = cols[6];
				if(drink.charAt(0) == '-' && meatFish.charAt(0) == '-'){
					products.insert(new VegetableAndFruit(id,name,price,quantity,season));
				}
				else if(season.charAt(0) == '-' && meatFish.charAt(0) == '-'){
					products.insert(new Drinks(id,name,price,quantity,drink));
				}
				else if(season.charAt(0) == '-' && drink.charAt(0) == '-'){
					products.insert(new MeatAndFish(id,name,price,quantity,meatFish));
				}
			}
			sc.close();
		}
		catch(FileNotFoundException e){
			System.out.println("Cannot Read From File");
		}
	
	}

	

}