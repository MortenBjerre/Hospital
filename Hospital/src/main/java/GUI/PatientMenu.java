package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Hospital.DepartmentRegister;
import Hospital.Patient;
import Hospital.PatientRegister;
import Hospital.Staff;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

@SuppressWarnings({ "unused", "serial" })
public class PatientMenu extends JFrame {
	static PatientRegister PatientReg;
	static DepartmentRegister DepartReg;
	private int serialnum;
	private Patient patient;
	private String deptName;
  
	/**
	 * Create the frame.
	 */
	@SuppressWarnings("static-access")
	public PatientMenu(PatientRegister pr, DepartmentRegister dr, int serialnum) {
		PatientMenu.PatientReg = pr;
		PatientMenu.DepartReg = dr;
		this.serialnum = serialnum;
		patient = pr.findSerialnum(serialnum);

	
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setTitle("Patient Menu ");
		setBounds(100, 100, 551, 354);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{94, 479, 0};
		gridBagLayout.rowHeights = new int[]{26, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, Double.MIN_VALUE, 0.0};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		JLabel lblWelcome = new JLabel("Welcome, " + patient.getName() + " " + patient.getSurname());
		GridBagConstraints gbc_lblWelcome = new GridBagConstraints();
		gbc_lblWelcome.anchor = GridBagConstraints.WEST;
		gbc_lblWelcome.insets = new Insets(0, 0, 5, 5);
		gbc_lblWelcome.gridx = 1;
		gbc_lblWelcome.gridy = 0;
		getContentPane().add(lblWelcome, gbc_lblWelcome);
		
		JLabel lblSerialNumber = new JLabel("Serial number:");
		GridBagConstraints gbc_lblSerialNumber = new GridBagConstraints();
		gbc_lblSerialNumber.anchor = GridBagConstraints.EAST;
		gbc_lblSerialNumber.insets = new Insets(0, 0, 5, 5);
		gbc_lblSerialNumber.gridx = 0;
		gbc_lblSerialNumber.gridy = 1;
		getContentPane().add(lblSerialNumber, gbc_lblSerialNumber);
		
		JLabel lblDynamicSerialnum = new JLabel(Integer.toString(patient.getSerialnum()));
		GridBagConstraints gbc_lblDynamicSerialnum = new GridBagConstraints();
		gbc_lblDynamicSerialnum.anchor = GridBagConstraints.WEST;
		gbc_lblDynamicSerialnum.insets = new Insets(0, 0, 5, 5);
		gbc_lblDynamicSerialnum.gridx = 1;
		gbc_lblDynamicSerialnum.gridy = 1;
		getContentPane().add(lblDynamicSerialnum, gbc_lblDynamicSerialnum);
		
		JLabel lblEmail = new JLabel("E-mail:");
		GridBagConstraints gbc_lblEmail = new GridBagConstraints();
		gbc_lblEmail.anchor = GridBagConstraints.EAST;
		gbc_lblEmail.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmail.gridx = 0;
		gbc_lblEmail.gridy = 2;
		getContentPane().add(lblEmail, gbc_lblEmail);
		
		JLabel lblDynamicEmail = new JLabel(patient.getEmail());
		GridBagConstraints gbc_lblDynamicEmail = new GridBagConstraints();
		gbc_lblDynamicEmail.anchor = GridBagConstraints.WEST;
		gbc_lblDynamicEmail.insets = new Insets(0, 0, 5, 5);
		gbc_lblDynamicEmail.gridx = 1;
		gbc_lblDynamicEmail.gridy = 2;
		getContentPane().add(lblDynamicEmail, gbc_lblDynamicEmail);
		
		JLabel lblAddress = new JLabel("Address:");
		GridBagConstraints gbc_lblAddress = new GridBagConstraints();
		gbc_lblAddress.anchor = GridBagConstraints.EAST;
		gbc_lblAddress.insets = new Insets(0, 0, 5, 5);
		gbc_lblAddress.gridx = 0;
		gbc_lblAddress.gridy = 3;
		getContentPane().add(lblAddress, gbc_lblAddress);
		
		JLabel lblDynamicAddress = new JLabel(patient.getAddress());
		GridBagConstraints gbc_lblDynamicAddress = new GridBagConstraints();
		gbc_lblDynamicAddress.anchor = GridBagConstraints.WEST;
		gbc_lblDynamicAddress.insets = new Insets(0, 0, 5, 5);
		gbc_lblDynamicAddress.gridx = 1;
		gbc_lblDynamicAddress.gridy = 3;
		getContentPane().add(lblDynamicAddress, gbc_lblDynamicAddress);
		
		JLabel lblPhoneNumber = new JLabel("Phone Number:");
		GridBagConstraints gbc_lblPhoneNumber = new GridBagConstraints();
		gbc_lblPhoneNumber.insets = new Insets(0, 0, 5, 5);
		gbc_lblPhoneNumber.anchor = GridBagConstraints.EAST;
		gbc_lblPhoneNumber.gridx = 0;
		gbc_lblPhoneNumber.gridy = 4;
		getContentPane().add(lblPhoneNumber, gbc_lblPhoneNumber);
		
		JLabel lblDynamicPhoneNumber = new JLabel(Integer.toString(patient.getPhoneNumber()));
		GridBagConstraints gbc_lblDynamicPhoneNumber = new GridBagConstraints();
		gbc_lblDynamicPhoneNumber.anchor = GridBagConstraints.WEST;
		gbc_lblDynamicPhoneNumber.insets = new Insets(0, 0, 5, 5);
		gbc_lblDynamicPhoneNumber.gridx = 1;
		gbc_lblDynamicPhoneNumber.gridy = 4;
		getContentPane().add(lblDynamicPhoneNumber, gbc_lblDynamicPhoneNumber);
		
		if (!dr.getDeptOfPatient(serialnum).equals("")) {
			JLabel lblDepartment = new JLabel("Department:");
			GridBagConstraints gbc_lblDepartment = new GridBagConstraints();
			gbc_lblDepartment.anchor = GridBagConstraints.WEST;
			gbc_lblDepartment.insets = new Insets(0, 0, 5, 5);
			gbc_lblDepartment.gridx = 0;
			gbc_lblDepartment.gridy = 5;
			getContentPane().add(lblDepartment, gbc_lblDepartment);
			
			deptName = dr.getDeptOfPatient(serialnum);
			JLabel lblDynamicDepartment = new JLabel(deptName);
			GridBagConstraints gbc_lblDynamicDepartment = new GridBagConstraints();
			gbc_lblDynamicDepartment.insets = new Insets(0, 0, 5, 5);
			gbc_lblDynamicDepartment.gridx = 1;
			gbc_lblDynamicDepartment.gridy = 5;
			getContentPane().add(lblDynamicDepartment, gbc_lblDynamicDepartment);
			
			try {
				int bednumber = dr.getBedOf(serialnum, deptName);
				JLabel lblBedNumber = new JLabel("Bed number:");
				GridBagConstraints gbc_lblBedNumber = new GridBagConstraints();
				gbc_lblBedNumber.anchor = GridBagConstraints.WEST;
				gbc_lblBedNumber.insets = new Insets(0, 0, 5, 5);
				gbc_lblBedNumber.gridx = 0;
				gbc_lblBedNumber.gridy = 6;
				getContentPane().add(lblBedNumber, gbc_lblBedNumber);
				
				JLabel lblDynamicBedNumber = new JLabel(Integer.toString(bednumber));
				GridBagConstraints gbc_lblDynamicBedNumber = new GridBagConstraints();
				gbc_lblDynamicBedNumber.insets = new Insets(0, 0, 5, 5);
				gbc_lblDynamicBedNumber.gridx = 1;
				gbc_lblDynamicBedNumber.gridy = 6;
				getContentPane().add(lblDynamicBedNumber, gbc_lblDynamicBedNumber);

			} catch (Exception e) {
				;
			}

		}
		
		
		JButton btnGoBack = new JButton("Go Back");
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		GridBagConstraints gbc_btnGoBack = new GridBagConstraints();
		gbc_btnGoBack.gridx = 2;
		gbc_btnGoBack.gridy = 7;
		getContentPane().add(btnGoBack, gbc_btnGoBack);
		
		
	}
}