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
import Hospital.*;
import java.io.File;
import javax.xml.bind.*;

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
	private Staff staff;
	
	private static void StaffRegistertoXML(StaffRegister sr)
    {
        try
        {
            JAXBContext jaxbContext = JAXBContext.newInstance(DepartmentRegister.class,OutpatientDepartment.class, InpatientDepartment.class, HospitalUser.class, Staff.class, Clerk.class,ICTOfficer.class,Doctor.class,Nurse.class,
            		Patient.class, Register.class, PatientRegister.class,StaffRegister.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            File file = new File("staffRegister.xml");
            jaxbMarshaller.marshal(sr, file);
        }
        catch (JAXBException e)
        {
            e.printStackTrace();
        }
    }
	
	private static void PatientRegistertoXML(PatientRegister pr)
    {
        try
        {
            JAXBContext jaxbContext = JAXBContext.newInstance(DepartmentRegister.class,OutpatientDepartment.class, InpatientDepartment.class, HospitalUser.class, Staff.class, Clerk.class,ICTOfficer.class,Doctor.class,Nurse.class,
            		Patient.class, Register.class, PatientRegister.class,StaffRegister.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            File file = new File("patientRegister.xml");
            jaxbMarshaller.marshal(pr, file);
        }
        catch (JAXBException e)
        {
            e.printStackTrace();
        }
    }
	
	private static void DepartmentRegistertoXML(DepartmentRegister dr)
    {
        try
        {
            JAXBContext jaxbContext = JAXBContext.newInstance(DepartmentRegister.class,OutpatientDepartment.class, InpatientDepartment.class, HospitalUser.class, Staff.class, Clerk.class,ICTOfficer.class,Doctor.class,Nurse.class,
            		Patient.class, Register.class, PatientRegister.class,StaffRegister.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            File file = new File("departmentRegister.xml");
            jaxbMarshaller.marshal(dr, file);
        }
        catch (JAXBException e)
        {
            e.printStackTrace();
        }
    }
	
	public static void savePatientRegister(PatientRegister pr) {
		PatientRegistertoXML(pr);
	}
	
	public static void saveStaffRegister(StaffRegister sr) {
		StaffRegistertoXML(sr);
	}
	
	public static void saveDepartmentRegister(DepartmentRegister dr) {
		DepartmentRegistertoXML(dr);
	}
	
	/**
	 * Create the frame.
	 */
	@SuppressWarnings("static-access")
	public StaffMenu(StaffRegister sr, int serialnum, PatientRegister pr, DepartmentRegister dr) {
		this.sr = sr;
		this.pr = pr;
		this.serialnum = serialnum;
		staff = sr.findSerialnum(serialnum);

		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setTitle("Staff Menu");
		setBounds(100, 100, 1006, 655);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 3, 0, 0));
		this.setLocationRelativeTo(null);
		JButton btnChangeInfo = new JButton("Update Patient Info");
		btnChangeInfo.setFont(new Font("Times New Roman", Font.PLAIN, 35));
		contentPane.add(btnChangeInfo);
		btnChangeInfo.setVisible(false);
		if (staff.hasWriteAccessTo(pr)) {
			btnChangeInfo.setVisible(true);
		}
		
		btnChangeInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpdatePatientInfo loginPage2 = new UpdatePatientInfo(pr);
				loginPage2.setVisible(true);
			}
		});
		
		JButton btnRemovePatient = new JButton("Discharge patient");
		btnRemovePatient.setFont(new Font("Times New Roman", Font.PLAIN, 35));
		contentPane.add(btnRemovePatient);
		btnRemovePatient.setVisible(false);
		btnRemovePatient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DischargePatient loginPage = new DischargePatient(pr,dr);
				loginPage.setVisible(true);
			}
		});
		
		JButton btnMovePatient = new JButton("Move Patient");
		btnMovePatient.setFont(new Font("Times New Roman", Font.PLAIN, 35));
		contentPane.add(btnMovePatient);
		btnMovePatient.setVisible(false);
		btnMovePatient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MovePatient loginPage = new MovePatient(pr,dr);
				loginPage.setVisible(true);
			}
		});
		
		JButton btnSearchPatients = new JButton("Search Patients");
		btnSearchPatients.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SearchPatient searchPatients = new SearchPatient(pr, dr);
				searchPatients.setVisible(true);
			}
		});
		btnSearchPatients.setFont(new Font("Times New Roman", Font.PLAIN, 35));
		contentPane.add(btnSearchPatients);
		btnSearchPatients.setVisible(false);
		if (staff.hasWriteAccessTo(pr)) {
			btnSearchPatients.setVisible(true);
		}
		
		JButton btnAdmitPatient = new JButton("Admit Patient");
		btnAdmitPatient.setFont(new Font("Times New Roman", Font.PLAIN, 35));
		btnAdmitPatient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AdmitPatientWindow(pr, dr).setVisible(true);
			}
		});
		btnAdmitPatient.setVisible(false);
		contentPane.add(btnAdmitPatient);
		
		JButton btnRegisterPatient = new JButton("Register Patient");
		btnRegisterPatient.setFont(new Font("Times New Roman", Font.PLAIN, 35));
		contentPane.add(btnRegisterPatient);
		btnRegisterPatient.setVisible(false);
		btnRegisterPatient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegisterPatient RegisterPage = new RegisterPatient(pr,dr);
				RegisterPage.setVisible(true);
			}
		});
		
		JButton btnHealthData = new JButton("Health data");
		btnHealthData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				HealthData healthDataMenu = new HealthData(pr, dr);
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
				SearchStaff searchStaff = new SearchStaff(sr, dr);
				searchStaff.setVisible(true);
			}
		});
		
		JButton btnAddStaff = new JButton("Register Staff");
		btnAddStaff.setFont(new Font("Times New Roman", Font.PLAIN, 35));
		contentPane.add(btnAddStaff);
		btnAddStaff.setVisible(false);
		btnAddStaff.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegisterStaff AddStaffPage = new RegisterStaff(sr, dr);
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
				MoveStaff MoveStaffPage = new MoveStaff(sr,dr);
				MoveStaffPage.setVisible(true);
			}
		});
		
		JButton btnDepartmentManager = new JButton("Department Manager");
		btnDepartmentManager.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DepartmentManager departmentManger = new DepartmentManager(dr, staff, sr);
				departmentManger.setVisible(true);
			}
		});
		
		JButton btnDischargeStaff = new JButton("Discharge Staff");
		btnDischargeStaff.setFont(new Font("Times New Roman", Font.PLAIN, 35));
		btnDischargeStaff.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new DischargeStaff(sr, dr).setVisible(true);
			}
		});
		contentPane.add(btnDischargeStaff);
		btnDischargeStaff.setVisible(false);
		btnDepartmentManager.setFont(new Font("Times New Roman", Font.PLAIN, 28));
		contentPane.add(btnDepartmentManager);
		btnDepartmentManager.setVisible(false);
		
		
		JButton btnGoBack = new JButton("Go Back");
		btnGoBack.setFont(new Font("Times New Roman", Font.PLAIN, 35));
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		contentPane.add(btnGoBack);
		
		JButton btnEditStaffInfo = new JButton("Update Staff Info");
		btnEditStaffInfo.setFont(new Font("Times New Roman", Font.PLAIN, 35));
		btnEditStaffInfo.setVisible(false);
		btnEditStaffInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new UpdateStaffInfo(sr, dr, staff).setVisible(true);
			}
		});
		contentPane.add(btnEditStaffInfo);
		
		JButton btnSave = new JButton("Save");
		btnSave.setFont(new Font("Times New Roman", Font.PLAIN, 35));
		contentPane.add(btnSave);
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				saveStaffRegister(sr);
				savePatientRegister(pr);
				saveDepartmentRegister(dr);
			}
		});

		if (staff.hasWriteAccessTo(pr)) {
			btnRegisterPatient.setVisible(true);
			btnAdmitPatient.setVisible(true);
		}
		if (staff.hasWriteAccessTo(sr)) {
			btnAddStaff.setVisible(true);
			btnDischargeStaff.setVisible(true);
			btnEditStaffInfo.setVisible(true);
		}
		if (staff.canMovePatients()) {
			btnMovePatient.setVisible(true);
		}
		if (staff.hasWriteAccessTo(pr)) {
			btnRemovePatient.setVisible(true);
		}
		if (staff.hasViewAccessTo(sr)) {
			btnSearch.setVisible(true);
		}
		if (staff.canViewDepartmentRegister()) {
			btnDepartmentManager.setVisible(true);
		}
		if (staff.canMoveStaff()) {
			btnMoveStaff.setVisible(true);
		}
	}
}