package EntityList;
import java.util.ArrayList;
import Entity.Employee;
public class EmployeeList{
	private ArrayList <Employee> employees = new ArrayList<Employee>();
	
	public void insert(Employee e){
		employees.add(e);
	}
	public Employee getByID(int id){
		for(int i=0;i<employees.size();i++){
			if(employees.get(i).getEmployeeId() == id){
				return employees.get(i);
			}
		}
		return null;
	}
	public boolean removeByID(int id){
		for(int i=0;i<employees.size();i++){
			if(employees.get(i).getEmployeeId() == id){
				employees.remove(i);
				return true;
			}
		}
		return false;
	}
	
	public void showAll(){
		for(int i=0;i<employees.size();i++){
			employees.get(i).show();
		}
	}
	
	public ArrayList <Employee> getAll(){
		return employees;
	}
	
}