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
import javax.swing.JTextField;
import java.awt.Insets;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class DischargeStaff extends JFrame {

	private JPanel contentPane;
	private JTextField serialnumberInput;
	private JLabel lblShowName;
	private JLabel lblShowSurname;
	private JLabel lblShowEmail;
	private JLabel lblShowGender;
	private JLabel lblShowDepartment;
	private int serialnum;
	private StaffRegister sr;
	private JLabel lblDepartment;
	
	public DischargeStaff(StaffRegister sr, DepartmentRegister dr) {
		this.sr = sr;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JButton btnSearchStaff = new JButton("Search Staff");
		btnSearchStaff.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new SearchStaff(sr, dr).setVisible(true);
			}
		});
		GridBagConstraints gbc_btnSearchStaff = new GridBagConstraints();
		gbc_btnSearchStaff.insets = new Insets(0, 0, 5, 0);
		gbc_btnSearchStaff.gridx = 1;
		gbc_btnSearchStaff.gridy = 0;
		contentPane.add(btnSearchStaff, gbc_btnSearchStaff);
		
		JLabel lblSerialNumber = new JLabel("Serial Number");
		GridBagConstraints gbc_lblSerialNumber = new GridBagConstraints();
		gbc_lblSerialNumber.insets = new Insets(0, 0, 5, 5);
		gbc_lblSerialNumber.anchor = GridBagConstraints.EAST;
		gbc_lblSerialNumber.gridx = 0;
		gbc_lblSerialNumber.gridy = 1;
		contentPane.add(lblSerialNumber, gbc_lblSerialNumber);
		
		serialnumberInput = new JTextField();
		serialnumberInput.addKeyListener(new KeyAdapter() {
			

			@Override
			public void keyPressed(KeyEvent arg0) {
				if (arg0.getKeyCode() == KeyEvent.VK_ENTER) {
					try {
						serialnum = Integer.parseInt(serialnumberInput.getText());
						lblShowName.setText(sr.findSerialnum(serialnum).getName());
						if (dr.getDeptOfStaff(serialnum).equals("")) {
							lblDepartment.setVisible(false);
							lblShowDepartment.setText(dr.getDeptOfStaff(serialnum));
						} else {
							lblDepartment.setVisible(true);
						}
						lblShowEmail.setText(sr.findSerialnum(serialnum).getEmail());
						lblShowGender.setText(sr.findSerialnum(serialnum).getGender());
						lblShowSurname.setText(sr.findSerialnum(serialnum).getSurname());
					} catch (Exception e) {
						new InvalidInput(e.getMessage()).setVisible(true);
					}
				}
			}
		});
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 1;
		contentPane.add(serialnumberInput, gbc_textField);
		serialnumberInput.setColumns(10);
		
		JLabel lblName = new JLabel("Name:");
		GridBagConstraints gbc_lblName = new GridBagConstraints();
		gbc_lblName.insets = new Insets(0, 0, 5, 5);
		gbc_lblName.gridx = 0;
		gbc_lblName.gridy = 3;
		contentPane.add(lblName, gbc_lblName);
		
		lblShowName = new JLabel("");
		GridBagConstraints gbc_lblName_1 = new GridBagConstraints();
		gbc_lblName_1.insets = new Insets(0, 0, 5, 0);
		gbc_lblName_1.gridx = 1;
		gbc_lblName_1.gridy = 3;
		contentPane.add(lblShowName, gbc_lblName_1);
		
		JLabel lblSurname = new JLabel("Surname:");
		GridBagConstraints gbc_lblSurname = new GridBagConstraints();
		gbc_lblSurname.insets = new Insets(0, 0, 5, 5);
		gbc_lblSurname.gridx = 0;
		gbc_lblSurname.gridy = 4;
		contentPane.add(lblSurname, gbc_lblSurname);
		
		lblShowSurname = new JLabel("");
		GridBagConstraints gbc_lblSurname_1 = new GridBagConstraints();
		gbc_lblSurname_1.insets = new Insets(0, 0, 5, 0);
		gbc_lblSurname_1.gridx = 1;
		gbc_lblSurname_1.gridy = 4;
		contentPane.add(lblShowSurname, gbc_lblSurname_1);
		
		JLabel lblEmail = new JLabel("Email:");
		GridBagConstraints gbc_lblEmail = new GridBagConstraints();
		gbc_lblEmail.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmail.gridx = 0;
		gbc_lblEmail.gridy = 5;
		contentPane.add(lblEmail, gbc_lblEmail);
		
		lblShowEmail = new JLabel("");
		GridBagConstraints gbc_lblEmail_1 = new GridBagConstraints();
		gbc_lblEmail_1.insets = new Insets(0, 0, 5, 0);
		gbc_lblEmail_1.gridx = 1;
		gbc_lblEmail_1.gridy = 5;
		contentPane.add(lblShowEmail, gbc_lblEmail_1);
		
		JLabel lblGender = new JLabel("Gender:");
		GridBagConstraints gbc_lblGender = new GridBagConstraints();
		gbc_lblGender.insets = new Insets(0, 0, 5, 5);
		gbc_lblGender.gridx = 0;
		gbc_lblGender.gridy = 6;
		contentPane.add(lblGender, gbc_lblGender);
		
		lblShowGender = new JLabel("");
		GridBagConstraints gbc_lblGender_1 = new GridBagConstraints();
		gbc_lblGender_1.insets = new Insets(0, 0, 5, 0);
		gbc_lblGender_1.gridx = 1;
		gbc_lblGender_1.gridy = 6;
		contentPane.add(lblShowGender, gbc_lblGender_1);
		
		lblDepartment = new JLabel("Department:");
		GridBagConstraints gbc_lblDepartment = new GridBagConstraints();
		gbc_lblDepartment.insets = new Insets(0, 0, 5, 5);
		gbc_lblDepartment.gridx = 0;
		gbc_lblDepartment.gridy = 7;
		contentPane.add(lblDepartment, gbc_lblDepartment);
		lblDepartment.setVisible(false);
		
		JButton btnFireEmployee = new JButton("Fire Employee");
		btnFireEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Serialnum is :" + serialnum);
				System.out.println(sr);
				try {
					dr.dischargeStaff(serialnum, sr);
					System.out.println(serialnum);
					new SuccesfullOperation("Staff member has been fired.").setVisible(true);
				} catch (Exception error) {
//					new InvalidInput("No such staff member").setVisible(true);;
					new InvalidInput(error.getMessage()).setVisible(true);;
				}
			}
		});
		
		lblShowDepartment = new JLabel();
		GridBagConstraints gbc_lblDepartment_1 = new GridBagConstraints();
		gbc_lblDepartment_1.insets = new Insets(0, 0, 5, 0);
		gbc_lblDepartment_1.gridx = 1;
		gbc_lblDepartment_1.gridy = 7;
		contentPane.add(lblShowDepartment, gbc_lblDepartment_1);
		GridBagConstraints gbc_btnFireEmployee = new GridBagConstraints();
		gbc_btnFireEmployee.gridx = 1;
		gbc_btnFireEmployee.gridy = 8;
		contentPane.add(btnFireEmployee, gbc_btnFireEmployee);
	}

}
