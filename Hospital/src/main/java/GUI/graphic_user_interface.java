package GUI; 

import Hospital.DepartmentRegister;
import Hospital.PatientRegister;
import Hospital.StaffRegister;


import java.awt.EventQueue;

import java.awt.Window;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JProgressBar;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JComboBox;
import java.awt.Font;

@SuppressWarnings("unused")
public class graphic_user_interface {

	private JFrame frame;
	private JTextField email;
	private JButton btnLogin;
	private JPasswordField passwordField;
	private StaffRegister StaffReg;

	/**
	 * Launch the application.
	 *
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					graphic_user_interface window = new graphic_user_interface();
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
	public graphic_user_interface() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		final PatientRegister  PatientReg = new PatientRegister();
		final StaffRegister StaffReg = new StaffRegister();
		final DepartmentRegister DepartReg = new DepartmentRegister();
		
		StaffReg.addICTOfficer("email", "name"," surname", new Date(), "gender");
		StaffReg.addClerk("email", "name", "surname", new Date(), "gender");
		StaffReg.addDoctor("email", "name", "surname", new Date(),"gender");
		PatientReg.add("alexfc@live.dk", "Alexander", "Christensen", new Date(), "gender", "Nybrovej", 69696969, true, "Dead");
		PatientReg.add("wef@ewfwef.com", "oeijf", "wef", new Date(), "gender", "Lungbyvej", 42042069, true, "alive");
		
		
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.setSize(1000,670);
//		frame.isResizable(true);
//		
		JButton btnStaff = new JButton("Staff");
		btnStaff.setBounds(188, 214, 171, 41);
		btnStaff.setFont(new Font("Times New Roman", Font.PLAIN, 27));
		btnStaff.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				StaffLogin loginPage = new StaffLogin(StaffReg, PatientReg);
				loginPage.setVisible(true);
			}
		});
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(btnStaff);
		
		JButton btnPatient = new JButton("Patient");
		btnPatient.setBounds(605, 214, 171, 41);
		btnPatient.setFont(new Font("Times New Roman", Font.PLAIN, 27));
		btnPatient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				PatientLogin loginPage2 = new PatientLogin(PatientReg, DepartReg);
				loginPage2.setVisible(true);
			}
		});
		frame.getContentPane().add(btnPatient);
		
		JButton btnQuit = new JButton("Quit");
		btnQuit.setBounds(0, 539, 171, 41);
		btnQuit.setFont(new Font("Times New Roman", Font.PLAIN, 27));
		btnQuit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		frame.getContentPane().add(btnQuit);
		
		
		}
	}