package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Hospital.DepartmentRegister;
import Hospital.Patient;
import Hospital.PatientRegister;
import Hospital.Staff;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

@SuppressWarnings({ "unused", "serial" })
public class Patient_Menu extends JFrame {

	private JPanel contentPane;
	static PatientRegister PatientReg;
	static DepartmentRegister DepartReg;
	private static int serialnumber;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Patient_Menu frame = new Patient_Menu(PatientReg, DepartReg, serialnumber);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Create the frame.
	 */
	@SuppressWarnings("static-access")
	public Patient_Menu(PatientRegister PatientReg, DepartmentRegister DepartReg, int serialnumber) {
		Patient_Menu.PatientReg = PatientReg;
		Patient_Menu.DepartReg = DepartReg;
		this.serialnumber = serialnumber;
		Patient patient = PatientReg.findSerialnum(serialnumber);

	
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setTitle("Patient Menu ");
		setBounds(100, 100, 985, 657);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblWelcomeToThe = new JLabel("Welcome to the Patient Menu, ");
		lblWelcomeToThe.setBounds(51, 44, 341, 32);
		lblWelcomeToThe.setFont(new Font("Times New Roman", Font.PLAIN, 27));
		
		JButton btnGoBack = new JButton("Go Back");
		btnGoBack.setFont(new Font("Times New Roman", Font.PLAIN, 27));
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnGoBack.setBounds(0, 528, 171, 41);
		contentPane.add(btnGoBack);
		
		JLabel lblYourEmailIs = new JLabel("E-mail is : ");
		lblYourEmailIs.setBounds(51, 181, 190, 33);
		lblYourEmailIs.setFont(new Font("Times New Roman", Font.PLAIN, 27));
		
		JLabel lblYourAddressIs = new JLabel("Address is :");
		lblYourAddressIs.setBounds(51, 242, 202, 33);
		lblYourAddressIs.setFont(new Font("Times New Roman", Font.PLAIN, 27));
		
		JLabel lblYourPhoneNumber = new JLabel("Phone Number is :");
		lblYourPhoneNumber.setBounds(51, 303, 293, 33);
		lblYourPhoneNumber.setFont(new Font("Times New Roman", Font.PLAIN, 27));
		
		JLabel lblNameOfThe = new JLabel(patient.getName() + " " + patient.getSurname());
		lblNameOfThe.setBounds(405, 42, 251, 32);
		lblNameOfThe.setFont(new Font("Times New Roman", Font.PLAIN, 27));
		
		JLabel lblPatientsEmail = new JLabel(patient.getEmail());
		lblPatientsEmail.setBounds(358, 181, 266, 32);
		lblPatientsEmail.setFont(new Font("Times New Roman", Font.PLAIN, 27));
		
		JLabel lblPatientsAddress = new JLabel(patient.getAddress());
		lblPatientsAddress.setBounds(358, 242, 266, 32);
		lblPatientsAddress.setFont(new Font("Times New Roman", Font.PLAIN, 27));
		
		JLabel lblPatientsPhonenumber = new JLabel(Integer.toString(patient.getPhoneNumber()));
		lblPatientsPhonenumber.setBounds(358, 303, 266, 32);
		lblPatientsPhonenumber.setFont(new Font("Times New Roman", Font.PLAIN, 27));
		contentPane.setLayout(null);
		contentPane.add(lblWelcomeToThe);
		contentPane.add(lblNameOfThe);
		contentPane.add(lblYourEmailIs);
		contentPane.add(lblPatientsEmail);
		contentPane.add(lblYourAddressIs);
		contentPane.add(lblPatientsAddress);
		contentPane.add(lblYourPhoneNumber);
		contentPane.add(lblPatientsPhonenumber);
		contentPane.add(btnGoBack);
		
		JLabel lblYourBedNumber = new JLabel("Bed Number is :");
		lblYourBedNumber.setFont(new Font("Times New Roman", Font.PLAIN, 27));
		lblYourBedNumber.setBounds(51, 364, 293, 33);
		contentPane.add(lblYourBedNumber);
		
		JLabel lblPatientsBednumber = new JLabel("Patients BedNumber");
		lblPatientsBednumber.setFont(new Font("Times New Roman", Font.PLAIN, 27));
		lblPatientsBednumber.setBounds(358, 362, 266, 32);
		contentPane.add(lblPatientsBednumber);
	}
}