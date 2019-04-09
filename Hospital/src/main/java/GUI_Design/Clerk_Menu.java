package GUI_Design;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Hospital.Hospital;

import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings({ "unused", "serial" })
public class Clerk_Menu extends JFrame {

	private JPanel contentPane;
	static Hospital H;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Clerk_Menu frame = new Clerk_Menu(H);
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
	public Clerk_Menu(Hospital H) {
		Clerk_Menu.H = H;
		
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
		btnAddPatient.setBounds(37, 100, 171, 41);
		contentPane.add(btnAddPatient);
		
		JButton btnAddStaff = new JButton("Add Staff");
		btnAddStaff.setBounds(37, 175, 171, 41);
		contentPane.add(btnAddStaff);
		
		JButton btnMovePatient = new JButton("Move Patient");
		btnMovePatient.setBounds(37, 254, 185, 41);
		contentPane.add(btnMovePatient);
		
		JButton btnRemovePatient = new JButton("Discharge patient");
		btnRemovePatient.setBounds(37, 323, 279, 41);
		contentPane.add(btnRemovePatient);
		
		JButton btnNewButton = new JButton("Move Staff");
		btnNewButton.setBounds(520, 175, 171, 41);
		contentPane.add(btnNewButton);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setBounds(520, 254, 171, 41);
		contentPane.add(btnSearch);
		
		JButton btnChangeInfo = new JButton("Update Info");
		btnChangeInfo.setBounds(520, 100, 175, 41);
		contentPane.add(btnChangeInfo);
		
		JLabel lblWelcomeToThe = new JLabel("Welcome to the Clerk Menu");
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
	}

}
