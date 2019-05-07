package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Hospital.DepartmentRegister;
import Hospital.Staff;
import Hospital.StaffRegister;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import GUI.DepartmentManager;

public class ChangeNameOfDept extends JFrame {

	private JPanel contentPane;
	private JTextField newDeptNametextField;

	public ChangeNameOfDept(String deptName, DepartmentRegister dr, Staff staff, StaffRegister sr) {

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 461, 220);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 124, 139, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		setLocationRelativeTo(null);
		
		JLabel lblChangeNameOf = new JLabel("Change name of department:");
		GridBagConstraints gbc_lblChangeNameOf = new GridBagConstraints();
		gbc_lblChangeNameOf.anchor = GridBagConstraints.EAST;
		gbc_lblChangeNameOf.insets = new Insets(0, 0, 5, 5);
		gbc_lblChangeNameOf.gridx = 0;
		gbc_lblChangeNameOf.gridy = 0;
		contentPane.add(lblChangeNameOf, gbc_lblChangeNameOf);
		
		JLabel lblDeptname = new JLabel(deptName);
		GridBagConstraints gbc_lblDeptname = new GridBagConstraints();
		gbc_lblDeptname.anchor = GridBagConstraints.WEST;
		gbc_lblDeptname.insets = new Insets(0, 0, 5, 5);
		gbc_lblDeptname.gridx = 1;
		gbc_lblDeptname.gridy = 0;
		contentPane.add(lblDeptname, gbc_lblDeptname);
		
		JLabel lblNewDepartmentName = new JLabel("New department name:");
		GridBagConstraints gbc_lblNewDepartmentName = new GridBagConstraints();
		gbc_lblNewDepartmentName.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewDepartmentName.anchor = GridBagConstraints.EAST;
		gbc_lblNewDepartmentName.gridx = 0;
		gbc_lblNewDepartmentName.gridy = 1;
		contentPane.add(lblNewDepartmentName, gbc_lblNewDepartmentName);
		
		newDeptNametextField = new JTextField();
		GridBagConstraints gbc_newDeptNametextField = new GridBagConstraints();
		gbc_newDeptNametextField.gridwidth = 2;
		gbc_newDeptNametextField.insets = new Insets(0, 0, 5, 0);
		gbc_newDeptNametextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_newDeptNametextField.gridx = 1;
		gbc_newDeptNametextField.gridy = 1;
		contentPane.add(newDeptNametextField, gbc_newDeptNametextField);
		newDeptNametextField.setColumns(10);
		
		JButton btnMakeChange = new JButton("Make change");
		btnMakeChange.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String newDeptName = newDeptNametextField.getText();
				if (!newDeptName.equals("")) {
					dr.changeNameOf(deptName, newDeptName);
					dispose();
					new DepartmentManager(dr, staff, sr).setVisible(true);
				} else {
					new InvalidInput("Please enter new department name");
				}
			}
		});
		GridBagConstraints gbc_btnMakeChange = new GridBagConstraints();
		gbc_btnMakeChange.gridwidth = 2;
		gbc_btnMakeChange.insets = new Insets(0, 0, 5, 0);
		gbc_btnMakeChange.fill = GridBagConstraints.BOTH;
		gbc_btnMakeChange.gridx = 1;
		gbc_btnMakeChange.gridy = 2;
		contentPane.add(btnMakeChange, gbc_btnMakeChange);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				new DepartmentManager(dr, staff, sr).setVisible(true);
			}
		});
		GridBagConstraints gbc_btnCancel = new GridBagConstraints();
		gbc_btnCancel.gridx = 2;
		gbc_btnCancel.gridy = 4;
		contentPane.add(btnCancel, gbc_btnCancel);
	}

}
