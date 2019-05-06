package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Hospital.DepartmentRegister;
import Hospital.PatientRegister;
import Hospital.StaffRegister;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.awt.event.ActionEvent;

public class SearchStaff extends JFrame {

	private JPanel contentPane;
	private JTextField userInput;
	private JTable table;
	private JComboBox searchOptions;
	private Object[][] tableData;
	private Object[] columnNames;
	private JScrollPane scrollPane;
	private DepartmentRegister dr;
	
	public SearchStaff(StaffRegister staffReg, DepartmentRegister dr) {
		
		this.dr = dr;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 756, 338);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblSearchBy = new JLabel("Search By");
		GridBagConstraints gbc_lblSearchBy = new GridBagConstraints();
		gbc_lblSearchBy.anchor = GridBagConstraints.EAST;
		gbc_lblSearchBy.insets = new Insets(0, 0, 5, 5);
		gbc_lblSearchBy.gridx = 0;
		gbc_lblSearchBy.gridy = 0;
		contentPane.add(lblSearchBy, gbc_lblSearchBy);
		
		searchOptions = new JComboBox();
		searchOptions.addItem("Serial number");
		searchOptions.addItem("Name");
		searchOptions.addItem("Surname");
		searchOptions.addItem("Email");
		searchOptions.addItem("Gender");


		
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 1;
		gbc_comboBox.gridy = 0;
		contentPane.add(searchOptions, gbc_comboBox);
		
		JLabel lblInput = new JLabel("Input");
		GridBagConstraints gbc_lblInput = new GridBagConstraints();
		gbc_lblInput.anchor = GridBagConstraints.EAST;
		gbc_lblInput.insets = new Insets(0, 0, 5, 5);
		gbc_lblInput.gridx = 0;
		gbc_lblInput.gridy = 1;
		contentPane.add(lblInput, gbc_lblInput);
		
		userInput = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 1;
		contentPane.add(userInput, gbc_textField);
		userInput.setColumns(10);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			private String[] result;
			private String searchParameter;

			public void actionPerformed(ActionEvent e) {
				searchParameter = userInput.getText();
				String choice = searchOptions.getSelectedItem().toString();
				System.out.println(staffReg.searchName("Morten"));
				System.out.println(searchParameter);
				System.out.println(searchParameter.equals("Morten"));
				if (choice.equals("Serial number")) {
					try {
						int serialnum = Integer.parseInt(searchParameter);
						result = staffReg.searchSerialnum(serialnum);
						tableData = makePartialTable(staffReg, result,dr);
						updateTable();
					} catch (Exception error) {
						new InvalidInput("Please enter valid serial number").setVisible(true);
					}	
				}
				else if (choice.equals("Name")) {
					result = staffReg.searchName(searchParameter);
					System.out.println(Arrays.deepToString(result));
					//System.out.println(staffReg.searchName(searchParameter));
					//System.out.println(staffReg.searchName("Eric")[0]);
					tableData = makePartialTable(staffReg, result, dr);
					updateTable();
				}
				else if (choice.equals("Surname")) {
					result = staffReg.searchSurname(searchParameter);
					tableData = makePartialTable(staffReg, result, dr);
					updateTable();
				}
				else if (choice.equals("Email")) {
					result = staffReg.searchSurname(searchParameter);
					tableData = makePartialTable(staffReg, result, dr);
					updateTable();
				}
				else if (choice.equals("Gender")) {
					result = staffReg.searchSurname(searchParameter);
					tableData = makePartialTable(staffReg, result, dr);
					updateTable();
				}
				
				
			}
		});
		GridBagConstraints gbc_btnSearch = new GridBagConstraints();
		gbc_btnSearch.insets = new Insets(0, 0, 5, 0);
		gbc_btnSearch.gridx = 1;
		gbc_btnSearch.gridy = 2;
		contentPane.add(btnSearch, gbc_btnSearch);
		
		scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 3;
		contentPane.add(scrollPane, gbc_scrollPane);
		
		tableData = makeFullTable(staffReg, dr);
		table = new JTable(tableData, columnNames);
		updateTable();
		scrollPane.setViewportView(table);
	}
	
	private void updateTable() {
		table = new JTable(tableData,columnNames);
		table.setEnabled(false); // un-editable
		scrollPane.setViewportView(table);
		table.setFillsViewportHeight(true);
	}
	private Object[][] makePartialTable(StaffRegister staffReg, String[] result, DepartmentRegister DepartReg) {
		String[] columnNames = {"Serial num","First name","Surname","E-mail","Date of birth","Gender","Department"};
		this.columnNames = columnNames;
		Object[][] data = new Object[result.length][columnNames.length];
		System.out.println("Method:");
		System.out.println(Arrays.toString(result));
		for (int i = 0; i < result.length; i++) {
			int serialnum = result[i].split(" ")[1].charAt(0) - 48;
			System.out.println(serialnum);
			data[i][0] = staffReg.findSerialnum(serialnum).getSerialnum();
			data[i][1] = staffReg.findSerialnum(serialnum).getName();
			data[i][2] = staffReg.findSerialnum(serialnum).getSurname();
			data[i][3] = staffReg.findSerialnum(serialnum).getEmail();
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			data[i][4] = format.format(staffReg.findSerialnum(serialnum).getBirthday());
			data[i][5] = staffReg.findSerialnum(serialnum).getGender();
			data[i][6] = DepartReg.getDeptOfStaff(staffReg.findSerialnum(i).getSerialnum());
		}
		return data;
	}
	
	private Object[][] makeFullTable(StaffRegister staffReg, DepartmentRegister DepartReg) {
		String[] columnNames = {"Serial num","First name","Surname","E-mail","Date of birth","Gender","Department"};
		this.columnNames = columnNames;
		Object[][] data = new Object[staffReg.NumberOfUsersInRegister()][columnNames.length];
		for (int i = 0; i < staffReg.NumberOfUsersInRegister();i++) {
				data[i][0] = staffReg.findSerialnum(i).getSerialnum();
				data[i][1] = staffReg.findSerialnum(i).getName();
				data[i][2] = staffReg.findSerialnum(i).getSurname();
				data[i][3] = staffReg.findSerialnum(i).getEmail();
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				data[i][4] = format.format(staffReg.findSerialnum(i).getBirthday());
				data[i][5] = staffReg.findSerialnum(i).getGender();
				data[i][6] = DepartReg.getDeptOfStaff(staffReg.findSerialnum(i).getSerialnum());
		}
		return data;
		
	}

}
