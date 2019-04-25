package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Hospital.Staff;
import Hospital.StaffRegister;
import Hospital.Clerk;
import Hospital.PatientRegister;

import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


@SuppressWarnings({ "unused", "serial" })
public class Staff_Menu extends JFrame {

	private JPanel contentPane;
	static StaffRegister StaffReg;
	static PatientRegister PatientReg;
	static int serialNumber;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Staff_Menu frame = new Staff_Menu(StaffReg,serialNumber, PatientReg);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	@SuppressWarnings("static-access")
	public Staff_Menu(StaffRegister StaffReg, int serialNumber, PatientRegister PatientReg) {
		Staff_Menu.StaffReg = StaffReg;
		Staff_Menu.PatientReg = PatientReg;
		this.serialNumber = serialNumber;
		Staff Staff = StaffReg.findSerialnum(serialNumber);

		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1006, 655);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAddPatient = new JButton("Register Patient");
		btnAddPatient.setBounds(400, 196, 219, 41);
		contentPane.add(btnAddPatient);
		btnAddPatient.setVisible(false);
		if (Staff.hasWriteAccessTo(PatientReg)) {
			btnAddPatient.setVisible(true);
		}

		
		JButton btnAddStaff = new JButton("Add Staff");
		btnAddStaff.setBounds(425, 265, 171, 41);
		contentPane.add(btnAddStaff);
		btnAddStaff.setVisible(false);
		if (Staff.hasWriteAccessTo(StaffReg)) {
			btnAddStaff.setVisible(true);
		}
		
		JButton btnMovePatient = new JButton("Move Patient");
		btnMovePatient.setBounds(763, 127, 185, 41);
		contentPane.add(btnMovePatient);
		btnMovePatient.setVisible(false);
		if (Staff.canMovePatients()) {
			btnMovePatient.setVisible(true);
		}
		
		JButton btnRemovePatient = new JButton("Discharge patient");
		btnRemovePatient.setBounds(390, 127, 239, 41);
		contentPane.add(btnRemovePatient);
		btnRemovePatient.setVisible(false);
		if (Staff.hasWriteAccessTo(PatientReg)) {
			btnRemovePatient.setVisible(true);
		}
		
		JButton btnMoveStaff = new JButton("Move Staff");
		btnMoveStaff.setBounds(763, 265, 171, 41);
		contentPane.add(btnMoveStaff);
		btnMoveStaff.setVisible(false);
		if (Staff.canMoveStaff()) {
			btnMoveStaff.setVisible(true);
		}
		
		JButton btnSearch = new JButton("Search Staff");
		btnSearch.setBounds(58, 265, 177, 41);
		contentPane.add(btnSearch);
		btnSearch.setVisible(false);
		if (Staff.hasViewAccessTo(StaffReg)) {
			btnSearch.setVisible(true);
		}
		
		JButton btnChangeInfo = new JButton("Update patient Info");
		btnChangeInfo.setBounds(26, 127, 265, 41);
		contentPane.add(btnChangeInfo);
		btnChangeInfo.setVisible(false);
		if (Staff.hasWriteAccessTo(PatientReg)) {
			btnChangeInfo.setVisible(true);
		}
		
		JButton btnSearchPatients = new JButton("Search Patients");
		btnSearchPatients.setBounds(36, 196, 215, 41);
		contentPane.add(btnSearchPatients);
		btnSearchPatients.setVisible(false);
		if (Staff.hasWriteAccessTo(PatientReg)) {
			btnSearchPatients.setVisible(true);
		}
		
		JButton btnHealthData = new JButton("Health data");
		btnHealthData.setBounds(763, 196, 171, 41);
		contentPane.add(btnHealthData);
		btnHealthData.setVisible(false);
		if (Staff.hasHealthDataAccess()) {
			btnHealthData.setVisible(true);
		}
		
		
		JButton btnGoBack = new JButton("Go Back");
		btnGoBack.setFont(new Font("Times New Roman", Font.PLAIN, 27));
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnGoBack.setBounds(0, 528, 171, 41);
		contentPane.add(btnGoBack);
		
		JLabel lblWelcomeToThe = new JLabel("Welcome to the Staff Menu");
		lblWelcomeToThe.setBounds(37, 28, 467, 33);
		contentPane.add(lblWelcomeToThe);
		
		
	}
}