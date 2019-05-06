package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Hospital.DepartmentRegister;
import Hospital.PatientRegister;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class AdmitPatientWindow extends JFrame {

	private JPanel contentPane;
	private JTextField serialnumberTextField;
	private JLabel lblAdmitToDepartment;
	private JButton btnAdmit;
	private JComboBox departmentNames;
	private DepartmentRegister dr;
	private JButton btnSearchPatients;
	private JButton btnGoBack;

	public AdmitPatientWindow(PatientRegister pr, DepartmentRegister dr) {
		this.dr = dr;
		setTitle("Admit a patient");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 585, 407);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{180, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 50, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		this.setLocationRelativeTo(null);
		
		btnSearchPatients = new JButton("Search Patients");
		btnSearchPatients.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new SearchPatient(pr, dr).setVisible(true);
			}
		});
		GridBagConstraints gbc_btnSearchPatients = new GridBagConstraints();
		gbc_btnSearchPatients.insets = new Insets(0, 0, 5, 5);
		gbc_btnSearchPatients.gridx = 1;
		gbc_btnSearchPatients.gridy = 1;
		contentPane.add(btnSearchPatients, gbc_btnSearchPatients);
		
		JLabel lblAdmitPatientWith = new JLabel("Admit patient with serial number:");
		GridBagConstraints gbc_lblAdmitPatientWith = new GridBagConstraints();
		gbc_lblAdmitPatientWith.anchor = GridBagConstraints.EAST;
		gbc_lblAdmitPatientWith.insets = new Insets(0, 0, 5, 5);
		gbc_lblAdmitPatientWith.gridx = 0;
		gbc_lblAdmitPatientWith.gridy = 3;
		contentPane.add(lblAdmitPatientWith, gbc_lblAdmitPatientWith);
		
		serialnumberTextField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 3;
		contentPane.add(serialnumberTextField, gbc_textField);
		serialnumberTextField.setColumns(10);
		
		lblAdmitToDepartment = new JLabel("Admit to department:");
		GridBagConstraints gbc_lblAdmitToDepartment = new GridBagConstraints();
		gbc_lblAdmitToDepartment.anchor = GridBagConstraints.EAST;
		gbc_lblAdmitToDepartment.insets = new Insets(0, 0, 5, 5);
		gbc_lblAdmitToDepartment.gridx = 0;
		gbc_lblAdmitToDepartment.gridy = 4;
		contentPane.add(lblAdmitToDepartment, gbc_lblAdmitToDepartment);
		
		btnAdmit = new JButton("Admit");
		btnAdmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int serialnum = Integer.parseInt(serialnumberTextField.getText());
					String deptName = (String) departmentNames.getSelectedItem();
					dr.admit(serialnum, deptName, pr);
					dispose();
					new SuccesfulOperation("Patient was admitted to " + deptName).setVisible(true);			
				} catch (Exception error) {
					InvalidInput invalidInput = new InvalidInput(error.getMessage());
					invalidInput.setVisible(true);
				}
				
			}
		});
		
		departmentNames = new JComboBox();
		for (String deptName : dr.getAllDepartments()) {
			departmentNames.addItem(deptName);
		}
		departmentNames.setVisible(true);
		
		GridBagConstraints gbc_departmentNames = new GridBagConstraints();
		gbc_departmentNames.insets = new Insets(0, 0, 5, 5);
		gbc_departmentNames.fill = GridBagConstraints.HORIZONTAL;
		gbc_departmentNames.gridx = 1;
		gbc_departmentNames.gridy = 4;
		contentPane.add(departmentNames, gbc_departmentNames);
		GridBagConstraints gbc_btnAdmit = new GridBagConstraints();
		gbc_btnAdmit.insets = new Insets(0, 0, 5, 5);
		gbc_btnAdmit.fill = GridBagConstraints.BOTH;
		gbc_btnAdmit.gridx = 1;
		gbc_btnAdmit.gridy = 5;
		contentPane.add(btnAdmit, gbc_btnAdmit);
		
		btnGoBack = new JButton("Go Back");
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		GridBagConstraints gbc_btnGoBack = new GridBagConstraints();
		gbc_btnGoBack.insets = new Insets(0, 0, 5, 0);
		gbc_btnGoBack.gridx = 2;
		gbc_btnGoBack.gridy = 5;
		contentPane.add(btnGoBack, gbc_btnGoBack);
	}

}
