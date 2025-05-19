package GUI;
import java.lang.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import javax.swing.table.*;
	
import Entity.*;
import EntityList.*;
import File.*;
import java.util.Arrays;
import java.util.ArrayList;

public class ProductPage extends JFrame implements ActionListener{
	JPanel panel;
	JButton addBtn,deleteBtn,backBtn;
	JLabel NameLabel,IdLabel,PriceLabel,CatagoryLabel,QuantityLabel,SeasonLabel,DrinktypeLabel,productmanageLabel,meatorfishLabel;
	JTextField NameField,IdField,PriceField,QuantityField,SeasonField,DrinktypeField,meatorfishField;
	
	JTable table;
	DefaultTableModel model;
	JComboBox cmbox;
	
	Dashboard dashboard;
	ProductList products;

	// fonts
	Font font = new Font("poppins", Font.PLAIN, 19);
	Font boldFont = new Font("roboto", Font.BOLD, 24);
	
	// colors
	Color greenColor = new Color(0,204,0);
	Color blueColor = new Color(25, 113, 255);
	Color redColor = new Color(250, 20, 20);

	private String[] catagory = {"Vegetable and Fruit", "Meat and Fish","Drinks" };
	
	public ProductPage(Dashboard dashboard, ProductList products){
		super("Shop Management System 2024 - Products Informations");
		this.dashboard = dashboard;
		this.products = products;
		initialization();
		
		
		productmanageLabel = new JLabel("MANAGE PRODUCTS");
		productmanageLabel.setBounds(80,5,350,50);
	    productmanageLabel.setFont(boldFont);
	    productmanageLabel.setForeground(Color.BLACK);
		this.add(productmanageLabel);


		IdLabel = new JLabel("ID :");
		IdLabel.setBounds(80,60,150,30);
	    IdLabel.setFont(font);
		this.add(IdLabel);
		
		IdField = new JTextField();
		IdField.setBounds(190,60,150,30);
		IdField.setFont(font);
		this.add(IdField);
		
		NameLabel = new JLabel("Name :");
		NameLabel.setBounds(80,100,150,30);
		NameLabel.setFont(font);
		this.add(NameLabel);
		
		NameField = new JTextField();
		NameField.setBounds(190,100,150,30);
		NameField.setFont(font);
		this.add(NameField);
		
		PriceLabel = new JLabel("Price :");
		PriceLabel.setBounds(80,140,150,30);
		PriceLabel.setFont(font);
		this.add(PriceLabel);
		
		PriceField = new JTextField();
		PriceField.setBounds(190,140,150,30);
		PriceField.setFont(font);
		this.add(PriceField);
		
		QuantityLabel = new JLabel("Quantity :");
		QuantityLabel.setBounds(80,180,150,30);
		QuantityLabel.setFont(font);
		this.add(QuantityLabel);
		
		QuantityField = new JTextField();
		QuantityField.setBounds(190,180,150,30);
		QuantityField.setFont(font);
		this.add(QuantityField);
		
		CatagoryLabel = new JLabel("Catagory");
		CatagoryLabel.setBounds(420,60,150,30);
		CatagoryLabel.setFont(font);
		this.add(CatagoryLabel);
		
		
		SeasonLabel = new JLabel("Season :");
		SeasonLabel.setBounds(420,100,150,30);
		SeasonLabel.setFont(font);
		this.add(SeasonLabel);
		
		SeasonField = new JTextField();
		SeasonField.setBounds(580,100,150,30);
		SeasonField.setFont(font);
		this.add(SeasonField);
		
		
		DrinktypeLabel = new JLabel("Drinktype :");
		DrinktypeLabel.setBounds(420,140,150,30);
		DrinktypeLabel.setFont(font);
		this.add(DrinktypeLabel);
		
		DrinktypeField = new JTextField();
		DrinktypeField.setBounds(580,140,150,30);
		DrinktypeField.setFont(font);
		this.add(DrinktypeField);
		
		
		meatorfishLabel = new JLabel("Meat Fish Type :");
		meatorfishLabel.setBounds(420,180,150,30);
		meatorfishLabel.setFont(font);
		this.add(meatorfishLabel);
		
		meatorfishField = new JTextField();
		meatorfishField.setBounds(580,180,150,30);
		meatorfishField.setFont(font);
		this.add(meatorfishField);
		
		
	
		cmbox = new JComboBox(catagory);
		cmbox.setBounds(580,60,150,30);
		cmbox.setEditable(true);
		this.add(cmbox);
		createTable();
		
		addBtn = createButton(800,80,120,40,"ADD");
		addBtn.setBackground(greenColor);
		
		deleteBtn = createButton(800,130,120,40,"DELETE");
		deleteBtn.setBackground(redColor);
		
		backBtn = createButton(860,610,90,35,"BACK");
		backBtn.setBackground(redColor);
		
		this.setVisible(true);
	}
	
	public void initialization(){
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(1000,700);
		this.setLocation(300, 70);
		this.setLayout(null);
		this.setIconImage(new ImageIcon("./Assets/Images/shopIcon.png").getImage());
		this.getContentPane().setBackground(Color.CYAN);
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setSize(1920,1080);
		panel.setBackground(Color.CYAN);
		panel.setOpaque(false);
		this.add(panel);
		
	}
	
	public JButton createButton(int x,int y,int w,int h, String text){
		JButton btn = new JButton(text);
		btn.setBounds(x, y, w,h);
		btn.setFont(font);
		btn.addActionListener(this);
		btn.setBackground(Color.BLACK);
		btn.setForeground(Color.WHITE);
		panel.add(btn);
		return btn;
	}
	
	public void createTable(){
		model = new DefaultTableModel();
		model.addColumn("Id");
		model.addColumn("Name");
		model.addColumn("Price");
		model.addColumn("Quantity");
		model.addColumn("Season");
		model.addColumn("Drinktype");
		model.addColumn("Meat/Fish");
		
		
		table = new JTable(model);
		table.setFont(font);
		table.getTableHeader().setFont(font);
		table.setBounds(0,0, 200, 100);
		table.setRowHeight(30);
		table.setBackground(Color.YELLOW);
		table.setSelectionBackground(Color.GRAY);
		
		JScrollPane scrollpane = new JScrollPane(table);
		scrollpane.setBounds(50,230,900,380);
		
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
		if(addBtn == e.getSource()){
			String Id =  IdField.getText();
			String Name = NameField.getText();
			String Price = PriceField.getText();
			String Quantity = QuantityField.getText();
			String Season = SeasonField.getText();
			String Drinktype = DrinktypeField.getText();
			String meatOrFish = meatorfishField.getText();
			if(!Id.isEmpty() && !Name.isEmpty() && !Price.isEmpty() && !Quantity.isEmpty()){
				if(cmbox.getSelectedItem() == "Vegetable and Fruit"){
					VegetableAndFruit vegi = new VegetableAndFruit(Integer.parseInt(Id),Name,Double.parseDouble(Price),Integer.parseInt(Quantity),Season);
					products.insert(vegi);
					model.addRow(new Object[]{Id,Name,Price,Quantity,Season,"-","-"});
				}
				else if(cmbox.getSelectedItem() == "Meat and Fish"){
					MeatAndFish meatFish = new MeatAndFish(Integer.parseInt(Id),Name,Double.parseDouble(Price),Integer.parseInt(Quantity),meatOrFish);
					products.insert(meatFish);
					model.addRow(new Object[]{Id,Name,Price,Quantity,"-","-",meatOrFish});
				}
				else if(cmbox.getSelectedItem() == "Drinks"){
					Drinks drink = new Drinks(Integer.parseInt(Id),Name,Double.parseDouble(Price),Integer.parseInt(Quantity),Drinktype);
					products.insert(drink);
					model.addRow(new Object[]{Id,Name,Price,Quantity,"-",Drinktype,"-"});
				}
								
				NameField.setText("");
				IdField.setText("");
				PriceField.setText("");
				SeasonField.setText("");
			    QuantityField.setText("");
			    DrinktypeField.setText("");
			    meatorfishField.setText("");
				updateFile();
			}
			else{
				JOptionPane.showMessageDialog(this,"Please Enter All Details","Data Entry Warning",JOptionPane.WARNING_MESSAGE );
			}
		}
		
		else if(deleteBtn == e.getSource()){
	 		int rows[] = table.getSelectedRows();
	 		if(rows!=null){
	 			Arrays.sort(rows);
	 			for(int i= rows.length-1; i>=0;i--){
					products = new ProductList();
					products.removeById(Integer.parseInt(table.getModel().getValueAt(rows[i],0).toString() ) );
					model.removeRow(rows[i]);
				}
	 		}
			updateFile();
		}
		if(backBtn == e.getSource()){
			dashboard.setVisible(true);
	 		this.dispose();
		}
	}
	
}


	