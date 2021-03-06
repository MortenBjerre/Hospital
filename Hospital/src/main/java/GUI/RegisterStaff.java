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

import Hospital.DepartmentRegister;
import Hospital.StaffRegister;
import com.toedter.calendar.JDateChooser;

public class RegisterStaff extends JFrame {

	static StaffRegister sr;
	private JTextField emailTextField;
	private JTextField nameTextField;
	private JTextField surnameTextField;
	private JTextField genderTextField;
	private JDateChooser dateChooser;
	private JComboBox staffTypes;

	/**
	 * Create the frame.
	 */
	@SuppressWarnings("unchecked")
	public RegisterStaff(StaffRegister sr, DepartmentRegister dr) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setTitle("Add Staff Menu");
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 37, 0, 111, 297, 0, 427, 0};
		gridBagLayout.rowHeights = new int[]{46, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0, 1.0, 0.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		this.setSize(new Dimension(1000,700));
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
		
		JLabel lblChooseStaffRole = new JLabel("Choose staff role");
		lblChooseStaffRole.setFont(new Font("Times New Roman", Font.PLAIN, 35));
		GridBagConstraints gbc_lblWhatRoleDoes = new GridBagConstraints();
		gbc_lblWhatRoleDoes.anchor = GridBagConstraints.EAST;
		gbc_lblWhatRoleDoes.insets = new Insets(0, 0, 5, 5);
		gbc_lblWhatRoleDoes.gridx = 2;
		gbc_lblWhatRoleDoes.gridy = 1;
		getContentPane().add(lblChooseStaffRole, gbc_lblWhatRoleDoes);
		
		@SuppressWarnings("rawtypes")
		JComboBox staffRoleChoice = new JComboBox();
		staffRoleChoice.setPreferredSize(new Dimension(200,50));
		staffRoleChoice.setFont(new Font("Times New Roman", Font.PLAIN, 35));
		staffRoleChoice.addItem("Clerk");
		staffRoleChoice.addItem("Doctor");
		staffRoleChoice.addItem("Nurse");
		staffRoleChoice.addItem("ICT Officer");
		staffRoleChoice.addItem("Staff");
		staffRoleChoice.setSelectedIndex(-1);
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 4;
		gbc_comboBox.gridy = 1;
		getContentPane().add(staffRoleChoice, gbc_comboBox);
		
		
		JLabel lblEmail = new JLabel("Email : ");
		lblEmail.setFont(new Font("Times New Roman", Font.PLAIN, 35));
		GridBagConstraints gbc_lblEmail = new GridBagConstraints();
		gbc_lblEmail.anchor = GridBagConstraints.EAST;
		gbc_lblEmail.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmail.gridx = 2;
		gbc_lblEmail.gridy = 4;
		getContentPane().add(lblEmail, gbc_lblEmail);
		
		emailTextField = new JTextField();
		emailTextField.setFont(new Font("Times New Roman", Font.PLAIN, 35));
		GridBagConstraints gbc_email = new GridBagConstraints();
		gbc_email.insets = new Insets(0, 0, 5, 5);
		gbc_email.fill = GridBagConstraints.HORIZONTAL;
		gbc_email.gridx = 4;
		gbc_email.gridy = 4;
		getContentPane().add(emailTextField, gbc_email);
		emailTextField.setColumns(10);
		
		JLabel lblName = new JLabel("Name : ");
		lblName.setFont(new Font("Times New Roman", Font.PLAIN, 35));
		GridBagConstraints gbc_lblName = new GridBagConstraints();
		gbc_lblName.anchor = GridBagConstraints.EAST;
		gbc_lblName.insets = new Insets(0, 0, 5, 5);
		gbc_lblName.gridx = 2;
		gbc_lblName.gridy = 5;
		getContentPane().add(lblName, gbc_lblName);
		
		nameTextField = new JTextField();
		nameTextField.setFont(new Font("Times New Roman", Font.PLAIN, 35));
		GridBagConstraints gbc_name = new GridBagConstraints();
		gbc_name.insets = new Insets(0, 0, 5, 5);
		gbc_name.fill = GridBagConstraints.HORIZONTAL;
		gbc_name.gridx = 4;
		gbc_name.gridy = 5;
		getContentPane().add(nameTextField, gbc_name);
		nameTextField.setColumns(10);
		
		JLabel lblSurname = new JLabel("Surname : ");
		lblSurname.setFont(new Font("Times New Roman", Font.PLAIN, 35));
		GridBagConstraints gbc_lblSurname = new GridBagConstraints();
		gbc_lblSurname.anchor = GridBagConstraints.EAST;
		gbc_lblSurname.insets = new Insets(0, 0, 5, 5);
		gbc_lblSurname.gridx = 2;
		gbc_lblSurname.gridy = 6;
		getContentPane().add(lblSurname, gbc_lblSurname);
		
		surnameTextField = new JTextField();
		surnameTextField.setFont(new Font("Times New Roman", Font.PLAIN, 35));
		GridBagConstraints gbc_surname = new GridBagConstraints();
		gbc_surname.insets = new Insets(0, 0, 5, 5);
		gbc_surname.fill = GridBagConstraints.HORIZONTAL;
		gbc_surname.gridx = 4;
		gbc_surname.gridy = 6;
		getContentPane().add(surnameTextField, gbc_surname);
		
		JLabel lblGender = new JLabel("Gender : ");
		lblGender.setFont(new Font("Times New Roman", Font.PLAIN, 35));
		GridBagConstraints gbc_lblGender = new GridBagConstraints();
		gbc_lblGender.anchor = GridBagConstraints.EAST;
		gbc_lblGender.insets = new Insets(0, 0, 5, 5);
		gbc_lblGender.gridx = 2;
		gbc_lblGender.gridy = 7;
		getContentPane().add(lblGender, gbc_lblGender);
		
		
		genderTextField = new JTextField();
		genderTextField.setFont(new Font("Times New Roman", Font.PLAIN, 35));
		GridBagConstraints gbc_gender = new GridBagConstraints();
		gbc_gender.insets = new Insets(0, 0, 5, 5);
		gbc_gender.fill = GridBagConstraints.HORIZONTAL;
		gbc_gender.gridx = 4;
		gbc_gender.gridy = 7;
		getContentPane().add(genderTextField, gbc_gender);
		genderTextField.setColumns(10);
		
		JLabel lblBirthday = new JLabel("Birthday : ");
		lblBirthday.setFont(new Font("Times New Roman", Font.PLAIN, 35));
		GridBagConstraints gbc_lblBirthday = new GridBagConstraints();
		gbc_lblBirthday.anchor = GridBagConstraints.EAST;
		gbc_lblBirthday.insets = new Insets(0, 0, 5, 5);
		gbc_lblBirthday.gridx = 2;
		gbc_lblBirthday.gridy = 8;
		getContentPane().add(lblBirthday, gbc_lblBirthday);
		surnameTextField.setColumns(10);
		
		staffTypes = new JComboBox();
		staffTypes.setSelectedIndex(-1);
		staffTypes.setFont(new Font("Times New Roman", Font.PLAIN, 35));
		for (String dept : dr.getAllDepartments()) {
			staffTypes.addItem(dept);
		}
		GridBagConstraints gbc_comboBox_1 = new GridBagConstraints();
		gbc_comboBox_1.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_1.gridx = 4;
		gbc_comboBox_1.gridy = 9;
		getContentPane().add(staffTypes, gbc_comboBox_1);
		
		JButton btnAdd = new JButton("Register");
		btnAdd.addActionListener(new ActionListener() {
			private String name;
			private int serialnum;
			private String email;
			private String surname;
			private String gender;
			private Date birthday;

			public void actionPerformed(ActionEvent arg0) {
				
				email = emailTextField.getText();
				name = nameTextField.getText();
				surname = surnameTextField.getText();
				gender = genderTextField.getText();
				
				String staffType = null;
				try {
					staffType = staffRoleChoice.getSelectedItem().toString();
					dateChooser.getDate();
				} catch (Exception e) {
					new InvalidInput("Please fill in all the boxes").setVisible(true);
				}
				if (staffType != null && (email != "") && (name != "") && (surname != "") && (gender != "")) {
					try {
						birthday = new Date(dateChooser.getDate().getYear(),dateChooser.getDate().getMonth(),dateChooser.getDate().getDay());
						if (staffType == "Clerk") {
							serialnum = sr.addClerk(email, name, surname, birthday, gender);
							dr.addStaffTo(serialnum, staffTypes.getSelectedItem().toString(), sr);
						} else if (staffType == "Doctor"){
							serialnum = sr.addDoctor(email, name, surname, birthday, gender);
							dr.addStaffTo(serialnum, staffTypes.getSelectedItem().toString(), sr);
						} else if (staffType == "Nurse") {
							serialnum = sr.addNurse(email, name, surname, birthday, gender);
							dr.addStaffTo(serialnum, staffTypes.getSelectedItem().toString(), sr);
						} else if (staffType == "ICT Officer") {
							serialnum = sr.addICTOfficer(email, name, surname, birthday, gender);
							dr.addStaffTo(serialnum, staffTypes.getSelectedItem().toString(), sr);
						} else {
							serialnum = sr.addStaff(email, name, surname, birthday, gender);
							dr.addStaffTo(serialnum, staffTypes.getSelectedItem().toString(), sr);
						}
						new SuccesfulOperation(name + " was registered as a(n) " + staffType + ". Their serial number is " + serialnum).setVisible(true);
						dispose();
					} catch (Exception e) {
						new InvalidInput("Select birthday of staff member").setVisible(true);
					}
				}
			}
		});
		
		dateChooser = new JDateChooser();
		GridBagConstraints gbc_dateChooser = new GridBagConstraints();
		gbc_dateChooser.insets = new Insets(0, 0, 5, 5);
		gbc_dateChooser.fill = GridBagConstraints.BOTH;
		gbc_dateChooser.gridx = 4;
		gbc_dateChooser.gridy = 8;
		getContentPane().add(dateChooser, gbc_dateChooser);
		
		JLabel lblDepartment = new JLabel("Department : ");
		lblDepartment.setFont(new Font("Times New Roman", Font.PLAIN, 35));
		GridBagConstraints gbc_lblDepartment = new GridBagConstraints();
		gbc_lblDepartment.anchor = GridBagConstraints.EAST;
		gbc_lblDepartment.insets = new Insets(0, 0, 5, 5);
		gbc_lblDepartment.gridx = 2;
		gbc_lblDepartment.gridy = 9;
		getContentPane().add(lblDepartment, gbc_lblDepartment);
		
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
