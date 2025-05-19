package Entity;
import java.lang.*;
import Interface.IEmployee;
public class Employee implements IEmployee{
	public int employeeId;
	public String employeeName;
	public String employeeGender;
	public double employeeSalary;
	
	public Employee (){}
	
	public Employee(int employeeId, String employeeName, String employeeGender, double employeeSalary){
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.employeeGender = employeeGender;
		
		if(employeeSalary > 0){
			this.employeeSalary =  employeeSalary;
		}
		else {
			System.out.println("Invalid Salary");
		}
	}
	
	// Employee Id setget
	public void setEmployeeId(int employeeId){
		this.employeeId = employeeId;
	}
	public int getEmployeeId(){
		return employeeId;
	}
	
	// Employee Name
	public void setEmployeeName(String employeeName){
		this.employeeName = employeeName;
	}	
	public String getEmployeeName(){
		return employeeName;
	}
	
	// Employee Gender
	public void setEmployeeGender(String employeeGender){
		this.employeeGender = employeeGender;
	}
	public String getEmployeeGender(){
		return employeeGender;
	}
	
	// Employee Salary
	public void setEmployeeSalary(double employeeSalary){
		if(employeeSalary > 0){		
			this.employeeId = employeeId;
		}
		else {
			System.out.println("Invalid Salary");
		}
	}
	public double getEmployeeSalary(){
		return employeeSalary;
		
	}
	
	public void show(){
		System.out.println("==========================");
		System.out.println("Employee Id: "+ employeeId);
		System.out.println("Employee Name: "+ employeeName);
		System.out.println("Employee Gender: "+ employeeGender);
		System.out.println("Employee Salary: "+ employeeSalary+" Taka");
	}
}