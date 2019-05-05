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
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

@SuppressWarnings({ "unused", "serial" })
public class PatientMenu extends JFrame {
	static PatientRegister PatientReg;
	static DepartmentRegister DepartReg;
	private int serialnum;
	private Patient patient;
	private String deptName;
  
	/**
	 * Create the frame.
	 */
	@SuppressWarnings("static-access")
	public PatientMenu(PatientRegister pr, DepartmentRegister dr, int serialnum) {
		PatientMenu.PatientReg = pr;
		PatientMenu.DepartReg = dr;
		this.serialnum = serialnum;
		patient = pr.findSerialnum(serialnum);

	
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setTitle("Patient Menu ");
		setBounds(100, 100, 985, 657);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		this.setLocationRelativeTo(null);
		
		JButton btnGoBack = new JButton("Go Back");
		btnGoBack.setFont(new Font("Times New Roman", Font.PLAIN, 27));
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		contentPane.setLayout(new GridLayout(8, 2, 0, 0));
		
		JLabel lblWelcomeToThe = new JLabel("Welcome to the Patient Menu, ");
		lblWelcomeToThe.setHorizontalAlignment(SwingConstants.RIGHT);
		lblWelcomeToThe.setFont(new Font("Times New Roman", Font.PLAIN, 35));
		contentPane.add(lblWelcomeToThe);
		
		JLabel lblNameOfThe = new JLabel(patient.getName() + " " + patient.getSurname());
		lblNameOfThe.setFont(new Font("Times New Roman", Font.PLAIN, 35));
		contentPane.add(lblNameOfThe);
		
		JLabel lblEmail = new JLabel("E-mail: ");
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmail.setFont(new Font("Times New Roman", Font.PLAIN, 35));
		contentPane.add(lblEmail);
		
		JLabel lblPatientsEmail = new JLabel(patient.getEmail());
		lblPatientsEmail.setFont(new Font("Times New Roman", Font.PLAIN, 35));
		contentPane.add(lblPatientsEmail);
		
		JLabel lblAddress = new JLabel("Address: ");
		lblAddress.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddress.setFont(new Font("Times New Roman", Font.PLAIN, 35));
		contentPane.add(lblAddress);
		
		JLabel lblPatientsAddress = new JLabel(patient.getAddress());
		lblPatientsAddress.setFont(new Font("Times New Roman", Font.PLAIN, 35));
		contentPane.add(lblPatientsAddress);
		
		JLabel lblnumber = new JLabel("Phone Number: ");
		lblnumber.setHorizontalAlignment(SwingConstants.CENTER);
		lblnumber.setFont(new Font("Times New Roman", Font.PLAIN, 35));
		contentPane.add(lblnumber);
		
		JLabel lblPatientsPhonenumber = new JLabel(Integer.toString(patient.getPhoneNumber()));
		lblPatientsPhonenumber.setFont(new Font("Times New Roman", Font.PLAIN, 35));
		contentPane.add(lblPatientsPhonenumber);
		
		JLabel lblBedNumber = new JLabel("Bed Number: ");
		lblBedNumber.setHorizontalAlignment(SwingConstants.CENTER);
		lblBedNumber.setFont(new Font("Times New Roman", Font.PLAIN, 35));
		contentPane.add(lblBedNumber);
		
		try {
			JLabel lblBednumber = new JLabel(Integer.toString(DepartReg.getBedOf(serialnumber, DepartReg.getDeptOfPatient(serialnumber))));
			lblBednumber.setFont(new Font("Times New Roman", Font.PLAIN, 35));
			contentPane.add(lblBednumber);
		} catch (Exception IllegalArgumentException) {
			JLabel lblBednumber = new JLabel("You have not been admitted to a department");
			lblBednumber.setFont(new Font("Times New Roman", Font.PLAIN, 35));
			contentPane.add(lblBednumber);
		}

		JLabel lblGender = new JLabel("Gender: ");
		lblGender.setFont(new Font("Times New Roman", Font.PLAIN, 35));
		lblGender.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblGender);
		
		JLabel gender = new JLabel(patient.getGender());
		gender.setFont(new Font("Times New Roman", Font.PLAIN, 35));
		contentPane.add(gender);
		
		JLabel serialNumber = new JLabel("Serial Number: ");
		serialNumber.setFont(new Font("Times New Roman", Font.PLAIN, 35));
		serialNumber.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(serialNumber);
		
		JLabel lblserialnumber = new JLabel(Integer.toString(patient.getSerialnum()));
		lblserialnumber.setFont(new Font("Times New Roman", Font.PLAIN, 35));
		contentPane.add(lblserialnumber);
		contentPane.add(btnGoBack);
		contentPane.add(btnGoBack);
	}
}