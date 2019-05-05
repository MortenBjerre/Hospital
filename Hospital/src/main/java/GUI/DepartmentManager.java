package GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Hospital.DepartmentRegister;
import javax.swing.BoxLayout;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class DepartmentManager extends JFrame {

	private JPanel contentPane;
	private JTextField departmentNameTextField;
	private JTextField numberOfBedsTextField;

	public DepartmentManager(DepartmentRegister dr) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 650, 186);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{150, 139, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{44, 100, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		this.setLocationRelativeTo(null);
		
		JButton btnCreateDepartment = new JButton("Create Department");
		btnCreateDepartment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String deptName = departmentNameTextField.getText();
				String numberOfBeds = numberOfBedsTextField.getText();
				if (dr.containsDept(deptName)) {
					new InvalidInput(deptName + " is already an existing department").setVisible(true);
					clearText();					
				} else {
					try {
						int beds = Integer.parseInt(numberOfBeds);
						dr.createDepartment(deptName, beds);
						new SuccesfullOperation("Department " + deptName + " with " + numberOfBeds + " beds was created").setVisible(true);
						clearText();
					} catch (Exception error) {
						dr.createDepartment(deptName);
						new SuccesfullOperation("Department " + deptName + " beds was created").setVisible(true);
						clearText();
					}
				}
				
			}
		});
		
		JLabel lblDepartmentName = new JLabel("Department Name:");
		GridBagConstraints gbc_lblDepartmentName = new GridBagConstraints();
		gbc_lblDepartmentName.anchor = GridBagConstraints.EAST;
		gbc_lblDepartmentName.insets = new Insets(0, 0, 5, 5);
		gbc_lblDepartmentName.gridx = 0;
		gbc_lblDepartmentName.gridy = 0;
		contentPane.add(lblDepartmentName, gbc_lblDepartmentName);
		
		departmentNameTextField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 0;
		contentPane.add(departmentNameTextField, gbc_textField);
		departmentNameTextField.setColumns(10);
		
		JLabel lblOptionalNumberOf = new JLabel("Optional number of beds");
		GridBagConstraints gbc_lblOptionalNumberOf = new GridBagConstraints();
		gbc_lblOptionalNumberOf.anchor = GridBagConstraints.EAST;
		gbc_lblOptionalNumberOf.insets = new Insets(0, 0, 5, 5);
		gbc_lblOptionalNumberOf.gridx = 2;
		gbc_lblOptionalNumberOf.gridy = 0;
		contentPane.add(lblOptionalNumberOf, gbc_lblOptionalNumberOf);
		
		numberOfBedsTextField = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 0);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 3;
		gbc_textField_1.gridy = 0;
		contentPane.add(numberOfBedsTextField, gbc_textField_1);
		numberOfBedsTextField.setColumns(10);
		GridBagConstraints gbc_btnCreateDepartment = new GridBagConstraints();
		gbc_btnCreateDepartment.fill = GridBagConstraints.BOTH;
		gbc_btnCreateDepartment.insets = new Insets(0, 0, 0, 5);
		gbc_btnCreateDepartment.gridx = 0;
		gbc_btnCreateDepartment.gridy = 1;
		contentPane.add(btnCreateDepartment, gbc_btnCreateDepartment);
		
		JButton btnDeleteDepartment = new JButton("Delete Department");
		btnDeleteDepartment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String deptName = departmentNameTextField.getText();
				try {
					dr.deleteDepartment(deptName);
					new SuccesfullOperation("Department " + deptName + " was deleted").setVisible(true);
					clearText();
				} catch (Exception error) {
					InvalidInput invalidInput = new InvalidInput(error.getMessage());
					invalidInput.setVisible(true);
					clearText();
				}
			}
		});
		GridBagConstraints gbc_btnDeleteDepartment = new GridBagConstraints();
		gbc_btnDeleteDepartment.fill = GridBagConstraints.BOTH;
		gbc_btnDeleteDepartment.insets = new Insets(0, 0, 0, 5);
		gbc_btnDeleteDepartment.gridx = 1;
		gbc_btnDeleteDepartment.gridy = 1;
		contentPane.add(btnDeleteDepartment, gbc_btnDeleteDepartment);
		
		JButton btnAddBedsTo = new JButton("Add beds to department");

		btnAddBedsTo.addActionListener(new ActionListener() {
			private int addedBeds;
			public void actionPerformed(ActionEvent e) {
				String deptName = departmentNameTextField.getText();
				String numberOfBeds = numberOfBedsTextField.getText();
				try {
					addedBeds = Integer.parseInt(numberOfBeds);
				} catch (Exception error) {
					InvalidInput invalidInput = new InvalidInput("Please enter valid number of beds");
					invalidInput.setVisible(true);
					clearText();
				}
				try {
					dr.addBeds(deptName, addedBeds);
					new SuccesfullOperation(addedBeds + " was added to " + deptName + ". Now there are " + dr.getTotalBeds(deptName) + " beds in "+ deptName).setVisible(true);
					clearText();
				} catch (Exception error2) {
					InvalidInput invalidInput = new InvalidInput(error2.getMessage());
					invalidInput.setVisible(true);
					clearText();
				}
			}
		});
		GridBagConstraints gbc_btnAddBedsTo = new GridBagConstraints();
		gbc_btnAddBedsTo.fill = GridBagConstraints.BOTH;
		gbc_btnAddBedsTo.insets = new Insets(0, 0, 0, 5);
		gbc_btnAddBedsTo.gridx = 2;
		gbc_btnAddBedsTo.gridy = 1;
		contentPane.add(btnAddBedsTo, gbc_btnAddBedsTo);
		
		JButton btnRemoveBedsFrom = new JButton("Remove beds from department");
		btnRemoveBedsFrom.addActionListener(new ActionListener() {
			private int removedBeds;
			public void actionPerformed(ActionEvent e) {
				String deptName = departmentNameTextField.getText();
				String numberOfBeds = numberOfBedsTextField.getText();
				try {
					removedBeds = Integer.parseInt(numberOfBeds);
				} catch (Exception error) {
					InvalidInput invalidInput = new InvalidInput("Please enter valid number of beds");
					invalidInput.setVisible(true);
					clearText();
				}
				try {
					dr.removeBeds(deptName, removedBeds);
					new SuccesfullOperation(removedBeds + " was removed from " + deptName + ". Now there are " + dr.getTotalBeds(deptName) + " beds in "+ deptName).setVisible(true);
					clearText();
				} catch (Exception error2) {
					InvalidInput invalidInput = new InvalidInput(error2.getMessage());
					invalidInput.setVisible(true);
					clearText();
				}
			}
		});
		GridBagConstraints gbc_btnRemoveBedsFrom = new GridBagConstraints();
		gbc_btnRemoveBedsFrom.fill = GridBagConstraints.BOTH;
		gbc_btnRemoveBedsFrom.gridx = 3;
		gbc_btnRemoveBedsFrom.gridy = 1;
		contentPane.add(btnRemoveBedsFrom, gbc_btnRemoveBedsFrom);
	}
	
	private void clearText() {
		departmentNameTextField.setText("");
		numberOfBedsTextField.setText("");
	}

}
