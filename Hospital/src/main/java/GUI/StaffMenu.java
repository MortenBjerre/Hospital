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
import Hospital.DepartmentRegister;
import Hospital.PatientRegister;

import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import javax.swing.SwingConstants;


@SuppressWarnings({ "unused", "serial" })
public class StaffMenu extends JFrame {

	private JPanel contentPane;
	static StaffRegister StaffReg;
	static PatientRegister PatientReg;
	static DepartmentRegister DepartReg;
	static int serialNumber;

	/**
	 * Create the frame.
	 */
	@SuppressWarnings("static-access")
	public StaffMenu(final StaffRegister StaffReg, int serialNumber, final PatientRegister PatientReg, final DepartmentRegister DepartReg) {
		StaffMenu.StaffReg = StaffReg;
		StaffMenu.PatientReg = PatientReg;
		this.serialNumber = serialNumber;
		Staff staff = StaffReg.findSerialnum(serialNumber);

		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setTitle("Staff Menu");
		setBounds(100, 100, 1006, 655);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 3, 0, 0));
		
		JButton btnChangeInfo = new JButton("Update patient Info");
		btnChangeInfo.setFont(new Font("Times New Roman", Font.PLAIN, 35));
		contentPane.add(btnChangeInfo);
		btnChangeInfo.setVisible(false);
		if (staff.hasWriteAccessTo(PatientReg)) {
			btnChangeInfo.setVisible(true);
		}
		btnChangeInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				UpdatePatientInfo loginPage2 = new UpdatePatientInfo(PatientReg);
				loginPage2.setVisible(true);
			}
		});
		
		JButton btnRemovePatient = new JButton("Discharge patient");
		btnRemovePatient.setFont(new Font("Times New Roman", Font.PLAIN, 35));
		contentPane.add(btnRemovePatient);
		btnRemovePatient.setVisible(false);
		btnRemovePatient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Dischargepatient loginPage = new Dischargepatient(PatientReg,DepartReg);
				loginPage.setVisible(true);
			}
		});
		
		JButton btnMovePatient = new JButton("Move Patient");
		btnMovePatient.setFont(new Font("Times New Roman", Font.PLAIN, 35));
		contentPane.add(btnMovePatient);
		btnMovePatient.setVisible(false);
		btnMovePatient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				MovePatient loginPage = new MovePatient(PatientReg,DepartReg);
				loginPage.setVisible(true);
			}
		});
		
		JButton btnSearchPatients = new JButton("Search Patients");
		btnSearchPatients.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				SearchPatients searchPatients = new SearchPatients(PatientReg);
				searchPatients.setVisible(true);
				
			}
		});
		btnSearchPatients.setFont(new Font("Times New Roman", Font.PLAIN, 35));
		contentPane.add(btnSearchPatients);
		btnSearchPatients.setVisible(false);
		if (staff.hasWriteAccessTo(PatientReg)) {
			btnSearchPatients.setVisible(true);
		}
		
		JButton btnAddPatient = new JButton("Register Patient");
		btnAddPatient.setFont(new Font("Times New Roman", Font.PLAIN, 35));
		contentPane.add(btnAddPatient);
		btnAddPatient.setVisible(false);
		btnAddPatient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				RegisterPatient RegisterPage = new RegisterPatient(PatientReg,DepartReg);
				RegisterPage.setVisible(true);
			}
		});
		
		JButton btnHealthData = new JButton("Health data");
		btnHealthData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				HealthData healthDataMenu = new HealthData(PatientReg, DepartReg);
				healthDataMenu.setVisible(true);
				
			}
		});
		btnHealthData.setFont(new Font("Times New Roman", Font.PLAIN, 35));
		contentPane.add(btnHealthData);
		btnHealthData.setVisible(false);
		if (staff.hasHealthDataAccess()) {
			btnHealthData.setVisible(true);
		}
		
		
		JButton btnGoBack = new JButton("Go Back");
		btnGoBack.setFont(new Font("Times New Roman", Font.PLAIN, 35));
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
				
		JButton btnSearch = new JButton("Search Staff");
		btnSearch.setFont(new Font("Times New Roman", Font.PLAIN, 35));
		contentPane.add(btnSearch);
		btnSearch.setVisible(false);

		
		JButton btnAddStaff = new JButton("Add Staff");
		btnAddStaff.setFont(new Font("Times New Roman", Font.PLAIN, 35));
		contentPane.add(btnAddStaff);
		btnAddStaff.setVisible(false);
		btnAddStaff.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AddStaff AddStaffPage = new AddStaff(StaffReg);
				AddStaffPage.setVisible(true);
			}
		});

		JButton btnMoveStaff = new JButton("Move Staff");
		btnMoveStaff.setFont(new Font("Times New Roman", Font.PLAIN, 35));
		contentPane.add(btnMoveStaff);
		btnMoveStaff.setVisible(false);
		contentPane.add(btnGoBack);
		btnMoveStaff.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				MoveStaff MoveStaffPage = new MoveStaff(StaffReg,DepartReg);
				MoveStaffPage.setVisible(true);
			}
		});
		
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		
		JButton btnSave = new JButton("Save");
		btnSave.setFont(new Font("Times New Roman", Font.PLAIN, 35));
		contentPane.add(btnSave);
		
		
		if (staff.hasWriteAccessTo(PatientReg)) {
			btnAddPatient.setVisible(true);
		}
		if (staff.hasWriteAccessTo(StaffReg)) {
			btnAddStaff.setVisible(true);
		}
		if (staff.canMovePatients()) {
			btnMovePatient.setVisible(true);
		}
		if (staff.hasWriteAccessTo(PatientReg)) {
			btnRemovePatient.setVisible(true);
		}
		if (staff.canMoveStaff()) {
			btnMoveStaff.setVisible(true);
		}
		if (staff.hasViewAccessTo(StaffReg)) {
			btnSearch.setVisible(true);
		}
	}
}