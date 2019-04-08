package GUI_Design;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Hospital.Hospital;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class Patient_Menu extends JFrame {

	private JPanel contentPane;
	static Hospital H;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Patient_Menu frame = new Patient_Menu(H);
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
	public Patient_Menu(Hospital H) {
		Patient_Menu.H = H;
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 985, 657);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblWelcomeToThe = new JLabel("Welcome to the Patient Menu, ");
		lblWelcomeToThe.setBounds(46, 44, 371, 33);
		contentPane.add(lblWelcomeToThe);
		
		JButton btnGoBack = new JButton("Go Back");
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnGoBack.setBounds(0, 528, 171, 41);
		contentPane.add(btnGoBack);
		
		JLabel lblYourEmailIs = new JLabel("Your E-mail is : ");
		lblYourEmailIs.setBounds(46, 240, 190, 33);
		contentPane.add(lblYourEmailIs);
		
		JLabel lblYourAddressIs = new JLabel("Your Address is :");
		lblYourAddressIs.setBounds(46, 320, 202, 33);
		contentPane.add(lblYourAddressIs);
		
		JLabel lblYourPhoneNumber = new JLabel("Your Phone Number is :");
		lblYourPhoneNumber.setBounds(45, 392, 293, 33);
		contentPane.add(lblYourPhoneNumber);
		
		JTextArea nameArea = new JTextArea();
		nameArea.setText("ohuihiuh");
		nameArea.setBounds(430, 44, 190, 33);
		contentPane.add(nameArea);
		
		JTextArea emailArea = new JTextArea();
		emailArea.setText("ohuihiuh");
		emailArea.setBounds(366, 251, 171, 22);
		contentPane.add(emailArea);
		
		JTextArea addressArea = new JTextArea();
		addressArea.setText("ohuihiuh");
		addressArea.setBounds(366, 331, 171, 22);
		contentPane.add(addressArea);
		
		JTextArea phonenumberArea = new JTextArea();
		phonenumberArea.setText("ohuihiuh");
		phonenumberArea.setBounds(366, 403, 171, 22);
		contentPane.add(phonenumberArea);
	}
}
