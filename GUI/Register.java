package GUI;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import File.*;
import java.lang.*;
import java.io.*;
import java.util.*;
import java.time.*;
import java.time.format.*;

public class Register extends JFrame implements ActionListener {
	JPanel panel;
	JLabel backgroundImgLabel, registerHeader, username, password, cap1, cap2, numberJLabel, emaiJLabel;
	JTextField usernameField, capt1, numberField, emaField;
	JPasswordField userPasswordField;
	JButton backBtn, registerBtn;
	int a, b, result;

	Login loginPage;

	// fonts
	Font font = new Font("poppins", Font.PLAIN, 19);
	Font boldFont = new Font("roboto", Font.BOLD, 35);

	// colors
	Color greenColor = new Color(0, 204, 0);
	Color blueColor = new Color(25, 113, 255);
	Color redColor = new Color(250, 20, 20);

	public Register(Login loginPage) {
		super("Shop Management System 2023 - Register");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(1000, 700);
		this.setLocation(300, 70);
		this.setLayout(null);
		this.setIconImage(new ImageIcon("./Assets/Images/shopIcon.png").getImage());
		this.loginPage = loginPage;


		ImageIcon backgroundImg = new ImageIcon("./Assets/Images/registerBackground.jpg");
		backgroundImgLabel = new JLabel();
		backgroundImgLabel.setBounds(550, 0, 1000, 700);
		backgroundImgLabel.setIcon(backgroundImg);
		this.add(backgroundImgLabel);

		// register header
		registerHeader = new JLabel("REGISTER HERE");
		registerHeader.setBounds(130, 60, 300, 40);
		registerHeader.setFont(boldFont);
		this.add(registerHeader);

		// usename label
		username = new JLabel("ENTER USER NAME :");
		username.setBounds(100, 120, 250, 40);
		username.setFont(font);
		this.add(username);
		// Username Field
		usernameField = new JTextField();
		usernameField.setBounds(100, 160, 340, 40);
		usernameField.setFont(font);
		this.add(usernameField);

		// User Password label
		password = new JLabel("ENTER PASSWORD :");
		password.setBounds(100, 200, 250, 40);
		password.setFont(font);
		this.add(password);
		// User PasswordField
		userPasswordField = new JPasswordField();
		userPasswordField.setBounds(100, 240, 340, 40);
		userPasswordField.setFont(font);
		this.add(userPasswordField);

		// user number label
		numberJLabel = new JLabel("ENTER YOUR NUMBER :");
		numberJLabel.setBounds(100, 280, 250, 40);
		numberJLabel.setFont(font);
		this.add(numberJLabel);

		// user number field
		numberField = new JTextField();
		numberField.setBounds(100, 320, 340, 40);
		numberField.setFont(font);
		this.add(numberField);

		// email label
		emaiJLabel = new JLabel("ENTER YOUR EMAIL :");
		emaiJLabel.setBounds(100, 360, 250, 40);
		emaiJLabel.setFont(font);
		this.add(emaiJLabel);

		// email field
		emaField = new JTextField();
		emaField.setBounds(100, 400, 340, 40);
		emaField.setFont(font);
		this.add(emaField);

		// Register Btn
		registerBtn = new JButton("Register");
		registerBtn.setBounds(100, 530, 400, 40);
		registerBtn.setFont(font);
		registerBtn.setForeground(Color.WHITE);
		registerBtn.setBackground(greenColor);
		registerBtn.setBorder(new EmptyBorder(0, 0, 0, 0));
		registerBtn.addActionListener(this);
		this.add(registerBtn);

		// Back Btn
		backBtn = new JButton("Back");
		backBtn.setBounds(30, 600, 100, 35);
		backBtn.setFont(font);
		backBtn.setForeground(Color.WHITE);
		backBtn.setBackground(redColor);
		backBtn.setBorder(new EmptyBorder(0, 0, 0, 0));
		backBtn.addActionListener(this);
		this.add(backBtn);

		//captcha
		cap1 = new JLabel();
		cap1.setText("Captcha");
		cap1.setBounds(100, 440, 340, 40);
		cap1.setForeground(Color.BLACK);
		cap1.setBackground(Color.CYAN);
		cap1.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		this.add(cap1);
		
		Random rand = new Random();
		a = rand.nextInt(10);
		b = rand.nextInt(10);
		result = a + b;
		// Captcha
		cap2 = new JLabel();
		cap2.setText("   " + a + " + " + b + "  ");
		cap2.setBounds(100, 480, 100, 40);
		cap2.setForeground(Color.black);
		cap2.setBackground(Color.WHITE);
		cap2.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		cap2.setBorder(null);
		cap2.setOpaque(true);
		this.add(cap2);

		capt1 = new JTextField();
		capt1.setBounds(220, 480, 140, 40);
		capt1.setFont(font);
		this.add(capt1);

		panel = new JPanel();
		panel.setLayout(null);
		panel.setSize(1920, 1080);
		panel.setBackground(new Color(240, 245, 245));
		this.add(panel);

		this.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		String name = usernameField.getText();
		String pass = String.valueOf(userPasswordField.getPassword());

		String t3 = capt1.getText();
		String t4 = Integer.toString(result);
		if (t3.isEmpty()) {
			JOptionPane.showMessageDialog(this, "Error!!!! Enter captcha correctly.");
		} else {

			if ((t4.compareTo(t3)) != 0) {
				JOptionPane.showMessageDialog(this, "Error!!!! Enter captcha correctly.");
			} else {

				if ((t4.compareTo(t3)) == 0) {
					boolean s = FileIO.registerUser(name, pass, "./File/users.txt");
					if (registerBtn == e.getSource()) {

						if (s == true) {

							JOptionPane.showMessageDialog(this, "Register Successfull");
							usernameField.setText("");
							userPasswordField.setText("");
						} else if (s == false) {
							JOptionPane.showMessageDialog(this, "Already Registered",
									"Error", JOptionPane.WARNING_MESSAGE);
						}

					}
				}
			}
		}
		if (backBtn == e.getSource()) {
			this.dispose();
			loginPage.setVisible(true);
		}
	}
}