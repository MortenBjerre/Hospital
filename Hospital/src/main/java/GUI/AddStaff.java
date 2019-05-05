package GUI;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Hospital.StaffRegister;

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
		gridBagLayout.columnWidths = new int[]{0, 37, 0, 111, 297, 0, 427, 0};
		gridBagLayout.rowHeights = new int[]{46, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0, 1.0, 0.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		this.setLocationRelativeTo(null);
		
		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 5, 5);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 1;
		gbc_panel_1.gridy = 0;
		getContentPane().add(panel_1, gbc_panel_1);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 1;
		getContentPane().add(panel, gbc_panel);
		
		JLabel lblWhatRoleDoes = new JLabel("Staff Role?");
		lblWhatRoleDoes.setFont(new Font("Times New Roman", Font.PLAIN, 35));
		GridBagConstraints gbc_lblWhatRoleDoes = new GridBagConstraints();
		gbc_lblWhatRoleDoes.anchor = GridBagConstraints.EAST;
		gbc_lblWhatRoleDoes.insets = new Insets(0, 0, 5, 5);
		gbc_lblWhatRoleDoes.gridx = 2;
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
		comboBox.setSelectedIndex(-1);
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 4;
		gbc_comboBox.gridy = 1;
		getContentPane().add(comboBox, gbc_comboBox);
		
		
		JLabel lblEmail = new JLabel("Email : ");
		lblEmail.setFont(new Font("Times New Roman", Font.PLAIN, 35));
		GridBagConstraints gbc_lblEmail = new GridBagConstraints();
		gbc_lblEmail.anchor = GridBagConstraints.EAST;
		gbc_lblEmail.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmail.gridx = 2;
		gbc_lblEmail.gridy = 4;
		getContentPane().add(lblEmail, gbc_lblEmail);
		
		email = new JTextField();
		email.setFont(new Font("Times New Roman", Font.PLAIN, 35));
		GridBagConstraints gbc_email = new GridBagConstraints();
		gbc_email.insets = new Insets(0, 0, 5, 5);
		gbc_email.fill = GridBagConstraints.HORIZONTAL;
		gbc_email.gridx = 4;
		gbc_email.gridy = 4;
		getContentPane().add(email, gbc_email);
		email.setColumns(10);
		
		JLabel lblName = new JLabel("Name : ");
		lblName.setFont(new Font("Times New Roman", Font.PLAIN, 35));
		GridBagConstraints gbc_lblName = new GridBagConstraints();
		gbc_lblName.anchor = GridBagConstraints.EAST;
		gbc_lblName.insets = new Insets(0, 0, 5, 5);
		gbc_lblName.gridx = 2;
		gbc_lblName.gridy = 5;
		getContentPane().add(lblName, gbc_lblName);
		
		name = new JTextField();
		name.setFont(new Font("Times New Roman", Font.PLAIN, 35));
		GridBagConstraints gbc_name = new GridBagConstraints();
		gbc_name.insets = new Insets(0, 0, 5, 5);
		gbc_name.fill = GridBagConstraints.HORIZONTAL;
		gbc_name.gridx = 4;
		gbc_name.gridy = 5;
		getContentPane().add(name, gbc_name);
		name.setColumns(10);
		
		JLabel lblSurname = new JLabel("Surname : ");
		lblSurname.setFont(new Font("Times New Roman", Font.PLAIN, 35));
		GridBagConstraints gbc_lblSurname = new GridBagConstraints();
		gbc_lblSurname.anchor = GridBagConstraints.EAST;
		gbc_lblSurname.insets = new Insets(0, 0, 5, 5);
		gbc_lblSurname.gridx = 2;
		gbc_lblSurname.gridy = 6;
		getContentPane().add(lblSurname, gbc_lblSurname);
		
		surname = new JTextField();
		surname.setFont(new Font("Times New Roman", Font.PLAIN, 35));
		GridBagConstraints gbc_surname = new GridBagConstraints();
		gbc_surname.insets = new Insets(0, 0, 5, 5);
		gbc_surname.fill = GridBagConstraints.HORIZONTAL;
		gbc_surname.gridx = 4;
		gbc_surname.gridy = 6;
		getContentPane().add(surname, gbc_surname);
		
		JLabel lblGender = new JLabel("Gender : ");
		lblGender.setFont(new Font("Times New Roman", Font.PLAIN, 35));
		GridBagConstraints gbc_lblGender = new GridBagConstraints();
		gbc_lblGender.anchor = GridBagConstraints.EAST;
		gbc_lblGender.insets = new Insets(0, 0, 5, 5);
		gbc_lblGender.gridx = 2;
		gbc_lblGender.gridy = 7;
		getContentPane().add(lblGender, gbc_lblGender);
		
		
		gender = new JTextField();
		gender.setFont(new Font("Times New Roman", Font.PLAIN, 35));
		GridBagConstraints gbc_gender = new GridBagConstraints();
		gbc_gender.insets = new Insets(0, 0, 5, 5);
		gbc_gender.fill = GridBagConstraints.HORIZONTAL;
		gbc_gender.gridx = 4;
		gbc_gender.gridy = 7;
		getContentPane().add(gender, gbc_gender);
		gender.setColumns(10);
		
		JLabel lblBirthday = new JLabel("Birthday : ");
		lblBirthday.setFont(new Font("Times New Roman", Font.PLAIN, 35));
		GridBagConstraints gbc_lblBirthday = new GridBagConstraints();
		gbc_lblBirthday.anchor = GridBagConstraints.EAST;
		gbc_lblBirthday.insets = new Insets(0, 0, 5, 5);
		gbc_lblBirthday.gridx = 2;
		gbc_lblBirthday.gridy = 8;
		getContentPane().add(lblBirthday, gbc_lblBirthday);
		surname.setColumns(10);
		
		JLabel lblDay = new JLabel("Day : ");
		lblDay.setFont(new Font("Times New Roman", Font.PLAIN, 35));
		GridBagConstraints gbc_lblDay = new GridBagConstraints();
		gbc_lblDay.insets = new Insets(0, 0, 5, 5);
		gbc_lblDay.anchor = GridBagConstraints.EAST;
		gbc_lblDay.gridx = 3;
		gbc_lblDay.gridy = 9;
		getContentPane().add(lblDay, gbc_lblDay);
		
		@SuppressWarnings("rawtypes")
		JComboBox comboDay = new JComboBox();
		for (int loopVal = 1; loopVal <= 31; loopVal++) {
			comboDay.addItem(loopVal);
		}
		comboDay.setFont(new Font("Times New Roman", Font.PLAIN, 35));
		comboDay.setPreferredSize(new Dimension(200,50));
		GridBagConstraints gbc_comboDay = new GridBagConstraints();
		gbc_comboDay.insets = new Insets(0, 0, 5, 5);
		gbc_comboDay.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboDay.gridx = 4;
		gbc_comboDay.gridy = 9;
		getContentPane().add(comboDay, gbc_comboDay);
		comboDay.setSelectedIndex(-1);
		
		JLabel lblMonth = new JLabel("Month : ");
		lblMonth.setFont(new Font("Times New Roman", Font.PLAIN, 35));
		GridBagConstraints gbc_lblMonth = new GridBagConstraints();
		gbc_lblMonth.anchor = GridBagConstraints.EAST;
		gbc_lblMonth.insets = new Insets(0, 0, 5, 5);
		gbc_lblMonth.gridx = 3;
		gbc_lblMonth.gridy = 10;
		getContentPane().add(lblMonth, gbc_lblMonth);
		
		@SuppressWarnings("rawtypes")
		JComboBox comboMonth = new JComboBox();
		comboMonth.setFont(new Font("Times New Roman", Font.PLAIN, 35));
		for (int loopVal = 1; loopVal <= 12; loopVal++) {
			comboMonth.addItem(loopVal);
		}
		comboMonth.setPreferredSize(new Dimension(200,50));
		GridBagConstraints gbc_comboMonth = new GridBagConstraints();
		gbc_comboMonth.insets = new Insets(0, 0, 5, 5);
		gbc_comboMonth.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboMonth.gridx = 4;
		gbc_comboMonth.gridy = 10;
		getContentPane().add(comboMonth, gbc_comboMonth);
		comboMonth.setSelectedIndex(-1);
		
		JLabel lblYear = new JLabel("Year : ");
		lblYear.setFont(new Font("Times New Roman", Font.PLAIN, 35));
		GridBagConstraints gbc_lblYear = new GridBagConstraints();
		gbc_lblYear.anchor = GridBagConstraints.EAST;
		gbc_lblYear.insets = new Insets(0, 0, 5, 5);
		gbc_lblYear.gridx = 3;
		gbc_lblYear.gridy = 11;
		getContentPane().add(lblYear, gbc_lblYear);
		
		@SuppressWarnings("rawtypes")
		JComboBox comboYear = new JComboBox();
		comboYear.setFont(new Font("Times New Roman", Font.PLAIN, 35));
		for (int loopVal = 1900; loopVal <= 2019; loopVal++) {
			comboYear.addItem(loopVal);
		}
		comboYear.setPreferredSize(new Dimension(200,50));
		GridBagConstraints gbc_comboYear = new GridBagConstraints();
		gbc_comboYear.insets = new Insets(0, 0, 5, 5);
		gbc_comboYear.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboYear.gridx = 4;
		gbc_comboYear.gridy = 11;
		getContentPane().add(comboYear, gbc_comboYear);
		comboYear.setSelectedIndex(-1);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String x = null;
				try {
					x = comboBox.getSelectedItem().toString();
				} catch (Exception e) {
					;
				}
				if (x != null) {	
					String Email = email.getText();
					String Name = name.getText();
					String Surname = surname.getText();
					@SuppressWarnings("deprecation")
					Date birthday = new Date((Integer.parseInt(comboYear.getSelectedItem().toString())+1900),
							Integer.parseInt(comboMonth.getSelectedItem().toString()),
							Integer.parseInt(comboDay.getSelectedItem().toString()));
					String Gender = gender.getText();
					
					
					if (x == "Clerk") {
						StaffReg.addClerk(Email, Name, Surname, birthday, Gender);
					} else if (x == "Doctor"){
						StaffReg.addDoctor(Email, Name, Surname, birthday, Gender);
					} else if (x == "Nurse") {
						StaffReg.addNurse(Email, Name, Surname, birthday, Gender);
					} else if (x == "ICT Officer") {
						StaffReg.addICTOfficer(Email, Name, Surname, birthday, Gender);
					} else {
						StaffReg.addStaff(Email, Name, Surname, birthday, Gender);
					}
				}
			}
		});
		btnAdd.setFont(new Font("Times New Roman", Font.PLAIN, 35));
		GridBagConstraints gbc_btnAdd = new GridBagConstraints();
		gbc_btnAdd.insets = new Insets(0, 0, 5, 5);
		gbc_btnAdd.gridx = 4;
		gbc_btnAdd.gridy = 12;
		getContentPane().add(btnAdd, gbc_btnAdd);
		
		JPanel panel_3 = new JPanel();
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.insets = new Insets(0, 0, 5, 5);
		gbc_panel_3.fill = GridBagConstraints.BOTH;
		gbc_panel_3.gridx = 5;
		gbc_panel_3.gridy = 13;
		getContentPane().add(panel_3, gbc_panel_3);
		
		JPanel panel_2 = new JPanel();
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.insets = new Insets(0, 0, 5, 0);
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 6;
		gbc_panel_2.gridy = 14;
		getContentPane().add(panel_2, gbc_panel_2);

	}
	

}
