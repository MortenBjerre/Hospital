package GUI;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Hospital.DepartmentRegister;
import Hospital.Patient;
import Hospital.PatientRegister;

public class Dischargepatient extends JFrame {

	private JPanel contentPane;
	private JTextField SerialNumber;
	private int serialnum;
	static PatientRegister PatientReg;
	static DepartmentRegister DepartReg;
	private JLabel lblName;
	private JLabel lblSurname;
	private JLabel lblEmail;
	private JLabel lblAddress;
	private JLabel lblPhonenumber;
	private JLabel Name;
	private JLabel Surname;
	private JLabel Email;
	private JLabel Address;
	private JLabel Number;
	private JPanel panel;
	private JPanel panel_1;
	private JButton btnDischarge;

	/**
	 * Create the frame.
	 */
	public Dischargepatient(final PatientRegister PatientReg, final DepartmentRegister DepartReg) {		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 796, 690);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 403, 209, 93, 0};
		gbl_contentPane.rowHeights = new int[]{56, 33, 39, 41, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 5, 5);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 0;
		contentPane.add(panel_1, gbc_panel_1);
		
		JLabel lblPleaseEnterThe = new JLabel("Enter Patient Serial Number: ");
		lblPleaseEnterThe.setFont(new Font("Times New Roman", Font.PLAIN, 35));
		GridBagConstraints gbc_lblPleaseEnterThe = new GridBagConstraints();
		gbc_lblPleaseEnterThe.anchor = GridBagConstraints.EAST;
		gbc_lblPleaseEnterThe.insets = new Insets(0, 0, 5, 5);
		gbc_lblPleaseEnterThe.gridx = 1;
		gbc_lblPleaseEnterThe.gridy = 1;
		contentPane.add(lblPleaseEnterThe, gbc_lblPleaseEnterThe);
		
		
		SerialNumber = new JTextField();
		SerialNumber.setFont(new Font("Times New Roman", Font.PLAIN, 35));
		GridBagConstraints gbc_SerialNumber = new GridBagConstraints();
		gbc_SerialNumber.fill = GridBagConstraints.HORIZONTAL;
		gbc_SerialNumber.anchor = GridBagConstraints.WEST;
		gbc_SerialNumber.insets = new Insets(0, 0, 5, 5);
		gbc_SerialNumber.gridx = 2;
		gbc_SerialNumber.gridy = 1;
		contentPane.add(SerialNumber, gbc_SerialNumber);
		SerialNumber.setColumns(10);
		
		lblName = new JLabel("Name: ");
		lblName.setFont(new Font("Times New Roman", Font.PLAIN, 35));
		GridBagConstraints gbc_lblName = new GridBagConstraints();
		gbc_lblName.anchor = GridBagConstraints.EAST;
		gbc_lblName.insets = new Insets(0, 0, 5, 5);
		gbc_lblName.gridx = 1;
		gbc_lblName.gridy = 3;
		contentPane.add(lblName, gbc_lblName);
		
		Name = new JLabel("");
		Name.setFont(new Font("Times New Roman", Font.PLAIN, 35));
		GridBagConstraints gbc_Name = new GridBagConstraints();
		gbc_Name.insets = new Insets(0, 0, 5, 5);
		gbc_Name.gridx = 2;
		gbc_Name.gridy = 3;
		contentPane.add(Name, gbc_Name);
		
		lblSurname = new JLabel("Surname: ");
		lblSurname.setFont(new Font("Times New Roman", Font.PLAIN, 35));
		GridBagConstraints gbc_lblSurname = new GridBagConstraints();
		gbc_lblSurname.anchor = GridBagConstraints.EAST;
		gbc_lblSurname.insets = new Insets(0, 0, 5, 5);
		gbc_lblSurname.gridx = 1;
		gbc_lblSurname.gridy = 4;
		contentPane.add(lblSurname, gbc_lblSurname);
		
		Surname = new JLabel("");
		Surname.setFont(new Font("Times New Roman", Font.PLAIN, 35));
		GridBagConstraints gbc_Surname = new GridBagConstraints();
		gbc_Surname.insets = new Insets(0, 0, 5, 5);
		gbc_Surname.gridx = 2;
		gbc_Surname.gridy = 4;
		contentPane.add(Surname, gbc_Surname);
		
		lblEmail = new JLabel("Email: ");
		lblEmail.setFont(new Font("Times New Roman", Font.PLAIN, 35));
		GridBagConstraints gbc_lblEmail = new GridBagConstraints();
		gbc_lblEmail.anchor = GridBagConstraints.EAST;
		gbc_lblEmail.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmail.gridx = 1;
		gbc_lblEmail.gridy = 5;
		contentPane.add(lblEmail, gbc_lblEmail);
		
		Email = new JLabel("");
		Email.setFont(new Font("Times New Roman", Font.PLAIN, 35));
		GridBagConstraints gbc_Email = new GridBagConstraints();
		gbc_Email.insets = new Insets(0, 0, 5, 5);
		gbc_Email.gridx = 2;
		gbc_Email.gridy = 5;
		contentPane.add(Email, gbc_Email);
		
		lblAddress = new JLabel("Address: ");
		lblAddress.setFont(new Font("Times New Roman", Font.PLAIN, 35));
		GridBagConstraints gbc_lblAddress = new GridBagConstraints();
		gbc_lblAddress.anchor = GridBagConstraints.EAST;
		gbc_lblAddress.insets = new Insets(0, 0, 5, 5);
		gbc_lblAddress.gridx = 1;
		gbc_lblAddress.gridy = 6;
		contentPane.add(lblAddress, gbc_lblAddress);
		
		Address = new JLabel("");
		Address.setFont(new Font("Times New Roman", Font.PLAIN, 35));
		GridBagConstraints gbc_Address = new GridBagConstraints();
		gbc_Address.insets = new Insets(0, 0, 5, 5);
		gbc_Address.gridx = 2;
		gbc_Address.gridy = 6;
		contentPane.add(Address, gbc_Address);
		
		lblPhonenumber = new JLabel("PhoneNumber: ");
		lblPhonenumber.setFont(new Font("Times New Roman", Font.PLAIN, 35));
		GridBagConstraints gbc_lblPhonenumber = new GridBagConstraints();
		gbc_lblPhonenumber.anchor = GridBagConstraints.EAST;
		gbc_lblPhonenumber.insets = new Insets(0, 0, 5, 5);
		gbc_lblPhonenumber.gridx = 1;
		gbc_lblPhonenumber.gridy = 7;
		contentPane.add(lblPhonenumber, gbc_lblPhonenumber);
		
		Number = new JLabel("");
		Number.setFont(new Font("Times New Roman", Font.PLAIN, 35));
		GridBagConstraints gbc_Number = new GridBagConstraints();
		gbc_Number.insets = new Insets(0, 0, 5, 5);
		gbc_Number.gridx = 2;
		gbc_Number.gridy = 7;
		contentPane.add(Number, gbc_Number);
		
		btnDischarge = new JButton("Discharge");
		btnDischarge.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					DepartReg.dischargePatient(serialnum, PatientReg);
					SuccesfullOperation discharged = new SuccesfullOperation("Patient has been discharged");
					discharged.setVisible(true);
				} catch (Exception e1) {
					InvalidInput invalid = new InvalidInput("Patient has not been admitted");
					invalid.setVisible(true);
				}
			}
		});
		GridBagConstraints gbc_btnDischarge = new GridBagConstraints();
		gbc_btnDischarge.insets = new Insets(0, 0, 5, 5);
		gbc_btnDischarge.gridx = 2;
		gbc_btnDischarge.gridy = 8;
		contentPane.add(btnDischarge, gbc_btnDischarge);
		
		panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 3;
		gbc_panel.gridy = 8;
		contentPane.add(panel, gbc_panel);
		SerialNumber.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					try {
						serialnum = Integer.parseInt(SerialNumber.getText());
						Patient patient = PatientReg.findSerialnum(serialnum);
						if (patient != null) {
							Name.setText(patient.getName());
							Surname.setText(patient.getSurname());
							Email.setText(patient.getEmail());
							Address.setText(patient.getAddress());
							Number.setText(Integer.toString(patient.getPhoneNumber()));
						}
					} catch (Exception e1) {
						;
					}
				}
			}
		});
	}

}
