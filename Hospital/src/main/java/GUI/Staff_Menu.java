package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import Hospital.Staff;
import Hospital.StaffRegister;
import Hospital.Clerk;
import Hospital.DepartmentRegister;
import Hospital.Doctor;
import Hospital.HospitalUser;
import Hospital.ICTOfficer;
import Hospital.InpatientDepartment;
import Hospital.Nurse;
import Hospital.OutpatientDepartment;
import Hospital.Patient;
import Hospital.PatientRegister;
import Hospital.Register;

import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;


@SuppressWarnings({ "unused", "serial" })
public class Staff_Menu extends JFrame {

	private JPanel contentPane;
	static StaffRegister StaffReg;
	static PatientRegister PatientReg;
	static DepartmentRegister DepartReg;
	static int serialNumber;
	
	private static void StaffRegistertoXML(StaffRegister staffRegister)
    {
        try
        {
            JAXBContext jaxbContext = JAXBContext.newInstance(DepartmentRegister.class,OutpatientDepartment.class, InpatientDepartment.class, HospitalUser.class, Staff.class, Clerk.class,ICTOfficer.class,Doctor.class,Nurse.class,
            		Patient.class, Register.class, PatientRegister.class,StaffRegister.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            jaxbMarshaller.marshal(staffRegister, System.out);
            File file = new File("staffRegister.xml");
            jaxbMarshaller.marshal(staffRegister, file);
        }
        catch (JAXBException e)
        {
            e.printStackTrace();
        }
    }
	
	private static void PatientRegistertoXML(PatientRegister patientRegister)
    {
        try
        {
            JAXBContext jaxbContext = JAXBContext.newInstance(DepartmentRegister.class,OutpatientDepartment.class, InpatientDepartment.class, HospitalUser.class, Staff.class, Clerk.class,ICTOfficer.class,Doctor.class,Nurse.class,
            		Patient.class, Register.class, PatientRegister.class,StaffRegister.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            jaxbMarshaller.marshal(patientRegister, System.out);
            File file = new File("patientRegister.xml");
            jaxbMarshaller.marshal(patientRegister, file);
        }
        catch (JAXBException e)
        {
            e.printStackTrace();
        }
    }
	
	private static void DepartmentRegistertoXML(DepartmentRegister departmentRegister)
    {
        try
        {
            JAXBContext jaxbContext = JAXBContext.newInstance(DepartmentRegister.class,OutpatientDepartment.class, InpatientDepartment.class, HospitalUser.class, Staff.class, Clerk.class,ICTOfficer.class,Doctor.class,Nurse.class,
            		Patient.class, Register.class, PatientRegister.class,StaffRegister.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
  
            jaxbMarshaller.marshal(departmentRegister, System.out);
            File file = new File("departmentRegister.xml");
            jaxbMarshaller.marshal(departmentRegister, file);
        }
        catch (JAXBException e)
        {
            e.printStackTrace();
        }
    }
	
	public static void savePatientRegister(PatientRegister p) {
		PatientRegistertoXML(p);
	}
	
	public static void saveStaffRegister(StaffRegister s) {
		StaffRegistertoXML(s);
	}
	
	public static void saveDepartmentRegister(DepartmentRegister d) {
		DepartmentRegistertoXML(d);
	}

	/**
	 * Create the frame.
	 */
	@SuppressWarnings("static-access")
	public Staff_Menu(final StaffRegister StaffReg, int serialNumber, final PatientRegister PatientReg, final DepartmentRegister DepartReg) {
		Staff_Menu.StaffReg = StaffReg;
		Staff_Menu.PatientReg = PatientReg;
		this.serialNumber = serialNumber;
		Staff Staff = StaffReg.findSerialnum(serialNumber);

		
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
		if (Staff.hasWriteAccessTo(PatientReg)) {
			btnChangeInfo.setVisible(true);
		}
		btnChangeInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				updatePatientInfo loginPage2 = new updatePatientInfo(PatientReg);
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
		btnSearchPatients.setFont(new Font("Times New Roman", Font.PLAIN, 35));
		contentPane.add(btnSearchPatients);
		btnSearchPatients.setVisible(false);
		if (Staff.hasWriteAccessTo(PatientReg)) {
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
		btnHealthData.setFont(new Font("Times New Roman", Font.PLAIN, 35));
		contentPane.add(btnHealthData);
		btnHealthData.setVisible(false);
		if (Staff.hasHealthDataAccess()) {
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
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				saveStaffRegister(StaffReg);
				savePatientRegister(PatientReg);
				saveDepartmentRegister(DepartReg);
			}
		});
		
		if (Staff.hasWriteAccessTo(PatientReg)) {
			btnAddPatient.setVisible(true);
		}
		if (Staff.hasWriteAccessTo(StaffReg)) {
			btnAddStaff.setVisible(true);
		}
		if (Staff.canMovePatients()) {
			btnMovePatient.setVisible(true);
		}
		if (Staff.hasWriteAccessTo(PatientReg)) {
			btnRemovePatient.setVisible(true);
		}
		if (Staff.canMoveStaff()) {
			btnMoveStaff.setVisible(true);
		}
		if (Staff.hasViewAccessTo(StaffReg)) {
			btnSearch.setVisible(true);
		}
	}
}