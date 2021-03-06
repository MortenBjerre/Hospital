package GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Hospital.DepartmentRegister;
import Hospital.Staff;
import Hospital.StaffRegister;

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
	private Object[][] tableData;
	private JScrollPane scrollPane;
	private Object[] columnNames;
	private DepartmentRegister dr;
	private Staff staff;

	public DepartmentManager(DepartmentRegister dr, Staff staff, StaffRegister sr) {
		this.staff = staff;
		this.dr = dr;
		setTitle("Department Manager");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1150, 449);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{218, 163, 164, 180, 166, 0, 0};
		gbl_contentPane.rowHeights = new int[]{44, 79, 135, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
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
				} else if (deptName.equals("")) {
					new InvalidInput("Department needs a name").setVisible(true);
				} else {
					if (numberOfBeds.equals("")) {
						dr.createDepartment(deptName);
						updateTable();
						SuccesfulOperation success = new SuccesfulOperation("Outpatient Department " + deptName + " was created");
						clearText();
						success.setVisible(true);
					} else {
						try {
							int beds = Integer.parseInt(numberOfBeds);
							dr.createDepartment(deptName, beds);
							SuccesfulOperation success = new SuccesfulOperation("Inpatient Department " + deptName + " with " + numberOfBeds + " beds was created");
							clearText();
							updateTable();
							success.setVisible(true);
						} catch (Exception error) {
							new InvalidInput("Invalid number of beds").setVisible(true);
						}
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
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
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
					updateTable();
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
					updateTable();
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
					updateTable();
				} catch (Exception error2) {
					InvalidInput invalidInput = new InvalidInput(error2.getMessage());
					invalidInput.setVisible(true);
					clearText();
				}
			}
		});
		GridBagConstraints gbc_btnRemoveBedsFrom = new GridBagConstraints();
		gbc_btnRemoveBedsFrom.insets = new Insets(0, 0, 5, 5);
		gbc_btnRemoveBedsFrom.fill = GridBagConstraints.BOTH;
		gbc_btnRemoveBedsFrom.gridx = 3;
		gbc_btnRemoveBedsFrom.gridy = 1;
		contentPane.add(btnRemoveBedsFrom, gbc_btnRemoveBedsFrom);
		
		JButton btnInspect = new JButton("Inspect Department");
		btnInspect.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnInspect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String deptName = departmentNameTextField.getText();
				if (!deptName.equals("") && dr.containsDept(deptName)) {
					new InspectDepartment(dr, deptName, staff, sr).setVisible(true);
				} else {
					new InvalidInput("Enter a valid department name").setVisible(true);
				}
			}
		});
		GridBagConstraints gbc_btnInspect = new GridBagConstraints();
		gbc_btnInspect.fill = GridBagConstraints.BOTH;
		gbc_btnInspect.insets = new Insets(0, 0, 5, 5);
		gbc_btnInspect.gridx = 4;
		gbc_btnInspect.gridy = 1;
		contentPane.add(btnInspect, gbc_btnInspect);
		
		JButton btnEditDepartmentName = new JButton("Edit Department Name");
		btnEditDepartmentName.addActionListener(new ActionListener() {
			private String deptName;

			public void actionPerformed(ActionEvent arg0) {
				if (numberOfBedsTextField.getText().equals("")) {
					deptName = departmentNameTextField.getText();
					if (dr.containsDept(deptName)) {
						new ChangeNameOfDept(deptName, dr, staff, sr).setVisible(true);
						dispose();
					} else {
						new InvalidInput("No such department").setVisible(true);
					}
				} else {
					new InvalidInput("Only declare a department name").setVisible(true);
				}
			}
		}); 
		btnEditDepartmentName.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_btnEditDepartmentName = new GridBagConstraints();
		gbc_btnEditDepartmentName.fill = GridBagConstraints.VERTICAL;
		gbc_btnEditDepartmentName.insets = new Insets(0, 0, 5, 0);
		gbc_btnEditDepartmentName.gridx = 5;
		gbc_btnEditDepartmentName.gridy = 1;
		contentPane.add(btnEditDepartmentName, gbc_btnEditDepartmentName);
		
		scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 6;
		gbc_scrollPane.fill = GridBagConstraints.HORIZONTAL;
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.insets = new Insets(0, 0, 0, 5);
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 2;
		contentPane.add(scrollPane, gbc_scrollPane);
		String[] columnNames = {"Department Name", "Number of patients","Number of staff","Number of beds", "Occupied beds" , "Free beds"};
		this.columnNames = columnNames;
		tableData = makeDepartmentTable(dr);
		
		table = new JTable(tableData, columnNames);
		scrollPane.setViewportView(table);
		table.setEnabled(false);
		
		if (!staff.canEditDepartmentRegister(dr)) {
			btnAddBedsTo.setVisible(false);
			btnCreateDepartment.setVisible(false);
			btnDeleteDepartment.setVisible(false);
			btnEditDepartmentName.setVisible(false);
			btnRemoveBedsFrom.setVisible(false);
			lblOptionalNumberOf.setVisible(false);
			numberOfBedsTextField.setVisible(false);
			
		}
	}
	
	private Object[][] makeDepartmentTable(DepartmentRegister dr) {
		ArrayList<String> allDepartments = dr.getAllDepartments();
		Object [][] data = new Object[allDepartments.size()][6];
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
	
	protected void updateTable() {
		tableData = makeDepartmentTable(dr);
		table = new JTable(tableData,columnNames);
		table.setEnabled(false); // un-editable
		scrollPane.setViewportView(table);
		table.setFillsViewportHeight(true);
	}
}
