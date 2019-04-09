package GUI_Design;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Hospital.Hospital;

import javax.swing.JLabel;

@SuppressWarnings({ "unused", "serial" })
public class Staff_Menu extends JFrame {

	private JPanel contentPane;
	static Hospital H;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Staff_Menu frame = new Staff_Menu(H);
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
	public Staff_Menu(Hospital H) {
		Staff_Menu.H = H;
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1016, 672);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblWelcomeToThe = new JLabel("Welcome to the Staff menu");
		lblWelcomeToThe.setBounds(26, 44, 340, 33);
		contentPane.add(lblWelcomeToThe);
		
		JButton btnGoBack = new JButton("Go Back");
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnGoBack.setBounds(0, 543, 171, 41);
		contentPane.add(btnGoBack);
	}

}
