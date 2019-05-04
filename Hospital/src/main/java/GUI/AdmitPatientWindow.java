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

public class AdmitPatientWindow extends JFrame {

	private JPanel contentPane;
	private JTextField serialnumberTextField;
	private JLabel lblAdmitToDepartment;
	private JButton btnAdmit;
	private JTextField drTextField;

	public AdmitPatientWindow(PatientRegister pr, DepartmentRegister dr) {
		setTitle("Admit patient");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{180, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 50, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblAdmitPatientWith = new JLabel("Admit patient with serial number:");
		GridBagConstraints gbc_lblAdmitPatientWith = new GridBagConstraints();
		gbc_lblAdmitPatientWith.anchor = GridBagConstraints.EAST;
		gbc_lblAdmitPatientWith.insets = new Insets(0, 0, 5, 5);
		gbc_lblAdmitPatientWith.gridx = 0;
		gbc_lblAdmitPatientWith.gridy = 1;
		contentPane.add(lblAdmitPatientWith, gbc_lblAdmitPatientWith);
		
		serialnumberTextField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 1;
		contentPane.add(serialnumberTextField, gbc_textField);
		serialnumberTextField.setColumns(10);
		
		lblAdmitToDepartment = new JLabel("Admit to department:");
		GridBagConstraints gbc_lblAdmitToDepartment = new GridBagConstraints();
		gbc_lblAdmitToDepartment.anchor = GridBagConstraints.EAST;
		gbc_lblAdmitToDepartment.insets = new Insets(0, 0, 5, 5);
		gbc_lblAdmitToDepartment.gridx = 0;
		gbc_lblAdmitToDepartment.gridy = 2;
		contentPane.add(lblAdmitToDepartment, gbc_lblAdmitToDepartment);
		
		drTextField = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 0);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 1;
		gbc_textField_1.gridy = 2;
		contentPane.add(drTextField, gbc_textField_1);
		drTextField.setColumns(10);
		
		btnAdmit = new JButton("Admit");
		btnAdmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int serialnum = Integer.parseInt(serialnumberTextField.getText());
					String deptName = drTextField.getText();
					dr.admit(serialnum, deptName, pr);
					dispose();
					InvalidInput invalidInput = new InvalidInput("Patient was admitted to " + deptName);
					invalidInput.setVisible(true);
					
				} catch (Exception error) {
					InvalidInput invalidInput = new InvalidInput(error.getMessage());
					invalidInput.setVisible(true);
				}
				
			}
		});
		GridBagConstraints gbc_btnAdmit = new GridBagConstraints();
		gbc_btnAdmit.fill = GridBagConstraints.BOTH;
		gbc_btnAdmit.gridx = 1;
		gbc_btnAdmit.gridy = 3;
		contentPane.add(btnAdmit, gbc_btnAdmit);
	}

}
