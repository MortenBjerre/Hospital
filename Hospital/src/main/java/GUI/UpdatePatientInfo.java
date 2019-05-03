package GUI;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Hospital.Patient;
import Hospital.PatientRegister;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.SwingConstants;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

@SuppressWarnings("serial")
public class UpdatePatientInfo extends JFrame {

	private JPanel contentPane;
	private JTextField SerialNumber;
	private JTextField Name;
	private JTextField Surname;
	private JTextField Address;
	private JTextField Email;
	private JTextField Birthday;
	private JTextField Gender;
	private JTextField Number;
	private JTextField Alive;
	int serialnum;
	static PatientRegister PatientReg;
	
	/**
	 * Create the frame.
	 */
	public UpdatePatientInfo(final PatientRegister PatientReg) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 796, 690);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{403, 348, 91, 0};
		gbl_contentPane.rowHeights = new int[]{56, 33, 39, 41, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblPleaseEnterThe = new JLabel("Enter Patient Serial Number: ");
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
		gbc_lblEnterPatientsName.gridy = 3;
		contentPane.add(lblEnterPatientsName, gbc_lblEnterPatientsName);
		lblEnterPatientsName.setVisible(false);
		
		Name = new JTextField();
		Name.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String newName = Name.getText();
				PatientReg.editName(serialnum, newName);
			}
		});
		Name.setFont(new Font("Times New Roman", Font.PLAIN, 27));
		GridBagConstraints gbc_Name = new GridBagConstraints();
		gbc_Name.insets = new Insets(0, 0, 5, 5);
		gbc_Name.fill = GridBagConstraints.HORIZONTAL;
		gbc_Name.gridx = 1;
		gbc_Name.gridy = 3;
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
		gbc_lblSurname.gridy = 4;
		contentPane.add(lblSurname, gbc_lblSurname);
		lblSurname.setVisible(false);
		
		Surname = new JTextField();
		Surname.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String newSurname = Surname.getText();
				PatientReg.editSurname(serialnum, newSurname);
			}
		});
		Surname.setFont(new Font("Times New Roman", Font.PLAIN, 27));
		GridBagConstraints gbc_Surname = new GridBagConstraints();
		gbc_Surname.insets = new Insets(0, 0, 5, 5);
		gbc_Surname.fill = GridBagConstraints.HORIZONTAL;
		gbc_Surname.gridx = 1;
		gbc_Surname.gridy = 4;
		contentPane.add(Surname, gbc_Surname);
		Surname.setColumns(10);
		Surname.setVisible(false);
		
		final JLabel lblAddress = new JLabel("Address: ");
		lblAddress.setFont(new Font("Times New Roman", Font.PLAIN, 27));
		lblAddress.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lblAddress = new GridBagConstraints();
		gbc_lblAddress.anchor = GridBagConstraints.EAST;
		gbc_lblAddress.insets = new Insets(0, 0, 5, 5);
		gbc_lblAddress.gridx = 0;
		gbc_lblAddress.gridy = 5;
		contentPane.add(lblAddress, gbc_lblAddress);
		lblAddress.setVisible(false);
		
		Address = new JTextField();
		Address.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String newAdd = Address.getText();
				PatientReg.editAddress(serialnum, newAdd);
			}
		});
		Address.setFont(new Font("Times New Roman", Font.PLAIN, 27));
		GridBagConstraints gbc_Address = new GridBagConstraints();
		gbc_Address.insets = new Insets(0, 0, 5, 5);
		gbc_Address.fill = GridBagConstraints.HORIZONTAL;
		gbc_Address.gridx = 1;
		gbc_Address.gridy = 5;
		contentPane.add(Address, gbc_Address);
		Address.setColumns(10);
		Address.setVisible(false);
		
		final JLabel lblEmail = new JLabel("Email: ");
		lblEmail.setFont(new Font("Times New Roman", Font.PLAIN, 27));
		GridBagConstraints gbc_lblEmail = new GridBagConstraints();
		gbc_lblEmail.anchor = GridBagConstraints.EAST;
		gbc_lblEmail.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmail.gridx = 0;
		gbc_lblEmail.gridy = 6;
		contentPane.add(lblEmail, gbc_lblEmail);
		lblEmail.setVisible(false);
		
		Email = new JTextField();
		Email.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String newEmail = Email.getText();
				PatientReg.editEmail(serialnum, newEmail);
			}
		});
		Email.setFont(new Font("Times New Roman", Font.PLAIN, 27));
		GridBagConstraints gbc_Email = new GridBagConstraints();
		gbc_Email.insets = new Insets(0, 0, 5, 5);
		gbc_Email.fill = GridBagConstraints.HORIZONTAL;
		gbc_Email.gridx = 1;
		gbc_Email.gridy = 6;
		contentPane.add(Email, gbc_Email);
		Email.setColumns(10);
		Email.setVisible(false);
		
		final JLabel lblBirthday = new JLabel("Birthday: ");
		lblBirthday.setFont(new Font("Times New Roman", Font.PLAIN, 27));
		GridBagConstraints gbc_lblBirthday = new GridBagConstraints();
		gbc_lblBirthday.anchor = GridBagConstraints.EAST;
		gbc_lblBirthday.insets = new Insets(0, 0, 5, 5);
		gbc_lblBirthday.gridx = 0;
		gbc_lblBirthday.gridy = 7;
		contentPane.add(lblBirthday, gbc_lblBirthday);
		lblBirthday.setVisible(false);
		
		Birthday = new JTextField();
		Birthday.setFont(new Font("Times New Roman", Font.PLAIN, 27));
		GridBagConstraints gbc_Birthday = new GridBagConstraints();
		gbc_Birthday.insets = new Insets(0, 0, 5, 5);
		gbc_Birthday.fill = GridBagConstraints.HORIZONTAL;
		gbc_Birthday.gridx = 1;
		gbc_Birthday.gridy = 7;
		contentPane.add(Birthday, gbc_Birthday);
		Birthday.setColumns(10);
		Birthday.setVisible(false);
		
		final JLabel lblGender = new JLabel("Gender: ");
		lblGender.setFont(new Font("Times New Roman", Font.PLAIN, 27));
		GridBagConstraints gbc_lblGender = new GridBagConstraints();
		gbc_lblGender.anchor = GridBagConstraints.EAST;
		gbc_lblGender.insets = new Insets(0, 0, 5, 5);
		gbc_lblGender.gridx = 0;
		gbc_lblGender.gridy = 8;
		contentPane.add(lblGender, gbc_lblGender);
		lblGender.setVisible(false);
		
		Gender = new JTextField();
		Gender.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String newGender = Gender.getText();
				PatientReg.editGender(serialnum, newGender);
			}
		});
		Gender.setFont(new Font("Times New Roman", Font.PLAIN, 27));
		GridBagConstraints gbc_Gender = new GridBagConstraints();
		gbc_Gender.insets = new Insets(0, 0, 5, 5);
		gbc_Gender.fill = GridBagConstraints.HORIZONTAL;
		gbc_Gender.gridx = 1;
		gbc_Gender.gridy = 8;
		contentPane.add(Gender, gbc_Gender);
		Gender.setColumns(10);
		Gender.setVisible(false);
		
		final JLabel lblPhoneNumber = new JLabel("Phone Number: ");
		lblPhoneNumber.setFont(new Font("Times New Roman", Font.PLAIN, 27));
		GridBagConstraints gbc_lblPhoneNumber = new GridBagConstraints();
		gbc_lblPhoneNumber.anchor = GridBagConstraints.EAST;
		gbc_lblPhoneNumber.insets = new Insets(0, 0, 5, 5);
		gbc_lblPhoneNumber.gridx = 0;
		gbc_lblPhoneNumber.gridy = 9;
		contentPane.add(lblPhoneNumber, gbc_lblPhoneNumber);
		lblPhoneNumber.setVisible(false);
		
		Number = new JTextField();
		Number.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String newNumber = Number.getText();
				if (("1234567890".contains(String.valueOf(e.getKeyChar())) || (!Character.isLetter(e.getKeyChar())) 
						&& !"!\"#¤%&/()=?`@£${[]}+|+´><\\;:_,.-'*¨^~".contains(String.valueOf(e.getKeyChar())))) {
					if (newNumber.length() <= 9) {
						PatientReg.editPhoneNumber(serialnum, Integer.parseInt(newNumber));
					} else {
						InvalidInput invalidinp = new InvalidInput("Too Long");
						invalidinp.setVisible(true);
					}
				} else {
					InvalidInput invalidinp = new InvalidInput(String.valueOf("Must be a number"));
					invalidinp.setVisible(true);
				}
			}
		});
		Number.setFont(new Font("Times New Roman", Font.PLAIN, 27));
		GridBagConstraints gbc_Number = new GridBagConstraints();
		gbc_Number.insets = new Insets(0, 0, 5, 5);
		gbc_Number.fill = GridBagConstraints.HORIZONTAL;
		gbc_Number.gridx = 1;
		gbc_Number.gridy = 9;
		contentPane.add(Number, gbc_Number);
		Number.setColumns(10);
		Number.setVisible(false);
		
		final JLabel lblAlive = new JLabel("Alive: ");
		lblAlive.setFont(new Font("Times New Roman", Font.PLAIN, 27));
		GridBagConstraints gbc_lblAlive = new GridBagConstraints();
		gbc_lblAlive.anchor = GridBagConstraints.EAST;
		gbc_lblAlive.insets = new Insets(0, 0, 0, 5);
		gbc_lblAlive.gridx = 0;
		gbc_lblAlive.gridy = 10;
		contentPane.add(lblAlive, gbc_lblAlive);
		lblAlive.setVisible(false);
		
		Alive = new JTextField();
		Alive.setFont(new Font("Times New Roman", Font.PLAIN, 27));
		GridBagConstraints gbc_Alive = new GridBagConstraints();
		gbc_Alive.insets = new Insets(0, 0, 0, 5);
		gbc_Alive.fill = GridBagConstraints.HORIZONTAL;
		gbc_Alive.gridx = 1;
		gbc_Alive.gridy = 10;
		contentPane.add(Alive, gbc_Alive);
		Alive.setColumns(10);
		Alive.setVisible(false);
		
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
	}
}
