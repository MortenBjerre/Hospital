package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Hospital.DepartmentRegister;
import Hospital.PatientRegister;

public class RegisterPatient extends JFrame {

	private JPanel contentPane;
	private JTextField Name;
	private JTextField Surname;
	private JTextField Address;
	private JTextField Email;
	private JTextField Alive;
	private JTextField Number;
	private JTextField Gender;
	static PatientRegister PatientReg;
	static DepartmentRegister DepartReg;


	/**
	 * Create the frame.
	 */
	public RegisterPatient(final PatientRegister PatientReg, final DepartmentRegister DepartReg) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 796, 690);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0};
		gbl_contentPane.rowHeights = new int[]{0};
		gbl_contentPane.columnWeights = new double[]{Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		
		
	}

}
