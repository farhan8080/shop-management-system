package GUI;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.*;
import java.text.DecimalFormat;

import Entity.*;
import EntityList.*;
import java.util.Arrays;
import java.util.ArrayList;
import File.*;

public class CartPage extends JFrame implements ActionListener{
	JPanel panel;
	JLabel productHeader, customerHeader, customerName, customerStatus,
    	cStatus, customerMembership, cMembership, totalPrice, tPrice, cQuantity;
	JTextField customerNameField;
	JButton backbtn, checkBtn, plusBtn, minBtn, clearQBtn, addBtn, removeBtn, buyBtn;
	JTable table, table1, table2;
	DefaultTableModel model, model1, model2;
	Cursor cursor;
	
	Dashboard dashboard;
	ProductList products;
	CustomerList customers;
	
	// fonts
	Font font = new Font("poppins", Font.PLAIN, 19);
	Font boldFont = new Font("roboto", Font.BOLD, 24);
	Font font1= new Font ("Arial",Font.BOLD,19);
    // colors
	Color greenColor = new Color(0,204,0);
	Color blueColor = new Color(25, 113, 255);
	Color redColor = new Color(250, 20, 20);
	
	public CartPage(Dashboard dashboard, ProductList products, CustomerList customers){
		super("Shop Management System 2024 - Sells Panel");
		this.dashboard = dashboard;
		this.products = products;
		this.customers = customers;
		initialization();
		
		productHeader = new JLabel("PRODUCT LISTS");
		productHeader.setBounds(50,5, 300, 40);
		productHeader.setFont(boldFont);
		productHeader.setForeground(Color.BLACK);
		productHeader.setBackground(Color.CYAN);
		this.add(productHeader);
		
		customerHeader = new JLabel("CHECK CUSTOMER INFO");
		customerHeader.setBounds(550, 5, 400, 40);
		customerHeader.setFont(boldFont);
		customerHeader.setBackground(Color.CYAN);
		customerHeader.setForeground(Color.BLACK);
		this.add(customerHeader);
		
		customerName = new JLabel("Customer Name");
		customerName.setBounds(500, 50, 200, 30);
		customerName.setForeground(Color.BLACK);
		customerName.setBackground(Color.CYAN);
		customerName.setFont(font);
		this.add(customerName);
		
		customerNameField = new JTextField();
		customerNameField.setBounds(650, 50, 200, 35);
		customerNameField.setBackground(Color.WHITE);
		customerNameField.setForeground(Color.BLACK);
		customerNameField.setFont(font);
		this.add(customerNameField);
		
		customerStatus = new JLabel("Customer Status :");
		customerStatus.setBounds(500, 95, 200, 30);
		customerStatus.setBackground(Color.CYAN);
		customerStatus.setForeground(Color.BLACK);
		customerStatus.setFont(font);
		this.add(customerStatus);
		
		cStatus = new JLabel("New Customer");
		cStatus.setBounds(800, 95, 200, 30);
		cStatus.setBackground(Color.CYAN);
		cStatus.setForeground(Color.BLACK);
		cStatus.setFont(font);
		this.add(cStatus);
		
		
		customerMembership = new JLabel("Customer Membership :");
		customerMembership.setBounds(500, 125, 250, 30);
		customerMembership.setBackground(Color.CYAN);
		customerMembership.setForeground(Color.BLACK);
		customerMembership.setFont(font);
		this.add(customerMembership);
		
		cMembership = new JLabel("Regular");
		cMembership.setBounds(800, 125, 200, 30);
		cMembership.setBackground(Color.CYAN);
		cMembership.setForeground(Color.BLACK);
		cMembership.setFont(font);
		this.add(cMembership);
		
		
		totalPrice = new JLabel("Total Price :");
		totalPrice.setBounds(500, 160, 250, 30);
		totalPrice.setBackground(Color.CYAN);
		totalPrice.setForeground(Color.BLACK);
		totalPrice.setFont(font);
		this.add(totalPrice);
		
		tPrice = new JLabel("0.0");
		tPrice.setBounds(800, 160, 200, 30);
		tPrice.setFont(font);
		this.add(tPrice);
		
		
        cursor = new Cursor(Cursor.HAND_CURSOR);
		
		
		checkBtn = new JButton("CHECK");
		checkBtn.setBounds(870, 50, 80, 35);
		checkBtn.setFont(font);
		checkBtn.setForeground(Color.WHITE);
		checkBtn.setCursor(cursor);
		checkBtn.setBackground(Color.BLUE);
		checkBtn.setBorder(new EmptyBorder(0,0,0,0));
		checkBtn.addActionListener(this);
		this.add(checkBtn);
		
		// clear quantity button
		clearQBtn = new JButton("CLEAR");
		clearQBtn.setBounds(155,610,80,35);
		clearQBtn.setFont(font);
		clearQBtn.setForeground(Color.WHITE);
		clearQBtn.setCursor(cursor);
		clearQBtn.setBackground(blueColor);
		clearQBtn.setBorder(new EmptyBorder(0, 0, 0, 0));
		clearQBtn.addActionListener(this);
		this.add(clearQBtn);
		
		// min button
		minBtn = new JButton("-");
		minBtn.setBounds(245,610,35,35);
		minBtn.setFont(new Font("poppins", Font.BOLD, 28));
		minBtn.setForeground(Color.WHITE);
		minBtn.setCursor(cursor);
		minBtn.setBackground(blueColor);
		minBtn.setBorder(new EmptyBorder(0, 0, 0, 0));
		minBtn.addActionListener(this);
		this.add(minBtn);
		
		// count quantity
		cQuantity = new JLabel("0");
		cQuantity.setBounds(290, 610, 50, 35);
		cQuantity.setFont(font);
		this.add(cQuantity);
		
		// plus button
		plusBtn = new JButton("+");
		plusBtn.setBounds(345,610,35,35);
		plusBtn.setFont(new Font("poppins", Font.BOLD, 28));
		plusBtn.setForeground(Color.WHITE);
		plusBtn.setCursor(cursor);
		plusBtn.setBackground(blueColor);
		plusBtn.setBorder(new EmptyBorder(0, 0, 0, 0));
		plusBtn.addActionListener(this);
		this.add(plusBtn);
		
		// add button
		addBtn = new JButton("ADD");
		addBtn.setBounds(390,610,80,35);
		addBtn.setFont(font);
		addBtn.setForeground(Color.WHITE);
		addBtn.setCursor(cursor);
		addBtn.setBackground(greenColor);
		addBtn.setBorder(new EmptyBorder(0, 0, 0, 0));
		addBtn.addActionListener(this);
		this.add(addBtn);
		
		// remove button
		removeBtn = new JButton("REMOVE");
		removeBtn.setBounds(500,610,100,35);
		removeBtn.setFont(font);
		removeBtn.setForeground(Color.WHITE);
		removeBtn.setCursor(cursor);
		removeBtn.setBackground(redColor);
		removeBtn.setBorder(new EmptyBorder(0, 0, 0, 0));
		removeBtn.addActionListener(this);
		this.add(removeBtn);
		
		// buy button
		buyBtn = new JButton("BUY");
		buyBtn.setBounds(870,610,80,35);
		buyBtn.setFont(font);
		buyBtn.setForeground(Color.WHITE);
		buyBtn.setCursor(cursor);
		buyBtn.setBackground(greenColor);
		buyBtn.setBorder(new EmptyBorder(0, 0, 0, 0));
		buyBtn.addActionListener(this);
		this.add(buyBtn);
		
		//back btn create
		backbtn = new JButton("BACK");
		backbtn.setBounds(20,610,80,35);
		backbtn.setFont(font);
		backbtn.setForeground(Color.WHITE);
		backbtn.setCursor(cursor);
		backbtn.setBackground(Color.BLACK);
		backbtn.setBorder(new EmptyBorder(0, 0, 0, 0));
		backbtn.addActionListener(this);
		this.add(backbtn);
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setSize(2000,1000);
		panel.setBackground(Color.CYAN);
		this.add(panel);
		productTable();
		cartTable();
	}
	
	public void initialization(){
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(1000, 700);
		this.setLocation(300, 70);
		this.setLayout(null);
		this.setVisible(true);
		this.setIconImage(new ImageIcon("./Assets/Images/shopIcon.png").getImage());
	}
	
	public void productTable(){
		model = new DefaultTableModel();
		model.addColumn("ID");
		model.addColumn("NAME");
		model.addColumn("PRICE");
		model.addColumn("IN STOCK");
		model.addColumn("SEASON");
		model.addColumn("DRINK");
		model.addColumn("FISH/MEAT");
		

		table = new JTable(model);
		table.setFont(new Font("poppins", Font.PLAIN, 13));
		table.getTableHeader().setFont(new Font("poppins", Font.PLAIN, 13));
		table.setBounds(0,0,400,500);
		table.setRowHeight(35);
		table.setBackground(Color.YELLOW);
		table.setSelectionBackground(Color.GRAY);


        JScrollPane scrollpane = new JScrollPane(table);
		scrollpane.setBounds(20,50,450,550);
		
		ArrayList <Product> allProducts =  products.getAll();
		for(int i=0;i<allProducts.size();i++){
			Product c = allProducts.get(i);
			if( c instanceof VegetableAndFruit){
				VegetableAndFruit v = (VegetableAndFruit) c;
				model.addRow(new Object[]{v.getProductId(),v.getProductName(),v.getProductPrice(),v.getQuantity(),v.getSeason(),"-","-"});
			}
			else if(c instanceof MeatAndFish){
				MeatAndFish m = (MeatAndFish) c;
				model.addRow(new Object[]{m.getProductId(),m.getProductName(),m.getProductPrice(),m.getQuantity(),"-","-",m.getCatagory()});
			}
			else if(c instanceof Drinks){
				Drinks d = (Drinks) c;
				model.addRow(new Object[]{d.getProductId(),d.getProductName(),d.getProductPrice(),d.getQuantity(),"-",d.getDrinktype(),"-"});
			}
		}
		
		panel.add(scrollpane);
	}
	
	
	public void cartTable(){
		model2 = new DefaultTableModel();
		model2.addColumn("ID");
		model2.addColumn("NAME");
		model2.addColumn("PRICE");
		model2.addColumn("QUANTITY");
		

		table2 = new JTable(model2);
		table2.setFont(new Font("poppins", Font.PLAIN, 15));
		table2.getTableHeader().setFont(new Font("poppins", Font.PLAIN, 15));
		table2.setBounds(0,0,400,500);
		table2.setRowHeight(35);
		table2.setBackground(Color.YELLOW);
		table2.setSelectionBackground(Color.GRAY);
		table.setBackground(Color.YELLOW);
		

        JScrollPane scrollpane = new JScrollPane(table2);
		scrollpane.setBounds(500,200,450,400);
		
		
		panel.add(scrollpane);
	}
	
	public void updateFile(){
    	int rows = model.getRowCount();
    	String allLines = "";
    	for(int i= 0; i < rows; i++){
    	   String id = table.getModel().getValueAt(i,0).toString();
		   String name = table.getModel().getValueAt(i,1).toString();
		   String price = table.getModel().getValueAt(i,2).toString();
		   String quantity = table.getModel().getValueAt(i,3).toString();
		   String season = table.getModel().getValueAt(i,4).toString();
		   String drinkType = table.getModel().getValueAt(i,5).toString();
		   String meatandfish = table.getModel().getValueAt(i,6).toString();
		   String line;
		   if(i<rows-1){
					 line = id+";"+name+";"+price+";"+quantity+";"+season+";"+drinkType+";"+meatandfish+"\n";
				}
				else{
					 line = id+";"+name+";"+price+";"+quantity+";"+season+";"+drinkType+";"+meatandfish;
				}
				allLines+= line;
		}
			FileIO.writeInFile(allLines,"./File/products.txt",false);
    }
	
	public void actionPerformed(ActionEvent e){
		if(checkBtn == e.getSource()){
			String name = customerNameField.getText();
			int cusStatus = FileIO.checkCustomer(name,"./File/Customers.txt");
			String memStatus = FileIO.checkMembership(name,"./File/Customers.txt");
			if(cusStatus == 1){
				cStatus.setText(name);
				cMembership.setText(memStatus);
				customerNameField.setText("");
			}
			else {
				cStatus.setText("New Customer");
				cMembership.setText("Regular");
				customerNameField.setText("");
			}
		}
		
		int count = Integer.parseInt(cQuantity.getText());
		if(plusBtn == e.getSource()){
			count += 1;
			String countQ = String.valueOf(count);
			cQuantity.setText(countQ);
		}
		if(minBtn == e.getSource()){
			if(count != 0){
				count -= 1;
				String countQ = String.valueOf(count);
				cQuantity.setText(countQ);
			}
		}
		if(clearQBtn == e.getSource()){
			cQuantity.setText("0");
		}
		
		if(addBtn == e.getSource()){
	 		if(count == 0){
				JOptionPane.showMessageDialog(this,"Please Increse Quantity!!!","Warning",JOptionPane.WARNING_MESSAGE );
			}
			else{
				int[] rows = table.getSelectedRows();
				Object row[] = new Object[4];
				for(int i= 0; i < rows.length; i++){
					row[0] = model.getValueAt(rows[i],0);
					row[1] = model.getValueAt(rows[i],1);
					row[2] = model.getValueAt(rows[i],2);
					row[3] = count;
					model2.addRow(row);
					
					int p = Integer.parseInt(table.getModel().getValueAt(rows[i],3).toString()) - count;
					String quantity = String.valueOf(p);
					model.setValueAt(quantity, rows[i], 3);
					
					double pr = Double.parseDouble(tPrice.getText());
					String memStatus = cMembership.getText();
					pr += Double.parseDouble(table.getModel().getValueAt(rows[i],2).toString()) * count;
					tPrice.setText(String.valueOf(pr));
				}
			}
			cQuantity.setText("0");
		}
		
		int id1, id2;
		if(removeBtn == e.getSource()){
	 		int rows[] = table2.getSelectedRows();
			int add = 0;
			String getId2;
	 		if(rows!=null){
	 			for(int i= rows.length-1; i>=0;i--){
					add += Integer.parseInt(table2.getModel().getValueAt(rows[i],3).toString());
					getId2 = table.getModel().getValueAt(rows[i],0).toString();
					double currentPr = Double.parseDouble(tPrice.getText());
					double pr2 = Double.parseDouble(table2.getModel().getValueAt(rows[i],2).toString()) * add;
					tPrice.setText(String.valueOf(currentPr - pr2));
					model2.removeRow(rows[i]);
				}
	 		}
			
			int[] rows1 = table.getSelectedRows();
			for(int i= 0; i < rows1.length; i++){
				add += Integer.parseInt(table.getModel().getValueAt(rows1[i],3).toString());
				model.setValueAt(add, rows1[i], 3);
			}
		}
		
		if(buyBtn == e.getSource()){
			if(table2.getRowCount() > 0){
				double finalP = Double.parseDouble(tPrice.getText());
					
				double silver = Double.parseDouble(new DecimalFormat("##.####").format(finalP-(finalP*0.05)));
				double gold = Double.parseDouble(new DecimalFormat("##.####").format(finalP-(finalP*0.1)));
				double platinum = Double.parseDouble(new DecimalFormat("##.####").format(finalP-(finalP*0.15)));
				String memStatus = cMembership.getText();
				
				if(memStatus == "Silver"){
					finalP = silver;
				}
				else if(memStatus == "Gold"){
					finalP = silver;
				}
				else if(memStatus.equals("Platinum")){
					finalP = silver;
				}
				
				int confirmed = JOptionPane.showConfirmDialog(null, "TOTAL PRICE WITH DISCOUNT : "+finalP,"CONFIRM ORDER!",JOptionPane.YES_NO_OPTION);
				if(confirmed == JOptionPane.YES_OPTION)
				{
					model2.getDataVector().removeAllElements();
					model2.fireTableDataChanged();
					updateFile();
				}
				tPrice.setText("0.0");
			}
			else {
				JOptionPane.showMessageDialog(this,"Your Cart Is Empty. Please Add Product!","Empty Cart",JOptionPane.WARNING_MESSAGE );
			}
		}
		
		if(backbtn == e.getSource()){
			dashboard.setVisible(true);
			this.dispose();
		}
	}
}

