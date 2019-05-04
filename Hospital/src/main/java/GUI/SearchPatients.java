package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import Hospital.PatientRegister;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JComboBox;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JTable;
import java.awt.ScrollPane;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.awt.event.ActionEvent;
import java.awt.Button;


public class SearchPatients extends JFrame {

	private JPanel contentPane;
	private JComboBox dropDownMenu;
	private JLabel lblInput;
	private JTextField userInput;
	private JTable table;
	private PatientRegister pr;
	private Button button;
	private JScrollPane scrollPane;
	private Object[][] tableData;
	private Object[] columnNames;
	private String searchParameter;

	/**
	 * Create the frame.
	 */
	@SuppressWarnings("unchecked")
	public SearchPatients(PatientRegister pr) {
				
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblSearchBy = new JLabel("Search By");
		GridBagConstraints gbc_lblSearchBy = new GridBagConstraints();
		gbc_lblSearchBy.insets = new Insets(0, 0, 5, 5);
		gbc_lblSearchBy.anchor = GridBagConstraints.EAST;
		gbc_lblSearchBy.gridx = 0;
		gbc_lblSearchBy.gridy = 0;
		contentPane.add(lblSearchBy, gbc_lblSearchBy);
		
		
		
		
		dropDownMenu = new JComboBox();
		dropDownMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
								
			}
		});
		dropDownMenu.addItem("Serial Number");
		dropDownMenu.addItem("First Name");
		dropDownMenu.addItem("Surname");
		dropDownMenu.addItem("Email");
		dropDownMenu.addItem("Birthday");
		dropDownMenu.addItem("Address");
		dropDownMenu.addItem("Phone Number");
		dropDownMenu.addItem("Gender");
		dropDownMenu.addItem("Alive status");

		
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 1;
		gbc_comboBox.gridy = 0;
		contentPane.add(dropDownMenu, gbc_comboBox);
		
		lblInput = new JLabel("Input: ");
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
		
		button = new Button("Search");
		button.addActionListener(new ActionListener() {
			

			public void actionPerformed(ActionEvent arg0) {
				String choice = dropDownMenu.getSelectedItem().toString();
				
				searchParameter = userInput.getText();
				switch(choice) {
					case ("Serial Number"):
						try {
							int serialnum = Integer.parseInt(searchParameter);
							String[] result1 = pr.searchSerialnum(serialnum);
							tableData = makePartialTable(pr, result1);
							System.out.println(Arrays.toString(result1));
							// table needs to be updated
							updateTable();
							break;
						} catch (Exception e) {
							System.out.println("Error");
						}
					case ("First Name"):
						System.out.println(searchParameter);
						String[] result2 = pr.searchName(searchParameter);
						tableData = makePartialTable(pr, result2);	
						updateTable();
						break;
					case("Surname"):
						String[] result3 = pr.searchSurname(searchParameter);
						tableData = makePartialTable(pr, result3);
						updateTable();
						break;
					case("Email"):
						String[] result4 = pr.searchEmail(searchParameter);
						tableData = makePartialTable(pr, result4);
						updateTable();
						break;
					case("Phone Number"):
						try {
							int phoneNumber= Integer.parseInt(searchParameter);
							String[] result5 = pr.searchNumber(phoneNumber);
							tableData = makePartialTable(pr, result5);
							updateTable();
							break;
						} catch(Exception e) {
							System.out.println("Error");
						}
						
					case("Address"):
						String[] result6 = pr.searchAddress(searchParameter);
						tableData = makePartialTable(pr, result6);
						updateTable();
						break;
					case("Gender"):
						String[] result7 = pr.searchGender(searchParameter);
						tableData = makePartialTable(pr, result7);
						updateTable();
						break;
					case("Alive status"):
						if (searchParameter == "alive") {
							String[] result8 = pr.searchAlive(true);
							tableData = makePartialTable(pr, result8);
							updateTable();
							break;
						} else if (searchParameter == "dead"){
							String[] result9 = pr.searchAlive(false);
							tableData = makePartialTable(pr, result9);
							updateTable();
						} else {
							System.out.println("Error");
						}
										
				}
			}

			
		});
		
		// Table - table initially shows all patients
		tableData = makeFullTable(pr);
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.fill = GridBagConstraints.HORIZONTAL;
		gbc_button.insets = new Insets(0, 0, 5, 0);
		gbc_button.gridx = 1;
		gbc_button.gridy = 2;
		contentPane.add(button, gbc_button);
		
		scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 3;
		contentPane.add(scrollPane, gbc_scrollPane);
		
		updateTable();
	}
	private void updateTable() {
		table = new JTable(tableData,columnNames);
		table.setEnabled(false); // un-editable
		scrollPane.setViewportView(table);
		table.setFillsViewportHeight(true);
	}
	private Object[][] makePartialTable(PatientRegister pr, String[] result) {
		String[] columnNames = {"Serial num","First name","Surname","E-mail","Date of birth","Gender","Address","Phone Number","Alive"};
		this.columnNames = columnNames;
		System.out.println(pr);
		Object[][] data = new Object[result.length][columnNames.length];
		System.out.println("Method:");
		System.out.println(Arrays.toString(result));
		for (int i = 0; i < result.length; i++) {
			int serialnum = result[i].split(" ")[1].charAt(0) - 48;
			System.out.println(serialnum);
			data[i][0] = pr.findSerialnum(serialnum).getSerialnum();
			data[i][1] = pr.findSerialnum(serialnum).getName();
			data[i][2] = pr.findSerialnum(serialnum).getSurname();
			data[i][3] = pr.findSerialnum(serialnum).getEmail();
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			data[i][4] = format.format(pr.findSerialnum(serialnum).getBirthday());
			data[i][5] = pr.findSerialnum(serialnum).getGender();
			data[i][6] = pr.findSerialnum(serialnum).getAddress();
			data[i][7] = pr.findSerialnum(serialnum).getPhoneNumber();
			data[i][8] = pr.findSerialnum(serialnum).getAlive();	
		}
		return data;
	}
	
	private Object[][] makeFullTable(PatientRegister pr) {
		String[] columnNames = {"Serial num","First name","Surname","E-mail","Date of birth","Gender","Address","Phone Number","Alive"};
		this.columnNames = columnNames;
		Object[][] data = new Object[pr.NumberOfUsersInRegister()][columnNames.length];
		for (int i = 0; i < pr.NumberOfUsersInRegister();i++) {
				data[i][0] = pr.findSerialnum(i).getSerialnum();
				data[i][1] = pr.findSerialnum(i).getName();
				data[i][2] = pr.findSerialnum(i).getSurname();
				data[i][3] = pr.findSerialnum(i).getEmail();
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				data[i][4] = format.format(pr.findSerialnum(i).getBirthday());
				data[i][5] = pr.findSerialnum(i).getGender();
				data[i][6] = pr.findSerialnum(i).getAddress();
				data[i][7] = pr.findSerialnum(i).getPhoneNumber();
				data[i][8] = pr.findSerialnum(i).getAlive();	
		}
		return data;
		
	}

}
