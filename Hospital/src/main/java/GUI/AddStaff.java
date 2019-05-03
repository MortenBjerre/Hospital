package GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Hospital.StaffRegister;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.Date;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

public class AddStaff extends JFrame {

	static StaffRegister StaffReg;
	private JTextField email;
	private JTextField name;
	private JTextField surname;
	private JTextField gender;

	/**
	 * Create the frame.
	 */
	@SuppressWarnings("unchecked")
	public AddStaff(StaffRegister StaffReg) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setTitle("Add Staff Menu");
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 57, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		JLabel lblWhatRoleDoes = new JLabel("What role does the new staff member have?");
		lblWhatRoleDoes.setFont(new Font("Times New Roman", Font.PLAIN, 35));
		GridBagConstraints gbc_lblWhatRoleDoes = new GridBagConstraints();
		gbc_lblWhatRoleDoes.insets = new Insets(0, 0, 5, 5);
		gbc_lblWhatRoleDoes.gridx = 0;
		gbc_lblWhatRoleDoes.gridy = 1;
		getContentPane().add(lblWhatRoleDoes, gbc_lblWhatRoleDoes);
		
		@SuppressWarnings("rawtypes")
		JComboBox comboBox = new JComboBox();
		comboBox.setPreferredSize(new Dimension(200,50));
		comboBox.setFont(new Font("Times New Roman", Font.PLAIN, 35));
		comboBox.addItem("Clerk");
		comboBox.addItem("Doctor");
		comboBox.addItem("Nurse");
		comboBox.addItem("ICT Officer");
		comboBox.addItem("Other");
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 2;
		gbc_comboBox.gridy = 1;
		getContentPane().add(comboBox, gbc_comboBox);
		
		JLabel lblName = new JLabel("Email : ");
		GridBagConstraints gbc_lblName = new GridBagConstraints();
		gbc_lblName.anchor = GridBagConstraints.EAST;
		gbc_lblName.insets = new Insets(0, 0, 5, 5);
		gbc_lblName.gridx = 0;
		gbc_lblName.gridy = 4;
		getContentPane().add(lblName, gbc_lblName);
		lblName.setVisible(false);
		
		email = new JTextField();
		GridBagConstraints gbc_email = new GridBagConstraints();
		gbc_email.insets = new Insets(0, 0, 5, 0);
		gbc_email.fill = GridBagConstraints.HORIZONTAL;
		gbc_email.gridx = 2;
		gbc_email.gridy = 4;
		getContentPane().add(email, gbc_email);
		email.setColumns(10);
		email.setVisible(false);
		
		JLabel lblNewLabel = new JLabel("Name : ");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 5;
		getContentPane().add(lblNewLabel, gbc_lblNewLabel);
		lblNewLabel.setVisible(false);
		
		name = new JTextField();
		GridBagConstraints gbc_name = new GridBagConstraints();
		gbc_name.insets = new Insets(0, 0, 5, 0);
		gbc_name.fill = GridBagConstraints.HORIZONTAL;
		gbc_name.gridx = 2;
		gbc_name.gridy = 5;
		getContentPane().add(name, gbc_name);
		name.setColumns(10);
		name.setVisible(false);
		
		JLabel lblSurname = new JLabel("Surname : ");
		GridBagConstraints gbc_lblSurname = new GridBagConstraints();
		gbc_lblSurname.anchor = GridBagConstraints.EAST;
		gbc_lblSurname.insets = new Insets(0, 0, 5, 5);
		gbc_lblSurname.gridx = 0;
		gbc_lblSurname.gridy = 6;
		getContentPane().add(lblSurname, gbc_lblSurname);
		lblSurname.setVisible(false);
		
		surname = new JTextField();
		GridBagConstraints gbc_surname = new GridBagConstraints();
		gbc_surname.insets = new Insets(0, 0, 5, 0);
		gbc_surname.fill = GridBagConstraints.HORIZONTAL;
		gbc_surname.gridx = 2;
		gbc_surname.gridy = 6;
		getContentPane().add(surname, gbc_surname);
		surname.setVisible(false);
		
		JLabel lblBirthday = new JLabel("Birthday : ");
		GridBagConstraints gbc_lblBirthday = new GridBagConstraints();
		gbc_lblBirthday.anchor = GridBagConstraints.EAST;
		gbc_lblBirthday.insets = new Insets(0, 0, 5, 5);
		gbc_lblBirthday.gridx = 0;
		gbc_lblBirthday.gridy = 7;
		getContentPane().add(lblBirthday, gbc_lblBirthday);
		surname.setColumns(10);
		lblBirthday.setVisible(false);
		
		JLabel lblDay = new JLabel("Day : ");
		GridBagConstraints gbc_lblDay = new GridBagConstraints();
		gbc_lblDay.insets = new Insets(0, 0, 5, 5);
		gbc_lblDay.anchor = GridBagConstraints.EAST;
		gbc_lblDay.gridx = 1;
		gbc_lblDay.gridy = 8;
		getContentPane().add(lblDay, gbc_lblDay);
		lblDay.setVisible(false);
		
		@SuppressWarnings("rawtypes")
		JComboBox comboDay = new JComboBox();
		for (int loopVal = 1; loopVal <= 31; loopVal++) {
			comboDay.addItem(loopVal);
		}
		GridBagConstraints gbc_comboDay = new GridBagConstraints();
		gbc_comboDay.insets = new Insets(0, 0, 5, 0);
		gbc_comboDay.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboDay.gridx = 2;
		gbc_comboDay.gridy = 8;
		getContentPane().add(comboDay, gbc_comboDay);
		comboDay.setVisible(false);
		
		JLabel lblMonth = new JLabel("Month : ");
		GridBagConstraints gbc_lblMonth = new GridBagConstraints();
		gbc_lblMonth.anchor = GridBagConstraints.EAST;
		gbc_lblMonth.insets = new Insets(0, 0, 5, 5);
		gbc_lblMonth.gridx = 1;
		gbc_lblMonth.gridy = 9;
		getContentPane().add(lblMonth, gbc_lblMonth);
		lblMonth.setVisible(false);
		
		@SuppressWarnings("rawtypes")
		JComboBox comboMonth = new JComboBox();
		for (int loopVal = 1; loopVal <= 12; loopVal++) {
			comboMonth.addItem(loopVal);
		}
		GridBagConstraints gbc_comboMonth = new GridBagConstraints();
		gbc_comboMonth.insets = new Insets(0, 0, 5, 0);
		gbc_comboMonth.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboMonth.gridx = 2;
		gbc_comboMonth.gridy = 9;
		getContentPane().add(comboMonth, gbc_comboMonth);
		comboMonth.setVisible(false);
		
		JLabel lblYear = new JLabel("Year : ");
		GridBagConstraints gbc_lblYear = new GridBagConstraints();
		gbc_lblYear.anchor = GridBagConstraints.EAST;
		gbc_lblYear.insets = new Insets(0, 0, 5, 5);
		gbc_lblYear.gridx = 1;
		gbc_lblYear.gridy = 10;
		getContentPane().add(lblYear, gbc_lblYear);
		lblYear.setVisible(false);
		
		@SuppressWarnings("rawtypes")
		JComboBox comboYear = new JComboBox();
		for (int loopVal = 1900; loopVal <= 2019; loopVal++) {
			comboYear.addItem(loopVal);
		}
		GridBagConstraints gbc_comboYear = new GridBagConstraints();
		gbc_comboYear.insets = new Insets(0, 0, 5, 0);
		gbc_comboYear.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboYear.gridx = 2;
		gbc_comboYear.gridy = 10;
		getContentPane().add(comboYear, gbc_comboYear);
		comboYear.setVisible(false);
		
		JLabel lblGender = new JLabel("Gender : ");
		GridBagConstraints gbc_lblGender = new GridBagConstraints();
		gbc_lblGender.anchor = GridBagConstraints.EAST;
		gbc_lblGender.insets = new Insets(0, 0, 0, 5);
		gbc_lblGender.gridx = 0;
		gbc_lblGender.gridy = 11;
		getContentPane().add(lblGender, gbc_lblGender);
		lblGender.setVisible(false);
		
		
		gender = new JTextField();
		GridBagConstraints gbc_gender = new GridBagConstraints();
		gbc_gender.fill = GridBagConstraints.HORIZONTAL;
		gbc_gender.gridx = 2;
		gbc_gender.gridy = 11;
		getContentPane().add(gender, gbc_gender);
		gender.setColumns(10);
		gender.setVisible(false);
		
		
		String x = comboBox.getSelectedItem().toString();
		if (x != null) {
			
			lblName.setVisible(true);
			email.setVisible(true);
			lblNewLabel.setVisible(true);
			name.setVisible(true);
			lblSurname.setVisible(true);
			surname.setVisible(true);
			lblBirthday.setVisible(true);
			lblDay.setVisible(true);
			comboDay.setVisible(true);
			lblMonth.setVisible(true);
			comboMonth.setVisible(true);
			lblYear.setVisible(true);
			comboYear.setVisible(true);
			lblGender.setVisible(true);
			gender.setVisible(true);
			
			
			
			
			String Email = email.getText();
			String Name = name.getText();
			String Surname = surname.getText();
			@SuppressWarnings("deprecation")
			//Date birthday = new Date((comboYear.getSelectedItem()+1900),comboMonth.getSelectedItem(),comboDay.getSelectedItem());
			String Gender = gender.getText();
			
			if (x == "Clerk") {
				//StaffReg.addClerk(email, name, surname, birthday, gender);
			} else if (x == "Doctor"){
				//StaffReg.addDoctor(email, name, surname, birthday, gender);
			} else if (x == "Nurse") {
				//StaffReg.addNurse(email, name, surname, birthday, gender);
			} else if (x == "ICT Officer") {
				//StaffReg.addICTOfficer(email, name, surname, birthday, gender);
			} else {
				//StaffReg.addStaff(email, name, surname, birthday, gender);
			}
		}

	}
	

}
