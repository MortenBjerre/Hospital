package GUI;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Hospital.DepartmentRegister;
import Hospital.Staff;
import Hospital.StaffRegister;
import javax.swing.JComboBox;

@SuppressWarnings("serial")
public class MoveStaff extends JFrame {

	private JPanel contentPane;
	private JTextField serialNumber;
	private JLabel lblShouldShowDepartment;
	static DepartmentRegister dr;
	static StaffRegister sr;
	

	/**
	 * Create the frame.
	 */
	@SuppressWarnings("unchecked")
	public MoveStaff(final StaffRegister sr, DepartmentRegister dr) {
		setTitle("Move staff member to other department");
		MoveStaff.sr = sr;
		MoveStaff.dr = dr;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 842, 658);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, 1.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		this.setLocationRelativeTo(null);
		
		JLabel lblEnterPatientSerial = new JLabel("Enter Staff Serial Number: ");
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
		gbc_serialNumber.insets = new Insets(0, 0, 5, 5);
		gbc_serialNumber.fill = GridBagConstraints.HORIZONTAL;
		gbc_serialNumber.gridx = 1;
		gbc_serialNumber.gridy = 2;
		contentPane.add(serialNumber, gbc_serialNumber);
		serialNumber.setColumns(10);
		
		
		final JLabel lblStaffIsIn = new JLabel("Staff is in Department: ");
		lblStaffIsIn.setFont(new Font("Times New Roman", Font.PLAIN, 35));
		GridBagConstraints gbc_lblStaffIsIn = new GridBagConstraints();
		gbc_lblStaffIsIn.anchor = GridBagConstraints.EAST;
		gbc_lblStaffIsIn.insets = new Insets(0, 0, 5, 5);
		gbc_lblStaffIsIn.gridx = 0;
		gbc_lblStaffIsIn.gridy = 5;
		contentPane.add(lblStaffIsIn, gbc_lblStaffIsIn);
		lblStaffIsIn.setVisible(false);
		
		lblShouldShowDepartment = new JLabel();
		lblShouldShowDepartment.setFont(new Font("Times New Roman", Font.PLAIN, 35));
		GridBagConstraints gbc_lblShouldShowDepartment = new GridBagConstraints();
		gbc_lblShouldShowDepartment.insets = new Insets(0, 0, 5, 5);
		gbc_lblShouldShowDepartment.gridx = 1;
		gbc_lblShouldShowDepartment.gridy = 5;
		contentPane.add(lblShouldShowDepartment, gbc_lblShouldShowDepartment);
		lblShouldShowDepartment.setVisible(false);
		
		final JLabel lblWhatDepartmentShould = new JLabel("Department Staff should be moved to: ");
		lblWhatDepartmentShould.setFont(new Font("Times New Roman", Font.PLAIN, 35));
		GridBagConstraints gbc_lblWhatDepartmentShould = new GridBagConstraints();
		gbc_lblWhatDepartmentShould.anchor = GridBagConstraints.EAST;
		gbc_lblWhatDepartmentShould.insets = new Insets(0, 0, 5, 5);
		gbc_lblWhatDepartmentShould.gridx = 0;
		gbc_lblWhatDepartmentShould.gridy = 8;
		contentPane.add(lblWhatDepartmentShould, gbc_lblWhatDepartmentShould);
		lblWhatDepartmentShould.setVisible(false);
		
		
		@SuppressWarnings("rawtypes")
		JComboBox comboBox = new JComboBox();
		for (String dept : dr.getAllDepartments()) {
			comboBox.addItem(dept);
		}
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 1;
		gbc_comboBox.gridy = 8;
		contentPane.add(comboBox, gbc_comboBox);
		
		JButton btnGoBack = new JButton("Go Back");
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		JButton btnMoveStaff = new JButton("Move Staff");
		btnMoveStaff.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					dr.moveStaff(Integer.parseInt(serialNumber.getText()), comboBox.getSelectedItem().toString(), sr);
					SuccesfulOperation window = new SuccesfulOperation("Staff has succesfully been moved");
					window.setVisible(true);
					dispose();
				} catch (Exception error) {
					InvalidInput invalid = new InvalidInput(error.getMessage());
					invalid.setVisible(true);
				}
			}
		});
		GridBagConstraints gbc_btnMoveStaff = new GridBagConstraints();
		gbc_btnMoveStaff.insets = new Insets(0, 0, 5, 5);
		gbc_btnMoveStaff.gridx = 1;
		gbc_btnMoveStaff.gridy = 11;
		contentPane.add(btnMoveStaff, gbc_btnMoveStaff);
		GridBagConstraints gbc_btnGoBack = new GridBagConstraints();
		gbc_btnGoBack.insets = new Insets(0, 0, 5, 5);
		gbc_btnGoBack.anchor = GridBagConstraints.EAST;
		gbc_btnGoBack.gridx = 2;
		gbc_btnGoBack.gridy = 11;
		contentPane.add(btnGoBack, gbc_btnGoBack);
		comboBox.setVisible(false);
		
		serialNumber.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					int serialnum;
					try {
						serialnum = Integer.parseInt(serialNumber.getText());
						Staff p = sr.findSerialnum(serialnum);
						if (p != null) {
							lblStaffIsIn.setVisible(true);
							lblShouldShowDepartment.setVisible(true);
							lblWhatDepartmentShould.setVisible(true);
							comboBox.setVisible(true);
							lblShouldShowDepartment.setText(dr.getDeptOfStaff(serialnum));
						} else {
							lblShouldShowDepartment.setText("");
							new InvalidInput("User with this serial number does not exist!").setVisible(true);
							comboBox.setVisible(false);
						}
					} catch (Exception e1) {
						lblShouldShowDepartment.setText("");
						new InvalidInput("User with this serial number does not exist!").setVisible(true);
						comboBox.setVisible(false);
					}
				}
			}
		});
		
		
		
	}
}