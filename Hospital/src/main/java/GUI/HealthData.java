package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import Hospital.DepartmentRegister;
import Hospital.Patient;
import Hospital.PatientRegister;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class HealthData extends JFrame {

	private JPanel contentPane;
	private int serialnum;
	private JLabel lblgetName;
	private JLabel lblgetSurname;
	private JLabel lblgetBirthday;
	private JLabel lblName;
	private JLabel lblSurname;
	private JLabel lblDateOfBirth;
	private Patient p;
	private JButton btnFindHealthData;
	private JLabel lblHealthData;
	protected PatientRegister pr;
	private JTextArea lblgetHealthdata;
	private JLabel lblPatientSerialNumber;
	private JTextArea updatedHealthDataField;
	private String healthData;
	private JButton btnAddNewHealth;
	private JScrollPane scrollPane;
	private JTextField serialnumTextField;
	
	/**
	 * Create the frame.
	 * @param dr 
	 * @param pr 
	 */
	public HealthData(PatientRegister pr, DepartmentRegister dr) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 756, 723);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{44, 31, 38, 0, 0, 204, 0, 244, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		btnFindHealthData = new JButton("Find health data for patient");
		btnFindHealthData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					serialnum = Integer.parseInt(serialnumTextField.getText());
					p = pr.findSerialnum(serialnum);
					lblgetName.setText(p.getName());
					lblgetSurname.setText(p.getSurname());
					lblgetBirthday.setText(p.getBirthday().toString());
					lblgetHealthdata.setText(pr.findSerialnum(serialnum).getHealthData());
					btnAddNewHealth.setVisible(true);
					updatedHealthDataField.setVisible(true);
					scrollPane.setVisible(true);
					lblgetHealthdata.setVisible(true);
					
				} catch (Exception e1) {
					InvalidInput errorWindow = new InvalidInput("Please enter a valid number");
					errorWindow.setVisible(true);
				}
			}
		});

		lblPatientSerialNumber = new JLabel("Patient Serial Number");
		GridBagConstraints gbc_lblPatientSerialNumber = new GridBagConstraints();
		gbc_lblPatientSerialNumber.insets = new Insets(0, 0, 5, 5);
		gbc_lblPatientSerialNumber.anchor = GridBagConstraints.EAST;
		gbc_lblPatientSerialNumber.gridx = 0;
		gbc_lblPatientSerialNumber.gridy = 0;
		contentPane.add(lblPatientSerialNumber, gbc_lblPatientSerialNumber);
		
		serialnumTextField = new JTextField();
		serialnumTextField.setVisible(true);
		serialnumTextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if (arg0.getKeyCode() == KeyEvent.VK_ENTER)
					try {
						serialnum = Integer.parseInt(serialnumTextField.getText());
						p = pr.findSerialnum(serialnum);
						lblgetName.setText(p.getName());
						lblgetSurname.setText(p.getSurname());
						lblgetBirthday.setText(p.getBirthday().toString());
						lblgetHealthdata.setText(pr.findSerialnum(serialnum).getHealthData());
						btnAddNewHealth.setVisible(true);
						updatedHealthDataField.setVisible(true);
						scrollPane.setVisible(true);
						lblgetHealthdata.setVisible(true);
						
					} catch (Exception NullPointerException) {
						InvalidInput errorWindow = new InvalidInput("Please enter a valid number");
						errorWindow.setVisible(true);
					}
			}
		});


		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 0;
		contentPane.add(serialnumTextField, gbc_textField);
		serialnumTextField.setColumns(10);
		GridBagConstraints gbc_btnFindHealthData = new GridBagConstraints();
		gbc_btnFindHealthData.insets = new Insets(0, 0, 5, 0);
		gbc_btnFindHealthData.gridx = 1;
		gbc_btnFindHealthData.gridy = 1;
		contentPane.add(btnFindHealthData, gbc_btnFindHealthData);
		
		lblName = new JLabel("Name: ");
		GridBagConstraints gbc_lblName = new GridBagConstraints();
		gbc_lblName.insets = new Insets(0, 0, 5, 5);
		gbc_lblName.gridx = 0;
		gbc_lblName.gridy = 2;
		contentPane.add(lblName, gbc_lblName);
		
		lblgetName = new JLabel("");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 2;
		contentPane.add(lblgetName, gbc_lblNewLabel_1);
		
		lblSurname = new JLabel("Surname: ");
		GridBagConstraints gbc_lblSurname = new GridBagConstraints();
		gbc_lblSurname.insets = new Insets(0, 0, 5, 5);
		gbc_lblSurname.gridx = 0;
		gbc_lblSurname.gridy = 3;
		contentPane.add(lblSurname, gbc_lblSurname);
		
		lblgetSurname = new JLabel("");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 3;
		contentPane.add(lblgetSurname, gbc_lblNewLabel);
		
		lblDateOfBirth = new JLabel("Date of birth: ");
		GridBagConstraints gbc_lblDateOfBirth = new GridBagConstraints();
		gbc_lblDateOfBirth.insets = new Insets(0, 0, 5, 5);
		gbc_lblDateOfBirth.gridx = 0;
		gbc_lblDateOfBirth.gridy = 4;
		contentPane.add(lblDateOfBirth, gbc_lblDateOfBirth);
		
		lblgetBirthday = new JLabel("");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_2.gridx = 1;
		gbc_lblNewLabel_2.gridy = 4;
		contentPane.add(lblgetBirthday, gbc_lblNewLabel_2);
		
		lblHealthData = new JLabel("Health Data: ");
		GridBagConstraints gbc_lblHealthData = new GridBagConstraints();
		gbc_lblHealthData.insets = new Insets(0, 0, 5, 5);
		gbc_lblHealthData.gridx = 0;
		gbc_lblHealthData.gridy = 5;
		contentPane.add(lblHealthData, gbc_lblHealthData);
		
		
				
		btnAddNewHealth = new JButton("Add new health data");
		btnAddNewHealth.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				healthData = updatedHealthDataField.getText();
				pr.editHealthData(serialnum, healthData);
				lblgetHealthdata.setText(pr.findSerialnum(serialnum).getHealthData());		// + healthData
				updatedHealthDataField.setText("");
								
			}
		});
		
		btnAddNewHealth.setVisible(false);
		
		lblgetHealthdata = new JTextArea("");
		lblgetHealthdata.setLineWrap(true);
		lblgetHealthdata.setWrapStyleWord(true);
		lblgetHealthdata.setEditable(false);
		
		scrollPane = new JScrollPane(lblgetHealthdata);
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		scrollPane.setVisible(false);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 5;
		contentPane.add(scrollPane, gbc_scrollPane);
		
	
		
		GridBagConstraints gbc_btnAddNewHealth = new GridBagConstraints();
		gbc_btnAddNewHealth.insets = new Insets(0, 0, 5, 0);
		gbc_btnAddNewHealth.gridx = 1;
		gbc_btnAddNewHealth.gridy = 6;
		contentPane.add(btnAddNewHealth, gbc_btnAddNewHealth);
		
		updatedHealthDataField = new JTextArea();
		updatedHealthDataField.setVisible(false);
		updatedHealthDataField.setLineWrap(true);
		updatedHealthDataField.setWrapStyleWord(true);
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.fill = GridBagConstraints.BOTH;
		gbc_textField_1.gridx = 1;
		gbc_textField_1.gridy = 7;
		contentPane.add(updatedHealthDataField, gbc_textField_1);
		updatedHealthDataField.setColumns(10);
	}

}
