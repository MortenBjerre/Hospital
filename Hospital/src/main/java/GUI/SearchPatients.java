package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.AbstractTableModel;
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
import java.awt.event.ActionEvent;
import java.awt.Button;


public class SearchPatients extends JFrame {

	private JPanel contentPane;
	private JComboBox dropDownMenu;
	private JLabel lblInput;
	private JTextField textField;
	private JTable table;
	private PatientRegister pr;
	private Button button;
	private JScrollPane scrollPane;
	private Object[][] tableData;
	private Object[] columnNames;

	/**
	 * Create the frame.
	 */
	public SearchPatients(PatientRegister pr) {
		
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 620, 487);
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
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 1;
		contentPane.add(textField, gbc_textField);
		textField.setColumns(10);
		
		button = new Button("Search");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		// Table
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
		table = new JTable(tableData,columnNames);
		table.setEnabled(false); // un-editable
		scrollPane.setViewportView(table);
		table.setFillsViewportHeight(true);
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
				data[i][4] = pr.findSerialnum(i).getBirthday();
				data[i][5] = pr.findSerialnum(i).getGender();
				data[i][6] = pr.findSerialnum(i).getAddress();
				data[i][7] = pr.findSerialnum(i).getPhoneNumber();
				data[i][8] = pr.findSerialnum(i).getAlive();	
		}
		return data;
		
	}

}
