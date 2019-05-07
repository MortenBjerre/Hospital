package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;

import Hospital.DepartmentRegister;
import Hospital.Staff;
import Hospital.StaffRegister;

public class UpdateStaffInfo extends JFrame {

	private JPanel contentPane;
	private JTextField Name;
	private JTextField Surname;
	private JTextField Email;
	private JTextField Birthday;
	private JLabel lblEditBirthday;
	private JDateChooser dateChooser;
	private JButton btnUpdate;
	private JTextField Gender;
	private JTextField SerialNumber;
	private JButton btnGoBack;
	private int serialnum;
	private SimpleDateFormat format;
	private JComboBox roleChoice;
	private JButton btnUpdateStaffRole;
	private JTextField showRole;
	private Staff s;

	public UpdateStaffInfo(StaffRegister sr, DepartmentRegister dr, Staff staff) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Update staff member's information");
		setBounds(100, 100, 850, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{403, 348, 91, 0};
		gbl_contentPane.rowHeights = new int[]{56, 33, 39, 41, 0, 0, 0, 0, 43, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		this.setLocationRelativeTo(null);
		
		JLabel lblPleaseEnterThe = new JLabel("Enter Staff Serial Number: ");
		lblPleaseEnterThe.setFont(new Font("Times New Roman", Font.PLAIN, 27));
		GridBagConstraints gbc_lblPleaseEnterThe = new GridBagConstraints();
		gbc_lblPleaseEnterThe.anchor = GridBagConstraints.EAST;
		gbc_lblPleaseEnterThe.insets = new Insets(0, 0, 5, 5);
		gbc_lblPleaseEnterThe.gridx = 0;
		gbc_lblPleaseEnterThe.gridy = 1;
		contentPane.add(lblPleaseEnterThe, gbc_lblPleaseEnterThe);
		
		final JLabel lblEnterPatientsName = new JLabel("Name: ");
		lblEnterPatientsName.setFont(new Font("Times New Roman", Font.PLAIN, 27));
		lblEnterPatientsName.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lblEnterPatientsName = new GridBagConstraints();
		gbc_lblEnterPatientsName.fill = GridBagConstraints.VERTICAL;
		gbc_lblEnterPatientsName.insets = new Insets(0, 0, 5, 5);
		gbc_lblEnterPatientsName.anchor = GridBagConstraints.EAST;
		gbc_lblEnterPatientsName.gridx = 0;
		gbc_lblEnterPatientsName.gridy = 2;
		contentPane.add(lblEnterPatientsName, gbc_lblEnterPatientsName);
		lblEnterPatientsName.setVisible(false);
		
		Name = new JTextField();
		Name.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String newName = Name.getText();
				sr.editName(serialnum, newName);
			}
		});
		Name.setFont(new Font("Times New Roman", Font.PLAIN, 27));
		GridBagConstraints gbc_Name = new GridBagConstraints();
		gbc_Name.insets = new Insets(0, 0, 5, 5);
		gbc_Name.fill = GridBagConstraints.HORIZONTAL;
		gbc_Name.gridx = 1;
		gbc_Name.gridy = 2;
		contentPane.add(Name, gbc_Name);
		Name.setColumns(10);
		Name.setVisible(false);
		
		final JLabel lblSurname = new JLabel("Surname: ");
		lblSurname.setFont(new Font("Times New Roman", Font.PLAIN, 27));
		lblSurname.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lblSurname = new GridBagConstraints();
		gbc_lblSurname.anchor = GridBagConstraints.EAST;
		gbc_lblSurname.insets = new Insets(0, 0, 5, 5);
		gbc_lblSurname.gridx = 0;
		gbc_lblSurname.gridy = 3;
		contentPane.add(lblSurname, gbc_lblSurname);
		lblSurname.setVisible(false);
		
		Surname = new JTextField();
		Surname.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String newSurname = Surname.getText();
				sr.editSurname(serialnum, newSurname);
			}
		});
		Surname.setFont(new Font("Times New Roman", Font.PLAIN, 27));
		GridBagConstraints gbc_Surname = new GridBagConstraints();
		gbc_Surname.insets = new Insets(0, 0, 5, 5);
		gbc_Surname.fill = GridBagConstraints.HORIZONTAL;
		gbc_Surname.gridx = 1;
		gbc_Surname.gridy = 3;
		contentPane.add(Surname, gbc_Surname);
		Surname.setColumns(10);
		Surname.setVisible(false);
		
		final JLabel lblEmail = new JLabel("Email: ");
		lblEmail.setFont(new Font("Times New Roman", Font.PLAIN, 27));
		GridBagConstraints gbc_lblEmail = new GridBagConstraints();
		gbc_lblEmail.anchor = GridBagConstraints.EAST;
		gbc_lblEmail.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmail.gridx = 0;
		gbc_lblEmail.gridy = 4;
		contentPane.add(lblEmail, gbc_lblEmail);
		lblEmail.setVisible(false);
		
		Email = new JTextField();
		Email.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String newEmail = Email.getText();
				sr.editEmail(serialnum, newEmail);
			}
		});
		Email.setFont(new Font("Times New Roman", Font.PLAIN, 27));
		GridBagConstraints gbc_Email = new GridBagConstraints();
		gbc_Email.insets = new Insets(0, 0, 5, 5);
		gbc_Email.fill = GridBagConstraints.HORIZONTAL;
		gbc_Email.gridx = 1;
		gbc_Email.gridy = 4;
		contentPane.add(Email, gbc_Email);
		Email.setColumns(10);
		Email.setVisible(false);
		
		final JLabel lblBirthday = new JLabel("Birthday: ");
		lblBirthday.setFont(new Font("Times New Roman", Font.PLAIN, 27));
		GridBagConstraints gbc_lblBirthday = new GridBagConstraints();
		gbc_lblBirthday.anchor = GridBagConstraints.EAST;
		gbc_lblBirthday.insets = new Insets(0, 0, 5, 5);
		gbc_lblBirthday.gridx = 0;
		gbc_lblBirthday.gridy = 5;
		contentPane.add(lblBirthday, gbc_lblBirthday);
		lblBirthday.setVisible(false);
		
		Birthday = new JTextField();
		Birthday.setFont(new Font("Times New Roman", Font.PLAIN, 27));
		GridBagConstraints gbc_Birthday = new GridBagConstraints();
		gbc_Birthday.insets = new Insets(0, 0, 5, 5);
		gbc_Birthday.fill = GridBagConstraints.HORIZONTAL;
		gbc_Birthday.gridx = 1;
		gbc_Birthday.gridy = 5;
		contentPane.add(Birthday, gbc_Birthday);
		Birthday.setColumns(10);
		Birthday.setVisible(false);
		
		lblEditBirthday = new JLabel("Edit Birthday");
		lblEditBirthday.setVisible(false);
		lblEditBirthday.setFont(new Font("Times New Roman", Font.PLAIN, 27));
		GridBagConstraints gbc_lblEditBirthday = new GridBagConstraints();
		gbc_lblEditBirthday.anchor = GridBagConstraints.EAST;
		gbc_lblEditBirthday.insets = new Insets(0, 0, 5, 5);
		gbc_lblEditBirthday.gridx = 0;
		gbc_lblEditBirthday.gridy = 6;
		contentPane.add(lblEditBirthday, gbc_lblEditBirthday);
		
		dateChooser = new JDateChooser();
		dateChooser.setVisible(false);
		
		GridBagConstraints gbc_dateChooser = new GridBagConstraints();
		gbc_dateChooser.insets = new Insets(0, 0, 5, 5);
		gbc_dateChooser.fill = GridBagConstraints.BOTH;
		gbc_dateChooser.gridx = 1;
		gbc_dateChooser.gridy = 6;
		contentPane.add(dateChooser, gbc_dateChooser);
		
		btnUpdate = new JButton("Update birthday");
		btnUpdate.setVisible(false);
		btnUpdate.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				format = new SimpleDateFormat("yyyy-MM-dd");
				Date birthday = dateChooser.getDate();
				Birthday.setText(format.format(birthday));
				sr.editBirthday(serialnum, birthday);
			}
		});
		GridBagConstraints gbc_btnUpdate = new GridBagConstraints();
		gbc_btnUpdate.insets = new Insets(0, 0, 5, 0);
		gbc_btnUpdate.gridx = 2;
		gbc_btnUpdate.gridy = 6;
		contentPane.add(btnUpdate, gbc_btnUpdate);
		
		final JLabel lblGender = new JLabel("Gender: ");
		lblGender.setFont(new Font("Times New Roman", Font.PLAIN, 27));
		GridBagConstraints gbc_lblGender = new GridBagConstraints();
		gbc_lblGender.anchor = GridBagConstraints.EAST;
		gbc_lblGender.insets = new Insets(0, 0, 5, 5);
		gbc_lblGender.gridx = 0;
		gbc_lblGender.gridy = 7;
		contentPane.add(lblGender, gbc_lblGender);
		lblGender.setVisible(false);
		
		JLabel lblCurrentRole = new JLabel("Current role: ");
		lblCurrentRole.setVisible(false);
		lblCurrentRole.setFont(new Font("Times New Roman", Font.PLAIN, 27));
		GridBagConstraints gbc_lblCurrentRole = new GridBagConstraints();
		gbc_lblCurrentRole.anchor = GridBagConstraints.EAST;
		gbc_lblCurrentRole.insets = new Insets(0, 0, 5, 5);
		gbc_lblCurrentRole.gridx = 0;
		gbc_lblCurrentRole.gridy = 8;
		contentPane.add(lblCurrentRole, gbc_lblCurrentRole);
		lblCurrentRole.setVisible(false);
		
		showRole = new JTextField(staff.getRole());
		showRole.setEditable(false);
		showRole.setFont(new Font("Times New Roman", Font.PLAIN, 27));
		GridBagConstraints gbc_showRole = new GridBagConstraints();
		gbc_showRole.insets = new Insets(0, 0, 5, 5);
		gbc_showRole.fill = GridBagConstraints.HORIZONTAL;
		gbc_showRole.gridx = 1;
		gbc_showRole.gridy = 8;
		contentPane.add(showRole, gbc_showRole);
		showRole.setColumns(10);
		showRole.setVisible(false);
		
		Gender = new JTextField();
		Gender.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String newGender = Gender.getText();
				sr.editGender(serialnum, newGender);
			}
		});
		Gender.setFont(new Font("Times New Roman", Font.PLAIN, 27));
		GridBagConstraints gbc_Gender = new GridBagConstraints();
		gbc_Gender.insets = new Insets(0, 0, 5, 5);
		gbc_Gender.fill = GridBagConstraints.HORIZONTAL;
		gbc_Gender.gridx = 1;
		gbc_Gender.gridy = 7;
		contentPane.add(Gender, gbc_Gender);
		Gender.setColumns(10);
		Gender.setVisible(false);
		
		JLabel lblChangeRole = new JLabel("Change role:");
		lblChangeRole.setVisible(false);
		lblChangeRole.setFont(new Font("Times New Roman", Font.PLAIN, 27));
		GridBagConstraints gbc_lblRole = new GridBagConstraints();
		gbc_lblRole.anchor = GridBagConstraints.EAST;
		gbc_lblRole.insets = new Insets(0, 0, 5, 5);
		gbc_lblRole.gridx = 0;
		gbc_lblRole.gridy = 9;
		contentPane.add(lblChangeRole, gbc_lblRole);

		btnUpdateStaffRole = new JButton("Update staff role");
		btnUpdateStaffRole.setVisible(false);
		btnUpdateStaffRole.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!(staff.getSerialnum() == Integer.parseInt(SerialNumber.getText()))) {
					try {
						String selectedRole = roleChoice.getSelectedItem().toString();
						String oldDept = dr.getDeptOfStaff(s.getSerialnum());
						if (selectedRole.equals(s.getRole())) {
							new InvalidInput("Select a new job role").setVisible(true);
						}
						else if (selectedRole.equals("Clerk")) {
							dr.dischargeStaff(s.getSerialnum(), sr);
							int newSerialnum = sr.addClerk(s.getEmail(), s.getName(), s.getSurname(), s.getBirthday(), s.getGender());
							dr.addStaffTo(newSerialnum, oldDept, sr);
							succesfulJobTransfer(sr, newSerialnum);
						}
						else if (selectedRole.equals("Nurse")) {
							dr.dischargeStaff(s.getSerialnum(), sr);
							int newSerialnum = sr.addNurse(s.getEmail(), s.getName(), s.getSurname(), s.getBirthday(), s.getGender());
							dr.addStaffTo(newSerialnum, oldDept, sr);
							succesfulJobTransfer(sr, newSerialnum);
						}
						else if (selectedRole.equals("Doctor")) {
							dr.dischargeStaff(s.getSerialnum(), sr);
							int newSerialnum = sr.addDoctor(s.getEmail(), s.getName(), s.getSurname(), s.getBirthday(), s.getGender());
							dr.addStaffTo(newSerialnum,oldDept, sr);
							succesfulJobTransfer(sr, newSerialnum);
						}
						else if (selectedRole.equals("Staff")) {
							dr.dischargeStaff(s.getSerialnum(), sr);
							int newSerialnum = sr.addStaff(s.getEmail(), s.getName(), s.getSurname(), s.getBirthday(), s.getGender());
							dr.addStaffTo(newSerialnum, oldDept, sr);
							succesfulJobTransfer(sr, newSerialnum);
						}
						else {
							dr.dischargeStaff(s.getSerialnum(), sr);
							int newSerialnum = sr.addICTOfficer(s.getEmail(), s.getName(), s.getSurname(), s.getBirthday(), s.getGender());
							dr.addStaffTo(newSerialnum, oldDept, sr);
							succesfulJobTransfer(sr, newSerialnum);
						}
					} catch (Exception error) {
						new InvalidInput(error.getMessage()).setVisible(true);
					}
					
				} else {
					new InvalidInput("You cannot change your own job role").setVisible(true);
				}
			}

			private void succesfulJobTransfer(StaffRegister sr, int newSerialnum) {
				new SuccesfulOperation(s.getName() + " " + s.getSurname() + " is now a(n) " + sr.findSerialnum(newSerialnum).getRole()).setVisible(true);
				dispose();
			}
		});
		GridBagConstraints gbc_btnUpdateStaffRole = new GridBagConstraints();
		gbc_btnUpdateStaffRole.gridx = 2;
		gbc_btnUpdateStaffRole.gridy = 9;
		
		contentPane.add(btnUpdateStaffRole, gbc_btnUpdateStaffRole);
		
		roleChoice = new JComboBox();	
		roleChoice.setFont(new Font("Times New Roman", Font.PLAIN, 27));
		roleChoice.setVisible(false);
		roleChoice.addItem("Staff");
		roleChoice.addItem("Nurse");
		roleChoice.addItem("Doctor");
		roleChoice.addItem("Clerk");
		roleChoice.addItem("ICT Officer");
		
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 1;
		gbc_comboBox.gridy = 9;
		contentPane.add(roleChoice, gbc_comboBox);
		
		SerialNumber = new JTextField();
		SerialNumber.setFont(new Font("Times New Roman", Font.PLAIN, 27));
		GridBagConstraints gbc_SerialNumber = new GridBagConstraints();
		gbc_SerialNumber.fill = GridBagConstraints.HORIZONTAL;
		gbc_SerialNumber.anchor = GridBagConstraints.WEST;
		gbc_SerialNumber.insets = new Insets(0, 0, 5, 5);
		gbc_SerialNumber.gridx = 1;
		gbc_SerialNumber.gridy = 1;
		contentPane.add(SerialNumber, gbc_SerialNumber);
		SerialNumber.setColumns(10);
		
		btnGoBack = new JButton("Go back");
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		GridBagConstraints gbc_btnGoBack = new GridBagConstraints();
		gbc_btnGoBack.gridx = 2;
		gbc_btnGoBack.gridy = 11;
		contentPane.add(btnGoBack, gbc_btnGoBack);
		
		SerialNumber.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					try {
						serialnum = Integer.parseInt(SerialNumber.getText());
						s = sr.findSerialnum(serialnum);
						if (s != null) {
							showRole.setVisible(true);
							showRole.setText(s.getRole());
							lblCurrentRole.setVisible(true);
							lblChangeRole.setVisible(true);
							roleChoice.setVisible(true);
							btnUpdateStaffRole.setVisible(true);
							lblEnterPatientsName.setVisible(true);
							Name.setVisible(true);
							Name.setText(s.getName());
							lblSurname.setVisible(true);
							Surname.setVisible(true);
							Surname.setText(s.getSurname());
							lblEmail.setVisible(true);
							Email.setVisible(true);
							Email.setText(s.getEmail());
							lblBirthday.setVisible(true);
							Birthday.setVisible(true);
							format = new SimpleDateFormat("yyyy-MM-dd");
							String bday = format.format(s.getBirthday());
							Birthday.setText(bday);
							lblGender.setVisible(true);
							Gender.setVisible(true);
							Gender.setText(s.getGender());
							lblEditBirthday.setVisible(true);
							dateChooser.setVisible(true);
							btnUpdate.setVisible(true);
						}
					} catch (Exception e1) {
						;
					}
				}
			}
		});
	}
}
