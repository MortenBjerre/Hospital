package GUI; 



import java.awt.EventQueue;
import java.awt.Window;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.swing.JComboBox;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Rectangle;
import Hospital.*;

public class graphic_user_interface {

	private JFrame frame;
	
	public static DepartmentRegister DepartmentRegisterXMLtoObject(String fileName) {
        File xmlFile = new File(fileName);
        DepartmentRegister depRegSaving = new DepartmentRegister();
        JAXBContext jaxbContext;
        try
        {
            jaxbContext = JAXBContext.newInstance(DepartmentRegister.class,OutpatientDepartment.class, InpatientDepartment.class, HospitalUser.class, Staff.class, Clerk.class,ICTOfficer.class,Doctor.class,Nurse.class,
            		Patient.class, Register.class, PatientRegister.class,StaffRegister.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            DepartmentRegister depRegSaving2 = (DepartmentRegister) jaxbUnmarshaller.unmarshal(xmlFile);
            System.out.println("Loaded File");
            return depRegSaving2;
        }
        catch (JAXBException e)
        {
            System.out.println("No Department Register file found - creating new file");
        }
        finally {
        }
        return depRegSaving;
    }
	
	public static StaffRegister StaffRegisterXMLtoObject(String fileName) {
        File xmlFile = new File(fileName);
        StaffRegister staffRegSaving = new StaffRegister();
        staffRegSaving.addICTOfficer("admin", "admin", "admin", new Date(), "Apache Attack Helicopter");
        JAXBContext jaxbContext;
        try
        {
            jaxbContext = JAXBContext.newInstance(DepartmentRegister.class,OutpatientDepartment.class, InpatientDepartment.class, HospitalUser.class, Staff.class, Clerk.class,ICTOfficer.class,Doctor.class,Nurse.class,
            		Patient.class, Register.class, PatientRegister.class,StaffRegister.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            StaffRegister staffRegSaving2 = (StaffRegister) jaxbUnmarshaller.unmarshal(xmlFile);
            System.out.println("Loaded File");
            return staffRegSaving2;
        }
        catch (JAXBException e)
        {
            System.out.println("No Staff Register file found - creating new file");
        }
        finally {
        }
        return staffRegSaving;
    }
	
	public static PatientRegister PatientRegisterXMLtoObject(String fileName) {
        File xmlFile = new File(fileName);
        PatientRegister patientRegSaving = new PatientRegister();
        JAXBContext jaxbContext;
        try
        {
            jaxbContext = JAXBContext.newInstance(DepartmentRegister.class,OutpatientDepartment.class, InpatientDepartment.class, HospitalUser.class, Staff.class, Clerk.class,ICTOfficer.class,Doctor.class,Nurse.class,
            		Patient.class, Register.class, PatientRegister.class,StaffRegister.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            PatientRegister patientRegSaving2 = (PatientRegister) jaxbUnmarshaller.unmarshal(xmlFile);
            System.out.println("Loaded File");
            return patientRegSaving2;
        }
        catch (JAXBException e)
        {
            System.out.println("No Patient Register file found - creating new file");
        }
        finally {
        }
        return patientRegSaving;
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
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					graphic_user_interface window = new graphic_user_interface();
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
	public graphic_user_interface() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		final PatientRegister PatientReg = loadPatientRegister();
		final StaffRegister StaffReg = loadStaffRegister();
		final DepartmentRegister DepartReg = loadDepartmentRegister();

		frame = new JFrame();
		frame.setTitle("Main Menu");
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
							
							PatientLogin loginPage2 = new PatientLogin(PatientReg, DepartReg);
							loginPage2.setVisible(true);
						}
					});
					
					JButton btnStaff = new JButton("Staff");
					btnStaff.setMaximumSize(new Dimension(10, 10));
					btnStaff.setFont(new Font("Times New Roman", Font.PLAIN, 100));
					btnStaff.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							
							StaffLogin loginPage = new StaffLogin(StaffReg, PatientReg, DepartReg);
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