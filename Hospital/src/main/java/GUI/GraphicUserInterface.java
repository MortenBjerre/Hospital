package GUI; 

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import Hospital.DepartmentRegister;
import Hospital.PatientRegister;
import Hospital.StaffRegister;

public class GraphicUserInterface {

	private JFrame frame;

	/**
	 *
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					GraphicUserInterface window = new GraphicUserInterface();
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
	public GraphicUserInterface() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		final PatientRegister  PatientReg = new PatientRegister();
		final StaffRegister StaffReg = new StaffRegister();
		final DepartmentRegister DepartReg = new DepartmentRegister();
		DepartReg.createDepartment("ER");
		StaffReg.addICTOfficer("morten@bjerre.dk", "Morten", "Bjerre", new Date(), "male");
		StaffReg.addClerk("eric@jensen.dk", "Eric", "Jensen", new Date(), "male");
		StaffReg.addDoctor("email", "name", "surname", new Date(),"gender");
		PatientReg.register("alexfc@live.dk", "Alexander", "Christensen", new Date(), "gender", "Nybrovej", 69696969, true, "Patient needs to be admitted.");
		PatientReg.register("wef@ewfwef.com", "oeijf", "wef", new Date(), "gender", "Lungbyvej", 42042069, true, "Still alive");
		PatientReg.register("Niks Asshole", "Nikolaj", "Thanos body double", new Date(), "undefined", "MotherRussia AKA greenland", 42042069, true, "");
		
		
		frame = new JFrame();
		frame.setTitle("Main Menu");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setSize(1000,670);
				frame.getContentPane().setLayout(new GridLayout(5, 2, 40, 20));
				
				JLabel label = new JLabel("");
				frame.getContentPane().add(label);
				
				JLabel label_1 = new JLabel("");
				frame.getContentPane().add(label_1);
				
				JLabel label_2 = new JLabel("");
				frame.getContentPane().add(label_2);
				
				JLabel label_3 = new JLabel("");
				frame.getContentPane().add(label_3);
				
					JButton btnPatient = new JButton("Patient");
					btnPatient.setMaximumSize(new Dimension(10, 10));
					btnPatient.setFont(new Font("Times New Roman", Font.PLAIN, 100));
					btnPatient.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							
							PatientLogin loginPage2 = new PatientLogin(PatientReg, DepartReg);
							loginPage2.setVisible(true);
						}
					});
					
					JButton btnStaff = new JButton("Staff");
					btnStaff.setMaximumSize(new Dimension(10, 10));
					btnStaff.setFont(new Font("Times New Roman", Font.PLAIN, 100));
					btnStaff.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							
							StaffLogin loginPage = new StaffLogin(StaffReg, PatientReg, DepartReg);
							loginPage.setVisible(true);
						}
					});
					frame.getContentPane().add(btnStaff);
					frame.getContentPane().add(btnPatient);
				
				JLabel label_4 = new JLabel("");
				frame.getContentPane().add(label_4);
				
				JLabel label_5 = new JLabel("");
				frame.getContentPane().add(label_5);

		
		}
	}