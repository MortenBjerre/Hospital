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
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class DepartmentManager extends JFrame {

	private JPanel contentPane;
	private JTextField departmentNameTextField;
	private JTextField numberOfBedsTextField;
	private JTable table;

	public DepartmentManager(DepartmentRegister dr) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 662, 311);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{150, 139, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{44, 79, 135, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		this.setLocationRelativeTo(null);

		
		JButton btnCreateDepartment = new JButton("Create Department");
		btnCreateDepartment.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnCreateDepartment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String deptName = departmentNameTextField.getText();
				String numberOfBeds = numberOfBedsTextField.getText();
				if (dr.containsDept(deptName)) {
					InvalidInput invalid = new InvalidInput(deptName + " is already an existing department");
					invalid.setVisible(true);
					clearText();					
					invalid.setSize(new Dimension(550,250));
				} else {
					try {
						int beds = Integer.parseInt(numberOfBeds);
						dr.createDepartment(deptName, beds);
						SuccesfulOperation success = new SuccesfulOperation("Department " + deptName + " with " + numberOfBeds + " beds was created");
						clearText();
						success.setVisible(true);
						success.setSize(new Dimension(650,250));
					} catch (Exception error) {
						dr.createDepartment(deptName);
						SuccesfulOperation success = new SuccesfulOperation("Department " + deptName + " was created");
						clearText();
						success.setVisible(true);
						success.setSize(new Dimension(500,250));
					}
				}
				
			}
		});
		
		JLabel lblDepartmentName = new JLabel("Department Name:");
		lblDepartmentName.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_lblDepartmentName = new GridBagConstraints();
		gbc_lblDepartmentName.anchor = GridBagConstraints.EAST;
		gbc_lblDepartmentName.insets = new Insets(0, 0, 5, 5);
		gbc_lblDepartmentName.gridx = 0;
		gbc_lblDepartmentName.gridy = 0;
		contentPane.add(lblDepartmentName, gbc_lblDepartmentName);
		
		departmentNameTextField = new JTextField();
		departmentNameTextField.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 0;
		contentPane.add(departmentNameTextField, gbc_textField);
		departmentNameTextField.setColumns(10);
		
		JLabel lblOptionalNumberOf = new JLabel("Optional number of beds");
		lblOptionalNumberOf.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_lblOptionalNumberOf = new GridBagConstraints();
		gbc_lblOptionalNumberOf.anchor = GridBagConstraints.EAST;
		gbc_lblOptionalNumberOf.insets = new Insets(0, 0, 5, 5);
		gbc_lblOptionalNumberOf.gridx = 2;
		gbc_lblOptionalNumberOf.gridy = 0;
		contentPane.add(lblOptionalNumberOf, gbc_lblOptionalNumberOf);
		
		numberOfBedsTextField = new JTextField();
		numberOfBedsTextField.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 0);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 3;
		gbc_textField_1.gridy = 0;
		contentPane.add(numberOfBedsTextField, gbc_textField_1);
		numberOfBedsTextField.setColumns(10);
		GridBagConstraints gbc_btnCreateDepartment = new GridBagConstraints();
		gbc_btnCreateDepartment.fill = GridBagConstraints.BOTH;
		gbc_btnCreateDepartment.insets = new Insets(0, 0, 5, 5);
		gbc_btnCreateDepartment.gridx = 0;
		gbc_btnCreateDepartment.gridy = 1;
		contentPane.add(btnCreateDepartment, gbc_btnCreateDepartment);
		
		JButton btnDeleteDepartment = new JButton("Delete Department");
		btnDeleteDepartment.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnDeleteDepartment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String deptName = departmentNameTextField.getText();
				try {
					dr.deleteDepartment(deptName);
					new SuccesfulOperation("Department " + deptName + " was deleted").setVisible(true);
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
		gbc_btnDeleteDepartment.insets = new Insets(0, 0, 5, 5);
		gbc_btnDeleteDepartment.gridx = 1;
		gbc_btnDeleteDepartment.gridy = 1;
		contentPane.add(btnDeleteDepartment, gbc_btnDeleteDepartment);
		
		JButton btnAddBedsTo = new JButton("Add beds to department");
		btnAddBedsTo.setFont(new Font("Tahoma", Font.PLAIN, 12));
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
					new SuccesfulOperation(addedBeds + " was added to " + deptName + ". Now there are " + dr.getTotalBeds(deptName) + " beds in "+ deptName).setVisible(true);
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
		gbc_btnAddBedsTo.insets = new Insets(0, 0, 5, 5);
		gbc_btnAddBedsTo.gridx = 2;
		gbc_btnAddBedsTo.gridy = 1;
		contentPane.add(btnAddBedsTo, gbc_btnAddBedsTo);
		
		JButton btnRemoveBedsFrom = new JButton("Remove beds from department");
		btnRemoveBedsFrom.setFont(new Font("Tahoma", Font.PLAIN, 12));
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
					SuccesfulOperation success = new SuccesfulOperation(removedBeds + " was removed from " + deptName + ". Now there are " + dr.getTotalBeds(deptName) + " beds in "+ deptName);
					clearText();
					success.setVisible(true);
					success.setSize(new Dimension(600,200));
				} catch (Exception error2) {
					InvalidInput invalidInput = new InvalidInput(error2.getMessage());
					invalidInput.setVisible(true);
					clearText();
				}
			}
		});
		GridBagConstraints gbc_btnRemoveBedsFrom = new GridBagConstraints();
		gbc_btnRemoveBedsFrom.insets = new Insets(0, 0, 5, 0);
		gbc_btnRemoveBedsFrom.fill = GridBagConstraints.BOTH;
		gbc_btnRemoveBedsFrom.gridx = 3;
		gbc_btnRemoveBedsFrom.gridy = 1;
		contentPane.add(btnRemoveBedsFrom, gbc_btnRemoveBedsFrom);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 4;
		gbc_scrollPane.fill = GridBagConstraints.HORIZONTAL;
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.insets = new Insets(0, 0, 0, 5);
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 2;
		contentPane.add(scrollPane, gbc_scrollPane);
		String[] columnNames = {"Department Name", "Number of patients","Number of staff","Number of beds", "Occupied beds" , "Free beds"};
		Object[][] data = makeDepartmentTable(dr);
		
		table = new JTable(data,columnNames);
		scrollPane.setViewportView(table);
	}
	
	private Object[][] makeDepartmentTable(DepartmentRegister dr) {
		ArrayList<String> allDepartments = dr.getAllDepartments();
		Object [][] data = new Object[allDepartments.size()][5];
		for (int i = 0; i < allDepartments.size(); i++) {
			String deptName = allDepartments.get(i);
			data[i][0] = deptName;
			data[i][1] = dr.numberOfPatient(deptName);
			data[i][2] = dr.numberOfStaff(deptName);
			int totalBeds = dr.getTotalBeds(deptName);
			int freeBeds = dr.getAvailableBeds(deptName);
			data[i][3] = totalBeds;
			data[i][4] = totalBeds - freeBeds;
			data[i][5] = freeBeds;
		}
		return data;
	}

	private void clearText() {
		departmentNameTextField.setText("");
		numberOfBedsTextField.setText("");
	}
}
