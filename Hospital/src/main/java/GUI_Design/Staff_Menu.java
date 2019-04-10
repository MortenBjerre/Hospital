package GUI_Design;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Hospital.Hospital;
import Hospital.Staff;

import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings({ "unused", "serial" })
public class Staff_Menu extends JFrame {

	private JPanel contentPane;
	static Hospital H;
	static int serialNumber;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Staff_Menu frame = new Staff_Menu(H,serialNumber);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	@SuppressWarnings("static-access")
	public Staff_Menu(Hospital H, int serialNumber) {
		Staff_Menu.H = H;
		this.serialNumber = serialNumber;
		Staff s = H.staffRegister.findSerialnum(serialNumber);

		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1006, 655);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAddPatient = new JButton("Add Patient");
		btnAddPatient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		btnAddPatient.setBounds(382, 261, 171, 41);
		contentPane.add(btnAddPatient);
		
		JButton btnAddStaff = new JButton("Add Staff");
		btnAddStaff.setBounds(37, 192, 171, 41);
		contentPane.add(btnAddStaff);
		
		JButton btnMovePatient = new JButton("Move Patient");
		btnMovePatient.setBounds(382, 127, 185, 41);
		contentPane.add(btnMovePatient);
		
		JButton btnRemovePatient = new JButton("Discharge patient");
		btnRemovePatient.setBounds(382, 192, 279, 41);
		contentPane.add(btnRemovePatient);
		
		JButton btnNewButton = new JButton("Move Staff");
		btnNewButton.setBounds(37, 330, 171, 41);
		contentPane.add(btnNewButton);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setBounds(37, 127, 171, 41);
		contentPane.add(btnSearch);
		
		JButton btnChangeInfo = new JButton("Update Info");
		btnChangeInfo.setBounds(37, 261, 175, 41);
		contentPane.add(btnChangeInfo);
		
		JLabel lblWelcomeToThe = new JLabel("Welcome to the Staff Menu");
		lblWelcomeToThe.setBounds(37, 28, 467, 33);
		contentPane.add(lblWelcomeToThe);
		
		JButton btnGoBack = new JButton("Go Back");
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnGoBack.setBounds(0, 528, 171, 41);
		contentPane.add(btnGoBack);
		
		
		if (s.hasWriteAccessTo(H.patientRegister)) {
			;
		} else {
			btnGoBack.setVisible(false);
			btnChangeInfo.setVisible(false);
			btnNewButton.setVisible(false);
			btnRemovePatient.setVisible(false);
			btnMovePatient.setVisible(false);
			btnAddStaff.setVisible(false);
			btnAddPatient.setVisible(false);
		}
	}

}