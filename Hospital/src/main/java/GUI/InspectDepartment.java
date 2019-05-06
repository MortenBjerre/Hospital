package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Hospital.*;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

public class InspectDepartment extends JFrame {

	private JPanel contentPane;
	private JTable StaffTable;
	private JTable PatientTable;
	private String[] staffColumnNames;
	private Object[][] staffTableData;
	private String[] patientColumnNames;
	private Object[][] patientTableData;
	
	
	public InspectDepartment(DepartmentRegister dr, String deptName) {
		this.setTitle(deptName + " details");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 714, 366);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{136, 510, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 1.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblDepartmentName = new JLabel("Department name: ");
		lblDepartmentName.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblDepartmentName = new GridBagConstraints();
		gbc_lblDepartmentName.anchor = GridBagConstraints.EAST;
		gbc_lblDepartmentName.insets = new Insets(0, 0, 5, 5);
		gbc_lblDepartmentName.gridx = 0;
		gbc_lblDepartmentName.gridy = 0;
		contentPane.add(lblDepartmentName, gbc_lblDepartmentName);
		
		JLabel lblDynamicDeptName = new JLabel(deptName);
		GridBagConstraints gbc_lblDynamicDeptName = new GridBagConstraints();
		gbc_lblDynamicDeptName.anchor = GridBagConstraints.WEST;
		gbc_lblDynamicDeptName.insets = new Insets(0, 0, 5, 0);
		gbc_lblDynamicDeptName.gridx = 1;
		gbc_lblDynamicDeptName.gridy = 0;
		contentPane.add(lblDynamicDeptName, gbc_lblDynamicDeptName);
		
		JScrollPane StaffScrollPane = new JScrollPane();
		GridBagConstraints gbc_StaffScrollPane = new GridBagConstraints();
		gbc_StaffScrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_StaffScrollPane.gridwidth = 2;
		gbc_StaffScrollPane.fill = GridBagConstraints.BOTH;
		gbc_StaffScrollPane.gridx = 0;
		gbc_StaffScrollPane.gridy = 1;
		contentPane.add(StaffScrollPane, gbc_StaffScrollPane);
		staffTableData = makeStaffTable(dr, deptName);
		StaffTable = new JTable(staffTableData,staffColumnNames);
		StaffTable.setEnabled(false);
		StaffScrollPane.setViewportView(StaffTable);
		
		JScrollPane PatientScrollPane = new JScrollPane();
		GridBagConstraints gbc_PatientScrollPane = new GridBagConstraints();
		gbc_PatientScrollPane.gridwidth = 2;
		gbc_PatientScrollPane.fill = GridBagConstraints.BOTH;
		gbc_PatientScrollPane.insets = new Insets(0, 0, 0, 5);
		gbc_PatientScrollPane.gridx = 0;
		gbc_PatientScrollPane.gridy = 2;
		contentPane.add(PatientScrollPane, gbc_PatientScrollPane);
		patientTableData = makePatientTable(dr, deptName);
		PatientTable = new JTable(patientTableData, patientColumnNames);
		PatientTable.setEnabled(false);
		PatientScrollPane.setViewportView(PatientTable);
		
		
	}
	
	private Object[][] makeStaffTable(DepartmentRegister dr, String deptName) {
		ArrayList<Staff> staffInDept = dr.getStaffFrom(deptName);
		Object [][] data = new Object[staffInDept.size()][6];
		String[] columnNames = {"Serial num","First name","Surname","E-mail","Date of birth","Gender"};
		this.staffColumnNames = columnNames;
		for (int i = 0; i < staffInDept.size(); i++) {
			Staff s = staffInDept.get(i);
			data[i][0] = Integer.toString(s.getSerialnum());
			data[i][1] = s.getName();
			data[i][2] = s.getSurname();
			data[i][3] = s.getEmail();
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			data[i][4] = format.format(s.getBirthday());
			data[i][5] = s.getGender();
		}
		return data;
	}
	
	private Object[][] makePatientTable(DepartmentRegister dr, String deptName) {
		ArrayList<Patient> patientInDept = dr.getPatientsFrom(deptName);
		String[] columnNames = {"Serial num","First name","Surname","E-mail","Date of birth","Gender","Address","Phone Number","Alive"};
		this.patientColumnNames = columnNames;
		Object [][] data = new Object[patientInDept.size()][columnNames.length];
		for (int i = 0; i < patientInDept.size(); i++) {
			Patient p = patientInDept.get(i);
			data[i][0] = Integer.toString(p.getSerialnum());
			data[i][1] = p.getName();
			data[i][2] = p.getSurname();
			data[i][3] = p.getEmail();
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			data[i][4] = format.format(p.getBirthday());
			data[i][5] = p.getGender();
			data[i][6] = p.getAddress();
			data[i][7] = p.getPhoneNumber();
			data[i][8] = p.getAlive();
		}
		return data;
	}
	

}
