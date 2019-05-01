package GUI; 

import Hospital.DepartmentRegister;
import Hospital.PatientRegister;
import Hospital.StaffRegister;


import java.awt.EventQueue;

import java.awt.Window;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JProgressBar;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JComboBox;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.BoxLayout;
import java.awt.Component;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ButtonGroup;

import java.io.File;
import java.io.Serializable;
import java.io.StringWriter;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@SuppressWarnings("unused")
public class graphic_user_interface implements Serializable{
	
	private static void StaffRegistertoXML(StaffRegister staffRegister)
    {
        try
        {
            JAXBContext jaxbContext = JAXBContext.newInstance(StaffRegister.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
 
            // To format JSON
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
             
            //Set JSON type
//            jaxbMarshaller.setProperty(MarshallerProperties.MEDIA_TYPE, "application/json");
//          jaxbMarshaller.setProperty(MarshallerProperties.JSON_INCLUDE_ROOT, true);
 
            //Print JSON String to Console
            StringWriter sw = new StringWriter();
            jaxbMarshaller.marshal(staffRegister, sw);
            File file = new File("StaffRegister.xml");
            jaxbMarshaller.marshal(staffRegister, file);
            System.out.println(sw.toString());
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
            JAXBContext jaxbContext = JAXBContext.newInstance(PatientRegister.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
 
            // To format JSON
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
             
            //Set JSON type
//            jaxbMarshaller.setProperty(MarshallerProperties.MEDIA_TYPE, "application/json");
//          jaxbMarshaller.setProperty(MarshallerProperties.JSON_INCLUDE_ROOT, true);
 
            //Print JSON String to Console
            StringWriter sw = new StringWriter();
            jaxbMarshaller.marshal(patientRegister, sw);
            File file = new File("patientRegister.xml");
            jaxbMarshaller.marshal(patientRegister, file);
            System.out.println(sw.toString());
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
            JAXBContext jaxbContext = JAXBContext.newInstance(DepartmentRegister.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
 
            // To format JSON
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
             
            //Set JSON type
//            jaxbMarshaller.setProperty(MarshallerProperties.MEDIA_TYPE, "application/json");
//          jaxbMarshaller.setProperty(MarshallerProperties.JSON_INCLUDE_ROOT, true);
 
            //Print JSON String to Console
            StringWriter sw = new StringWriter();
            jaxbMarshaller.marshal(departmentRegister, sw);
            File file = new File("departmentRegister.xml");
            jaxbMarshaller.marshal(departmentRegister, file);
            System.out.println(sw.toString());
        }
        catch (JAXBException e)
        {
            e.printStackTrace();
        }
    }
	
	public static DepartmentRegister depRegXmlFileToObject(String fileName) {
        File xmlFile = new File(fileName);
        DepartmentRegister depRegSaving = new DepartmentRegister();
        JAXBContext jaxbContext;
        try
        {
            jaxbContext = JAXBContext.newInstance(DepartmentRegister.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            DepartmentRegister depRegSaving2 = (DepartmentRegister) jaxbUnmarshaller.unmarshal(xmlFile);
            return depRegSaving2;
        }
        catch (JAXBException e)
        {
            e.printStackTrace();
        }
        finally {
        }
        return depRegSaving;
    }
	
	public static StaffRegister staffRegXmlFileToObject(String fileName) {
        File xmlFile = new File(fileName);
        StaffRegister staffRegSaving = new StaffRegister();
        JAXBContext jaxbContext;
        try
        {
            jaxbContext = JAXBContext.newInstance(DepartmentRegister.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            StaffRegister staffRegSaving2 = (StaffRegister) jaxbUnmarshaller.unmarshal(xmlFile);
            return staffRegSaving2;
        }
        catch (JAXBException e)
        {
            e.printStackTrace();
        }
        finally {
        }
        return staffRegSaving;
    }
	
	public static PatientRegister patientRegXmlFileToObject(String fileName) {
        File xmlFile = new File(fileName);
        PatientRegister patientRegSaving = new PatientRegister();
        JAXBContext jaxbContext;
        try
        {
            jaxbContext = JAXBContext.newInstance(DepartmentRegister.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            PatientRegister patientRegSaving2 = (PatientRegister) jaxbUnmarshaller.unmarshal(xmlFile);
            return patientRegSaving2;
        }
        catch (JAXBException e)
        {
            e.printStackTrace();
        }
        finally {
        }
        return patientRegSaving;
    }

	private JFrame frame;
	private JTextField email;
	private JButton btnLogin;
	private JPasswordField passwordField;
	private StaffRegister StaffReg;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 *
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
		final PatientRegister  PatientReg = new PatientRegister();
		final StaffRegister StaffReg = new StaffRegister();
		final DepartmentRegister DepartReg = new DepartmentRegister();
		
		StaffReg.addICTOfficer("email", "ICT"," surname", new Date(), "gender");
		StaffReg.addClerk("email", "CLERK", "surname", new Date(), "gender");
		StaffReg.addDoctor("email", "DOCTOR", "surname", new Date(),"gender");
		PatientReg.add("alexfc@live.dk", "Alexander", "Christensen", new Date(), "gender", "Nybrovej", 69696969, true, "Dead");
		PatientReg.add("wef@ewfwef.com", "oeijf", "wef", new Date(), "gender", "Lungbyvej", 42042069, true, "alive");
		
		StaffRegistertoXML(StaffReg);
		
		StaffRegister StaffReg2 = staffRegXmlFileToObject("StaffRegister.xml");
		System.out.println(StaffReg2);
		
		frame = new JFrame();
		frame.setTitle("Main Menu");
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.setSize(1000,670);
		
		JButton btnQuit = new JButton("Quit");
		buttonGroup.add(btnQuit);
		btnQuit.setAlignmentY(0.0f);
		btnQuit.setFont(new Font("Times New Roman", Font.PLAIN, 27));
		btnQuit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
			JButton btnPatient = new JButton("Patient");
			buttonGroup.add(btnPatient);
			btnPatient.setAlignmentY(0.0f);
			btnPatient.setFont(new Font("Times New Roman", Font.PLAIN, 27));
			btnPatient.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					PatientLogin loginPage2 = new PatientLogin(PatientReg, DepartReg);
					loginPage2.setVisible(true);
				}
			});
		//		frame.isResizable(true);
		//		
				JButton btnStaff = new JButton("Staff");
				buttonGroup.add(btnStaff);
				btnStaff.setAlignmentY(0.0f);
				btnStaff.setFont(new Font("Times New Roman", Font.PLAIN, 27));
				btnStaff.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						StaffLogin loginPage = new StaffLogin(StaffReg, PatientReg);
						loginPage.setVisible(true);
					}
				});
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setAutoCreateGaps(true);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnStaff, GroupLayout.DEFAULT_SIZE, 475, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnPatient, GroupLayout.DEFAULT_SIZE, 475, Short.MAX_VALUE))
						.addComponent(btnQuit, GroupLayout.DEFAULT_SIZE, 968, Short.MAX_VALUE))
					.addGap(0))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnStaff, GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
						.addComponent(btnPatient, GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnQuit, GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE))
		);
		frame.getContentPane().setLayout(groupLayout);

		
		}
	}