package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Hospital.DepartmentRegister;
import Hospital.StaffRegister;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class AddStaffToDept extends JFrame {

	private JPanel contentPane;
	private DepartmentRegister dr;
	private StaffRegister sr;
	private JTextField serialnumInputField;
	private JLabel lblName;
	private JLabel lblSurname;
	private JLabel lblGetName;
	private JLabel lblGetSurname;
	private JLabel lblAddToDepartment;
	private JComboBox departmentChoice;
	private int serialnum;
	private JButton btnAddStaffMember;

	public AddStaffToDept(DepartmentRegister dr, StaffRegister sr) {
		this.dr = dr;
		this.sr = sr;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblSerialNumber = new JLabel("Serial Number");
		GridBagConstraints gbc_lblSerialNumber = new GridBagConstraints();
		gbc_lblSerialNumber.anchor = GridBagConstraints.EAST;
		gbc_lblSerialNumber.insets = new Insets(0, 0, 5, 5);
		gbc_lblSerialNumber.gridx = 0;
		gbc_lblSerialNumber.gridy = 0;
		contentPane.add(lblSerialNumber, gbc_lblSerialNumber);
		
		serialnumInputField = new JTextField();
		serialnumInputField.addKeyListener(new KeyAdapter() {
			

			@Override
			public void keyPressed(KeyEvent arg0) {
				if (arg0.getKeyCode() == KeyEvent.VK_ENTER) {
					try {
						serialnum = Integer.parseInt(serialnumInputField.getText());
						lblAddToDepartment.setVisible(true);
						lblGetName.setVisible(true);
						lblGetName.setText(sr.findSerialnum(serialnum).getName());
						lblGetSurname.setVisible(true);
						lblGetSurname.setText(sr.findSerialnum(serialnum).getSurname());
						lblName.setVisible(true);
						lblSurname.setVisible(true);
						btnAddStaffMember.setVisible(true);
					} catch (Exception error) {
						new InvalidInput("Please enter valid serial number").setVisible(true);
					}
				}
			}
		});
		GridBagConstraints gbc_serialnumInputField = new GridBagConstraints();
		gbc_serialnumInputField.insets = new Insets(0, 0, 5, 0);
		gbc_serialnumInputField.fill = GridBagConstraints.HORIZONTAL;
		gbc_serialnumInputField.gridx = 1;
		gbc_serialnumInputField.gridy = 0;
		contentPane.add(serialnumInputField, gbc_serialnumInputField);
		serialnumInputField.setColumns(10);
		
		lblName = new JLabel("Name:");
		lblName.setVisible(false);
		GridBagConstraints gbc_lblName = new GridBagConstraints();
		gbc_lblName.anchor = GridBagConstraints.EAST;
		gbc_lblName.insets = new Insets(0, 0, 5, 5);
		gbc_lblName.gridx = 0;
		gbc_lblName.gridy = 1;
		contentPane.add(lblName, gbc_lblName);
		
		lblGetName = new JLabel("");
		GridBagConstraints gbc_lblGetName = new GridBagConstraints();
		gbc_lblGetName.anchor = GridBagConstraints.WEST;
		gbc_lblGetName.insets = new Insets(0, 0, 5, 0);
		gbc_lblGetName.gridx = 1;
		gbc_lblGetName.gridy = 1;
		contentPane.add(lblGetName, gbc_lblGetName);
		
		lblSurname = new JLabel("Surname:");
		lblSurname.setVisible(false);
		GridBagConstraints gbc_lblSurname = new GridBagConstraints();
		gbc_lblSurname.insets = new Insets(0, 0, 5, 5);
		gbc_lblSurname.anchor = GridBagConstraints.EAST;
		gbc_lblSurname.gridx = 0;
		gbc_lblSurname.gridy = 2;
		contentPane.add(lblSurname, gbc_lblSurname);
		
		lblGetSurname = new JLabel("");
		GridBagConstraints gbc_lblGetSurname = new GridBagConstraints();
		gbc_lblGetSurname.anchor = GridBagConstraints.WEST;
		gbc_lblGetSurname.insets = new Insets(0, 0, 5, 0);
		gbc_lblGetSurname.gridx = 1;
		gbc_lblGetSurname.gridy = 2;
		contentPane.add(lblGetSurname, gbc_lblGetSurname);
		
		lblAddToDepartment = new JLabel("Add to department");
		GridBagConstraints gbc_lblAddToDepartment = new GridBagConstraints();
		gbc_lblAddToDepartment.insets = new Insets(0, 0, 5, 5);
		gbc_lblAddToDepartment.anchor = GridBagConstraints.EAST;
		gbc_lblAddToDepartment.gridx = 0;
		gbc_lblAddToDepartment.gridy = 3;
		contentPane.add(lblAddToDepartment, gbc_lblAddToDepartment);
		
		departmentChoice = new JComboBox();
		departmentChoice.setVisible(false);
		
		for(int i = 0; i < dr.getAllDepartments().size(); i++) {
			departmentChoice.addItem(dr.getAllDepartments().get(i));
		}
		
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 1;
		gbc_comboBox.gridy = 3;
		contentPane.add(departmentChoice, gbc_comboBox);
		
		btnAddStaffMember = new JButton("Add staff member");
		btnAddStaffMember.setVisible(false);
		btnAddStaffMember.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String deptName = departmentChoice.getSelectedItem().toString();
				dr.addStaffTo(serialnum, deptName, sr);
			}
		});
		GridBagConstraints gbc_btnAddStaffMember = new GridBagConstraints();
		gbc_btnAddStaffMember.gridx = 1;
		gbc_btnAddStaffMember.gridy = 4;
		contentPane.add(btnAddStaffMember, gbc_btnAddStaffMember);
	}

}
