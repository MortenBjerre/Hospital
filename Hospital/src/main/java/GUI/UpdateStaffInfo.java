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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;


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

	public UpdateStaffInfo(StaffRegister sr) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 799, 473);
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
		
		btnUpdate = new JButton("Update");
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
		gbc_btnGoBack.gridy = 12;
		contentPane.add(btnGoBack, gbc_btnGoBack);
		
		SerialNumber.addKeyListener(new KeyAdapter() {


			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					try {
						serialnum = Integer.parseInt(SerialNumber.getText());
						Staff s = sr.findSerialnum(serialnum);
						if (s != null) {
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
