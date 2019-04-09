package GUI_Design;


import Hospital.*;


import java.awt.EventQueue;

import java.awt.Window;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JProgressBar;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JComboBox;

@SuppressWarnings("unused")
public class graphic_user_Interface {

	private JFrame frame;
	private JTextField email;
	private JButton btnLogin;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					graphic_user_Interface window = new graphic_user_Interface();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public graphic_user_Interface() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Hospital H = new Hospital();
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().setLayout(null);
//		frame.isResizable(true);
//		
		JButton btnStaff = new JButton("Staff");
		btnStaff.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				StaffLogin loginPage = new StaffLogin(H);
				loginPage.setVisible(true);
			}
		});
		btnStaff.setBounds(364, 214, 171, 41);
		frame.getContentPane().add(btnStaff);
		
		JButton btnPatient = new JButton("Patient");
		btnPatient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				PatientLogin loginPage = new PatientLogin(H);
				loginPage.setVisible(true);
				
			}
		});
		btnPatient.setBounds(647, 214, 171, 41);
		frame.getContentPane().add(btnPatient);
		
		JButton btnClerk = new JButton("Clerk");
		btnClerk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ClerkLogin loginPage = new ClerkLogin(H);
				loginPage.setVisible(true);
				
				
			}
		});
		btnClerk.setBounds(56, 214, 171, 41);
		frame.getContentPane().add(btnClerk);
		
		
		}
	}
