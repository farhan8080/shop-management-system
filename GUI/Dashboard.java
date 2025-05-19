package GUI;
import 	java.lang.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

import Entity.*;
import EntityList.*;
import File.*;

public class Dashboard extends JFrame implements ActionListener{
	JPanel panel;
	JLabel adminPanelHeader, backgroundImgLabel;
	JButton employeeBtn, customerBtn, productBtn, sellsBtn, logoutBtn;
	
	Login loginPage;
	Cursor cursor;


	
	EmployeeList employees = new EmployeeList();
	CustomerList customers = new CustomerList();
	ProductList products = new ProductList();
	
	// fonts
	Font font = new Font("poppins", Font.PLAIN, 19);
	Font boldFont = new Font("roboto", Font.BOLD, 35);
	
	// colors
	Color blueColor = new Color(25, 113, 255);
	Color redColor = new Color(250, 20, 20);
	
	public Dashboard(Login loginPage){
		super("Shop Management System - Dashboard");
		this.loginPage = loginPage;
		initialization();
		
		// admin panel header
		adminPanelHeader = new JLabel("ADMIN PANEL");
		adminPanelHeader.setBounds(150, 60, 350, 40);
		adminPanelHeader.setFont(boldFont);
		this.add(adminPanelHeader);
		
		// create Cursor
        cursor = new Cursor(Cursor.HAND_CURSOR);
		
		// employee button
		Icon employeeIcon = new ImageIcon("./Assets/Images/employee.png");
		employeeBtn = new JButton(" Employee Information's", employeeIcon);
		employeeBtn.setBounds(125, 130, 300, 80);
		employeeBtn.setFont(font);
		employeeBtn.setForeground(Color.black);
		employeeBtn.setBackground(Color.white);
		employeeBtn.setBorder(new EmptyBorder(0, 0, 0, 0));
		employeeBtn.addActionListener(this);
		employeeBtn.setCursor(cursor);
		this.add(employeeBtn);
		
		// customer button
		Icon customerIcon = new ImageIcon("./Assets/Images/customer.png");
		customerBtn = new JButton(" Customer Information's", customerIcon);
		customerBtn.setBounds(125, 240, 300, 80);
		customerBtn.setFont(font);
		customerBtn.setForeground(Color.black);
		customerBtn.setBackground(Color.white);
		customerBtn.setBorder(new EmptyBorder(0, 0, 0, 0));
		customerBtn.addActionListener(this);
		customerBtn.setCursor(cursor);
		this.add(customerBtn);
		
		// product button
		Icon productIcon = new ImageIcon("./Assets/Images/product.png");
		productBtn = new JButton(" Product Information's", productIcon);
		productBtn.setBounds(125, 350, 300, 80);
		productBtn.setFont(font);
		productBtn.setForeground(Color.black);
		productBtn.setBackground(Color.white);
		productBtn.setBorder(new EmptyBorder(0,0,0,0));
		productBtn.addActionListener(this);
		productBtn.setCursor(cursor);
		this.add(productBtn);
		
		// sells button
		Icon sellsIcon = new ImageIcon("./Assets/Images/cart.png");
		sellsBtn = new JButton("  Sells Panel", sellsIcon);
		sellsBtn.setBounds(125, 460, 300, 80);
		sellsBtn.setFont(font);
		sellsBtn.setForeground(Color.black);
		sellsBtn.setBackground(Color.white);
		sellsBtn.setBorder(new EmptyBorder(0,0,0,0));
		sellsBtn.addActionListener(this);
		sellsBtn.setCursor(cursor);
		this.add(sellsBtn);
		
		// logout button
		logoutBtn = new JButton("Log out");
		logoutBtn.setBounds(50, 580, 100, 45);
		logoutBtn.setFont(font);
		logoutBtn.setForeground(Color.WHITE);
		logoutBtn.setBackground(redColor);
		logoutBtn.setBorder(new EmptyBorder(0,0,0,0));
		logoutBtn.addActionListener(this);
		logoutBtn.setCursor(cursor);
		this.add(logoutBtn);
		
		// background image
		ImageIcon backgroundImg = new ImageIcon("./Assets/Images/dashboardBackground.jpg");
		backgroundImgLabel = new JLabel();
		backgroundImgLabel.setBounds(550, 0, 450, 700);
		backgroundImgLabel.setIcon(backgroundImg);
		this.add(backgroundImgLabel);
		
		// background panel for color
		panel = new JPanel();
		panel.setSize(1920, 1080);
		panel.setLayout(null);
		panel.setBackground(new Color(255, 255, 102));
		this.add(panel);
	}
	
	public void initialization(){
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(1000, 700);
		this.setLocation(300, 70);
		this.setLayout(null);
		this.setVisible(true);
		this.setIconImage(new ImageIcon("./Assets/Images/shopIcon.png").getImage());
	}
	
	public void actionPerformed(ActionEvent e){
		if(employeeBtn == e.getSource()){
			employees = new EmployeeList();
			FileIO.loadEmployeeFromFile(employees,"./File/employees.txt");
			employeepage emPage = new employeepage(this,employees);
			this.setVisible(false);
		}
		if(customerBtn == e.getSource()){
			customers = new CustomerList();
			FileIO.loadCustomerFromFile(customers,"./File/Customers.txt");
			CustomerPage customerPage = new CustomerPage(this,customers);
			this.setVisible(false);
		}
		if(productBtn == e.getSource()){
			products = new ProductList();
			FileIO.loadProductFromFile(products,"./File/products.txt");
			ProductPage productpage = new ProductPage(this, products);
			this.setVisible(false);
		}
		if(sellsBtn == e.getSource()){
			customers = new CustomerList();
			FileIO.loadCustomerFromFile(customers,"./File/Customers.txt");
			products = new ProductList();
			FileIO.loadProductFromFile(products,"./File/products.txt");
			CartPage sellsCart = new CartPage(this, products, customers);
			this.setVisible(false);
		}
		if(logoutBtn == e.getSource()){
			int confirmed = JOptionPane.showConfirmDialog(null, "Do You Want To  Log Out?","LOG OUT",JOptionPane.YES_NO_OPTION);
			if(confirmed == JOptionPane.YES_OPTION)
			{
				this.dispose();
				loginPage.setVisible(true);
			}
		}	
	}
}