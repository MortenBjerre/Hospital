package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Hospital.DepartmentRegister;
import Hospital.PatientRegister;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import com.toedter.calendar.JDateChooser;
import javax.swing.JTextArea;

public class RegisterPatient extends JFrame {

	private JPanel contentPane;
	private JTextField Name;
	private JTextField Surname;
	private JTextField Address;
	private JTextField Email;
	private JTextField Number;
	private JTextField Gender;
	private JTextArea txtrHealthdatafield;
	PatientRegister PatientReg;
	DepartmentRegister DepartReg;
	private Date DayOfBirth;
	private JTextField txtHealthDataInput;
	
	


	/**
	 * Create the frame.
	 */
	public RegisterPatient(final PatientRegister PatientReg, final DepartmentRegister DepartReg) {
		
		
		this.PatientReg = PatientReg;
		this.DepartReg = DepartReg;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 500, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 89, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 245, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblName = new JLabel("Name: ");
		GridBagConstraints gbc_lblName = new GridBagConstraints();
		gbc_lblName.anchor = GridBagConstraints.EAST;
		gbc_lblName.insets = new Insets(0, 0, 5, 5);
		gbc_lblName.gridx = 2;
		gbc_lblName.gridy = 1;
		contentPane.add(lblName, gbc_lblName);
		
		Name = new JTextField();
		GridBagConstraints gbc_txtHealthDataInput = new GridBagConstraints();
		gbc_txtHealthDataInput.insets = new Insets(0, 0, 5, 5);
		gbc_txtHealthDataInput.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtHealthDataInput.gridx = 3;
		gbc_txtHealthDataInput.gridy = 1;
		contentPane.add(Name, gbc_txtHealthDataInput);
		Name.setColumns(10);
		
		JLabel lblSurname = new JLabel("Surname: ");
		GridBagConstraints gbc_lblSurname = new GridBagConstraints();
		gbc_lblSurname.anchor = GridBagConstraints.EAST;
		gbc_lblSurname.insets = new Insets(0, 0, 5, 5);
		gbc_lblSurname.gridx = 2;
		gbc_lblSurname.gridy = 2;
		contentPane.add(lblSurname, gbc_lblSurname);
		
		Surname = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 3;
		gbc_textField_1.gridy = 2;
		contentPane.add(Surname, gbc_textField_1);
		Surname.setColumns(10);
		
		JLabel lblAddress = new JLabel("Address: ");
		GridBagConstraints gbc_lblAddress = new GridBagConstraints();
		gbc_lblAddress.anchor = GridBagConstraints.EAST;
		gbc_lblAddress.insets = new Insets(0, 0, 5, 5);
		gbc_lblAddress.gridx = 2;
		gbc_lblAddress.gridy = 3;
		contentPane.add(lblAddress, gbc_lblAddress);
		
		Address = new JTextField();
		Address.setColumns(10);
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.insets = new Insets(0, 0, 5, 5);
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.gridx = 3;
		gbc_textField_2.gridy = 3;
		contentPane.add(Address, gbc_textField_2);
		
		JLabel lblEmail = new JLabel("Email: ");
		GridBagConstraints gbc_lblEmail = new GridBagConstraints();
		gbc_lblEmail.anchor = GridBagConstraints.EAST;
		gbc_lblEmail.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmail.gridx = 2;
		gbc_lblEmail.gridy = 4;
		contentPane.add(lblEmail, gbc_lblEmail);
		
		Email = new JTextField();
		Email.setColumns(10);
		GridBagConstraints gbc_textField_3 = new GridBagConstraints();
		gbc_textField_3.insets = new Insets(0, 0, 5, 5);
		gbc_textField_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_3.gridx = 3;
		gbc_textField_3.gridy = 4;
		contentPane.add(Email, gbc_textField_3);
		
		JLabel lblBirthday = new JLabel("Birthday: ");
		GridBagConstraints gbc_lblBirthday = new GridBagConstraints();
		gbc_lblBirthday.anchor = GridBagConstraints.EAST;
		gbc_lblBirthday.insets = new Insets(0, 0, 5, 5);
		gbc_lblBirthday.gridx = 2;
		gbc_lblBirthday.gridy = 5;
		contentPane.add(lblBirthday, gbc_lblBirthday);
		
		JDateChooser dateChooser = new JDateChooser();
//		dateChooser.getCalendarButton().addActionListener(new ActionListener() {
//
//			public void actionPerformed(ActionEvent arg0) {
//				DayOfBirth = dateChooser.getDate();
//
//			}
//		});
		GridBagConstraints gbc_dateChooser = new GridBagConstraints();
		gbc_dateChooser.insets = new Insets(0, 0, 5, 5);
		gbc_dateChooser.fill = GridBagConstraints.HORIZONTAL;
		gbc_dateChooser.gridx = 3;
		gbc_dateChooser.gridy = 5;
		contentPane.add(dateChooser, gbc_dateChooser);
		
//		textField_4 = new JTextField();
//		textField_4.setColumns(10);
//		GridBagConstraints gbc_textField_4 = new GridBagConstraints();
//		gbc_textField_4.insets = new Insets(0, 0, 5, 5);
//		gbc_textField_4.fill = GridBagConstraints.HORIZONTAL;
//		gbc_textField_4.gridx = 3;
//		gbc_textField_4.gridy = 7;
//		contentPane.add(textField_4, gbc_textField_4);
		
		JLabel lblGender = new JLabel("Gender: ");
		GridBagConstraints gbc_lblGender = new GridBagConstraints();
		gbc_lblGender.anchor = GridBagConstraints.EAST;
		gbc_lblGender.insets = new Insets(0, 0, 5, 5);
		gbc_lblGender.gridx = 2;
		gbc_lblGender.gridy = 6;
		contentPane.add(lblGender, gbc_lblGender);
		
		Gender = new JTextField();
		Gender.setColumns(10);
		GridBagConstraints gbc_textField_5 = new GridBagConstraints();
		gbc_textField_5.insets = new Insets(0, 0, 5, 5);
		gbc_textField_5.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_5.gridx = 3;
		gbc_textField_5.gridy = 6;
		contentPane.add(Gender, gbc_textField_5);
		
		JLabel lblPhoneNumber = new JLabel("Phone Number: ");
		GridBagConstraints gbc_lblPhoneNumber = new GridBagConstraints();
		gbc_lblPhoneNumber.anchor = GridBagConstraints.EAST;
		gbc_lblPhoneNumber.insets = new Insets(0, 0, 5, 5);
		gbc_lblPhoneNumber.gridx = 2;
		gbc_lblPhoneNumber.gridy = 7;
		contentPane.add(lblPhoneNumber, gbc_lblPhoneNumber);
		
		Number = new JTextField();
		Number.setColumns(10);
		GridBagConstraints gbc_textField_6 = new GridBagConstraints();
		gbc_textField_6.insets = new Insets(0, 0, 5, 5);
		gbc_textField_6.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_6.gridx = 3;
		gbc_textField_6.gridy = 7;
		contentPane.add(Number, gbc_textField_6);
		
		JLabel lblAlive = new JLabel("Alive: ");
		lblAlive.setHorizontalAlignment(SwingConstants.TRAILING);
		GridBagConstraints gbc_lblAlive = new GridBagConstraints();
		gbc_lblAlive.insets = new Insets(0, 0, 5, 5);
		gbc_lblAlive.anchor = GridBagConstraints.EAST;
		gbc_lblAlive.gridx = 2;
		gbc_lblAlive.gridy = 8;
		contentPane.add(lblAlive, gbc_lblAlive);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String name = Name.getText();
					String surname = Surname.getText();
					String address = Address.getText();
					String email = Email.getText();
					String healthData = txtHealthDataInput.getText();
					String gender = Gender.getText();
					int phoneNumber = Integer.parseInt(Number.getText());
					int birthMonth = dateChooser.getDate().getMonth();
					int birthday =  dateChooser.getDate().getDay();
					int birthYear = dateChooser.getDate().getYear();
					PatientReg.add(email, name, surname, new Date(birthYear, birthMonth, birthday), gender, address, phoneNumber, true, healthData);
					dispose();
				} catch (Exception er) {
					InvalidInput invalidInput = new InvalidInput("Please enter valid input."); 
					invalidInput.setVisible(true);
					Name.setText("");
					Surname.setText("");
					Address.setText("");
					Email.setText("");
					Gender.setText("");
					Number.setText("");
					txtHealthDataInput.setText("");
				}
			}
		});
		
		@SuppressWarnings({ "unchecked", "rawtypes", "serial" })
		JList list = new JList(new AbstractListModel() {
			String[] values = new String[] {"Alive", "Dead"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		GridBagConstraints gbc_list = new GridBagConstraints();
		gbc_list.insets = new Insets(0, 0, 5, 5);
		gbc_list.fill = GridBagConstraints.HORIZONTAL;
		gbc_list.gridx = 3;
		gbc_list.gridy = 8;
		contentPane.add(list, gbc_list);
		
		JLabel lblHealthData = new JLabel("Health Data:");
		GridBagConstraints gbc_lblHealthData = new GridBagConstraints();
		gbc_lblHealthData.anchor = GridBagConstraints.EAST;
		gbc_lblHealthData.insets = new Insets(0, 0, 5, 5);
		gbc_lblHealthData.gridx = 2;
		gbc_lblHealthData.gridy = 9;
		contentPane.add(lblHealthData, gbc_lblHealthData);
		
		txtHealthDataInput = new JTextField();
		txtHealthDataInput.setText("");
		GridBagConstraints gbc_txtHealthDataInput1 = new GridBagConstraints();
		gbc_txtHealthDataInput1.insets = new Insets(0, 0, 5, 5);
		gbc_txtHealthDataInput1.fill = GridBagConstraints.BOTH;
		gbc_txtHealthDataInput1.gridx = 3;
		gbc_txtHealthDataInput1.gridy = 9;
		contentPane.add(txtHealthDataInput, gbc_txtHealthDataInput1);
		txtHealthDataInput.setColumns(10);
		GridBagConstraints gbc_btnRegister = new GridBagConstraints();
		gbc_btnRegister.insets = new Insets(0, 0, 0, 5);
		gbc_btnRegister.gridx = 3;
		gbc_btnRegister.gridy = 10;
		contentPane.add(btnRegister, gbc_btnRegister);
		
		
		
	}
}
