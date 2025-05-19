package GUI;
import java.lang.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import java.util.Arrays;
import java.util.ArrayList;

import Entity.*;
import EntityList.*;
import File.*;


public class CustomerPage extends JFrame implements ActionListener{
	JPanel panel;
	JLabel customerHeader, customerName, customerId, customerNumber, customerMembership;
	JTextField nameField, idField, numberField;
	JButton backBtn, addBtn, deleteBtn;
	JRadioButton silver, gold, platinum;
	Cursor cursor;
	
	JTable customerTable;
	DefaultTableModel model;
	
	Dashboard dashboard;
	CustomerList customers;
	
	// fonts
	Font font = new Font("poppins", Font.PLAIN, 19);
	Font boldFont = new Font("roboto", Font.BOLD, 24);
	Font font1= new Font ("Arial",Font.BOLD,19);
	// colors
	Color blueColor = new Color(25, 113, 255);
	Color redColor = new Color(250, 20, 20);
	
	public CustomerPage(Dashboard dashboard, CustomerList customers){
		super("Shop Management System 2024 - Customer Informations");
		this.dashboard = dashboard;
		this.customers = customers;
		initialization();
		
		// customer header
		customerHeader = new JLabel("CUSTOMER MANAGEMENT");
		customerHeader.setBounds(80, 5, 350, 40);
		customerHeader.setFont(boldFont);
		customerHeader.setForeground(Color.BLACK);
		this.add(customerHeader);
		
		// customer name
		customerName = new JLabel("Customer Name   :");
		customerName.setBounds(80, 60, 200, 40);
		customerName.setForeground(Color.BLACK);
		customerName.setFont(font);
		this.add(customerName);
		// name text field
		nameField = new JTextField();
		nameField.setBounds(400, 60, 250, 35);
		nameField.setBackground(Color.WHITE);
		nameField.setFont(font);
		this.add(nameField);
		
		// customer id
		customerId = new JLabel("Customer ID     :");
		customerId.setBounds(80, 105, 200, 40);
		customerId.setForeground(Color.BLACK);
		customerId.setFont(font);
		this.add(customerId);
		// id text field
		idField = new JTextField();
		idField.setBounds(400, 105, 250, 35);
		idField.setBackground(Color.WHITE);
		idField.setFont(font);
		this.add(idField);
		
		// customer number
		customerNumber = new JLabel("Customer Number :");
		customerNumber.setBounds(80, 150, 200, 40);
		customerNumber.setForeground(Color.BLACK);
		customerNumber.setFont(font);
		this.add(customerNumber);
		// number text field
		numberField = new JTextField();
		numberField.setBounds(400, 150, 250, 35);
		numberField.setBackground(Color.WHITE);
		numberField.setFont(font);
		this.add(numberField);
		
		// customer membership
		customerMembership = new JLabel("Customer Membership :");
		customerMembership.setBounds(80, 195, 250, 40);
		customerMembership.setForeground(Color.BLACK);
		customerMembership.setFont(font);
		this.add(customerMembership);
		
		// customer membership radio button
		silver = new JRadioButton("Silver");
		silver.addActionListener(this);
		silver.setBounds(340,205,80,25);
		silver.setFont(font1);
		silver.setForeground(Color.BLACK);
		silver.setBackground(Color.CYAN);
		this.add(silver);
		
		gold = new JRadioButton("Gold");
		gold.addActionListener(this);
		gold.setBounds(420,205,80,25);
		gold.setFont(font1);
		gold.setForeground(Color.BLACK);
		gold.setBackground(Color.CYAN);
		this.add(gold);
		
		platinum = new JRadioButton("Platinum");
		platinum.addActionListener(this);
		platinum.setBounds(500,205,120,25);
		platinum.setFont(font1);
		platinum.setForeground(Color.BLACK);
		platinum.setBackground(Color.CYAN);
		this.add(platinum);
		
		ButtonGroup g1 = new ButtonGroup();
		g1.add(silver);
		g1.add(gold);
		g1.add(platinum);
		
		// create Cursor
        cursor = new Cursor(Cursor.HAND_CURSOR);
		
		// add button
		addBtn = new JButton("ADD");
		addBtn.setBounds(700,60,150,40);
		addBtn.setFont(font);
		addBtn.setForeground(Color.WHITE);
		addBtn.addActionListener(this);
		addBtn.setCursor(cursor);
		addBtn.setBackground(new Color(0,204,0));
		addBtn.setBorder(new EmptyBorder(0, 0, 0, 0));
		this.add(addBtn);
		
		// delete button
		deleteBtn = new JButton("DELETE");
		deleteBtn.setBounds(700,120,150,40);
		deleteBtn.setFont(font);
		deleteBtn.setForeground(Color.WHITE);
		deleteBtn.addActionListener(this);
		deleteBtn.setCursor(cursor);
		deleteBtn.setBackground(redColor);
		deleteBtn.setBorder(new EmptyBorder(0, 0, 0, 0));
		this.add(deleteBtn);
		
		// back button
		backBtn = new JButton("BACK");
		backBtn.setBounds(860,610,80,35);
		backBtn.setFont(font);
		backBtn.setBackground(Color.BLACK);
		backBtn.setForeground(Color.WHITE);
		backBtn.setBorder(new EmptyBorder(0,0,0,0));
		backBtn.setCursor(cursor);
		backBtn.addActionListener(this);
		this.add(backBtn);
		
		// backgrond panel
		panel = new JPanel();
		panel.setSize(1920, 1080);
		panel.setLayout(null);
		panel.setBackground(Color.CYAN);
		this.add(panel);
		createTable();
	}
	
	public void initialization(){
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(1000, 700);
		this.setLocation(300, 70);
		this.setLayout(null);
		this.setVisible(true);
		this.setIconImage(new ImageIcon("./Assets/Images/shopIcon.png").getImage());
	}
	
	public void createTable(){
		model = new DefaultTableModel();
		model.addColumn("ID");
		model.addColumn("NAME");
		model.addColumn("NUMBER");
		model.addColumn("MEMBERSHIP");
		
		customerTable = new JTable(model);
		customerTable.setFont(new Font("poppins", Font.PLAIN, 16));
		customerTable.getTableHeader().setFont(new Font("poppins", Font.PLAIN, 18));
		customerTable.setBounds(0,0,400,500);
		customerTable.setRowHeight(35);
		customerTable.setBackground(Color.YELLOW);
		customerTable.setSelectionBackground(Color.GRAY);
		
		JScrollPane scrollpane = new JScrollPane(customerTable);
		scrollpane.setBounds(80,250,700,400);
		
		ArrayList <Customer> allcustomers = customers.getAll();
		for(int i=0; i<allcustomers.size();i++){
			Customer c = allcustomers.get(i);
			model.addRow(new Object[]{c.getCustomerId(),c.getCustomerName(),c.getCustomerNumber(),c.getMembership()});
		}
		panel.add(scrollpane);
	}


	public void updateFile(){
    	int rows = model.getRowCount();
    	String allLines = "";
    	for(int i= 0; i < rows; i++){
    	   String id = customerTable.getModel().getValueAt(i,0).toString();
		   String name = customerTable.getModel().getValueAt(i,1).toString();
		   String number = customerTable.getModel().getValueAt(i,2).toString();
		   String membership = customerTable.getModel().getValueAt(i,3).toString();
		   String line;
		   if(i<rows-1){
					 line = id+";"+name+";"+number+";"+membership+"\n";
				}
				else{
					 line = id+";"+name+";"+number+";"+membership;
				}
				allLines+= line;
			}
			FileIO.writeInFile(allLines,"./File/Customers.txt",false);
    }
	
	public void actionPerformed(ActionEvent e){
		if(addBtn == e.getSource()){
	 		String id = idField.getText();
	 		String name = nameField.getText();
	 		String number = numberField.getText();
	 		String membership;
	 		if(silver.isSelected()){
	 			membership = silver.getText();
	 		}
	 		else if(gold.isSelected()){
	 			membership = gold.getText();
	 		}
			else{
	 			membership = platinum.getText();
	 		}
	 		if (!id.isEmpty() && !name.isEmpty() && !number.isEmpty() && !membership.isEmpty()){
				Customer c = new Customer(Integer.parseInt(id),name,number,membership);
				customers.insert(c);
                model.addRow(new Object[]{c.getCustomerId(),c.getCustomerName(),c.getCustomerNumber(),c.getMembership()});
                idField.setText("");
                nameField.setText("");
                numberField.setText("");
                updateFile();
	 		}
	 		else{
	 			JOptionPane.showMessageDialog(this,"Please Enter All Details","Data Entry Warning",JOptionPane.WARNING_MESSAGE);
	 		}
	 	}
	 	if(deleteBtn == e.getSource()){
	 		int rows[] = customerTable.getSelectedRows();
	 		if(rows!=null){
	 			Arrays.sort(rows);
	 			for(int i= rows.length-1; i>=0;i--){
					customers.removeByID(Integer.parseInt(customerTable.getModel().getValueAt(rows[i],0).toString()));
					model.removeRow(rows[i]);
				}

	 		}
	 		updateFile();
	 	}
		if(backBtn == e.getSource()){
			dashboard.setVisible(true);
			this.dispose();
			updateFile();
		}
	}
}
