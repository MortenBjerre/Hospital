package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
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

public class HealthData extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private int serialnum;
	private JLabel lblgetName;
	private JLabel lblgetSurname;
	private JLabel lblgetBirthday;
	private JLabel lblName;
	private JLabel lblSurname;
	private JLabel lblDateOfBirth;
	private JLabel lblHealthdata;
	
	/**
	 * Create the frame.
	 * @param dr 
	 * @param pr 
	 */
	public HealthData(PatientRegister pr, DepartmentRegister dr) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 733, 506);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 268, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblPatientSerialNumber = new JLabel("Patient serial number");
		GridBagConstraints gbc_lblPatientSerialNumber = new GridBagConstraints();
		gbc_lblPatientSerialNumber.insets = new Insets(0, 0, 5, 5);
		gbc_lblPatientSerialNumber.anchor = GridBagConstraints.EAST;
		gbc_lblPatientSerialNumber.gridx = 0;
		gbc_lblPatientSerialNumber.gridy = 0;
		contentPane.add(lblPatientSerialNumber, gbc_lblPatientSerialNumber);
		
		JButton btnFindHealthData = new JButton("Find health data for patient");
		btnFindHealthData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					serialnum = Integer.parseInt(textField.getText());
					Patient p = pr.findSerialnum(serialnum);
					lblgetName.setText(p.getName());
					lblgetSurname.setText(p.getSurname());
					lblgetBirthday.setText(p.getBirthday().toString());
					
					
				} catch (Exception e1) {
					InvalidInput errorWindow = new InvalidInput("Please enter a valid number");
					errorWindow.setVisible(true);
				}
			}
		});
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 0;
		contentPane.add(textField, gbc_textField);
		textField.setColumns(10);
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
		
		lblHealthdata = new JLabel("healthData");
		GridBagConstraints gbc_lblHealthdata = new GridBagConstraints();
		gbc_lblHealthdata.insets = new Insets(0, 0, 5, 0);
		gbc_lblHealthdata.gridx = 1;
		gbc_lblHealthdata.gridy = 5;
		contentPane.add(lblHealthdata, gbc_lblHealthdata);
		
		JButton btnAddNewHealth = new JButton("Add new health data");
		GridBagConstraints gbc_btnAddNewHealth = new GridBagConstraints();
		gbc_btnAddNewHealth.gridx = 1;
		gbc_btnAddNewHealth.gridy = 6;
		contentPane.add(btnAddNewHealth, gbc_btnAddNewHealth);
	}

}
