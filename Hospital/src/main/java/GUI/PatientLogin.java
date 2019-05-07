package GUI;

import Hospital.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JPasswordField;
import java.awt.GridLayout;
import javax.swing.SwingConstants;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

@SuppressWarnings({ "serial", "unused" })
public class PatientLogin extends JFrame {

	private JPanel contentPane;
	static PatientRegister pr;
	static DepartmentRegister dr;
	private int serialNumber;
	private JPasswordField SerialNumber;

	/**
	 * Create the frame.
	 */
	public PatientLogin(final PatientRegister pr, final DepartmentRegister dr) {
		PatientLogin.pr = pr;
		PatientLogin.dr = dr;
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setTitle("Patient Login Page");
		setBounds(100, 100, 975, 701);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{466, 466, 72, 0};
		gbl_contentPane.rowHeights = new int[]{86, 86, 86, 86, 86, 86, 86, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		this.setLocationRelativeTo(null);
		
		JLabel lblWelcomeToPatient = new JLabel("Welcome to patient login page");
		lblWelcomeToPatient.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcomeToPatient.setFont(new Font("Times New Roman", Font.PLAIN, 35));
		GridBagConstraints gbc_lblWelcomeToPatient = new GridBagConstraints();
		gbc_lblWelcomeToPatient.fill = GridBagConstraints.BOTH;
		gbc_lblWelcomeToPatient.insets = new Insets(0, 0, 5, 5);
		gbc_lblWelcomeToPatient.gridx = 0;
		gbc_lblWelcomeToPatient.gridy = 0;
		contentPane.add(lblWelcomeToPatient, gbc_lblWelcomeToPatient);
		
		JButton btnGoBack = new JButton("Go Back");
		btnGoBack.setFont(new Font("Times New Roman", Font.PLAIN, 35));
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		JLabel label = new JLabel("");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.fill = GridBagConstraints.BOTH;
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 1;
		gbc_label.gridy = 0;
		contentPane.add(label, gbc_label);
		
		JLabel label_1 = new JLabel("");
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.fill = GridBagConstraints.BOTH;
		gbc_label_1.insets = new Insets(0, 0, 5, 5);
		gbc_label_1.gridx = 0;
		gbc_label_1.gridy = 1;
		contentPane.add(label_1, gbc_label_1);
		
		JLabel label_3 = new JLabel("");
		GridBagConstraints gbc_label_3 = new GridBagConstraints();
		gbc_label_3.fill = GridBagConstraints.BOTH;
		gbc_label_3.insets = new Insets(0, 0, 5, 5);
		gbc_label_3.gridx = 1;
		gbc_label_3.gridy = 1;
		contentPane.add(label_3, gbc_label_3);
		
		JLabel lblSurname = new JLabel("Serial Number :");
		lblSurname.setHorizontalAlignment(SwingConstants.CENTER);
		lblSurname.setFont(new Font("Times New Roman", Font.PLAIN, 35));
		GridBagConstraints gbc_lblSurname = new GridBagConstraints();
		gbc_lblSurname.fill = GridBagConstraints.BOTH;
		gbc_lblSurname.insets = new Insets(0, 0, 5, 5);
		gbc_lblSurname.gridx = 0;
		gbc_lblSurname.gridy = 2;
		contentPane.add(lblSurname, gbc_lblSurname);
		
		final JLabel invalidLogin = new JLabel("Incorrect Login");
		invalidLogin.setFont(new Font("Times New Roman", Font.PLAIN, 35));
		GridBagConstraints gbc_invalidLogin = new GridBagConstraints();
		gbc_invalidLogin.fill = GridBagConstraints.BOTH;
		gbc_invalidLogin.insets = new Insets(0, 0, 5, 5);
		gbc_invalidLogin.gridx = 1;
		gbc_invalidLogin.gridy = 3;
		contentPane.add(invalidLogin, gbc_invalidLogin);
		invalidLogin.setForeground(Color.red);
		invalidLogin.setVisible(false);
		
		
		SerialNumber = new JPasswordField();
		GridBagConstraints gbc_SerialNumber = new GridBagConstraints();
		gbc_SerialNumber.fill = GridBagConstraints.BOTH;
		gbc_SerialNumber.insets = new Insets(0, 0, 5, 5);
		gbc_SerialNumber.gridx = 1;
		gbc_SerialNumber.gridy = 2;
		contentPane.add(SerialNumber, gbc_SerialNumber);
		SerialNumber.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER){
					try {
						@SuppressWarnings("deprecation")
						int serialNumber = Integer.parseInt(SerialNumber.getText());
							if (pr.findSerialnum(serialNumber) != null) {
								PatientMenu menu = new PatientMenu(pr, dr, serialNumber);
								menu.setVisible(true);
								dispose();
							} else {
								invalidLogin.setVisible(true);
							}
					} catch (Exception e1) {
						;
					}
				}
			}
		});
		
		JLabel label_4 = new JLabel("");
		GridBagConstraints gbc_label_4 = new GridBagConstraints();
		gbc_label_4.fill = GridBagConstraints.BOTH;
		gbc_label_4.insets = new Insets(0, 0, 5, 5);
		gbc_label_4.gridx = 0;
		gbc_label_4.gridy = 3;
		contentPane.add(label_4, gbc_label_4);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("Times New Roman", Font.PLAIN, 35));
		btnLogin.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				try  {
						if (pr.findSerialnum(serialNumber) != null) {
							PatientMenu menu = new PatientMenu(pr, dr, serialNumber);
							menu.setVisible(true);
							dispose();
						} else {
							invalidLogin.setVisible(true);
						}
				} catch (Exception e) {
					InvalidInput invalid = new InvalidInput("Wrong Input, Try Again!");
					invalid.setVisible(true);
				}
			}
		});
		
		JLabel label_5 = new JLabel("");
		GridBagConstraints gbc_label_5 = new GridBagConstraints();
		gbc_label_5.fill = GridBagConstraints.BOTH;
		gbc_label_5.insets = new Insets(0, 0, 5, 5);
		gbc_label_5.gridx = 0;
		gbc_label_5.gridy = 4;
		contentPane.add(label_5, gbc_label_5);
		GridBagConstraints gbc_btnLogin = new GridBagConstraints();
		gbc_btnLogin.fill = GridBagConstraints.BOTH;
		gbc_btnLogin.insets = new Insets(0, 0, 5, 5);
		gbc_btnLogin.gridx = 1;
		gbc_btnLogin.gridy = 4;
		contentPane.add(btnLogin, gbc_btnLogin);
		
		JLabel label_6 = new JLabel("");
		GridBagConstraints gbc_label_6 = new GridBagConstraints();
		gbc_label_6.fill = GridBagConstraints.BOTH;
		gbc_label_6.insets = new Insets(0, 0, 5, 5);
		gbc_label_6.gridx = 0;
		gbc_label_6.gridy = 5;
		contentPane.add(label_6, gbc_label_6);
		
		JLabel label_7 = new JLabel("");
		GridBagConstraints gbc_label_7 = new GridBagConstraints();
		gbc_label_7.fill = GridBagConstraints.BOTH;
		gbc_label_7.insets = new Insets(0, 0, 5, 5);
		gbc_label_7.gridx = 1;
		gbc_label_7.gridy = 5;
		contentPane.add(label_7, gbc_label_7);
		GridBagConstraints gbc_btnGoBack = new GridBagConstraints();
		gbc_btnGoBack.fill = GridBagConstraints.BOTH;
		gbc_btnGoBack.insets = new Insets(0, 0, 0, 5);
		gbc_btnGoBack.gridx = 0;
		gbc_btnGoBack.gridy = 6;
		contentPane.add(btnGoBack, gbc_btnGoBack);
		
		JLabel label_8 = new JLabel("");
		GridBagConstraints gbc_label_8 = new GridBagConstraints();
		gbc_label_8.insets = new Insets(0, 0, 0, 5);
		gbc_label_8.fill = GridBagConstraints.BOTH;
		gbc_label_8.gridx = 1;
		gbc_label_8.gridy = 6;
		contentPane.add(label_8, gbc_label_8);
	}
}