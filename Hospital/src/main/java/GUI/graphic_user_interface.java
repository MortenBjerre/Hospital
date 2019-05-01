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

@SuppressWarnings("unused")
public class graphic_user_interface {

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
		
		StaffReg.addICTOfficer("email", "name"," surname", new Date(), "gender");
		StaffReg.addClerk("email", "name", "surname", new Date(), "gender");
		StaffReg.addDoctor("email", "name", "surname", new Date(),"gender");
		PatientReg.add("alexfc@live.dk", "Alexander", "Christensen", new Date(), "gender", "Nybrovej", 69696969, true, "Dead");
		PatientReg.add("wef@ewfwef.com", "oeijf", "wef", new Date(), "gender", "Lungbyvej", 42042069, true, "alive");
		
		
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
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(64)
							.addComponent(btnStaff, GroupLayout.DEFAULT_SIZE, 351, Short.MAX_VALUE)
							.addGap(76)
							.addComponent(btnPatient, GroupLayout.DEFAULT_SIZE, 396, Short.MAX_VALUE))
						.addComponent(btnQuit, GroupLayout.PREFERRED_SIZE, 281, GroupLayout.PREFERRED_SIZE))
					.addGap(81))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addGap(186)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnPatient, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
						.addComponent(btnStaff, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE))
					.addGap(64)
					.addComponent(btnQuit, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE))
		);
		groupLayout.setAutoCreateGaps(true);
		frame.getContentPane().setLayout(groupLayout);

		
		}
	}