package GUI;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;
import java.util.ArrayList;

import File.*;
import Entity.*;
import EntityList.*;


public class employeepage extends JFrame implements ActionListener{
	JLabel employeeHeader,employeeNameLebel,employeeIdLabel,employeeSalaryLabel,employeePassLabel,employeeGenderLabel,backgroundImgLabel; 
	JTextField employeeNameText,employeeIdText,employeeSalaryText;
	JButton addBtn,deleteBtn,backbtn;
	JPanel panel;
	Cursor cursor;
	
	JTable table;
	DefaultTableModel model;
	JRadioButton radioButton1,radioButton2;
	
	Dashboard dashboard;
	EmployeeList employees;
	
	// fonts
	Font font = new Font("poppins", Font.PLAIN, 19);
	Font boldFont = new Font("roboto", Font.BOLD, 24);
	Font font1= new Font ("Arial",Font.BOLD,19);
	
    // colors
	Color greenColor = new Color(0,204,0);
	Color blueColor = new Color(25, 113, 255);
	Color redColor = new Color(250, 20, 20);

	public employeepage(Dashboard dashboard, EmployeeList employees){
		super("Shop Management 2024 - Employee Informations");
		this.dashboard = dashboard;
		this.employees = employees;
		initialization();
		
		// customer header
		employeeHeader = new JLabel("EMPLOYEE MANAGEMENT");
		employeeHeader.setBounds(100, 10, 350, 40);
		employeeHeader.setFont(boldFont);
		employeeHeader.setForeground(Color.BLACK);
		this.add(employeeHeader);
		
		//employee Name Lebel
		employeeNameLebel=new JLabel("Employee Name :");
		employeeNameLebel.setBounds(100,70,250,25);
		employeeNameLebel.setForeground(Color.BLACK);
		employeeNameLebel.setFont(font1);
		this.add(employeeNameLebel);

		//employee Id Label
		employeeIdLabel = new JLabel("Employee ID :");
		employeeIdLabel.setBounds(100,120,250,25);
		employeeIdLabel.setForeground(Color.BLACK);
		employeeIdLabel.setFont(font1);
		this.add(employeeIdLabel);
		
		//employee Salary Label
		employeeSalaryLabel=new JLabel("Employee Salary :");
		employeeSalaryLabel.setBounds(100,170,250,25);
		employeeSalaryLabel.setForeground(Color.BLACK);
		employeeSalaryLabel.setFont(font1);
		this.add(employeeSalaryLabel);

		//employee Gender Label
		employeeGenderLabel=new JLabel("Employee Gender :");
		employeeGenderLabel.setBounds(100,210,250,25);
		employeeGenderLabel.setForeground(Color.BLACK);
		employeeGenderLabel.setFont(font1);
		this.add(employeeGenderLabel);

		//employee Name text field
		employeeNameText = new JTextField();
		employeeNameText.setBounds(400,70,250,35);
		employeeNameText.setBackground(Color.white);
		employeeNameText.setFont(font1);
		this.add(employeeNameText);

		//employee ID text field
		employeeIdText = new JTextField();
		employeeIdText.setBounds(400,115,250,35);
		employeeIdText.setBackground(Color.WHITE);
		employeeIdText.setFont(font1);
		this.add(employeeIdText);

		//employee Salary text field
		employeeSalaryText = new JTextField();
		employeeSalaryText.setBounds(400,160,250,35);
		employeeSalaryText.setBackground(Color.WHITE);
		employeeSalaryText.setFont(font1);
		this.add(employeeSalaryText);


        //JRadioButton create  
		radioButton1 = new JRadioButton("Male");
		radioButton1.addActionListener(this);
		radioButton1.setBounds(400,210,80,25);
		radioButton1.setFont(font1);
		radioButton1.setForeground(Color.BLACK);
		radioButton1.setBackground(Color.cyan);
		this.add(radioButton1);


        radioButton2 = new JRadioButton("Female");
        radioButton2.setBounds(480,210,100,25);
        radioButton2.addActionListener(this);
		radioButton2.setFont(font1);
        radioButton2.setForeground(Color.BLACK);
		radioButton2.setBackground(Color.cyan);
		this.add(radioButton2);

		ButtonGroup G1 = new ButtonGroup();
		G1.add(radioButton1);
		G1.add(radioButton2);

        // create Cursor
        cursor = new Cursor(Cursor.HAND_CURSOR);

		//Add Btn create
		addBtn = new JButton("ADD");
		addBtn.setBounds(700,70,150,40);
		addBtn.setFont(font);
		addBtn.setForeground(Color.WHITE);
		addBtn.addActionListener(this);
		addBtn.setCursor(cursor);
		addBtn.setBackground(greenColor);
		addBtn.setBorder(new EmptyBorder(0, 0, 0, 0));
		this.add(addBtn);

		//delete Btn create
		deleteBtn = new JButton("DELETE");
		deleteBtn.setBounds(700,130,150,40);
		deleteBtn.setFont(font);
		deleteBtn.setForeground(Color.WHITE);
		deleteBtn.addActionListener(this);
		deleteBtn.setCursor(cursor);
		deleteBtn.setBackground(redColor);
		deleteBtn.setBorder(new EmptyBorder(0, 0, 0, 0));
		this.add(deleteBtn);

		//back btn create
		backbtn = new JButton("BACK");
		backbtn.setBounds(860,610,80,35);
		backbtn.setFont(font);
		backbtn.setForeground(Color.WHITE);
		backbtn.setCursor(cursor);
		backbtn.addActionListener(this);
		backbtn.setBackground(Color.BLACK);
		backbtn.setBorder(new EmptyBorder(0, 0, 0, 0));
		this.add(backbtn);

        // background panel for color
		panel = new JPanel();
		panel.setLayout(null);
		panel.setSize(2000,1000);
		panel.setBackground(Color.cyan);
		
		this.add(panel);
        createTable();
	}
	
	public void initialization(){
		this.setSize(1000, 700);
		this.setLocation(300, 70);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setVisible(true);
		this.setIconImage(new ImageIcon("./Assets/Images/shopIcon.png").getImage());
	}
	
	public void createTable(){
		model = new DefaultTableModel();
		model.addColumn("ID");
		model.addColumn("NAME");
		model.addColumn("GENDER");
		model.addColumn("SALARY");
		

		table = new JTable(model);
		table.setFont(font);
		table.getTableHeader().setFont(font);
		table.setBounds(0,0,400,500);
		table.setRowHeight(35);
		table.setBackground(Color.YELLOW);
		table.setSelectionBackground(Color.GRAY);


        JScrollPane scrollpane = new JScrollPane(table);
		scrollpane.setBounds(100,250,700,400);

		ArrayList <Employee> allemployees = employees.getAll();
		for(int i=0; i<allemployees.size();i++){
			Employee emp = allemployees.get(i);
			model.addRow(new Object[]{emp.getEmployeeId(),emp.getEmployeeName(),emp.getEmployeeGender(),emp.getEmployeeSalary()});
		}
		panel.add(scrollpane);
	}

    public void updateFile(){
    	int rows = model.getRowCount();
    	String allLines = "";
    	for(int i= 0; i < rows; i++){
    	   String id = table.getModel().getValueAt(i,0).toString();
		   String name = table.getModel().getValueAt(i,1).toString();
		   String salary = table.getModel().getValueAt(i,2).toString();
		   String gender = table.getModel().getValueAt(i,3).toString();
		   String line;
		   if(i<rows-1){
					 line = id+";"+name+";"+gender+";"+salary+"\n";
				}
				else{
					 line = id+";"+name+";"+gender+";"+salary;
				}
				allLines+= line;
			}
			FileIO.writeInFile(allLines,"./File/employees.txt",false);
    }

	public void actionPerformed(ActionEvent e){
	 	if(addBtn == e.getSource()){
	 		String id = employeeIdText.getText();
	 		String name = employeeNameText.getText();
	 		String salary = employeeSalaryText.getText();
	 		String selectedGender;
	 		if(radioButton1.isSelected()){
	 			selectedGender=radioButton1.getText();
	 		}
	 		else{
	 			selectedGender=radioButton2.getText();
	 		}
	 		if (!id.isEmpty() && !name.isEmpty() && !salary.isEmpty() && !selectedGender.isEmpty()){
	 		    Employee emp = new Employee(Integer.parseInt(id),name,selectedGender,Double.parseDouble(salary));
	 		    employees.insert(emp);
                model.addRow(new Object[]{emp.getEmployeeId(),emp.getEmployeeName(),emp.getEmployeeGender(),emp.getEmployeeSalary()});
                employeeIdText.setText("");
                employeeNameText.setText("");
                employeeSalaryText.setText("");
                updateFile();

	 		}
	 		else{
	 			JOptionPane.showMessageDialog(this,"Please Enter All Details","Data Entry Warning",JOptionPane.WARNING_MESSAGE);
	 		}
	 	}
	 	else if(deleteBtn == e.getSource()){
	 		int rows[] = table.getSelectedRows();
	 		if(rows!=null){
	 			Arrays.sort(rows);
	 			for(int i= rows.length-1; i>=0;i--){
	 				employees.removeByID(Integer.parseInt(table.getModel().getValueAt(rows[i],0).toString()));
					model.removeRow(rows[i]);
				}
	 		}
	 		updateFile();
	 	}
	 	else if (backbtn == e.getSource() ){
			dashboard.setVisible(true);
	 		this.dispose();
			updateFile();
	 	}

	 }
	
	

}