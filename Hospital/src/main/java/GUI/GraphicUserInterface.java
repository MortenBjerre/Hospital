package GUI; 

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import Hospital.DepartmentRegister;
import Hospital.PatientRegister;
import Hospital.StaffRegister;
import GUI.StaffMenu;
import Hospital.*;
import javax.xml.bind.*;
import java.io.File;
import java.io.FileNotFoundException;

public class GraphicUserInterface {
//
	private JFrame frame;
	private PatientRegister pr;
	private StaffRegister sr;
	private DepartmentRegister dr;

	public static DepartmentRegister DepartmentRegisterXMLtoObject(String fileName) {
        File xmlFile = new File(fileName);
        DepartmentRegister drSaving = new DepartmentRegister();
        JAXBContext jaxbContext;
        try
        {
            jaxbContext = JAXBContext.newInstance(DepartmentRegister.class,OutpatientDepartment.class, InpatientDepartment.class, HospitalUser.class, Staff.class, Clerk.class,ICTOfficer.class,Doctor.class,Nurse.class,
            		Patient.class, Register.class, PatientRegister.class,StaffRegister.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            DepartmentRegister drSaving2 = (DepartmentRegister) jaxbUnmarshaller.unmarshal(xmlFile);
            System.out.println("Loaded File");
      
            return drSaving2;
        }
        catch (JAXBException e)
        {
//        	Patient.resetSerialnumCounter;
            System.out.println("No Department Register file found - creating new file");
        }
        finally {
        }
        return drSaving;
    }
	
	public static StaffRegister StaffRegisterXMLtoObject(String fileName) {
        File xmlFile = new File(fileName);
        StaffRegister srSaving = new StaffRegister();
        srSaving.addICTOfficer("admin", "admin", "admin", new Date(), "Apache Attack Helicopter");
        JAXBContext jaxbContext;
        try
        {
            jaxbContext = JAXBContext.newInstance(DepartmentRegister.class,OutpatientDepartment.class, InpatientDepartment.class, HospitalUser.class, Staff.class, Clerk.class,ICTOfficer.class,Doctor.class,Nurse.class,
            		Patient.class, Register.class, PatientRegister.class,StaffRegister.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            StaffRegister srSaving2 = (StaffRegister) jaxbUnmarshaller.unmarshal(xmlFile);
            System.out.println("Loaded File");
            return srSaving2;
        }
        catch (JAXBException e)
        {
            System.out.println("No Staff Register file found - creating new file");
        }
        finally {
        }
        return srSaving;
    }
	
	public static PatientRegister PatientRegisterXMLtoObject(String fileName) {
        File xmlFile = new File(fileName);
        PatientRegister prSaving = new PatientRegister();
        JAXBContext jaxbContext;
        try
        {
            jaxbContext = JAXBContext.newInstance(DepartmentRegister.class,OutpatientDepartment.class, InpatientDepartment.class, HospitalUser.class, Staff.class, Clerk.class,ICTOfficer.class,Doctor.class,Nurse.class,
            		Patient.class, Register.class, PatientRegister.class,StaffRegister.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            PatientRegister prSaving2 = (PatientRegister) jaxbUnmarshaller.unmarshal(xmlFile);
            System.out.println("Loaded File");
            return prSaving2;
        }
        catch (JAXBException e)
        {
            System.out.println("No Patient Register file found - creating new file");
        }
        finally {
        }
        return prSaving;
    }
	
	public static PatientRegister loadPatientRegister() {
		return PatientRegisterXMLtoObject("patientRegister.xml");
	}
	
	public static StaffRegister loadStaffRegister() {
		return StaffRegisterXMLtoObject("staffRegister.xml");
	}
	
	public static DepartmentRegister loadDepartmentRegister() {
		return DepartmentRegisterXMLtoObject("departmentRegister.xml");
	}
	
	/**
	 *
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					GraphicUserInterface window = new GraphicUserInterface();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GraphicUserInterface() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		pr = loadPatientRegister();
		sr = loadStaffRegister();
		dr = loadDepartmentRegister();
		pr.setSerialnumCounter();
		sr.setSerialnumCounter();
		
		frame = new JFrame();
		frame.setTitle("Main Menu");
		
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				int answer = JOptionPane.showConfirmDialog(frame, "Do you wish to save the program?","Close Program",JOptionPane.YES_NO_CANCEL_OPTION);
				if (answer == JOptionPane.YES_OPTION) {
					StaffMenu.savePatientRegister(pr);
					StaffMenu.saveStaffRegister(sr);
					StaffMenu.saveDepartmentRegister(dr);
					System.exit(0);
				}
				if (answer == JOptionPane.NO_OPTION) {
					System.exit(0);
				} else {
					; // do nothing 
				}
			}
		});

		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setSize(1000,670);
				frame.getContentPane().setLayout(new GridLayout(5, 2, 40, 20));
				
				JLabel label = new JLabel("");
				frame.getContentPane().add(label);
				
				JLabel label_1 = new JLabel("");
				frame.getContentPane().add(label_1);
				
				JLabel label_2 = new JLabel("");
				frame.getContentPane().add(label_2);
				
				JLabel label_3 = new JLabel("");
				frame.getContentPane().add(label_3);
				
					JButton btnPatient = new JButton("Patient");
					btnPatient.setMaximumSize(new Dimension(10, 10));
					btnPatient.setFont(new Font("Times New Roman", Font.PLAIN, 100));
					btnPatient.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							
							PatientLogin loginPage2 = new PatientLogin(pr, dr);
							loginPage2.setVisible(true);
						}
					});
					
					JButton btnStaff = new JButton("Staff");
					btnStaff.setMaximumSize(new Dimension(10, 10));
					btnStaff.setFont(new Font("Times New Roman", Font.PLAIN, 100));
					btnStaff.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							
							StaffLogin loginPage = new StaffLogin(sr, pr, dr);
							loginPage.setVisible(true);
						}
					});
					frame.getContentPane().add(btnStaff);
					frame.getContentPane().add(btnPatient);
				
				JLabel label_4 = new JLabel("");
				frame.getContentPane().add(label_4);
				
				JLabel label_5 = new JLabel("");
				frame.getContentPane().add(label_5);

		
		}
	}