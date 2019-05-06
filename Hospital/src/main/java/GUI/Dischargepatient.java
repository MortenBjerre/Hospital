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
	private JButton btnDischarge;
	private JButton btnGoBack;
	private JLabel lblDepartment;
	private JLabel departmentShow;

	
	public Dischargepatient(final PatientRegister pr, final DepartmentRegister dr) {		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 667, 585);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{201, 173, 93, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 33, 39, 41, 0, 0, 0, 0, 0, 153, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		this.setLocationRelativeTo(null);
		
		JLabel lblPleaseEnterThe = new JLabel("Enter Patient Serial Number: ");
		lblPleaseEnterThe.setFont(new Font("Tahoma", Font.PLAIN, 22));
		GridBagConstraints gbc_lblPleaseEnterThe = new GridBagConstraints();
		gbc_lblPleaseEnterThe.anchor = GridBagConstraints.EAST;
		gbc_lblPleaseEnterThe.insets = new Insets(0, 0, 5, 5);
		gbc_lblPleaseEnterThe.gridx = 0;
		gbc_lblPleaseEnterThe.gridy = 1;
		contentPane.add(lblPleaseEnterThe, gbc_lblPleaseEnterThe);
		
		
		SerialNumber = new JTextField();
		SerialNumber.setFont(new Font("Tahoma", Font.PLAIN, 22));
		GridBagConstraints gbc_SerialNumber = new GridBagConstraints();
		gbc_SerialNumber.fill = GridBagConstraints.HORIZONTAL;
		gbc_SerialNumber.anchor = GridBagConstraints.WEST;
		gbc_SerialNumber.insets = new Insets(0, 0, 5, 5);
		gbc_SerialNumber.gridx = 1;
		gbc_SerialNumber.gridy = 1;
		contentPane.add(SerialNumber, gbc_SerialNumber);
		SerialNumber.setColumns(10);
		
		lblName = new JLabel("Name: ");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 22));
		GridBagConstraints gbc_lblName = new GridBagConstraints();
		gbc_lblName.anchor = GridBagConstraints.EAST;
		gbc_lblName.insets = new Insets(0, 0, 5, 5);
		gbc_lblName.gridx = 0;
		gbc_lblName.gridy = 3;
		contentPane.add(lblName, gbc_lblName);
		
		Name = new JLabel("");
		Name.setFont(new Font("Tahoma", Font.PLAIN, 22));
		GridBagConstraints gbc_Name = new GridBagConstraints();
		gbc_Name.anchor = GridBagConstraints.WEST;
		gbc_Name.insets = new Insets(0, 0, 5, 5);
		gbc_Name.gridx = 1;
		gbc_Name.gridy = 3;
		contentPane.add(Name, gbc_Name);
		
		lblSurname = new JLabel("Surname: ");
		lblSurname.setFont(new Font("Tahoma", Font.PLAIN, 22));
		GridBagConstraints gbc_lblSurname = new GridBagConstraints();
		gbc_lblSurname.anchor = GridBagConstraints.EAST;
		gbc_lblSurname.insets = new Insets(0, 0, 5, 5);
		gbc_lblSurname.gridx = 0;
		gbc_lblSurname.gridy = 4;
		contentPane.add(lblSurname, gbc_lblSurname);
		
		Surname = new JLabel("");
		Surname.setFont(new Font("Tahoma", Font.PLAIN, 22));
		GridBagConstraints gbc_Surname = new GridBagConstraints();
		gbc_Surname.anchor = GridBagConstraints.WEST;
		gbc_Surname.insets = new Insets(0, 0, 5, 5);
		gbc_Surname.gridx = 1;
		gbc_Surname.gridy = 4;
		contentPane.add(Surname, gbc_Surname);
		
		lblEmail = new JLabel("Email: ");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 22));
		GridBagConstraints gbc_lblEmail = new GridBagConstraints();
		gbc_lblEmail.anchor = GridBagConstraints.EAST;
		gbc_lblEmail.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmail.gridx = 0;
		gbc_lblEmail.gridy = 5;
		contentPane.add(lblEmail, gbc_lblEmail);
		
		Email = new JLabel("");
		Email.setFont(new Font("Tahoma", Font.PLAIN, 22));
		GridBagConstraints gbc_Email = new GridBagConstraints();
		gbc_Email.anchor = GridBagConstraints.WEST;
		gbc_Email.insets = new Insets(0, 0, 5, 5);
		gbc_Email.gridx = 1;
		gbc_Email.gridy = 5;
		contentPane.add(Email, gbc_Email);
		
		lblAddress = new JLabel("Address: ");
		lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 22));
		GridBagConstraints gbc_lblAddress = new GridBagConstraints();
		gbc_lblAddress.anchor = GridBagConstraints.EAST;
		gbc_lblAddress.insets = new Insets(0, 0, 5, 5);
		gbc_lblAddress.gridx = 0;
		gbc_lblAddress.gridy = 6;
		contentPane.add(lblAddress, gbc_lblAddress);
		
		Address = new JLabel("");
		Address.setFont(new Font("Tahoma", Font.PLAIN, 22));
		GridBagConstraints gbc_Address = new GridBagConstraints();
		gbc_Address.anchor = GridBagConstraints.WEST;
		gbc_Address.insets = new Insets(0, 0, 5, 5);
		gbc_Address.gridx = 1;
		gbc_Address.gridy = 6;
		contentPane.add(Address, gbc_Address);
		
		lblPhonenumber = new JLabel("PhoneNumber: ");
		lblPhonenumber.setFont(new Font("Tahoma", Font.PLAIN, 22));
		GridBagConstraints gbc_lblPhonenumber = new GridBagConstraints();
		gbc_lblPhonenumber.anchor = GridBagConstraints.EAST;
		gbc_lblPhonenumber.insets = new Insets(0, 0, 5, 5);
		gbc_lblPhonenumber.gridx = 0;
		gbc_lblPhonenumber.gridy = 7;
		contentPane.add(lblPhonenumber, gbc_lblPhonenumber);
		
		Number = new JLabel("");
		Number.setFont(new Font("Tahoma", Font.PLAIN, 22));
		GridBagConstraints gbc_Number = new GridBagConstraints();
		gbc_Number.anchor = GridBagConstraints.WEST;
		gbc_Number.insets = new Insets(0, 0, 5, 5);
		gbc_Number.gridx = 1;
		gbc_Number.gridy = 7;
		contentPane.add(Number, gbc_Number);
		
		btnDischarge = new JButton("Discharge");
		btnDischarge.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnDischarge.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					dr.dischargePatient(serialnum, pr);
					SuccesfulOperation discharged = new SuccesfulOperation("Patient has been discharged");
					discharged.setVisible(true);
				} catch (Exception e1) {
					InvalidInput invalid = new InvalidInput("Patient has not been admitted");
					invalid.setVisible(true);
				}
			}
		});
		
		lblDepartment = new JLabel("Department:");
		lblDepartment.setFont(new Font("Tahoma", Font.PLAIN, 22));
		GridBagConstraints gbc_lblDepartment = new GridBagConstraints();
		gbc_lblDepartment.anchor = GridBagConstraints.EAST;
		gbc_lblDepartment.insets = new Insets(0, 0, 5, 5);
		gbc_lblDepartment.gridx = 0;
		gbc_lblDepartment.gridy = 8;
		contentPane.add(lblDepartment, gbc_lblDepartment);
		
		departmentShow = new JLabel("");
		departmentShow.setFont(new Font("Tahoma", Font.PLAIN, 22));
		GridBagConstraints gbc_departmentShow = new GridBagConstraints();
		gbc_departmentShow.anchor = GridBagConstraints.WEST;
		gbc_departmentShow.insets = new Insets(0, 0, 5, 5);
		gbc_departmentShow.gridx = 1;
		gbc_departmentShow.gridy = 8;
		contentPane.add(departmentShow, gbc_departmentShow);
		GridBagConstraints gbc_btnDischarge = new GridBagConstraints();
		gbc_btnDischarge.insets = new Insets(0, 0, 5, 5);
		gbc_btnDischarge.gridx = 1;
		gbc_btnDischarge.gridy = 9;
		contentPane.add(btnDischarge, gbc_btnDischarge);
		
		btnGoBack = new JButton("Go Back");
		btnGoBack.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		GridBagConstraints gbc_btnGoBack = new GridBagConstraints();
		gbc_btnGoBack.insets = new Insets(0, 0, 5, 5);
		gbc_btnGoBack.gridx = 2;
		gbc_btnGoBack.gridy = 9;
		contentPane.add(btnGoBack, gbc_btnGoBack);
		SerialNumber.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					try {
						serialnum = Integer.parseInt(SerialNumber.getText());
						Patient patient = pr.findSerialnum(serialnum);
						if (patient != null) {
							if (!dr.getDeptOfPatient(serialnum).equals("")) {
								lblDepartment.setVisible(true);
								departmentShow.setText(dr.getDeptOfPatient(serialnum));
								departmentShow.setVisible(true);
							} else {
								departmentShow.setText("");
							}
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
