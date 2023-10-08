import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;
import javax.swing.*;

public class FastCash extends JFrame implements ActionListener{

	
	JButton deposit, withdrawal, ministatement, pinchange, fastcash, balanceinquiry, exit;
	String pinnumber;
	FastCash(String pinnumber) {
		this.pinnumber = pinnumber;
		setLayout(null);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm.jpg"));
		Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0, 0, 900, 900);
		add(image);
		
		JLabel text = new JLabel("Select withdrawal amount");
		text.setBounds(210, 300, 700, 35);
		text.setForeground(Color.WHITE);
		text.setFont(new Font("System", Font.BOLD, 16));
		image.add(text);
		
		deposit = new JButton("$100");
		deposit.setBounds(170, 415, 150, 30);
		deposit.addActionListener(this);
		image.add(deposit);
		
		withdrawal = new JButton("$500");
		withdrawal.setBounds(355, 415, 150, 30);
		withdrawal.addActionListener(this);
		image.add(withdrawal);
		
		fastcash = new JButton("$1000");
		fastcash.setBounds(170, 450, 150, 30);
		fastcash.addActionListener(this);
		image.add(fastcash);
		
		ministatement = new JButton("$2000");
		ministatement.setBounds(355, 450, 150, 30);
		ministatement.addActionListener(this);
		image.add(ministatement);
		
		pinchange = new JButton("$5000");
		pinchange.setBounds(170, 485, 150, 30);
		pinchange.addActionListener(this);
		image.add(pinchange);
		
		balanceinquiry = new JButton("$10000");
		balanceinquiry.setBounds(355, 485, 150, 30);
		balanceinquiry.addActionListener(this);
		image.add(balanceinquiry);
		
		exit = new JButton("Back");
		exit.setBounds(355, 520, 150, 30);
		exit.addActionListener(this);
		image.add(exit);
		
		
		
		
		
		
		
		setSize(900, 900);
		setLocation(300, 0);
		setUndecorated(true);
		setVisible(true);
		
		
		
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == exit) {
			setVisible(false);
			new Transactions(pinnumber).setVisible(true);
		} else  {
			String amount = ((JButton)ae.getSource()).getText().substring(1); //$
			Conn c = new Conn();
			try {
				ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
				int balance = 0;
				while(rs.next()) {
					if(rs.getString("type").equals("Deposit")) {
						balance += Integer.parseInt( rs.getString("amount"));
					} else {
						balance -= Integer.parseInt(rs.getString("amount"));
					}
					
					
					
					if (ae.getSource() != exit && balance < Integer.parseInt(amount)) {
						JOptionPane.showMessageDialog(null, "Insufficient balance");
						return;
					}
					
					Date date = new Date();
					String query = "insert into bank values('"+pinnumber+"', '"+date+"', 'Withdrawal', '"+amount+"')";
					c.s.executeUpdate(query);
					JOptionPane.showMessageDialog(null, "$ "+ amount + " withdrawn successfully.");
					setVisible(false);
					new Transactions(pinnumber).setVisible(true);
				}
			}catch (Exception e) {
				System.out.println(e);
			}
		}
		
		
	}
	
	
	public static void main(String[] args) {
		new FastCash("");

	}

}
