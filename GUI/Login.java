package GUI;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.geom.*;
import java.awt.*;
import java.awt.event.*;
import File.*;

public class Login extends JFrame implements ActionListener{
	
	JPanel panel;
	JLabel userNameLabel, userPassLabel, backgroundImgLabel, loginPanelText, btnDivider;
	JTextField userNameText;
	JPasswordField userPasswordField;
	JButton loginBtn, registerBtn;
	
	// font
	Font font = new Font("poppins", Font.PLAIN, 19); 
	Font boldFont = new Font("roboto", Font.BOLD, 35);
	Font paragraphFont = new Font("cambria", Font.PLAIN, 18); 
	public Login(){
		super("Shop Management System - Login");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(1000, 700);
		this.setLocation(300, 70);
		this.getContentPane().setBackground(new Color(179, 230, 204));
		this.setLayout(null);
		this.setIconImage(new ImageIcon("./Assets/Images/shopIcon.png").getImage());
		
		// background image
		ImageIcon backgroundImg = new ImageIcon("./Assets/Images/loginBackgroundImage.gif");
		backgroundImgLabel = new JLabel();
		backgroundImgLabel.setBounds(-70, 0, 550, 700);
		backgroundImgLabel.setIcon(backgroundImg);
		this.add(backgroundImgLabel);
		
		// login panel header
		loginPanelText = new JLabel("LOGIN PANEL");
		loginPanelText.setBounds(600, 100, 350, 40);
		loginPanelText.setFont(boldFont);
		this.add(loginPanelText);
		// login panel text
		loginPanelText = new JLabel("Enter your user name and password to login");
		loginPanelText.setBounds(551, 140, 350, 40);
		loginPanelText.setFont(new Font("cambria", Font.PLAIN, 17));
		this.add(loginPanelText);
		
		// user name label
		userNameLabel = new JLabel("User Name");
		userNameLabel.setBounds(550,200,250,25);
		userNameLabel.setFont(font);
		this.add(userNameLabel);
		// user name text field
		userNameText = new JTextField("");
		userNameText.setBounds(550,235,340,40);
		userNameText.setFont(font);
		this.add(userNameText);
		
		// user password label
		userPassLabel = new JLabel("Password");
		userPassLabel.setBounds(550,285,250,25);
		userPassLabel.setFont(font);
		this.add(userPassLabel);
		// user password field
		userPasswordField = new JPasswordField("");
		userPasswordField.setBounds(550,320,340,40);
		userPasswordField.setFont(font);
		this.add(userPasswordField);
		
		// login button
		loginBtn = new JButton("Login");
		loginBtn.setBounds(550, 390, 340, 40);
		loginBtn.setFont(font);
		loginBtn.setForeground(Color.WHITE);
		loginBtn.setBackground(new Color(25, 113, 255)); // BLUE new Color(25, 113, 255);
		loginBtn.setBorder(new EmptyBorder(0, 0, 0, 0));
		loginBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		loginBtn.addActionListener(this);
		this.add(loginBtn);
		
		// divider label
		btnDivider = new JLabel("**********  Don't have account?  **********");
		btnDivider.setForeground(new Color(0, 0, 0));
		btnDivider.setBounds(550, 435, 340, 40);
		btnDivider.setFont(paragraphFont);
		this.add(btnDivider);
		
		// registration button
		registerBtn = new JButton("Register Now");
		registerBtn.setBounds(550, 480, 340, 40);
		registerBtn.setFont(font);
		registerBtn.setForeground(Color.WHITE);
		registerBtn.setBackground(new Color(0, 230, 22)); 
		registerBtn.setBorder(new EmptyBorder(0, 0, 0, 0));
		registerBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		registerBtn.addActionListener(this);
		this.add(registerBtn);
		
		// background panel for color
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0, 0, 500, 800);
		panel.setBackground(new Color(255, 255, 255));
		this.add(panel);
		
		this.setVisible(true);
	}
	
	// using action listener
	public void actionPerformed(ActionEvent e) {
        if(loginBtn == e.getSource()){
			String name = userNameText.getText();
			String password = String.valueOf(userPasswordField.getPassword());
			int status = FileIO.checkUser(name,password,"./File/users.txt");
            if (status == 1) {
				
				JOptionPane.showMessageDialog(this, "Login Successfull");
				
				Dashboard dashboardPage = new Dashboard(this);
				
                userNameText.setText("");
				userPasswordField.setText("");
                this.setVisible(false);
            } 
			else if(status == 2){
                JOptionPane.showMessageDialog(this, "Invalid Password", 
											  "Error",JOptionPane.WARNING_MESSAGE);
            }
			else{
                JOptionPane.showMessageDialog(this, "USER NOT REGISTERED", 
											  "Error",JOptionPane.ERROR_MESSAGE);
            }
		}
		
		if(registerBtn == e.getSource()){
			Register registerPage = new Register(this);
			this.setVisible(false);
		}
    }
}
