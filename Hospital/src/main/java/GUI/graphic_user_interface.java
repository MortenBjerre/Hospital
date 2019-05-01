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
import java.awt.Rectangle;

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
import com.jgoodies.forms.layout.FormSpecs;
import java.awt.FlowLayout;

@SuppressWarnings("unused")
public class graphic_user_interface {

	private JFrame frame;
	private JTextField email;
	private JButton btnLogin;
	private JPasswordField passwordField;
	private StaffRegister StaffReg;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();

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
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setSize(1000,670);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{180, 149, 315, 213, 180, 0};
		gridBagLayout.rowHeights = new int[]{258, 55, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
			JButton btnPatient = new JButton("Patient");
			btnPatient.setMaximumSize(new Dimension(10, 10));
			btnPatient.setFont(new Font("Times New Roman", Font.PLAIN, 40));
			btnPatient.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					PatientLogin loginPage2 = new PatientLogin(PatientReg, DepartReg);
					loginPage2.setVisible(true);
				}
			});
			
			JButton btnStaff = new JButton("Staff");
			btnStaff.setMaximumSize(new Dimension(10, 10));
			btnStaff.setFont(new Font("Times New Roman", Font.PLAIN, 40));
			btnStaff.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					StaffLogin loginPage = new StaffLogin(StaffReg, PatientReg, DepartReg);
					loginPage.setVisible(true);
				}
			});
			GridBagConstraints gbc_btnStaff = new GridBagConstraints();
			gbc_btnStaff.anchor = GridBagConstraints.NORTH;
			gbc_btnStaff.fill = GridBagConstraints.HORIZONTAL;
			gbc_btnStaff.insets = new Insets(0, 0, 0, 5);
			gbc_btnStaff.gridx = 1;
			gbc_btnStaff.gridy = 1;
			frame.getContentPane().add(btnStaff, gbc_btnStaff);
			GridBagConstraints gbc_btnPatient = new GridBagConstraints();
			gbc_btnPatient.insets = new Insets(0, 0, 0, 5);
			gbc_btnPatient.fill = GridBagConstraints.HORIZONTAL;
			gbc_btnPatient.anchor = GridBagConstraints.NORTH;
			gbc_btnPatient.gridx = 3;
			gbc_btnPatient.gridy = 1;
			frame.getContentPane().add(btnPatient, gbc_btnPatient);

		
		}
	}