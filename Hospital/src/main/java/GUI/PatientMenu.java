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
import javax.swing.SwingConstants;
import java.awt.GridLayout;

@SuppressWarnings({ "unused", "serial" })
public class PatientMenu extends JFrame {

	private JPanel contentPane;
	static PatientRegister PatientReg;
	static DepartmentRegister DepartReg;
	private static int serialnumber;
  
	/**
	 * Create the frame.
	 */
	@SuppressWarnings("static-access")
	public PatientMenu(PatientRegister PatientReg, DepartmentRegister DepartReg, int serialnumber) {
		PatientMenu.PatientReg = PatientReg;
		PatientMenu.DepartReg = DepartReg;
		this.serialnumber = serialnumber;
		Patient patient = PatientReg.findSerialnum(serialnumber);

	
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setTitle("Patient Menu ");
		setBounds(100, 100, 985, 657);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnGoBack = new JButton("Go Back");
		btnGoBack.setFont(new Font("Times New Roman", Font.PLAIN, 27));
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		contentPane.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblWelcomeToThe = new JLabel("Welcome to the Patient Menu, ");
		lblWelcomeToThe.setHorizontalAlignment(SwingConstants.RIGHT);
		lblWelcomeToThe.setFont(new Font("Times New Roman", Font.PLAIN, 27));
		contentPane.add(lblWelcomeToThe);
		
		JLabel lblNameOfThe = new JLabel(patient.getName() + " " + patient.getSurname());
		lblNameOfThe.setFont(new Font("Times New Roman", Font.PLAIN, 27));
		contentPane.add(lblNameOfThe);
		
		JLabel lblYourEmailIs = new JLabel("E-mail is :");
		lblYourEmailIs.setHorizontalAlignment(SwingConstants.CENTER);
		lblYourEmailIs.setFont(new Font("Times New Roman", Font.PLAIN, 27));
		contentPane.add(lblYourEmailIs);
		
		JLabel lblPatientsEmail = new JLabel(patient.getEmail());
		lblPatientsEmail.setFont(new Font("Times New Roman", Font.PLAIN, 27));
		contentPane.add(lblPatientsEmail);
		
		JLabel lblYourAddressIs = new JLabel("Address is :");
		lblYourAddressIs.setHorizontalAlignment(SwingConstants.CENTER);
		lblYourAddressIs.setFont(new Font("Times New Roman", Font.PLAIN, 27));
		contentPane.add(lblYourAddressIs);
		
		JLabel lblPatientsAddress = new JLabel(patient.getAddress());
		lblPatientsAddress.setFont(new Font("Times New Roman", Font.PLAIN, 27));
		contentPane.add(lblPatientsAddress);
		
		JLabel lblYourPhoneNumber = new JLabel("Phone Number is : ");
		lblYourPhoneNumber.setHorizontalAlignment(SwingConstants.CENTER);
		lblYourPhoneNumber.setFont(new Font("Times New Roman", Font.PLAIN, 27));
		contentPane.add(lblYourPhoneNumber);
		
		JLabel lblPatientsPhonenumber = new JLabel(Integer.toString(patient.getPhoneNumber()));
		lblPatientsPhonenumber.setFont(new Font("Times New Roman", Font.PLAIN, 27));
		contentPane.add(lblPatientsPhonenumber);
		
		JLabel lblYourBedNumber = new JLabel("Bed Number is : ");
		lblYourBedNumber.setHorizontalAlignment(SwingConstants.CENTER);
		lblYourBedNumber.setFont(new Font("Times New Roman", Font.PLAIN, 27));
		contentPane.add(lblYourBedNumber);
		
		JLabel lblPatientsBednumber = new JLabel("BedNumber");
		lblPatientsBednumber.setFont(new Font("Times New Roman", Font.PLAIN, 27));
		contentPane.add(lblPatientsBednumber);
		contentPane.add(btnGoBack);
		contentPane.add(btnGoBack);
		
		JLabel label = new JLabel("");
		contentPane.add(label);
	}
}