import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Login extends JFrame implements ActionListener{
	
	//Globally declaring buttons and fields so that it can be used in the action performed interface.
	JButton login, signup, clear;
	JTextField cardTextField;
	JPasswordField pinTextField;
	
	//Constructor to render upon application run
	Login(){
		
		setTitle("AUTOMATED TELLER MACHINE");
		//changing the default border layout to my custom layout to move components on JFrame.
		setLayout(null);
		
		//get the image of icon folder
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/logo.jpg"));
		//change the size of image
		Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
		//creating the new image object with changed size
		ImageIcon i3 = new ImageIcon(i2);
		//adding the image on JLabel to view.
		JLabel label = new JLabel(i3);
		//Changing the position of the image.
		label.setBounds(70, 10, 100, 100);
		//adding JLabel with image to the JFrame.
		add(label);
		
		//Text Label
		JLabel text = new JLabel("Welcome to ATM");
		text.setFont(new Font("Osward", Font.BOLD, 38));
		text.setBounds(200, 40, 400, 40);
		add(text);
		
		//Card Label
		JLabel cardno = new JLabel("Card No:");
		cardno.setFont(new Font("Raleway", Font.BOLD, 28));
		cardno.setBounds(120, 150, 150, 30);
		add(cardno);
		
		//TextField
		cardTextField = new JTextField();
		cardTextField.setBounds(300, 150, 230, 30);
		cardTextField.setFont(new Font("Arial", Font.BOLD, 14));
		add(cardTextField);
		
		//Pin Label
		JLabel pin = new JLabel("PIN:");
		pin.setFont(new Font("Raleway", Font.BOLD, 28));
		pin.setBounds(120, 220, 250, 30);
		add(pin);
		
		//TextField
		pinTextField = new JPasswordField();
		pinTextField.setBounds(300, 220, 230, 30);
		pinTextField.setFont(new Font("Arial", Font.BOLD, 14));
		add(pinTextField);
		
		//Button
		login = new JButton("SIGN IN");
		login.setBounds(300, 300, 100, 30);
		login.setBackground(Color.BLACK);
		login.setForeground(Color.WHITE);
		login.addActionListener(this);
		add(login);
		
		//Button
		clear = new JButton("CLEAR");
		clear.setBounds(430, 300, 100, 30);
		clear.setBackground(Color.BLACK);
		clear.setForeground(Color.WHITE);
		clear.addActionListener(this);
		add(clear);
				
		//Button
		signup = new JButton("SIGN UP");
		signup.setBounds(300, 350, 230, 30);
		signup.setBackground(Color.BLACK);
		signup.setForeground(Color.WHITE);
		signup.addActionListener(this);
		add(signup);
		
		
		
		//Change the frame color
		getContentPane().setBackground(Color.WHITE);
		
		
		//Changing the JFrame properties.
		setSize(800, 480);
		setVisible(true);
		setLocation(350, 200);
		
	} //end of constructor
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == clear) {
			cardTextField.setText("");
			pinTextField.setText("");
		} else if(ae.getSource() == login) {
			
		} else if(ae.getSource() == signup) {
			setVisible(false);
			new SignupOne().setVisible(true);
		}
	} //end of interface
	
	public static void main (String args[]) {
		
		new Login();
		
	}
}