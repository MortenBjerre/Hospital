package GUI;

import java.awt.Dimension;
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
import javax.swing.JComboBox;

public class MovePatient extends JFrame {

	private JPanel contentPane;
	private JTextField serialNumber;
	private JLabel lblShowDepartmentPatient;
	static PatientRegister PatientReg;
	static DepartmentRegister DepartReg;

	/**
	 * Create the frame.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public MovePatient(final PatientRegister PatientReg, DepartmentRegister DepartReg) {
		MovePatient.PatientReg = PatientReg;
		MovePatient.DepartReg = DepartReg;
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 842, 658);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 542, 137, 50, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{1.0, 0.0, 0.0, 1.0, 1.0, 1.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		this.setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		contentPane.add(panel, gbc_panel);
		
		JLabel lblEnterPatientSerial = new JLabel("Enter Patient Serial Number: ");
		lblEnterPatientSerial.setFont(new Font("Times New Roman", Font.PLAIN, 35));
		GridBagConstraints gbc_lblEnterPatientSerial = new GridBagConstraints();
		gbc_lblEnterPatientSerial.insets = new Insets(0, 0, 5, 5);
		gbc_lblEnterPatientSerial.anchor = GridBagConstraints.EAST;
		gbc_lblEnterPatientSerial.gridx = 1;
		gbc_lblEnterPatientSerial.gridy = 3;
		contentPane.add(lblEnterPatientSerial, gbc_lblEnterPatientSerial);
		
		serialNumber = new JTextField();
		serialNumber.setFont(new Font("Times New Roman", Font.PLAIN, 35));
		GridBagConstraints gbc_serialNumber = new GridBagConstraints();
		gbc_serialNumber.insets = new Insets(0, 0, 5, 5);
		gbc_serialNumber.fill = GridBagConstraints.HORIZONTAL;
		gbc_serialNumber.gridx = 2;
		gbc_serialNumber.gridy = 3;
		contentPane.add(serialNumber, gbc_serialNumber);
		serialNumber.setColumns(10);
		
		
		final JLabel lblPatientIsIn = new JLabel("Patient is in Department: ");
		lblPatientIsIn.setFont(new Font("Times New Roman", Font.PLAIN, 35));
		GridBagConstraints gbc_lblPatientIsIn = new GridBagConstraints();
		gbc_lblPatientIsIn.anchor = GridBagConstraints.EAST;
		gbc_lblPatientIsIn.insets = new Insets(0, 0, 5, 5);
		gbc_lblPatientIsIn.gridx = 1;
		gbc_lblPatientIsIn.gridy = 4;
		contentPane.add(lblPatientIsIn, gbc_lblPatientIsIn);
		lblPatientIsIn.setVisible(false);
		
		lblShowDepartmentPatient = new JLabel("");
		lblShowDepartmentPatient.setFont(new Font("Times New Roman", Font.PLAIN, 35));
		GridBagConstraints gbc_lblShowDepartmentPatient = new GridBagConstraints();
		gbc_lblShowDepartmentPatient.insets = new Insets(0, 0, 5, 5);
		gbc_lblShowDepartmentPatient.gridx = 2;
		gbc_lblShowDepartmentPatient.gridy = 4;
		contentPane.add(lblShowDepartmentPatient, gbc_lblShowDepartmentPatient);
		lblShowDepartmentPatient.setVisible(false);
		
		final JLabel lblWhatDepartmentShould = new JLabel("Department patient should be moved to: ");
		lblWhatDepartmentShould.setFont(new Font("Times New Roman", Font.PLAIN, 35));
		GridBagConstraints gbc_lblWhatDepartmentShould = new GridBagConstraints();
		gbc_lblWhatDepartmentShould.anchor = GridBagConstraints.EAST;
		gbc_lblWhatDepartmentShould.insets = new Insets(0, 0, 5, 5);
		gbc_lblWhatDepartmentShould.gridx = 1;
		gbc_lblWhatDepartmentShould.gridy = 5;
		contentPane.add(lblWhatDepartmentShould, gbc_lblWhatDepartmentShould);
		lblWhatDepartmentShould.setVisible(false);
		
		final JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Times New Roman", Font.PLAIN, 35));
		for (String dept : DepartReg.getAllDepartments()) {
			comboBox.addItem(dept);
		}
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 2;
		gbc_comboBox.gridy = 5;
		contentPane.add(comboBox, gbc_comboBox);
		comboBox.setVisible(false);
		
		JButton btnMovePatient = new JButton("Move Patient");
		btnMovePatient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					DepartReg.movePatient(Integer.parseInt(serialNumber.getText()), comboBox.getSelectedItem().toString(), PatientReg);
					SuccesfullOperation window = new SuccesfullOperation("Patient has succesfully been moved");
					window.setVisible(true);
					dispose();
				} catch (Exception IllegalArgumentException) {
					InvalidInput invalid = new InvalidInput("Patient has not been admitted to a department");
					invalid.setVisible(true);
				}
			
			}
		});
		btnMovePatient.setFont(new Font("Times New Roman", Font.PLAIN, 35));
		GridBagConstraints gbc_btnMovePatient = new GridBagConstraints();
		gbc_btnMovePatient.insets = new Insets(0, 0, 5, 5);
		gbc_btnMovePatient.gridx = 2;
		gbc_btnMovePatient.gridy = 7;
		contentPane.add(btnMovePatient, gbc_btnMovePatient);
		
		JButton btnGoBack = new JButton("Go Back");
		btnGoBack.setFont(new Font("Times New Roman", Font.PLAIN, 35));
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		GridBagConstraints gbc_btnGoBack = new GridBagConstraints();
		gbc_btnGoBack.insets = new Insets(0, 0, 5, 5);
		gbc_btnGoBack.anchor = GridBagConstraints.EAST;
		gbc_btnGoBack.gridx = 3;
		gbc_btnGoBack.gridy = 7;
		contentPane.add(btnGoBack, gbc_btnGoBack);
		
		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 4;
		gbc_panel_1.gridy = 10;
		contentPane.add(panel_1, gbc_panel_1);
		
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
							lblShowDepartmentPatient.setVisible(true);
							lblWhatDepartmentShould.setVisible(true);
							comboBox.setVisible(true);
							lblShowDepartmentPatient.setText(DepartReg.getDeptOfPatient(serialnum));
						}
					} catch (Exception e1) {
						;
					}
				}
			}
		});
	}

}
