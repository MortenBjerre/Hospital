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
	private StaffRegister sr;
	private PatientRegister pr;
	private DepartmentRegister dr;
	private int serialnum;
	private JButton btnAddStaffToDept;

	/**
	 * Create the frame.
	 */
	@SuppressWarnings("static-access")
	public StaffMenu(final StaffRegister StaffReg, int serialNumber, final PatientRegister PatientReg, final DepartmentRegister DepartReg) {
		this.sr = StaffReg;
		this.pr = PatientReg;
		this.serialnum = serialNumber;
		Staff staff = StaffReg.findSerialnum(serialNumber);

		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setTitle("Staff Menu");
		setBounds(100, 100, 1006, 655);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 3, 0, 0));
		this.setLocationRelativeTo(null);
		
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
				
				SearchPatient searchPatients = new SearchPatient(PatientReg, DepartReg);
				searchPatients.setVisible(true);
				
			}
		});
		btnSearchPatients.setFont(new Font("Times New Roman", Font.PLAIN, 35));
		contentPane.add(btnSearchPatients);
		btnSearchPatients.setVisible(false);
		if (staff.hasWriteAccessTo(PatientReg)) {
			btnSearchPatients.setVisible(true);
		}
		
		JButton btnSearchPatients_1 = new JButton("Admit Patient");
		btnSearchPatients_1.setFont(new Font("Times New Roman", Font.PLAIN, 35));
		btnSearchPatients_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AdmitPatientWindow(PatientReg, DepartReg).setVisible(true);
			}
		});
		contentPane.add(btnSearchPatients_1);
		
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
				
		JButton btnSearch = new JButton("Search Staff");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SearchStaff searchStaff = new SearchStaff(StaffReg, DepartReg);
				searchStaff.setVisible(true);
			}
		});
		
				
				JButton btnAddStaff = new JButton("Register Staff");
				btnAddStaff.setFont(new Font("Times New Roman", Font.PLAIN, 35));
				contentPane.add(btnAddStaff);
				btnAddStaff.setVisible(false);
				btnAddStaff.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						RegisterStaff AddStaffPage = new RegisterStaff(StaffReg, DepartReg);
						AddStaffPage.setVisible(true);
					}
				});
		btnSearch.setFont(new Font("Times New Roman", Font.PLAIN, 35));
		contentPane.add(btnSearch);
		btnSearch.setVisible(false);

		JButton btnMoveStaff = new JButton("Move Staff");
		btnMoveStaff.setFont(new Font("Times New Roman", Font.PLAIN, 35));
		contentPane.add(btnMoveStaff);
		btnMoveStaff.setVisible(false);
		btnMoveStaff.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				MoveStaff MoveStaffPage = new MoveStaff(StaffReg,DepartReg);
				MoveStaffPage.setVisible(true);
			}
		});
		
		
		JButton btnIctOfficerMenu = new JButton("Department Manager");
		btnIctOfficerMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DepartmentManager departmentManger = new DepartmentManager(DepartReg);
				departmentManger.setVisible(true);
			}
		});
		
		JButton btnDischargeStaff = new JButton("Discharge Staff");
		btnDischargeStaff.setFont(new Font("Times New Roman", Font.PLAIN, 35));
		btnDischargeStaff.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new DischargeStaff(StaffReg, DepartReg).setVisible(true);
			}
		});
		contentPane.add(btnDischargeStaff);
		btnDischargeStaff.setVisible(false);
		btnIctOfficerMenu.setFont(new Font("Times New Roman", Font.PLAIN, 28));
		contentPane.add(btnIctOfficerMenu);
		btnIctOfficerMenu.setVisible(false);
		
		
		JButton btnGoBack = new JButton("Go Back");
		btnGoBack.setFont(new Font("Times New Roman", Font.PLAIN, 35));
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		contentPane.add(btnGoBack);
		
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
			btnDischargeStaff.setVisible(true);
		}
		if (staff.canMovePatients()) {
			btnMovePatient.setVisible(true);
		}
		if (staff.hasWriteAccessTo(PatientReg)) {
			btnRemovePatient.setVisible(true);
		}
		if (staff.hasViewAccessTo(StaffReg)) {
			btnSearch.setVisible(true);
		}
		if (staff.canEditDepartmentRegister(DepartReg)) {
			btnIctOfficerMenu.setVisible(true);
		}
		if (staff.canMoveStaff()) {
			btnMoveStaff.setVisible(true);
		}
	}
}