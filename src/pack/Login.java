package pack;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class Login  {
	
static int k=3;
static double usrn;
static double pass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		           
		
		
					JFrame frame = new JFrame("Login Page");
					
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					frame.setBounds(100, 100, 450, 300);
					JPanel contentPane = new JPanel();
					contentPane.setBackground(new Color(51, 102, 102));
					contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
					frame.setContentPane(contentPane);
					contentPane.setLayout(null);
					
					JPanel panel = new JPanel();
					panel.setBackground(Color.GRAY);
					panel.setBorder(new LineBorder(new Color(0, 0, 0)));
					panel.setBounds(43, 34, 356, 193);
					contentPane.add(panel);
					panel.setLayout(null);
					
					JLabel lblLogin = new JLabel("Login");
					lblLogin.setFont(new Font("Tahoma", Font.PLAIN, 20));
					lblLogin.setBounds(145, 11, 54, 25);
					panel.add(lblLogin);
					
					JLabel lblUsername = new JLabel("Username:");
					lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 12));
					lblUsername.setBounds(63, 66, 63, 14);
					panel.add(lblUsername);
					
					JLabel lblPassword = new JLabel("Password:");
					lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 12));
					lblPassword.setBounds(63, 104, 63, 14);
					panel.add(lblPassword);
					
					JTextField textusername = new JTextField();
					textusername.setBounds(125, 61, 161, 20);
					panel.add(textusername);
					textusername.setColumns(10);
					JPasswordField passwordpass = new JPasswordField();
					passwordpass.setBounds(125, 101, 161, 20);
					panel.add(passwordpass);
					
					JButton blog = new JButton("Login");
					blog.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							try {
							 usrn=Double.parseDouble(textusername.getText());
							 pass=Double.parseDouble(passwordpass.getText());
							if(usrn==1234 && pass==2345)
							{
								frame.setVisible(false);
								new Mainpage();
							}
							else {
								
								
								textusername.setText(null);
								passwordpass.setText(null);
								k--;
								if(k!=0)
								{
								JOptionPane.showMessageDialog(blog,"INVALID USERNAME OR PASSWORD...\nyou have "+k+" try(s)");
								}
								if(k==0)
								{
									JOptionPane.showMessageDialog(blog,"you entered wrong password 3 times\nApplcation closed.");
									System.exit(0);
								}
								
							     }
							}
							catch(Exception d)
							{
								if(usrn==0 && pass==0)
								{
								JOptionPane.showMessageDialog(blog, "Please Enter The Username And Password..");
								}
								else if(pass==0)
								{
								JOptionPane.showMessageDialog(blog, "Please Enter The Password..");
								}
								else if(usrn==0)
								{
								JOptionPane.showMessageDialog(blog, "Please Enter The Username..");
								}
							}
						
						}
					});
					
					blog.setBounds(189, 148, 97, 23);
					panel.add(blog);
					
					JButton bexit = new JButton("EXIT");
					bexit.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
						 int choice = JOptionPane.showConfirmDialog(bexit, "Do You Want To Exit?");
						 if(choice==0)
						 {
						    System.exit(0);
						 } 
						}
					});
					bexit.setBounds(63, 148, 97, 23);
					panel.add(bexit);
					
					frame.setVisible(true);
				
	}

}
