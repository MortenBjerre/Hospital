package GUI;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Hospital.DepartmentRegister;
import Hospital.Patient;
import Hospital.PatientRegister;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;

public class MovePatient extends JFrame {

	private JPanel contentPane;
	private JTextField serialNumber;
	private JTextField Department_1;
	private JTextField Department_2;

	/**
	 * Create the frame.
	 */
	public MovePatient(final PatientRegister PatientReg, DepartmentRegister DepartReg) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 842, 658);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, 1.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblEnterPatientSerial = new JLabel("Enter Patient Serial Number: ");
		lblEnterPatientSerial.setFont(new Font("Times New Roman", Font.PLAIN, 35));
		GridBagConstraints gbc_lblEnterPatientSerial = new GridBagConstraints();
		gbc_lblEnterPatientSerial.insets = new Insets(0, 0, 5, 5);
		gbc_lblEnterPatientSerial.anchor = GridBagConstraints.EAST;
		gbc_lblEnterPatientSerial.gridx = 0;
		gbc_lblEnterPatientSerial.gridy = 2;
		contentPane.add(lblEnterPatientSerial, gbc_lblEnterPatientSerial);
		
		serialNumber = new JTextField();
		serialNumber.setFont(new Font("Times New Roman", Font.PLAIN, 35));
		GridBagConstraints gbc_serialNumber = new GridBagConstraints();
		gbc_serialNumber.insets = new Insets(0, 0, 5, 0);
		gbc_serialNumber.fill = GridBagConstraints.HORIZONTAL;
		gbc_serialNumber.gridx = 1;
		gbc_serialNumber.gridy = 2;
		contentPane.add(serialNumber, gbc_serialNumber);
		serialNumber.setColumns(10);
		
		
		final JLabel lblPatientIsIn = new JLabel("Patient is in Department: ");
		lblPatientIsIn.setFont(new Font("Times New Roman", Font.PLAIN, 35));
		GridBagConstraints gbc_lblPatientIsIn = new GridBagConstraints();
		gbc_lblPatientIsIn.anchor = GridBagConstraints.EAST;
		gbc_lblPatientIsIn.insets = new Insets(0, 0, 5, 5);
		gbc_lblPatientIsIn.gridx = 0;
		gbc_lblPatientIsIn.gridy = 5;
		contentPane.add(lblPatientIsIn, gbc_lblPatientIsIn);
		lblPatientIsIn.setVisible(false);
		
		Department_1 = new JTextField();
		Department_1.setFont(new Font("Times New Roman", Font.PLAIN, 35));
		GridBagConstraints gbc_Department_1 = new GridBagConstraints();
		gbc_Department_1.insets = new Insets(0, 0, 5, 0);
		gbc_Department_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_Department_1.gridx = 1;
		gbc_Department_1.gridy = 5;
		contentPane.add(Department_1, gbc_Department_1);
		Department_1.setColumns(10);
		Department_1.setVisible(false);
		
		final JLabel lblWhatDepartmentShould = new JLabel("Department patient should be moved to: ");
		lblWhatDepartmentShould.setFont(new Font("Times New Roman", Font.PLAIN, 35));
		GridBagConstraints gbc_lblWhatDepartmentShould = new GridBagConstraints();
		gbc_lblWhatDepartmentShould.anchor = GridBagConstraints.EAST;
		gbc_lblWhatDepartmentShould.insets = new Insets(0, 0, 5, 5);
		gbc_lblWhatDepartmentShould.gridx = 0;
		gbc_lblWhatDepartmentShould.gridy = 8;
		contentPane.add(lblWhatDepartmentShould, gbc_lblWhatDepartmentShould);
		lblWhatDepartmentShould.setVisible(false);
		
		Department_2 = new JTextField();
		Department_2.setFont(new Font("Times New Roman", Font.PLAIN, 35));
		GridBagConstraints gbc_Department_2 = new GridBagConstraints();
		gbc_Department_2.insets = new Insets(0, 0, 5, 0);
		gbc_Department_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_Department_2.gridx = 1;
		gbc_Department_2.gridy = 8;
		contentPane.add(Department_2, gbc_Department_2);
		Department_2.setColumns(10);
		Department_2.setVisible(false);
		
		JButton btnGoBack = new JButton("Go Back");
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		GridBagConstraints gbc_btnGoBack = new GridBagConstraints();
		gbc_btnGoBack.anchor = GridBagConstraints.EAST;
		gbc_btnGoBack.gridx = 1;
		gbc_btnGoBack.gridy = 16;
		contentPane.add(btnGoBack, gbc_btnGoBack);
		
		serialNumber.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					int serialnum;
					try {
						serialnum = Integer.parseInt(serialNumber.getText());
						Patient p = PatientReg.findSerialnum(serialnum);
						if (p != null) {
							lblPatientIsIn.setVisible(true);
							Department_1.setVisible(true);
							lblWhatDepartmentShould.setVisible(true);
							Department_2.setVisible(true);
						}
					} catch (Exception e1) {
						;
					}
				}
			}
		});
	}

}
